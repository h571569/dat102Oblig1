package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {
        // TODO
        // Usikker på oppgaven. Skal bruker kunne skrive inn tittel, produesnt, sjanger osv også skal vi:
        // return new film(tittel, produsent, sjanger ... etc) ?

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

        for(Sjanger sjanger : Sjanger.values()) {
            if (arkiv.antall(sjanger) > 0) {
                System.out.println("Det er " + arkiv.antall(sjanger) + " av " + sjanger.toString() + " i arkivet");
            }
        }
//        System.out.println(arkiv.antallPerSjanger());


    }
    // osv ... andre metoder
}
