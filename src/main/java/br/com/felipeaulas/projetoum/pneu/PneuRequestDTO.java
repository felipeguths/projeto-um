package br.com.felipeaulas.projetoum.pneu;

import br.com.felipeaulas.projetoum.car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PneuRequestDTO {
    private String name;
    private PneuType pneuType;
    private Long carId;

    public Pneu createPneuEntity(Car car){
        return new Pneu(name, pneuType, car);
    }
}
