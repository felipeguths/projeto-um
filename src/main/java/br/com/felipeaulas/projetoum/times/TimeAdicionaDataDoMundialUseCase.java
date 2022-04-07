package br.com.felipeaulas.projetoum.times;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TimeAdicionaDataDoMundialUseCase {
    private final TimeService timeService;

    public void adiciona(Long id, LocalDate dataDoUltimoMundial){
        Time time = timeService.findById(id);
        this.adicionaDataDoMundial(time, dataDoUltimoMundial);
    }

    private void adicionaDataDoMundial(Time time, LocalDate dataDoUltimoMundial) {
        if (time.getTimesComMundial().equals(TimesComMundial.TEM)){
            time.setDataDoUltimoMundial(dataDoUltimoMundial);
        }
    }
}
