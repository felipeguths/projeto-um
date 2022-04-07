package br.com.felipeaulas.projetoum.meat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meat")
public class MeatRESTController {
    @Autowired
    private MeatRepository meatRepository;

    @PostMapping
    public void create(@RequestBody MeatRequestDTO meatRequestDTO) {
        Meat meat = meatRequestDTO.createEntity();
        meatRepository.save(meat);
    }

    @GetMapping
    public List<MeatResponseDTO> findAll() {
        return meatRepository.findAll().stream().map(MeatResponseDTO::convertFromEntity).collect(Collectors.toList());
    }

    @GetMapping("/pageable")
    public Page<MeatResponseDTO> findAllPageable(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                 @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return meatRepository.findAll(pageable).map(MeatResponseDTO::convertFromEntity);
    }

    @GetMapping("/{id}")
    public MeatResponseDTO findById(@PathVariable Long id) {
        Meat meat = meatRepository.findById(id).orElseThrow(MeatNotFoundException::new);
        return MeatResponseDTO.convertFromEntity(meat);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        meatRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public MeatResponseDTO updateById(@PathVariable Long id, @RequestBody MeatRequestDTO meatRequestDTO) {
        Meat meat = meatRepository.findById(id).orElseThrow(MeatNotFoundException::new);
        meat.updateValuesFrom(meatRequestDTO);
        Meat meatUpdated = meatRepository.save(meat);
        return MeatResponseDTO.convertFromEntity(meatUpdated);
    }
}