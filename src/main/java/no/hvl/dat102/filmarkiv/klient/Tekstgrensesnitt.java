package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class Tekstgrensesnitt {

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(int filmnr) {
        // TODO
        // Usikker på oppgaven. Skal bruker kunne skrive inn tittel, produesnt, sjanger osv også skal vi:
        // return new film(tittel, produsent, sjanger ... etc) ?

        Scanner input = new Scanner(System.in);

        System.out.println("Tittel:");
        String tittel = input.nextLine();

        System.out.println("produsent:");
        String produsent = input.nextLine();

        System.out.println("lansering:");
        int lansering = input.nextInt();
        input.nextLine();

        System.out.println("filmselskap:");
        String filmselskap = input.nextLine();

        System.out.println("Velg mellom Sjanger:");
        System.out.println(Arrays.toString(Sjanger.values()));
        Sjanger sjanger = Sjanger.valueOf(input.nextLine().toUpperCase());

        return new Film(tittel,filmnr, produsent, lansering, filmselskap, sjanger);
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
        if(filmer.length > 0) {
            for (Film film : filmer) {
                System.out.println(film.toString());
            }
        } else {
            System.out.println("Ingen filmer med det søkeordet");
        }


    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        // TODO

        Film[] filmer = arkiv.soekProdusent(delstreng);
        if (filmer.length > 0) {
            for (Film film : filmer) {
                System.out.println(film.toString());
            }
        } else {
            System.out.println("Ingen filmer med det søkeordet");
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

        // Kan gjøre begge deler

        Map<Sjanger, Integer> frekvens = arkiv.antallPerSjanger();

        for(Map.Entry<Sjanger,Integer> entry : frekvens.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
    // osv ... andre metoder
}
