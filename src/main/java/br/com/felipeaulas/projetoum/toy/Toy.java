package br.com.felipeaulas.projetoum.toy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_toys")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String color;
    private String type;
    private ToyBrand toybrand;

    public Toy(String name, String color, String type, ToyBrand toyBrand) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.toybrand = toyBrand;
    }
}
