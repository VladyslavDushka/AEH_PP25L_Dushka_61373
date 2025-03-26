package pl.pp;
import java.util.Scanner;
public class MojaCzwartaAplikacja2 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean kontynuuj = true;
        while (kontynuuj) {
            System.out.println("Wybierz operacje z ponizej podanych:");
            System.out.println("1 - dodawanie");
            System.out.println("2 - odejmowanie");
            System.out.println("3 - mnozenie");
            System.out.println("4 - dzielenie");
            System.out.println("-1 - wyjscie");
            int wybor = scanner.nextInt();
            if ( wybor == -1 ) {
                System.out.println("Wyjscie");
            break;
            }
            if ( wybor < 1 || wybor > 4){
                System.out.println("Niepoprawy wybor, sproboj ponownie.");
                continue;
            }
            System.out.println("Podaj pierwszą liczbę: ");
            double liczba1 = scanner.nextDouble();
            System.out.println("Podaj druga liczbe:");
            double liczba2 = scanner.nextDouble();
            switch ( wybor) {
                case 1 :
                    System.out.println(" Wynik " + ( liczba1 + liczba2));
                    break;
                case 2 :
                    System.out.println(" Wynik " + ( liczba1 - liczba2));
                case 3 :
                    System.out.println(" Wynik " + ( liczba1 * liczba2));
                case 4 :
                    if (liczba2 == 0) {
                        System.out.println("Blad, nie mozna dzielic przez zero.");}else
                {System.out.println(" Wynik " + ( liczba1 / liczba2)); break;}


        }
    }
        scanner.close();
    }

}
