package br.com.felipeaulas.projetoum.pneu;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PneuResponseDTO {
    private Long id;
    private String name;
    private String pneuType;
    private Long carId;
    private String carName;


    public static PneuResponseDTO convertFromEntity(Pneu pneu){
        return new PneuResponseDTOBuilder()
                .id(pneu.getId())
                .name(pneu.getName())
                .pneuType(pneu.getPneuType().toString())
                .carId(pneu.getCarId())
                .carName(pneu.getCarName())
                .build();
    }
}
