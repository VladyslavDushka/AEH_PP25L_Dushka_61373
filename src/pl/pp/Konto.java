package pl.pp;

public class Konto {
    private String numerKonta;
    private double dostepneSrodki;
    private String wlasciciel;
    private String email;
    private String telefon;

    public Konto(String numerKonta, double dostepneSrodki, String wlascicel,
                 String email, String telefon) {
        this.numerKonta = numerKonta;
        this.dostepneSrodki = dostepneSrodki;
        this.wlasciciel = wlasciciel;
        this.email = email;
        this.telefon = telefon;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public double getDostepneSrodki() {
        return dostepneSrodki;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }

    public void setDostepneSrodki(double dostepneSrodki) {
        this.dostepneSrodki = dostepneSrodki;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void wyplata(double kwota) {
        if (kwota <= dostepneSrodki) {
            dostepneSrodki -= kwota;
            System.out.printf("Pobrano PLN %.1f z konta, Pozostale saldo = PLN %.1f%n", kwota, dostepneSrodki);
        } else {
            System.out.printf("Brak srodkow. Masz PLN %.1f na koncie.", dostepneSrodki);
        }
    }

    public void wplata(double kwota) {
        dostepneSrodki += kwota;
        System.out.printf("Wplata %.1f zostala wykonana. Nowe saldo = %.1f%n", kwota, dostepneSrodki);
    }

    public static void main(String[] args) {
        Konto mojeKonto = new Konto ("123456789", 1000, "Krzysztof Piatek", "Krzys1231@gmail.com",
                "+48 652 194 653");
        mojeKonto.wyplata(900.0);
        mojeKonto.wplata(250.0);
        mojeKonto.wyplata(50.0);
        mojeKonto.wyplata(3000.0);
    }
}

