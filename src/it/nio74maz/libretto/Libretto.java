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

}
