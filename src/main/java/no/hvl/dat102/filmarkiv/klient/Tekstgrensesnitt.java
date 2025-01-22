package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tekstgrensesnitt {

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {
        // TODO

        // Usikker på oppgaven

//        Scanner input = new Scanner(System.in);
//        System.out.print("Tast 1 eller 2");
//        System.out.print("1. Søke etter tittel\n" +
//                "2. Søke etter produsent");
//        String valg = input.nextLine();
//        switch(valg) {
//            case "1":
//                System.out.println("Skriv inn en tittel");
////
//                break;
//            case "2":
//                System.out.println("Skriv inn en produsent");
//
//                break;
//        }

        return null;
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
    // TODO
        System.out.println(film.toString());
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
    // TODO

        Film[] filmer = arkiv.soekTittel(delstreng);
        for (Film film : filmer) {
            System.out.println(film.toString());
        }


    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
    // TODO

        Film[] filmer = arkiv.soekProdusent(delstreng);
        for (Film film : filmer) {
            System.out.println(film.toString());
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
    // TODO

        System.out.println("Det er totalt " + arkiv.antall() + " filmer i arkivet");
        arkiv.antallSjanger();


    }
    // osv ... andre metoder
}
