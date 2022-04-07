package br.com.felipeaulas.projetoum.client;

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
@RequestMapping("/client")
public class ClientRESTController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @PostMapping
    public void create(@RequestBody ClientRequestDTO clientRequestDTO){
        Client client = clientRequestDTO.createClientEntity();
        clientRepository.save(client);
    }

    @GetMapping
    public List<ClientResponseDTO> findAll(){
        return clientRepository.findAll().stream().map(ClientResponseDTO::convertFromEntity).collect(Collectors.toList());
    }
    @GetMapping("/pageable")
    public Page<ClientResponseDTO> findAllPageable(@RequestParam(name = "page", required = false, defaultValue = "0")int page,
                                                   @RequestParam(name = "size", required = false, defaultValue = "10")int size){
        Pageable pageable = PageRequest.of(page, size);
        return clientRepository.findAll(pageable).map(ClientResponseDTO::convertFromEntity);

    }

    @GetMapping("/{id}")
    public ClientResponseDTO findById(@PathVariable Long id){
        Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        return ClientResponseDTO.convertFromEntity(client);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        clientRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ClientResponseDTO updateById(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO){
        Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
        client.updateValuesFrom(clientRequestDTO);
        Client clientUpdated = clientRepository.save(client);
        return ClientResponseDTO.convertFromEntity(clientUpdated);
    }

    @GetMapping("/name/{name}")
    public List<ClientResponseDTO> findAllByName(@PathVariable String name){
        return clientService.findAllByName(name);
    }

    @GetMapping("/clientType/{clientType}")
    public  List<ClientResponseDTO> findAllbyType(@PathVariable ClientType clientType) {
        return clientService.findAllByType(clientType);
    }

    @GetMapping("/client-types")
    public List<String> getClientTypes(){
        return Arrays.stream(ClientType.values()).map(ClientType::toString).collect(Collectors.toList());
    }

}
