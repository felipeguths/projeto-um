package br.com.felipeaulas.projetoum.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDTO {
    @NotEmpty(message = "Deve passar um nome")
    private String name;
    @NotEmpty(message = "Deve passar uma cor")
    private String color;
    @NotNull(message = "Deve passar uma CarBrand")
    private CarBrand carBrand;

    public Car createCarEntity() {

        return new Car(name, color, carBrand);
    }
    @AssertTrue(message = "Toda Ferrari deve ser vermelho" )
    public boolean isValid(){
        if (!this.name.equalsIgnoreCase("FERRARI")){
            return true;
        } else {
            return this.name.equalsIgnoreCase("FERRARI")&&
                    this.color.equalsIgnoreCase("Vermelho");
        }
    }
}
