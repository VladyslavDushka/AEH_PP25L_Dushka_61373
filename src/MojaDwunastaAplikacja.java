import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class MojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPath, outputPath;

        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            inputPath = scanner.nextLine();
            if (!Files.exists(Paths.get(inputPath))) {
                System.out.println("Plik nie istnieje. Spróbuj ponownie.");
            } else {
                break;
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        outputPath = scanner.nextLine();

        try {
            long lineCount = Files.lines(Paths.get(inputPath)).count();

            System.out.println("Liczba linii w pliku: " + lineCount);

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
                writer.println("Nazwa pliku wejściowego: " + inputPath);
                writer.println("Liczba linii: " + lineCount);
            }

            System.out.println("Wynik został zapisany w pliku: " + outputPath);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu lub zapisu pliku: " + e.getMessage());
        }
    }
}
