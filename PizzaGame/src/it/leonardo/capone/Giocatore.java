package it.leonardo.capone;

public class Giocatore {

    private String nome;
    private int ultimaMossa;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getUltimaMossa() {
        return ultimaMossa;
    }

    public void setUltimaMossa(int ultimaMossa) {
        this.ultimaMossa = ultimaMossa;
    }
}
