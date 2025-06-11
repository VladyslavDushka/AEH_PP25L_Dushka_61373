package pl.pp;

public class TestWypozyczalni {
    public static void main(String[] args) {
        Wypozyczalnia wypozyczalnia = new Wypozyczalnia();

        wypozyczalnia.dodajPojazd(new Osobowe("KR1234", "VIN001", "Czerwony", 50000, 7, 50, 10000, 5, "benzyna"));
        wypozyczalnia.dodajPojazd(new Ciezarowka("WA5678", "VIN002", "Niebieski", 80000, 12, 60, 20000, 1000, "diesel"));
        wypozyczalnia.dodajPojazd(new Motocykl("KT9012", "VIN003", "Czarny", 20000, 4, 20, 5000, true, "benzyna"));
        wypozyczalnia.dodajPojazd(new SprzetBudowlany("LU3456", "VIN004", "Żółty", 150000, 15, 80, 3000, 1200, "diesel"));

        wypozyczalnia.pokazDostepne();

        wypozyczalnia.wypozyczPojazd("KR1234");
        wypozyczalnia.wypozyczPojazd("KT9012");

        wypozyczalnia.pokazDostepne();

        wypozyczalnia.zwrocPojazd("KR1234");
        wypozyczalnia.pokazDostepne();
    }
}
