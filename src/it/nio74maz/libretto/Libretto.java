package it.nio74maz.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

    private List<Voto> voti;

    public Libretto() {

        this.voti = new ArrayList<Voto>();

    }
    /**
     * Aggiungere un nuovo voto al libretto
     * @param v il{@link voto}
     */
    public void add(Voto v) {
        voti.add(v);
    }

    /**
     * Seleziona il sottoinsieme di voti che hanno ilk ipunteggio specificato
     * @param punti punteggio da ricercare
     * @return lista di {@ Voto} aventi tutti quel punteggio(eventualmente vuota)
     */
    public  List<Voto> cercaVoti(int punti){

        List<Voto> result = new ArrayList<Voto>();

        for (Voto v: this.voti){
            if (v.getPunti()== punti){
                result.add(v);
            }
        }
        return result;
    }

    /**
     * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
     *
     * @param nomeEsame nome del corso da cercare
     * @return il {@link Voto} corrispondente, oppure {@code null} se non esistente
     */
    public Voto cercaEsame(String nomeEsame){
        for(Voto v : this.voti){
            if (v.getCorso().equals(nomeEsame))
            {
                return v;
            }
        }
        return  null;
    }

    /**
     * Dato un{@link Voto}, determino se esiste già un voto con uguale
     * corso ed uguale punteggio.
     * @param v
     * @return {@code true}, se ha trovato un corso e punteggio uguali,
     *         {@code false}, se non ha trovato il corso,oppure l'ha trovato con
     *         voto diverso
     */
    public boolean esisteGiaVoto(Voto v) {
        Voto trovato = this.cercaEsame(v.getCorso());
        if (trovato == null)
            return false;
        if (trovato.getPunti() == v.getPunti()) {
            return true;
        }else{
            return false;
        }



    }

}
