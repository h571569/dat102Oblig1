package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;

import static no.hvl.dat102.filmarkiv.impl.Sjanger.*;
import static no.hvl.dat102.filmarkiv.impl.Sjanger.ACTION;

public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;


    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
    // legg inn en del forhåndsdefinerte filmer for å teste metodene

        filmarkiv.leggTilFilm(new Film("IT", 1, "ryan", 2008, "Lion", SKREKK));
        filmarkiv.leggTilFilm(new Film("Løvenes Konge", 2, "even", 1995, "Disney", ACTION));
        filmarkiv.leggTilFilm(new Film("Berseker", 3, "david", 2022, "star", DRAMA));
        filmarkiv.leggTilFilm(new Film("Equalizer", 4, "denzel", 2010, "fish", ACTION));
        filmarkiv.leggTilFilm(new Film("Mission impossible", 5, "tom", 2019, "Disney", ACTION));

    // Terste metodene
        tekstgr.skrivUtFilm(filmarkiv.finnFilm(2));
        System.out.println();
        tekstgr.skrivUtStatistikk(filmarkiv);
    // ..
    // TODO
    }
}
