package br.com.felipeaulas.projetoum.meat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    private MeatDuration meatDuration;

    public Meat(String name, LocalDate shelfLife) {
        this.name = name;
        if (LocalDate.now().isAfter(shelfLife)){
        this.meatDuration = MeatDuration.BAD;
        } else {
        this.meatDuration = MeatDuration.GOOD;
        }

    }

    public void updateValuesFrom(MeatRequestDTO meatRequestDTO) {
        this.name = meatRequestDTO.getName();
        this.meatDuration = meatRequestDTO.createEntity().getMeatDuration();
    }
}
