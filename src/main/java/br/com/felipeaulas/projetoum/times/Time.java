package br.com.felipeaulas.projetoum.times;

import br.com.felipeaulas.projetoum.client.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_times")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private TimesComMundial timesComMundial;
    private LocalDate dataDoUltimoMundial;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private List<Client> clientes = new ArrayList<>();


    public Time(String name, String cidade, TimesComMundial timesComMundial){
        this.name = name;
        this.cidade = cidade;
        this.timesComMundial = timesComMundial;
    }

    public void updateValuesFrom(TimesRequestDTO timesRequestDTO) {
        this.name = timesRequestDTO.getName();
        this.cidade = timesRequestDTO.getCidade();
        this.timesComMundial = timesRequestDTO.getTimesComMundial();
    }
}

