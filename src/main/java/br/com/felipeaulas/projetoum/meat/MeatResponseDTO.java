package br.com.felipeaulas.projetoum.meat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MeatResponseDTO {
    private Long id;
    private String name;
    private String shelfLife;


    public static MeatResponseDTO convertFromEntity(Meat meat) {
        return new MeatResponseDTOBuilder()
                .id(meat.getId())
                .name(meat.getName())
                .shelfLife(meat.getMeatDuration().toString())
                .build();
    }
}
