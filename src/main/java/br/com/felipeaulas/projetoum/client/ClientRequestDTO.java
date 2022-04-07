package br.com.felipeaulas.projetoum.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {
    private String name;
    private ClientType clientType;

    public Client createClientEntity(){
        return new Client(name, clientType);
    }
}
