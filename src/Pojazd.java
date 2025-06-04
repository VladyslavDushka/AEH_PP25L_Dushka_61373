public abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected double spalanie;
    protected double poziomPaliwa;
    protected double przebieg;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena,
                  double spalanie, double poziomPaliwa, double przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
    }

    public void prowadz() {
        System.out.println("Pojazd jedzie...");
        przebieg += 10;
        poziomPaliwa -= spalanie;
    }

    public void zatankuj() {
        System.out.println("Pojazd został zatankowany.");
        poziomPaliwa = 100;
    }

    public abstract void wyswietlInformacje();
}
