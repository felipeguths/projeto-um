package br.com.felipeaulas.projetoum.toy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ToyResponseDTO {
    private Long id;
    private String name;
    private String color;
    private String type;
    private String toyBrand;

    public static ToyResponseDTO convertFromEntity(Toy toy){
        return new ToyResponseDTOBuilder()
                .id(toy.getId())
                .name(toy.getName())
                .color(toy.getColor())
                .type(toy.getType())
                .toyBrand(toy.getToybrand().toString())
                .build();
    }
}
