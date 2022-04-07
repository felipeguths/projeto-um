package br.com.felipeaulas.projetoum.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new);
    }

    public ClientResponseDTO findByIdDTO(Long id){
        Client client = findById(id);
        return ClientResponseDTO.convertFromEntity(client);
    }

    public List<ClientResponseDTO> findAllByName(String name) {
        return convertToDTO(clientRepository.findAllByName(name));
    }

    public List<ClientResponseDTO> findAllByType(ClientType clientType){
        return  convertToDTO(clientRepository.findAllByClientType(clientType));
    }

    private List<ClientResponseDTO> convertToDTO(List<Client> clientList) {
        return clientList.stream().map(ClientResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }

}
