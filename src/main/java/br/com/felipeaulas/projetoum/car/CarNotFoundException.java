package br.com.felipeaulas.projetoum.car;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException() {
        super("Carro não encontrado");
    }
}
