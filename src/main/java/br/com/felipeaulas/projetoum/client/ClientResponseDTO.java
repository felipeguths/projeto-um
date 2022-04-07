package br.com.felipeaulas.projetoum.client;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientResponseDTO {
    private Long id;
    private String name;
    private String clientType;

    public static ClientResponseDTO convertFromEntity(Client client) {
        return new ClientResponseDTOBuilder()
                .id(client.getId())
                .name(client.getName())
                .clientType(client.getClientType().toString())
                .build();
    }
}
