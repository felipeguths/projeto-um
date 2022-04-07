package br.com.felipeaulas.projetoum.kid;

import javax.persistence.*;

@Entity
@Table(name = "tb_kids")
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    @Enumerated(EnumType.STRING)
    private Kidtype kidtype;
}
