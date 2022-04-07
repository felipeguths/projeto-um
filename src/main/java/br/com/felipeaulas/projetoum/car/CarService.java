package br.com.felipeaulas.projetoum.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car findById(Long id){
        return carRepository.findById(id)
                            .orElseThrow(CarNotFoundException::new);
    }

    public CarResponseDTO findByIdDTO(Long id){
        Car car = findById(id);
        return CarResponseDTO.convertFromEntity(car);
    }


    public List<CarResponseDTO> findAllByName(String name) {
        return convertToDTO(carRepository.findAllByName(name));
    }

    public List<CarResponseDTO> findAllByColor(String color) {
        return convertToDTO(carRepository.findAllByColor(color));
    }

    public List<CarResponseDTO> findAllByBrand(CarBrand carBrand){
        return  convertToDTO(carRepository.findAllByCarBrand(carBrand));
    }

    public List<CarResponseDTO> findAllByColorAndName(String color, String name) {
        return convertToDTO(carRepository.findAllByColorAndName(color, name));
    }

    public String getDiscount(Long id) {
        return findById(id).getCarDiscount();
    }


    private List<CarResponseDTO> convertToDTO(List<Car> carList){
        return carList.stream().map(CarResponseDTO::convertFromEntity)
                .collect(Collectors.toList());
    }
}
