package br.com.felipeaulas.projetoum.sapato;

import br.com.felipeaulas.projetoum.client.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SapatoRequestDTO {
    private String name;
    private String color;
    private SapatoBrand sapatoBrand;
    private Long clientId;

    public Sapato createSapatoEntity(Client client){

        return new Sapato(name, color, sapatoBrand, client);
    }
}
