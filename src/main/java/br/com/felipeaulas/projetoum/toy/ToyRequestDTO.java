package br.com.felipeaulas.projetoum.toy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ToyRequestDTO {
    private String name;
    private String color;
    private String type;
    private ToyBrand toyBrand;

    public Toy createToyEntity(){
        return new Toy(name, color, type, toyBrand);
    }
}
