package br.com.felipeaulas.projetoum.times;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TimeAdicionaDataDoMundialUseCaseTest {
    @Mock
    private TimeService timeService;
    private TimeAdicionaDataDoMundialUseCase principal;

    @BeforeEach
    public void antesDeCadaTeste(){
        System.out.println("antes de cada teste");
        MockitoAnnotations.openMocks(this);
        principal = new TimeAdicionaDataDoMundialUseCase(timeService);
        Mockito.when(timeService.findById(1L)).thenReturn(new Time("Grêmio", "POA", TimesComMundial.TEM));
    }
    @Test
    void adicionaDataDoMundialParaTimesQueTemMundial() {
        System.out.println("teste 1");
        principal.adiciona(1L, LocalDate.now());
    }

    @Test
    void naoAdicionaDataDoMundialParaTimesQueNaoTemMundial() {
        System.out.println("teste 2");
        principal.adiciona(1L, LocalDate.now());
    }
}