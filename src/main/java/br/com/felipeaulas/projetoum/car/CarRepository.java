package br.com.felipeaulas.projetoum.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByName(String name);
    List<Car> findAllByColor(String color);
    List<Car> findAllByColorAndName(String color, String name);
    List<Car> findAllByCarBrand(CarBrand carBrand);

}
