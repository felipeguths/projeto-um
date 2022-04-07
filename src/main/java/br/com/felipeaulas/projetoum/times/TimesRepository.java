package br.com.felipeaulas.projetoum.times;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesRepository extends JpaRepository<Time, Long> {
    List<Time> findAllByName(String name);

    List<Time> findAllByCidade(String cidade);

    List<Time> findAllByTimesComMundial(TimesComMundial timesComMundial);

    List<Time> findAllByCidadeAndName(String cidade, String name);
}
