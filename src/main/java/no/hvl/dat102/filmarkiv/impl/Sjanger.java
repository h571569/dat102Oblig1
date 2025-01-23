package no.hvl.dat102.filmarkiv.impl;

public enum Sjanger {
    ACTION, KOMEDIE, DRAMA, SKREKK, SCI_FI, ROMANSE;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equals(navn.toUpperCase())) {
                return s;
            }
        }
        return null;
    }
    public void skrivUt() {
        Sjanger[] sjanger = Sjanger.values();
    }

}
