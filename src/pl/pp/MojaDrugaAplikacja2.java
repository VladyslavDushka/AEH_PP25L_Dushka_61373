package pl.pp;
import java.util.Scanner;
public class MojaDrugaAplikacja2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoj wiek w latach:");
        int wiek = scanner.nextInt();
        int wiekseconds = wiek * 365 * 24 * 60 * 60;
        System.out.println("Twoj wiek w sekundach to:" + wiekseconds);
        scanner.close();

    }
}
