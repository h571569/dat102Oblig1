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
    }

    @Test
    void slettFilm() {
    }

    @Test
    void soekTittel() {
    }

    @Test
    void soekProdusent() {
    }

    @Test
    void antall() {
    }

    @Test
    void testAntall() {
    }
}