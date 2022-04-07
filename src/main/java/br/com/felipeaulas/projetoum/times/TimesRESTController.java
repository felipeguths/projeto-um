package br.com.felipeaulas.projetoum.times;

import br.com.felipeaulas.projetoum.client.Client;
import br.com.felipeaulas.projetoum.client.ClientRequestDTO;
import br.com.felipeaulas.projetoum.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/times")
public class TimesRESTController {
    @Autowired
    private TimesRepository timesRepository;
    @Autowired
    private TimeService timeService;
    @Autowired
    private ClientService clientService;



    @PostMapping
    public void create(@RequestBody @Valid TimesRequestDTO timesRequestDTO){
        Time time = timesRequestDTO.createTimesEntity();
        timesRepository.save(time);
    }

//    @PostMapping("/{id}/adiciona-clientes/{clientID}")
//    public void adicionaClientes(@PathVariable("id") Long timeID, @PathVariable("clientID") Long clientID){
//        Time time = timeService.findById(timeID);
//        Client client = clientService.findById(clientID);
//        time.adicionaClientesNaLista();
//
//    }


    @GetMapping
    public List<TimesResponseDTO> findAll(){
        return timesRepository.findAll().stream().map(TimesResponseDTO::convertFromEntity).collect(Collectors.toList());
    }
    @GetMapping("/pageable")
    public Page<TimesResponseDTO> findAllPageable(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                  @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return timesRepository.findAll(pageable).map(TimesResponseDTO::convertFromEntity);
    }

    @GetMapping("/{id}")
    public TimesResponseDTO findById(@PathVariable Long id){
        return timeService.findByIdDTO(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        timesRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public TimesResponseDTO updateById(@PathVariable Long id, @RequestBody TimesRequestDTO timesRequestDTO){
        Time time = timeService.findById(id);
        time.updateValuesFrom(timesRequestDTO);
        Time timeUpdated = timesRepository.save(time);
        return TimesResponseDTO.convertFromEntity(timeUpdated);
    }

    @GetMapping("/name/{name}")
    public List<TimesResponseDTO> findAllByName(@PathVariable String name){
        return timeService.findAllByName(name);
    }

    @GetMapping("/cidade/{cidade}")
    public  List<TimesResponseDTO> findAllByCidade(@PathVariable String cidade){
        return timeService.findAllByCidade(cidade);
    }

    @GetMapping("/cidade/{cidade}/name/{name}")
    public  List<TimesResponseDTO> findAllByCidadeAndName(@PathVariable(name = "cidade") String cidade,
                                                       @PathVariable(name = "name") String name){
        return timeService.findAllByCidadeAndName(cidade, name);
    }

    @GetMapping("/timesComMundial/{timesComMundial}")
    public  List<TimesResponseDTO> findAllByMundial(@PathVariable TimesComMundial timesComMundial){
        return timeService.findAllByMundial(timesComMundial);
    }

    @GetMapping("/times-com-mundial")
    public List<String> getTimesComMundial(){
        return Arrays.stream(TimesComMundial.values()).map(TimesComMundial::toString).collect(Collectors.toList());
    }


}
