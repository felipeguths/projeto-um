package br.com.felipeaulas.projetoum.client;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(){
        super("Cliente não encontrado");
    }
}
