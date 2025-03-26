package pl.pp;
import java.util.Scanner;
public class MojaCzwartaAplikacja {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Podaj gorny oraz dolny limit:");
            int lower = scanner.nextInt();
            int upper = scanner.nextInt();
            if (lower >= upper) {
                System.out.println("Done");
                break;
            }
            int square = lower * lower;
            int square2 = upper * upper;
            int sum = 0;
            for (int i = lower; i <= upper; i++) {
                sum = sum +  i*i;
            }
            System.out.println("The sum of squares from " + square + " to " + square2 + " is " + sum);




    }
}}
