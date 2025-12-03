package ProjectJezykiProg;
import java.util.Scanner;
import java.util.Random;


interface Modyfikowalny{
    boolean dodajMleko();
    boolean dodajCukier();
    boolean czyMoznaMleko();
    // jest tu, po to zeby oddzielic logike modyficacji , np. kawa i herbata  od deserow
}

abstract class Product {
    protected String nazwa;
    protected double cena;
    protected boolean czyZepsuty = false;
    // klasa abstrakcyjna, ktora przechowuje wspolne pola(cena,nazwa)

    public Product(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        // konstruktor
    }

    public double getCena() {
        return this.cena; // getter
    }

    public boolean isZepsuty() {
        return czyZepsuty;
         // metoda zeby sprawdzic czy produkt jest zepsuty
    }

    public void zepsujProduct() {
        this.czyZepsuty = true;
        this.nazwa += " [ZNISZCZONY!]";
        // metoda zeby popsuc produkt
    }

    public abstract String pobierzOpis();
    // u nowych produktow musi byc ta metoda, bedzie dzialac tak, jak oni tego chca
}

class Kawa extends Product implements Modyfikowalny{
    private int iloscCukru = 0;
    private boolean czyZMlekiem = false;
    private Random randomizer = new Random();
// sa private, aby wymusic korzystanie z metod

    public Kawa(String nazwa, double cena) {
        super(nazwa, cena);
        // konstruktor, ktory dziedziczy
    }

    @Override
    public String pobierzOpis() {
        String info= "";
        if (czyZMlekiem) info += " z mlekiem ";
        if (iloscCukru > 0) info += " cukier x" + iloscCukru;
        return "Kawa: "+ nazwa + info;
    }

    @Override
    public boolean dodajMleko() {
        if (randomizer.nextInt(100) < 20){
            System.out.println(" [!] O NIE, ROZLALES MLEKO!");
            zepsujProduct();
            return false;
        }
        if (czyZMlekiem){
            System.out.println(" (info) Juz masz mleko!");
        } else {
            this.czyZMlekiem = true;
            this.cena += 2.0;
            System.out.println(" >> DODANO MLEKO (+2.00 zl).");
        }
        return true;
    }

    public void dodajMlekoCicho(){
        this.czyZMlekiem = true;
        this.cena += 2.0;
    }

    @Override
    public boolean dodajCukier() {
        if (randomizer.nextInt(100) < 20){
            System.out.println(" [!] ROZSYPALES CUKIER!");
            zepsujProduct();
            return false;
        } else {
            this.iloscCukru++;
            System.out.println(" >> DODANO CUKIER!");
            return true;
        }
    }

    public void dodajCukierCicho(){
        iloscCukru++;
    }

    @Override
    public boolean czyMoznaMleko() { return true; }
}

class Herbata extends Product implements Modyfikowalny{
    private int iloscCukru = 0;
    private boolean czyZCytryna = false;
    private Random randomizer = new Random();


    public Herbata(String nazwa, double cena) {
        super(nazwa, cena);
    }


    @Override
    public boolean czyMoznaMleko() {
        return false;
    }

    @Override
    public boolean dodajMleko() {
        System.out.println( " [!] NIE DODAMJEMY MLEKA DO HERBATY!");
        return true; // zwrocilismy true, zeby kontynuowac gre
    }


    @Override
    public boolean dodajCukier() {
        if (randomizer.nextInt(100) < 20){
            System.out.println(" [!] ROZSYPALES CUKIER!");
            zepsujProduct();
            return false;
        }
        this.iloscCukru ++ ;
        System.out.println(" >> DODANO CUKIER!");
        return true;
    }

    public void dodajCukierCicho(){
        iloscCukru++;
    }

    public void dodajCytryne(){
        this.czyZCytryna = true;
        this.cena += 1.0;
        System.out.println(" >> DODANO CYTRYNE (+1.00 zl).");
    }

    public void dodajCytryneCicho(){
        this.czyZCytryna = true;
        this.cena += 1.0;
    }


    @Override
    public String pobierzOpis() {
        String info = "";
        if (czyZCytryna) info += " z cytryna";
        if (iloscCukru>0) info += ", cukier x" + iloscCukru;
        return "Herbata: " + nazwa + info;
    }
}


class Deser extends Product {

    private boolean czyNaCieplo;

    public Deser(String nazwa, double cena, boolean czyNaCieplo) {
        super(nazwa, cena);
        this.czyNaCieplo = czyNaCieplo;
    }


    @Override
    public String pobierzOpis() {
        String temp = czyNaCieplo ? " na cieplo " : " na zimno ";
        return "Deser " + nazwa + temp;
    }
}



class Klient {
    private String imie;
    private int hojnosc;

    public Klient(String imie) {
        this.imie = imie;
        this.hojnosc = new Random().nextInt(100);
        // konstruktor
    }

    public Zamowienie zlozZamowienie() {
        Random randomizer = new Random();
        int los = randomizer.nextInt(5);// bo mamy menu z 5 pozycji

        Product product;
        if (los == 0)
            product = new Kawa("Espresso", SymulatorKawiarni.CENA_ESPRESSO);
        else if (los == 1) {
            Kawa kawa = new Kawa("Latte", SymulatorKawiarni.CENA_LATTE);
            kawa.dodajMlekoCicho();
            kawa.dodajCukierCicho();
            product = kawa;
        } else if (los == 2) {
            Herbata herbata = new Herbata("Earl Grey", SymulatorKawiarni.CENA_HERBATA);
            herbata.dodajCukierCicho();
            herbata.dodajCytryneCicho();
            product = herbata;
        } else if (los == 3) {
            product = new Deser("Sernik", SymulatorKawiarni.CENA_SERNIK, false);
        } else {
            product = new Deser("Szarlotka", SymulatorKawiarni.CENA_SZARLOTKA, true);
        }

        return new Zamowienie(product);
    }

