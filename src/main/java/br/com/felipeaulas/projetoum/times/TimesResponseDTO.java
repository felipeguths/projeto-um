package br.com.felipeaulas.projetoum.times;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TimesResponseDTO {
    private Long id;
    private String name;
    private String cidade;
    private String timesComMundial;

    public static TimesResponseDTO convertFromEntity(Time time){
        return new TimesResponseDTOBuilder()
                .id(time.getId())
                .name(time.getName())
                .cidade(time.getCidade())
                .timesComMundial(time.getTimesComMundial().toString())
                .build();
    }
}
