package pl.pp;

public class Motocykl extends Pojazd implements TypPaliwa {
    private boolean posiadaDostawke;
    private String typPaliwa;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena,
                    double spalanie, double poziomPaliwa, double przebieg,
                    boolean posiadaDostawke, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.posiadaDostawke = posiadaDostawke;
        this.typPaliwa = typPaliwa;
    }

    public String getTypPaliwa() {
        return typPaliwa;
    }

    public void wyswietlInformacje() {
        System.out.println("Motocykl - z dostawką: " + posiadaDostawke + ", paliwo: " + typPaliwa);
    }
}

