package br.com.felipeaulas.projetoum.sapato;

import br.com.felipeaulas.projetoum.client.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_sapato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sapato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String color;
    @Enumerated(EnumType.STRING)
    private SapatoBrand sapatoBrand;

    @ManyToOne
    private Client client;

    public Sapato(String name, String color, SapatoBrand sapatoBrand, Client client) {
        this.name = name;
        this.color = color;
        this.sapatoBrand = sapatoBrand;
        this.client = client;
    }

    public void updateValuesFrom(SapatoRequestDTO sapatoRequestDTO, Client client) {
        this.name = sapatoRequestDTO.getName();
        this.color = sapatoRequestDTO.getColor();
        this.sapatoBrand = sapatoRequestDTO.getSapatoBrand();
        this.client = client;
    }


    public Long getClientId() {
        return client==null? null:client.getId();
    }

    public String getClientName() {
        return client==null? null:client.getName();
    }
}
