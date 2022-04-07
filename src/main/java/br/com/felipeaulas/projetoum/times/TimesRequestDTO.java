package br.com.felipeaulas.projetoum.times;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TimesRequestDTO {
    @NotEmpty(message = "Deve passar um nome")
    private String name;
    @NotEmpty(message = "Deve passar uma cidade")
    private String cidade;
    @NotNull(message = "Não pode ser o Palmeiras")
    private TimesComMundial timesComMundial;

    public Time createTimesEntity() {
        return new Time(name, cidade, timesComMundial);
    }

    @AssertTrue(message = "Deve ser um time de SP")
    public boolean isValid(){
        return this.cidade.equalsIgnoreCase("SP");
    }
}
