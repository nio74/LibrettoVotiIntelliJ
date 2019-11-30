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
     * @return {@code true} nel caso normale, {@code false} se non è riuscito ad
     *          aggiungere il voto
     */
    public boolean add(Voto v) {
        if (!this.esisteGiaVoto(v) && !this.votoInConflitto(v)){
            voti.add(v);
            return true;
        }
        else{
            return false;
        }

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
       Voto voto = new Voto(0,nomeEsame,null);
       int pos = this.voti.indexOf(voto);
       if ( pos == -1)
           return null;
       else
           return this.voti.get(pos);

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
        int pos = this.voti.indexOf(v);
        if(pos == -1)
            return false;
        else
            return (v.getPunti() == this.voti.get(pos).getPunti());


    }

    /**
     * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti
     * esistenti. Se il voto non esiste, non c'è conflitto. Se esiste ed ha
     * punteggio diverso,c'è conflitto
     * @param v
     * @return {@code true} se il voto esiste ed ha un punteggio diverso,
     *          {@code false} se il voto non esiste,oppure esiste ma ha
     *          lo stesso punteggio
     */
    public boolean votoInConflitto(Voto v) {
        int pos = this.voti.indexOf(v);
        if(pos == -1)
            return false;
        else
            return (v.getPunti() != this.voti.get(pos).getPunti());


    }

    @Override
    public String toString() {
        return String.format(
                "Libretto [voti=%s]",
                this.voti);
    }
}
