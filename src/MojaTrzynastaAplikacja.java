import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MojaTrzynastaAplikacja {
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
            String content = new String(Files.readAllBytes(Paths.get(inputPath)));
            String[] wordsArray = content.split("\\s+");
            int totalWords = wordsArray.length;

            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : wordsArray) {
                word = word.toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]", "");
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            System.out.println("Liczba wszystkich słów: " + totalWords);
            System.out.println("Wystąpienia słów:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
                writer.println("Nazwa pliku wejściowego: " + inputPath);
                writer.println("Liczba wszystkich słów: " + totalWords);
                writer.println("Wystąpienia słów:");
                for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                    writer.println(entry.getKey() + ": " + entry.getValue());
                }
            }

            System.out.println("Wynik zapisany w pliku: " + outputPath);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd przy przetwarzaniu pliku: " + e.getMessage());
        }
    }
}
