package br.com.felipeaulas.projetoum.meat;

public class MeatNotFoundException extends RuntimeException {
    public MeatNotFoundException() {
        super("Carne não encontrada");
    }
}
