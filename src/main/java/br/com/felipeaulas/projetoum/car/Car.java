package br.com.felipeaulas.projetoum.car;

import br.com.felipeaulas.projetoum.pneu.Pneu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private CarBrand carBrand;
//    @OneToMany(fetch = FetchType.LAZY ou EAGER(+ COMPLEXO)
//    private List<Pneu> pneus = new ArrayList<>();

    public Car(String name, String color, CarBrand carBrand) {
        this.name = name;
        this.color = color;
        this.carBrand = carBrand;
    }

    public void updateValuesFrom(CarRequestDTO carRequestDTO) {
        this.name = carRequestDTO.getName();
        this.color = carRequestDTO.getColor();
        this.carBrand = carRequestDTO.getCarBrand();
    }

    public String getCarDiscount() {
        return carBrand.getDiscount();
    }
}
