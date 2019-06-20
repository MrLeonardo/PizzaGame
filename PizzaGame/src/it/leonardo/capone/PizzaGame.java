package it.leonardo.capone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaGame {

    public static final int NO_MOSSE_VALIDE  = 1;
    public static final int PROSSIMO_TURNO  = 2;
    public static final int PERSO  = 3;

    private List<Giocatore> giocatori;
    private Giocatore giocatorePrecedente;
    private int numeroPizze;

    public PizzaGame(int numeroGiocatori) {
        char nome = 'A';
        this.giocatori = new ArrayList<>();
        for(int i = 0; i < numeroGiocatori; i++) {
            this.giocatori.add(new Giocatore(String.valueOf(nome)));
            nome += 1;
        }
        this.numeroPizze = (int)(10 + Math.random() * 100);
    }

    public boolean mosseValide() {
        if(giocatorePrecedente != null &&
                giocatorePrecedente.getUltimaMossa() != 0 &&
                giocatorePrecedente.getUltimaMossa() == 1 &&
                numeroPizze == 1)
            return false;
        return true;
    }

    public boolean controllaPerdita() {
        if(numeroPizze == 0)
            return true;
        return false;
    }

    public int turno(int index) {
        int toReturn;
        Scanner scan = new Scanner(System.in);

        if(mosseValide()) {
            int scelta = 0;

            do {
                try {
                    StringBuilder sb = new StringBuilder();
                    System.out.print(sb.append("Giocatore ")
                            .append(giocatori.get(index).getNome())
                            .append(" scegli il numero di pizze da mangiare ")
                            .append("(un numero tra 1 e 3 diverso dalla scelta del giocatore precedente): ")
                            .toString());
                    scelta = Integer.parseInt(scan.nextLine());
                } catch (Exception ex) {}
            } while ((scelta <= 0 || scelta > 3) ||
                    (giocatorePrecedente != null &&
                    scelta == giocatorePrecedente.getUltimaMossa()) ||
                    ((numeroPizze - scelta) < 0));

            giocatori.get(index).setUltimaMossa(scelta);
            numeroPizze -= scelta;
            toReturn = controllaPerdita() ? PERSO : PROSSIMO_TURNO;
        }
        else {
            toReturn = NO_MOSSE_VALIDE;
            giocatori.get(index).setUltimaMossa(0);
        }

        return toReturn;
    }

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    public Giocatore getGiocatorePrecedente() {
        return giocatorePrecedente;
    }

    public void setGiocatorePrecedente(Giocatore giocatorePrecedente) {
        this.giocatorePrecedente = giocatorePrecedente;
    }

    public int getNumeroPizze() {
        return numeroPizze;
    }

    public static void main(String[] args) {
        int i = 0;
        boolean fineGioco = false;
        int numeroGiocatori = 2;

        PizzaGame pizzaGame = new PizzaGame(numeroGiocatori);

        System.out.println("Numero giocatori: " + numeroGiocatori);
        System.out.println("Sul tavolo sono presenti: " + pizzaGame.getNumeroPizze());

        while(!fineGioco) {
            switch (pizzaGame.turno(i)) {
                case PizzaGame.NO_MOSSE_VALIDE:
                    System.out.println("Vince il Giocatore " + pizzaGame.getGiocatori().get(i).getNome());
                    fineGioco = true;
                    break;
                case PizzaGame.PROSSIMO_TURNO:
                    pizzaGame.setGiocatorePrecedente(pizzaGame.getGiocatori().get(i));
                    System.out.println("Sul tavolo ci sono " + pizzaGame.getNumeroPizze() + " pizze");
                    i = (i + 1) % numeroGiocatori;
                    break;
                case PizzaGame.PERSO:
                    System.out.println("Vince il Giocatore " + pizzaGame.getGiocatorePrecedente().getNome());
                    fineGioco = true;
                    break;
                default:
                    break;
            }
        }
    }
}
