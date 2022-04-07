package br.com.felipeaulas.projetoum.sapato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sapato")
public class SapatoRESTController {
    @Autowired
    private SapatoService sapatoService;
    @PostMapping
    public void create(@RequestBody SapatoRequestDTO sapatoRequestDTO) {
        sapatoService.create(sapatoRequestDTO);
    }

    @GetMapping
    public List<SapatoResponseDTO> findAll(){
        return sapatoService.findAll();
    }

    @GetMapping("/pageable")
    public Page<SapatoResponseDTO> findAllPageable(@RequestParam(name = "page", required = false, defaultValue = "0")int page,
                                                @RequestParam(name = "size", required = false, defaultValue = "10")int size) {
        return sapatoService.findAllPageable(page, size);
    }

    @GetMapping("/{id}")
    public SapatoResponseDTO findById(@PathVariable Long id){
        return sapatoService.findByIdDTO(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        sapatoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public SapatoResponseDTO updateById(@PathVariable Long id, @RequestBody SapatoRequestDTO sapatoRequestDTO){
        return sapatoService.updateById(id, sapatoRequestDTO);
    }


    @GetMapping("/name/{name}")
    public List<SapatoResponseDTO> findAllByName(@PathVariable String name){
        return sapatoService.findAllByName(name);
    }

    @GetMapping("/color/{color}")
    public  List<SapatoResponseDTO> findAllByColor(@PathVariable String color){
        return sapatoService.findAllByColor(color);
    }

    @GetMapping("/color/{color}/name/{name}")
    public  List<SapatoResponseDTO> findAllByColorAndName(@PathVariable(name = "color") String color,
                                                       @PathVariable(name = "name") String name){
        return sapatoService.findAllByColorAndName(color, name);
    }

    @GetMapping("/sapatoBrand/{sapatoBrand}")
    public  List<SapatoResponseDTO> findAllbyBrand(@PathVariable SapatoBrand sapatoBrand){
        return sapatoService.findAllByBrand(sapatoBrand);
    }

    @GetMapping("/sapato-brand")
    public List<String> getSapatoBrand(){
        return Arrays.stream(SapatoBrand.values()).map(SapatoBrand::toString).collect(Collectors.toList());
    }

}
