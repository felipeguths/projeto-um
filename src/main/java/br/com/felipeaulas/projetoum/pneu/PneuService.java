package br.com.felipeaulas.projetoum.pneu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PneuService {
    @Autowired
    private PneuRepository pneuRepository;


    public Pneu findById(Long id) {
        return pneuRepository.findById(id)
                .orElseThrow(PneuNotFoundException::new);
    }

    public PneuResponseDTO findByIdDTO(Long id){
        Pneu pneu = findById(id);
        return PneuResponseDTO.convertFromEntity(pneu);
    }

    public List<PneuResponseDTO> findAllByName(String name) {
        return convertToDTO(pneuRepository.findAllByName(name));
    }

    public List<PneuResponseDTO> findAllByType(PneuType pneuType){
        return  convertToDTO(pneuRepository.findAllByPneuType(pneuType));
    }

    private List<PneuResponseDTO> convertToDTO(List<Pneu> pneuList) {
        return pneuList.stream().map(PneuResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }
}
