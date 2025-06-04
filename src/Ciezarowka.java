public class Ciezarowka extends Pojazd implements TypPaliwa {
    private double ladownosc;
    private String typPaliwa;

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena,
                      double spalanie, double poziomPaliwa, double przebieg,
                      double ladownosc, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.ladownosc = ladownosc;
        this.typPaliwa = typPaliwa;
    }


    public String getTypPaliwa() {
        return typPaliwa;
    }

    public void wyswietlInformacje() {
        System.out.println("Ciężarówka - ładowność: " + ladownosc + ", paliwo: " + typPaliwa);
    }
}

