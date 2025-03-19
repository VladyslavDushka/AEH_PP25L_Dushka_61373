package pl.pp;
import java.util.Scanner;
public class MojaTrzeciaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj liczbe dni:");
            int dni = scanner.nextInt();
            if (dni < 0) {
                System.out.println("zakoncznie programu");
                break;
            }
            int tygodnie = dni / 7;
            int resztadni = dni % 7;
            System.out.println(dni + " dni to " + tygodnie + " tygodnie i " + resztadni + " dni ");

        }
        scanner.close();
    }
}



