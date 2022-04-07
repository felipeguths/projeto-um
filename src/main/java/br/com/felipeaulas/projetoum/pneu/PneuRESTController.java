package br.com.felipeaulas.projetoum.pneu;

import br.com.felipeaulas.projetoum.car.Car;
import br.com.felipeaulas.projetoum.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pneu")
public class PneuRESTController {
    @Autowired
    private PneuRepository pneuRepository;
    @Autowired
    private PneuService pneuService;
    @Autowired
    private CarService carService;
    @PostMapping
    public void create(@RequestBody PneuRequestDTO pneuRequestDTO){
        Car car = carService.findById(pneuRequestDTO.getCarId());
        Pneu pneu = pneuRequestDTO.createPneuEntity(car);
        pneuRepository.save(pneu);
    }

    @GetMapping
    public List<PneuResponseDTO> findAll(){
        return pneuRepository.findAll().stream().map(PneuResponseDTO::convertFromEntity).collect(Collectors.toList());
    }

    @GetMapping("/pageable")
    public Page<PneuResponseDTO> findAllPageable(@RequestParam(name = "page", required = false, defaultValue = "0")int page,
                                                   @RequestParam(name = "size", required = false, defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page, size);
        return  pneuRepository.findAll(pageable).map(PneuResponseDTO::convertFromEntity);
    }

    @GetMapping("/{id}")
    public PneuResponseDTO findById(@PathVariable Long id){
        Pneu pneu = pneuRepository.findById(id).orElseThrow(PneuNotFoundException::new);
        return PneuResponseDTO.convertFromEntity((pneu));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        pneuRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public PneuResponseDTO updateById(@PathVariable Long id, @RequestBody PneuRequestDTO pneuRequestDTO){
        Pneu pneu = pneuRepository.findById(id).orElseThrow(PneuNotFoundException::new);
        Car car = carService.findById(pneuRequestDTO.getCarId());
        pneu.updateValuesFrom(pneuRequestDTO, car);
        Pneu pneuUpdated = pneuRepository.save(pneu);
        return PneuResponseDTO.convertFromEntity(pneuUpdated);
    }

    @GetMapping("/name/{name}")
    public List<PneuResponseDTO> findAllByName(@PathVariable String name){
        return pneuService.findAllByName(name);
    }

    @GetMapping("/pneuType/{pneuType}")
    public  List<PneuResponseDTO> findAllbyType(@PathVariable PneuType pneuType) {
        return pneuService.findAllByType(pneuType);
    }

    @GetMapping("/pneu-types")
    public List<String> getPneuTypes(){
        return Arrays.stream(PneuType.values()).map(PneuType::toString).collect(Collectors.toList());
    }

}
