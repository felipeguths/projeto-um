package br.com.felipeaulas.projetoum.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
public class CarRESTController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;
    @PostMapping
    public void create(@RequestBody @Valid CarRequestDTO carRequestDTO) {
        Car car = carRequestDTO.createCarEntity();
        carRepository.save(car);
    }

    @GetMapping
    public List<CarResponseDTO> findAll(){
       return carRepository.findAll()
                            .stream().map(CarResponseDTO::convertFromEntity)
                            .collect(Collectors.toList());
    }

    @GetMapping("/pageable")
    public Page<CarResponseDTO> findAllPageable(@RequestParam(name = "page", required = false, defaultValue = "0")int page,
                                                   @RequestParam(name = "size", required = false, defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size);
        return carRepository.findAll(pageable)
                            .map(CarResponseDTO::convertFromEntity);
    }

    @GetMapping("/{id}")
    public CarResponseDTO findById(@PathVariable Long id){
        return carService.findByIdDTO(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        carRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public CarResponseDTO updateById(@PathVariable Long id, @RequestBody CarRequestDTO carRequestDTO){
        Car car = carService.findById(id);
        car.updateValuesFrom(carRequestDTO);
        Car carUpdated = carRepository.save(car);
        return CarResponseDTO.convertFromEntity(carUpdated);
    }

    @GetMapping("/name/{name}")
    public List<CarResponseDTO> findAllByName(@PathVariable String name){
        return carService.findAllByName(name);
    }

    @GetMapping("/color/{color}")
    public  List<CarResponseDTO> findAllByColor(@PathVariable String color){
        return carService.findAllByColor(color);
    }

    @GetMapping("/color/{color}/name/{name}")
    public  List<CarResponseDTO> findAllByColorAndName(@PathVariable(name = "color") String color,
                                                       @PathVariable(name = "name") String name){
        return carService.findAllByColorAndName(color, name);
    }

    @GetMapping("/carBrand/{carBrand}")
    public  List<CarResponseDTO> findAllbyBrand(@PathVariable CarBrand carBrand){
        return carService.findAllByBrand(carBrand);
    }

    @GetMapping("/{id}/carBrand/discount")
    public String getDiscount(@PathVariable Long id){
        return carService.getDiscount(id);

    }


}
