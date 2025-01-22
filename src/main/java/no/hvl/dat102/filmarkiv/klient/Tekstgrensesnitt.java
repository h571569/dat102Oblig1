package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;

public class Tekstgrensesnitt {

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm() {
        // TODO
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
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
    // TODO
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
    // TODO
    }
    // osv ... andre metoder
}
