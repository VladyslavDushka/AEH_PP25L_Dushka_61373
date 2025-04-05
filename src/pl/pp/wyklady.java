package pl.pp;
import java.util.*;
public class wyklady {
    public static void main (String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Set<Integer> drawnNumbersSet = new HashSet<>();
        while (drawnNumbersSet.size() < 6) {
            drawnNumbersSet.add(random.nextInt(49) + 1);
        }
        Integer[] drawnNumbers = drawnNumbersSet.toArray(new Integer[0]);
        System.out.println("Wylosowane liczby: " + Arrays.toString(drawnNumbers));
        Set<Integer> userNumbersSet = new HashSet<>();
        System.out.println("Wprowadz 6 roznych liczb od 1 do 49:");
        while (userNumbersSet.size() < 6) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number < 1 || number > 49) {
                    System.out.println("Liczba musi byc w przedziale od 1 do 49. Sproboj ponownie:");
                } else if (userNumbersSet.contains(number)) {
                    System.out.println("Ta liczba juz zostala podana. Sproboj ponownie:");
                } else {
                    userNumbersSet.add(number);
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba. Sproboj ponownie:");

                }
            }
        Integer[] userNumbers = userNumbersSet.toArray(new Integer[0]);
        System.out.println("Twoje liczby:"+ Arrays.toString(userNumbers));
        Set<Integer> common =  new HashSet<>(drawnNumbersSet);
        common.retainAll(userNumbersSet);
        System.out.println("Liczby powtarzajace sie w obu tablicach: " + common);
        System.out.println("Ilosc powtorzonych liczb " + common.size());
        }
    }

