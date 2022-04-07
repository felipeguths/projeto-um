package br.com.felipeaulas.projetoum.log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "who_do")
    private String whoDo;
    @Column(name = "action")
    private String action;
    @Column(name = "description", length = 4000)
    private String description;
    @CreationTimestamp //preenche o localDateTime com a data e hora da criação do objeto
    private LocalDateTime dateTime;

    public Log(String whoDo, LogAction action, String description) {
        this.whoDo = whoDo;
        this.action = action.toString();
        this.description = description;
    }
}
