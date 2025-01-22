package no.hvl.dat102.filmarkiv.impl;

import java.util.Objects;

public class Film {

    private String tittel;
    private int filmnr;
    private String produsent;
    private int lansering;
    private String filmselskap;
    private Sjanger sjanger;

    public Film(){}

    public Film (String tittel, int filmnr, String produsent, int lansering, String filmselskap, Sjanger sjanger) {
        this.tittel = tittel;
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.lansering = lansering;
        this.filmselskap = filmselskap;
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public int getLansering() {
        return lansering;
    }

    public void setLansering(int lansering) {
        this.lansering = lansering;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }
    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmnr);
    }
}
