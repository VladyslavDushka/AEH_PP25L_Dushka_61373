package pl.pp;

public class MojaSzostaAplikacja {
    public static long factorialInterative (int n) {
        long result = 1;
        for (int i = 2; i <= n ; i++) {
            result *= i;
        }
        return result;
    }
    public static long factorialRecursive(int n) {
        if (n<=1) {
            return 1;
        }
        return n * factorialRecursive(n-1);
    }
    public static void main (String[] args) {
        int N = 5;
        long startInterative = System.nanoTime();
        long resultInterative = factorialInterative(N);
        long endInterative = System.nanoTime();
        long timeInterative = endInterative - startInterative;
        long startRecursive = System.nanoTime();
        long resultRecursive = factorialRecursive(N);
        long endRecursive = System.nanoTime();
        long timeRecursive = endRecursive - startRecursive;
        System.out.println("Silnia iteracyjnie (" + N + ") =" + resultInterative) ;
        System.out.println("Czas wykonania iteracyjnie: " + timeInterative + "ns");
        System.out.println("Silnia rekutencyjnie (" + N + ") =" + resultRecursive);
        System.out.println("Czas wykonania rekurencyjnie:" + timeRecursive + "ns");
    }
}
