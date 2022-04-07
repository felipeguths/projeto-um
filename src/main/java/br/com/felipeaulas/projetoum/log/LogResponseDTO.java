package br.com.felipeaulas.projetoum.log;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder //DESIGN PATTERN = "BUILDER" - SOLUÇÃO ELEGANTE PARA UM PROBLEMA RECORRENTE
public class LogResponseDTO {
    private Long id;
    private String whoDo;
    private String action;
    private String description;
    private LocalDateTime dateTime;

public static LogResponseDTO convertFromEntity(Log log){
    return new LogResponseDTOBuilder()
            .id(log.getId())
            .whoDo(log.getWhoDo())
            .action(log.getAction())
            .description(log.getDescription())
            .dateTime(log.getDateTime())
            .build();
}
}

