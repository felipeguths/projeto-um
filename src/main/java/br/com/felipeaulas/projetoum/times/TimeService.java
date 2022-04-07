package br.com.felipeaulas.projetoum.times;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {
    @Autowired
    private TimesRepository timesRepository;

    public Time findById(Long id){
        return timesRepository.findById(id).orElseThrow(TimesNotFoundException::new);
    }

    public TimesResponseDTO findByIdDTO(Long id){
        Time time = findById(id);
        return TimesResponseDTO.convertFromEntity(time);
    }

    public List<TimesResponseDTO> findAllByName(String name) {
        return convertToDTO(timesRepository.findAllByName(name));
    }

    public List<TimesResponseDTO> findAllByCidade(String cidade) {
        return convertToDTO(timesRepository.findAllByCidade(cidade));
    }

    public List<TimesResponseDTO> findAllByMundial(TimesComMundial timesComMundial){
        return  convertToDTO(timesRepository.findAllByTimesComMundial(timesComMundial));
    }

    public List<TimesResponseDTO> findAllByCidadeAndName(String cidade, String name) {
        return convertToDTO(timesRepository.findAllByCidadeAndName(cidade, name));
    }

    private List<TimesResponseDTO> convertToDTO(List<Time> timeList) {
        return timeList.stream().map(TimesResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }
}

