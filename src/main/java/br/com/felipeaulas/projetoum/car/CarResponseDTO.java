package br.com.felipeaulas.projetoum.car;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarResponseDTO {
    private Long id;
    private String name;
    private String color;
    private String carBrand;
    private String discount;


    public static CarResponseDTO convertFromEntity(Car car) {
        return new CarResponseDTOBuilder()
                .id(car.getId())
                .name(car.getName())
                .color(car.getColor())
                .carBrand(car.getCarBrand().toString())
                .discount(car.getCarDiscount())
                .build();
    }
}
