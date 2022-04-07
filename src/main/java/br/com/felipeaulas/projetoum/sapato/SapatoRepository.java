package br.com.felipeaulas.projetoum.sapato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SapatoRepository extends JpaRepository<Sapato, Long>{
    List<Sapato> findAllByName(String name);
    List<Sapato> findAllByColor(String color);
    List<Sapato> findAllByColorAndName(String color, String name);
    List<Sapato> findAllBySapatoBrand(SapatoBrand sapatoBrand);

}
