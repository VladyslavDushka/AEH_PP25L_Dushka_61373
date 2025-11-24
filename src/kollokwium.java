//zadanie 1
//import java.util.Scanner;
//public class kollokwium {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("number: ");
//        int n = scanner.nextInt();
//
//        int sum = 0;
//
//        while(n>0){
//            int digit = n % 10;
//            if (digit % 3 == 0){
//                sum += digit;
//            }
//            n /= 10;
//        }
//        System.out.println("Suma cyfr podzielnych przez 3 = " + sum);
//    }
//}


//zadanie 2

//import java.util.Scanner;
//import java.util.Random;
//
//public class kollokwium {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        int n;
//        while(true){
//            System.out.print("Enter the size of array (must be >5): ");
//            n = scanner.nextInt();
//            if (n >= 5){
//                break;
//            }
//            System.out.println("Enter the right size");
//        }
//
//        int[]tablica = new int[n];
//        for (int i = 0; i<n; i++){
//            tablica[i] = random.nextInt(21)-10;
//        }
//        System.out.print("Wygenerowana tablica: ");
//        for (int x : tablica){
//            System.out.print(x + " ");
//        }
//
//        int countPositive = 0;
//        int countNegative = 0;
//        int zero = 0;
//        System.out.println();
//
//        for (int x : tablica){
//            if (x > 0){
//                countPositive ++;
//            }
//            if (x == 0){
//                zero ++;
//            }
//            if (x < 0){
//                countNegative ++;
//            }
//        }
//        System.out.println("Dodatnie: "+ countPositive);
//        System.out.println("Ujemne: "+ countNegative);
//        System.out.println("zera: "+ zero);
//
//
//
//    }
//}


import java.util.Scanner;

public class kollokwium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println("suma odd numbers to " + n + " = " + oddSum(n));
    }

    public static int oddSum(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (n % 2 != 0) {
            return n + oddSum(n - 2);
        }
        else  {
            return oddSum(n - 1);
        }
    }
}

