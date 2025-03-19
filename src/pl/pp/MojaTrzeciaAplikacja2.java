package pl.pp;
import java.util.Scanner;
public class MojaTrzeciaAplikacja2 {
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
        while (true) {
            System.out.println("Wprowadz temperature w skali Fahrenheita:");
            double celsjusz = scanner.nextDouble();
            if (celsjusz == -1) {
                System.out.println("Zatrzymanie programu");
                break;
            }

            double fahrenheit = 1.8 * celsjusz + 32.0;
            double kelwin = celsjusz + 273.16;
            System.out.printf("Celsjusz: %.2f°C, Fahrenheit: %.2f°F, Kelwin: %.2fK%n", celsjusz, fahrenheit, kelwin);
        }

            scanner.close();
        }
    }


