package br.com.felipeaulas.projetoum.times;

public class TimesNotFoundException extends RuntimeException {
    public TimesNotFoundException(){
        super("Time não encontrado");
    }
}
