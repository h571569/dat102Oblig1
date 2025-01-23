package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;
import java.util.Map;

public class Filmarkiv2 implements FilmarkivADT {

    public class Node<T> {

        public T data;
        public Node<T> neste;

        private Node(T data) {
            this.data = data;
            this.neste = null;
        }
    }

    private int antall;
    private Node<Film> start;

    public Filmarkiv2() {
        start = null;
        antall = 0;

    }

    private boolean isEmpty() {
        return antall == 0;
    }

    @Override
    public Film finnFilm(int nr) {
        Node<Film> p = start;

        while(p != null) {
            if(p.data.getFilmnr() == nr) {
                return p.data;
            }
            p = p.neste;
        }
        return null;
    }

    private Node<Film> finnNodeFilm(int nr) {
        Node<Film> p = start;

        while(p != null) {
            if(p.data.getFilmnr() == nr) {
                return p;
            }
            p = p.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        Node ny = new Node(nyFilm);
        ny.neste = start;
        start = ny;
        antall++;
    }

    private void slettFilm() {
        if(isEmpty()) {
            return;
        }
        start = start.neste;
        antall--;
    }

    @Override
    public boolean slettFilm(int filmnr) {

        if (isEmpty()) {
            return false;
        }
        Node<Film> p = finnNodeFilm(filmnr);
        if (p == null) {
            return false;
        }
        p.data = start.data;
        slettFilm();

        return true;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Node<Film> p = start;
        Film[] film = new Film[antall];
        int ant = 0;

        while(p != null) {
            if(p.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                film[ant] = p.data;
                ant++;
            }
            p = p.neste;
        }
        return Arrays.copyOf(film, ant);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Node<Film> p = start;
        Film[] film = new Film[antall];
        int ant = 0;

        while(p != null) {
            if(p.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                film[ant] = p.data;
                ant++;
            }
            p = p.neste;
        }
        return Arrays.copyOf(film, ant);
    }

    @Override
    public int antall(Sjanger sjanger) {
        Node<Film> p = start;
        int ant = 0;

        while(p != null) {
            if(p.data.getSjanger().equals(sjanger)) {
                ant++;
            }
            p = p.neste;
        }
        return ant;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public Map<Sjanger, Integer> antallPerSjanger() {
        return Map.of();
    }


}