    public double dajNapiwek(){
        if (hojnosc > 50) { return 2.0 * new Random().nextDouble() * 5.0; }
        return 0.0;
    }

    public String getImie(){return imie;}
}



class Zamowienie{
    private String trescZamowienia;

    public Zamowienie(Product ProductWzorcowy){
        this.trescZamowienia = ProductWzorcowy.pobierzOpis();
    }

    public String getTrescZamowienia (){
        return trescZamowienia;
    }
}




public class SymulatorKawiarni {
    public static final double CENA_ESPRESSO = 10.0;
    public static final double CENA_LATTE = 15.0;
    public static final double CENA_HERBATA = 12.0;
    public static final double CENA_SZARLOTKA = 12.0;
    public static final double CENA_SERNIK = 17.0;




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double zarobki = 0.0;
        int punkty = 0;
        int liczbaKlientow = 5;

        System.out.println("=== COFFEE SHOP : CODE & COFFEE ===");



        for (int i = 1; i <= liczbaKlientow; i++) {

            System.out.println("\n--------- MENU ---------");
            System.out.println("1. Espresso     " + SymulatorKawiarni.CENA_ESPRESSO + " zl");
            System.out.println("2. Latte        " + SymulatorKawiarni.CENA_LATTE + " zl");
            System.out.println("3. Earl Grey    " + SymulatorKawiarni.CENA_HERBATA + " zl");
            System.out.println("4. Szarlotka    " + SymulatorKawiarni.CENA_SZARLOTKA + " zl");
            System.out.println("5. Sernik       " + SymulatorKawiarni.CENA_SERNIK + " zl");
            System.out.println("------------------------");

            Klient klient = new Klient("Klient " + i);
            Zamowienie zamowienie = klient.zlozZamowienie();

            System.out.println("\n---TURA " + i + " ---");
            System.out.println("Przychodzi: " + klient.getImie());
            System.out.println("ZAMOWIENIE: " + zamowienie.getTrescZamowienia());


            Product prodWybrany = null;
            System.out.println("Co przygotujesz? (Wpisz numer)");
            System.out.print("> ");
            String wybor = scanner.nextLine();


            switch (wybor) {
                case "1":
                    prodWybrany = new Kawa("Espresso", CENA_ESPRESSO);
                    break;
                case "2":
                    prodWybrany = new Kawa("Latte", CENA_LATTE);
                    break;
                case "3":
                    prodWybrany = new Herbata("Earl Grey", CENA_HERBATA);
                    break;
                case "4":
                    System.out.println("Czy podgzrac szarlotke? (t = tak, n = nie) ");
                    String decyzjaSzarl = scanner.nextLine();
                    boolean czyPodgrzewamSzarl = decyzjaSzarl.equalsIgnoreCase("t");
                    prodWybrany = new Deser("Szarlotka", CENA_SZARLOTKA, czyPodgrzewamSzarl);
                    break;
                case "5":
                    System.out.println("Czy podgzrac sernik? (t = tak, n = nie) ");
                    String decyzjaSernik = scanner.nextLine();
                    boolean czyPodgrzewamSernik = decyzjaSernik.equalsIgnoreCase("t");
                    prodWybrany = new Deser("Sernik", CENA_SERNIK, czyPodgrzewamSernik);
                    break;
                default:
                    prodWybrany = new Deser("PUSTY TALERZ!", 0, false);
            }

            if (prodWybrany instanceof Modyfikowalny) {
                Modyfikowalny mod = (Modyfikowalny) prodWybrany;
                boolean gotowe = false;
                while (!gotowe && !prodWybrany.isZepsuty()) {
                    System.out.println("Dodatki? (1: Mleko [+2 zl], 2: Cukier, 3: Cytryna [+1 zl], ENTER: Gotowe!)");
                    String modyfikacja = scanner.nextLine();

                    if (modyfikacja.equals("1")) {mod.dodajMleko();}
                    else if (modyfikacja.equals("2")) {mod.dodajCukier();}
                    else if (modyfikacja.equals("3")){
                        if (prodWybrany instanceof Herbata) ((Herbata)prodWybrany).dodajCytryne();
                        else System.out.println(" Cytryna tylko do herbaty! ");
                    } else { gotowe = true; }
                }
            }

            System.out.println("\n-> Podajesz: " + prodWybrany.pobierzOpis());

            if (prodWybrany.isZepsuty()){
                System.out.println(" Klient jest bardzo niezadowolony! Zostawil zla recenzje! (Produkt zepsuty)");
            } else if (prodWybrany.pobierzOpis().equals(zamowienie.getTrescZamowienia())){
                System.out.println(" SUKCES!");
                punkty ++;

                double aktualnaCena = prodWybrany.getCena();
                double napiwek = klient.dajNapiwek();

                zarobki += aktualnaCena + napiwek;

                System.out.printf(" KASA: %.2f zl (Produkt) %.2f zl (Napiwek)%n", aktualnaCena, napiwek);
            } else {
                System.out.println(" Klient niezadowolony (Zle zamowienie)! Brak zaplaty.");
            }
        }



        System.out.println("\n===KONIEC ZMIANY===");
        System.out.println("Zadowoleni klienci: "+ punkty + "/" + liczbaKlientow);
        System.out.printf("Calkowity utarg: %.2f zl %n" , zarobki);
    }

}









































































































































































