package br.com.felipeaulas.projetoum.meat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MeatRequestDTO {
    private String name;
    private LocalDate shelfLife;


    public Meat createEntity() {
        return new Meat(name, shelfLife);
    }
}
