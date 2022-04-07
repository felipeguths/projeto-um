package br.com.felipeaulas.projetoum.pneu;

import br.com.felipeaulas.projetoum.car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_pneu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pneu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    private PneuType pneuType;
    @ManyToOne
    private Car car;

    public Pneu(String name, PneuType pneuType, Car car){
        this.name = name;
        this.pneuType = pneuType;
        this.car = car;
    }

    public void updateValuesFrom(PneuRequestDTO pneuRequestDTO, Car car) {
        this.name = pneuRequestDTO.getName();
        this.pneuType = pneuRequestDTO.getPneuType();
        this.car = car;
    }

    public Long getCarId(){
        return car==null? null:car.getId();
    }

    public String getCarName() {
        return car==null? null:car.getName();
    }

}
