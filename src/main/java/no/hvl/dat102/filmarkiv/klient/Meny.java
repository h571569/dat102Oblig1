package no.hvl.dat102.filmarkiv.klient;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;

import java.util.Scanner;

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
        int i = 0;
        Scanner input = new Scanner(System.in);
        while (i != 7) {
            System.out.println("Meny: ");
            System.out.println( "1. Les Film " +
                                "\n2. Skriv ut film " +
                                "\n3. Søk etter filmer med tittel " +
                                "\n4. Søk etter filmer med produsent " +
                                "\n5. Skriv ut statistikk " +
                                "\n6. Legg til film " +
                                "\n7. Exit" );

            String valg = input.nextLine();

            switch (valg) {
                case "1":
                    tekstgr.skrivUtFilm(tekstgr.lesFilm());
                    break;
                case "2":
                    System.out.println("Skriv inn filmnr mellom 1 og " + filmarkiv.antall());
                    int filmnr = input.nextInt();
                    input.nextLine();
                    if (filmnr < filmarkiv.antall() || filmnr > 0) {
                        tekstgr.skrivUtFilm(filmarkiv.finnFilm(filmnr));
                    } else {
                        System.out.println("Filmnr må være mellom 1 og " + filmarkiv.antall());
                    }
                    break;
                case "3":
                    System.out.println("Skriv inn ett søkeord for tittel");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, input.nextLine());
                    break;
                case "4":
                    System.out.println("Skriv inn ett søkeord for produsent");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, input.nextLine());
                    break;
                case "5":
                    System.out.println("Skriver ut statisikk for filmarkiv:");
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case "6":
                    System.out.println("Legg til en ny film:");
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    break;
                case "7":
                    System.out.println("Lukker applikasjonen...");
                    i = 7;
                    break;
            }
        }
        input.close();
    }
}
