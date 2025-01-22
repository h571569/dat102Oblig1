package no.hvl.dat102.filmarkiv.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static no.hvl.dat102.filmarkiv.impl.Sjanger.*;
import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {

    private Filmarkiv filmarkiv;

    @BeforeEach
    void setUp() {
        filmarkiv = new Filmarkiv(5);
        filmarkiv.leggTilFilm(new Film("IT", 1, "ryan", 2008, "Lion", SKREKK));
        filmarkiv.leggTilFilm(new Film("Løvenes Konge", 2, "even", 1995, "Disney", ACTION));
        filmarkiv.leggTilFilm(new Film("Berseker", 3, "david", 2022, "star", DRAMA));
        filmarkiv.leggTilFilm(new Film("Equalizer", 4, "denzel", 2010, "fish", ACTION));
        filmarkiv.leggTilFilm(new Film("Mission impossible", 5, "tom", 2019, "Disney", ACTION));
    }

    @Test
    void finnFilm() {
        Film film = filmarkiv.finnFilm(2);
        assertNotNull(film);
        assertEquals(2, film.getFilmnr());
        assertEquals("Løvenes Konge", film.getTittel());
        assertNull(filmarkiv.finnFilm(6));
        //legg til assert med object return
    }

    @Test
    void leggTilFilm() {
        assertEquals(5, filmarkiv.antall());
        filmarkiv.leggTilFilm(new Film("Biler", 6, "adrian", 2003, "disney", KOMEDIE));
        assertEquals(6, filmarkiv.antall());
    }

    @Test
    void slettFilm() {
        filmarkiv.slettFilm(5);
        assertEquals(4, filmarkiv.antall());
        filmarkiv.slettFilm(2);
        assertEquals(3, filmarkiv.antall());
    }

    @Test
    void soekTittel() {
        Film[] filmer = filmarkiv.soekTittel("mis");
        assertNotNull(filmer);
        assertEquals(1, filmer.length);
        assertEquals("Mission impossible", filmer[0].getTittel());
        Film[] filmer1 = filmarkiv.soekTittel("i");
        assertNotNull(filmer1);
        assertEquals(3, filmer1.length);

    }

    @Test
    void soekProdusent() {
        Film[] filmer = filmarkiv.soekProdusent("Dav");
        assertNotNull(filmer);
        assertEquals(1, filmer.length);
        assertEquals("david", filmer[0].getProdusent());
        Film[] filmer1 = filmarkiv.soekProdusent("d");
        assertNotNull(filmer1);
        assertEquals(2, filmer1.length);
    }

    @Test
    void antall() {
        assertEquals(3,filmarkiv.antall(ACTION));
        assertEquals(1,filmarkiv.antall(DRAMA));
        assertEquals(1,filmarkiv.antall(SKREKK));

    }

    @Test
    void testAntall() {
        assertEquals(5, filmarkiv.antall());
        filmarkiv.slettFilm(5);
        assertEquals(4, filmarkiv.antall());
    }
}