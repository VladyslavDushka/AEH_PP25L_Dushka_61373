package pl.pp;

import java.util.*;

public class Wypozyczalnia {
    private Map<String, Pojazd> dostepnePojazdy = new HashMap<>();
    private Map<String, Pojazd> wypozyczonePojazdy = new HashMap<>();

    public void dodajPojazd(Pojazd pojazd) {
        dostepnePojazdy.put(pojazd.getNrRejestracyjny(), pojazd);
    }

    public void wypozyczPojazd(String nrRejestracyjny) {
        if (dostepnePojazdy.containsKey(nrRejestracyjny)) {
            Pojazd pojazd = dostepnePojazdy.remove(nrRejestracyjny);
            wypozyczonePojazdy.put(nrRejestracyjny, pojazd);
            System.out.println("Wypożyczono pojazd: " + nrRejestracyjny);
        } else {
            System.out.println("Pojazd niedostępny.");
        }
    }

    public void zwrocPojazd(String nrRejestracyjny) {
        if (wypozyczonePojazdy.containsKey(nrRejestracyjny)) {
            Pojazd pojazd = wypozyczonePojazdy.remove(nrRejestracyjny);
            dostepnePojazdy.put(nrRejestracyjny, pojazd);
            System.out.println("Zwrócono pojazd: " + nrRejestracyjny);
        } else {
            System.out.println("Nie znaleziono wypożyczonego pojazdu.");
        }
    }

    public void pokazDostepne() {
        System.out.println("\nDostępne pojazdy:");
        for (Pojazd p : dostepnePojazdy.values()) {
            p.wyswietlInformacje();
        }
    }
}

