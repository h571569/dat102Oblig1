package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

import java.util.*;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmarkiv;

    private int antall;

    public Filmarkiv(int ant) {
        filmarkiv = new Film[ant];
        antall = 0;
    }

    private Film[] trimTab(Film[] tab, int n) {
        // n er antall elementer
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }


    private void utvid(Film[] film) {
        Film[] newFilm = new Film[film.length * 2];
        System.arraycopy(film, 0, newFilm, 0, film.length);
        filmarkiv = newFilm;
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
        if (antall == filmarkiv.length) {
            utvid(filmarkiv);
        }
        filmarkiv[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        boolean funnet = false;
        int i = 0;
        while (!funnet && i < antall) {
            if (filmarkiv[i].getFilmnr() == filmnr) {
                funnet = true;
                filmarkiv[i] = filmarkiv[antall - 1];
                filmarkiv[antall - 1] = null;
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
        int count = 0;

        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                filmer[count] = filmarkiv[i];
                count++;
            }
        }

        //kan gjøre begge deler
//      return Arrays.copyOf(filmer, count);
        return trimTab(filmer, count);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {

        Film[] filmer = new Film[antall];
        int count = 0;

        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                filmer[count] = filmarkiv[i];
                count++;
            }
        }
        //kan gjøre begge deler
        return Arrays.copyOf(filmer, count);
//      return trimTab(filmer, count);
    }

    @Override
    public int antall(Sjanger sjanger) {

        int ant = 0;
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getSjanger().equals(sjanger)) {
                ant++;
            }
        }
        return ant;
    }

    @Override
    public int antall() {
        return antall;
    }


    //Ekstra metode for å lese ut frekvens av sjangerne
    //Litt leking med kode
    @Override
    public Map<Sjanger, Integer> antallPerSjanger() {

        Map<Sjanger, Integer> frekvens = new HashMap<>();

        for (int i = 0; i < antall; i++) {
            if (!frekvens.containsKey(filmarkiv[i].getSjanger())) {
                frekvens.put(filmarkiv[i].getSjanger(), 1);
            } else {
                frekvens.put(filmarkiv[i].getSjanger(), frekvens.get(filmarkiv[i].getSjanger()) + 1);
            }
        }
        return frekvens;
    }

}
