package br.com.felipeaulas.projetoum.sapato;

public class SapatoNotFoundException extends RuntimeException{
    public SapatoNotFoundException() {
        super("Sapato não encontrado");
    }
}
