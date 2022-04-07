package br.com.felipeaulas.projetoum.meat;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class MeatRequestDTOTest {

    @Test
    public void deveAcertarValidadeComoRuim(){

        var date =  LocalDate.of(2021, Month.JANUARY, 19);
        Meat meat = new MeatRequestDTO("steak", date).createEntity();
        Assertions.assertEquals(MeatDuration.BAD, meat.getMeatDuration());
    }
    @Test
    public void deveAcertarValidadeParaAmanhaComoBoa(){

        var date = LocalDate.now().plusDays(1);
        Meat meat = new MeatRequestDTO("steak", date).createEntity();
        Assertions.assertEquals(MeatDuration.GOOD, meat.getMeatDuration());
    }

    @Test
    public void deveAcertarValidadeDaCarneBoaParaHoje(){

        var date =  LocalDate.now();
        Meat meat = new MeatRequestDTO("steak", date).createEntity();
        Assertions.assertEquals(MeatDuration.GOOD, meat.getMeatDuration());
    }
}