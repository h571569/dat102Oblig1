package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmarkiv;
    private int antall;

    public Filmarkiv(int ant) {
        filmarkiv = new Film[ant];
        antall = 0;
    }

    private void utvid (Film[] film) {
        Film[] newFilm = new Film[film.length*2];
        System.arraycopy(film, 0, newFilm, 0, film.length);
        film = newFilm;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getFilmnr() == nr) {
                return filmarkiv[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall >= filmarkiv.length) {
            utvid(filmarkiv);
        }
        filmarkiv[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        boolean funnet = false;
        int i = 0;
        while (!funnet && i<antall) {
            if (filmarkiv[i].getFilmnr() == filmnr) {
                funnet = true;
                filmarkiv[i] = filmarkiv[antall-1];
                filmarkiv[antall-1] = null;
                antall--;
            } else {
                i++;
            }
        }
        return funnet;
    }

    @Override
    public Film[] soekTittel(String delstreng) {

        Film[] filmer = new Film[antall];

        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                filmer[i] = filmarkiv[i];
            }
        }

        return filmer;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        Film[] filmer = new Film[antall];

        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                filmer[i] = filmarkiv[i];
            }
        }
        return filmer;
    }

    @Override
    public int antall(Sjanger sjanger) {

        int ant = 0;
        for (int i = 0; i < antall; i++) {
            if(filmarkiv[i].getSjanger().equals(sjanger)) {
                ant++;
            }
        }
        return ant;
    }

    @Override
    public int antall() {
        return antall;
    }
}
