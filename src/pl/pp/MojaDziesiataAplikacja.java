package pl.pp;

public class MojaDziesiataAplikacja {
    public static int[] countAndSumElements(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countNegative = 0;
        int sumPositive = 0;

        for (int number : input) {
            if (number < 0) {
                countNegative++;
            } else if (number > 0) {
                sumPositive += number;
            }
        }

        return new int[]{countNegative, sumPositive};
    }
}
