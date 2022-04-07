package br.com.felipeaulas.projetoum.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    public Client(String name, ClientType clientType) {
        this.name = name;
        this.clientType = clientType;
    }

    public void updateValuesFrom(ClientRequestDTO clientRequestDTO) {
        this.name = clientRequestDTO.getName();
        this.clientType = clientRequestDTO.getClientType();
    }

    public String getIdentification() {
        return this.name + " de id: " + this.id;
    }
}
