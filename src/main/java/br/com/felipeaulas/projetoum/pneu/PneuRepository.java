package br.com.felipeaulas.projetoum.pneu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PneuRepository extends JpaRepository<Pneu, Long> {
    List<Pneu> findAllByName(String name);
    List<Pneu> findAllByPneuType(PneuType pneuType);
}
