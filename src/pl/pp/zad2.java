package pl.pp;
import java.util.Scanner;
public class zad2 {
    public static int sumaCyfr(int liczba) {
        if (liczba == 0) {
            return 0;
        } else {
            return (liczba % 10) + sumaCyfr(liczba / 10);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("wpisz liczbe:");
        int liczba = scanner.nextInt();
        int suma = sumaCyfr(liczba);
        System.out.println("Suma cyfr: " + suma);
    }
}




