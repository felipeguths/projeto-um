package br.com.felipeaulas.projetoum.toy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Long> {
}
