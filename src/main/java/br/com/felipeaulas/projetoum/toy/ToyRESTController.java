package br.com.felipeaulas.projetoum.toy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/toy")
public class ToyRESTController {
    @Autowired
    private ToyRepository toyRepository;
    @PostMapping
    public void create(@RequestBody ToyRequestDTO toyRequestDTO){
        Toy toy = toyRequestDTO.createToyEntity();
        toyRepository.save(toy);
    }

    @GetMapping
    public List<ToyResponseDTO> findAll(){
        return toyRepository.findAll().stream()
                .map(ToyResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }
}
