package br.com.felipeaulas.projetoum.sapato;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder //DESIGN PATTERN = "BUILDER" - SOLUÇÃO ELEGANTE PARA UM PROBLEMA RECORRENTE
public class SapatoResponseDTO {
    private Long id;
    private String name;
    private String color;
    private String sapatoBrand;
    private Long clientId;
    private String clientName;


    public static SapatoResponseDTO convertFromEntity(Sapato sapato) {
        return new SapatoResponseDTOBuilder()
                .id(sapato.getId())
                .name(sapato.getName())
                .color(sapato.getColor())
                .sapatoBrand(sapato.getSapatoBrand().toString())
                .clientId(sapato.getClientId())
                .clientName(sapato.getClientName())
                .build();
    }
}
