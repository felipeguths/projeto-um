package br.com.felipeaulas.projetoum.sapato;

import br.com.felipeaulas.projetoum.client.Client;
import br.com.felipeaulas.projetoum.client.ClientNotFoundException;
import br.com.felipeaulas.projetoum.client.ClientRepository;
import br.com.felipeaulas.projetoum.log.LogAction;
import br.com.felipeaulas.projetoum.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SapatoService {
    @Autowired
    private SapatoRepository sapatoRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LogService logService;

    public Sapato findById(Long id){
        return sapatoRepository.findById(id).orElseThrow(SapatoNotFoundException::new);
    }

    public SapatoResponseDTO findByIdDTO(Long id){
        Sapato sapato = findById(id);
        return SapatoResponseDTO.convertFromEntity(sapato);
    }

    public List<SapatoResponseDTO> findAllByName(String name){
        return convertToDTO(sapatoRepository.findAllByName(name));
    }

    public List<SapatoResponseDTO> findAllByColor(String color){
        return convertToDTO(sapatoRepository.findAllByColor(color));
    }
    public List<SapatoResponseDTO> findAllByBrand(SapatoBrand sapatoBrand){
        return convertToDTO(sapatoRepository.findAllBySapatoBrand(sapatoBrand));
    }
    public List<SapatoResponseDTO> findAllByColorAndName(String color, String name){
        return convertToDTO(sapatoRepository.findAllByColorAndName(color, name));
    }

    private List<SapatoResponseDTO> convertToDTO(List<Sapato> sapatoList){
        return sapatoList.stream().map(SapatoResponseDTO::convertFromEntity)
                                  .collect(Collectors.toList());
    }

    public SapatoResponseDTO updateById(Long id, SapatoRequestDTO sapatoRequestDTO) {
        Sapato sapato = findById(id);
        Client client = clientRepository.findById(sapatoRequestDTO.getClientId()).orElseThrow(ClientNotFoundException::new);
        sapato.updateValuesFrom(sapatoRequestDTO, client);
        Sapato sapatoUpdated = sapatoRepository.save(sapato);
        logService.createLog(client.getName(), LogAction.UPDATE_SAPATO, "O sapato foi alterado pelo: " + client.getIdentification());
        return SapatoResponseDTO.convertFromEntity(sapatoUpdated);

    }

    public void create(SapatoRequestDTO sapatoRequestDTO) {
        Client client = clientRepository.findById(sapatoRequestDTO.getClientId()).orElseThrow(ClientNotFoundException::new);
        Sapato sapato = sapatoRequestDTO.createSapatoEntity(client);
        sapatoRepository.save(sapato);
        logService. createLog(client.getName(), LogAction.CREATE_SAPATO, "O sapato foi criado pelo: " + client.getIdentification());

    }

    public Page<SapatoResponseDTO> findAllPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return sapatoRepository.findAll(pageable)
                                .map(SapatoResponseDTO::convertFromEntity);
    }

    public List<SapatoResponseDTO> findAll() {
        return sapatoRepository.findAll()
                .stream().map(SapatoResponseDTO::convertFromEntity)
                .collect(Collectors.toList());

    }

    public void deleteById(Long id) {
        sapatoRepository.deleteById(id);
        logService.createLog("Felipão", LogAction.DELETE_SAPATO, "O sapato " + id + "foi deletado pelo: Felipão");

    }
}
