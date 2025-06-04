public class Osobowe extends Pojazd implements TypPaliwa {
    private int liczbaDrzwi;
    private String typPaliwa;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena,
                   double spalanie, double poziomPaliwa, double przebieg,
                   int liczbaDrzwi, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.liczbaDrzwi = liczbaDrzwi;
        this.typPaliwa = typPaliwa;
    }

    public String getTypPaliwa() {
        return typPaliwa;
    }

    public void wyswietlInformacje() {
        System.out.println("Auto osobowe - drzwi: " + liczbaDrzwi + ", paliwo: " + typPaliwa);
    }
}

