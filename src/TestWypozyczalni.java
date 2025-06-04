public class TestWypozyczalni {
    public static void main(String[] args) {
        Pojazd auto = new Osobowe("KR1234", "1HGCM82633A004352", "Czerwony", 50000, 7.5, 50, 10000, 5, "benzyna");
        Pojazd ciezarowka = new Ciezarowka("WA5678", "2HGCM82633A004353", "Niebieski", 80000, 12.0, 60, 20000, 1000, "diesel");
        Pojazd motor = new Motocykl("KT9012", "3HGCM82633A004354", "Czarny", 20000, 4.0, 20, 5000, true, "benzyna");
        Pojazd koparka = new SprzetBudowlany("LU3456", "4HGCM82633A004355", "Żółty", 150000, 15.0, 80, 3000, 1200, "diesel");

        Pojazd[] pojazdy = {auto, ciezarowka, motor, koparka};

        for (Pojazd p : pojazdy) {
            p.wyswietlInformacje();
            p.prowadz();
            p.zatankuj();
            System.out.println();
        }
    }
}

