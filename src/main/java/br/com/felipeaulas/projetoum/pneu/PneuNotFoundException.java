package br.com.felipeaulas.projetoum.pneu;

public class PneuNotFoundException extends RuntimeException{
    public PneuNotFoundException(){
        super("Pneu Não Encontrado");
    }
}
