package it.nio74maz.libretto;

import java.time.LocalDate;
import java.util.Objects;

public class Voto {
    private int punti;
    private String corso;
    private LocalDate data;

    public Voto(int punti, String corso, LocalDate data) {
        this.punti = punti;
        this.corso = corso;
        this.data = data;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format(
                "Voto [punti=%s, corso=%s, data=%s]",
                this.punti,
                this.corso,
                this.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return corso.equals(voto.corso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corso);
    }
}
