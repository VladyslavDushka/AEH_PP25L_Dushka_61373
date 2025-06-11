package pl.pp;

public class SprzetBudowlany extends Pojazd implements TypPaliwa {
    private int przepracowaneGodziny;
    private String typPaliwa;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena,
                           double spalanie, double poziomPaliwa, double przebieg,
                           int przepracowaneGodziny, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.przepracowaneGodziny = przepracowaneGodziny;
        this.typPaliwa = typPaliwa;
    }

    public String getTypPaliwa() {
        return typPaliwa;
    }

    public void wyswietlInformacje() {
        System.out.println("Sprzęt budowlany - godziny: " + przepracowaneGodziny + ", paliwo: " + typPaliwa);
    }
}

