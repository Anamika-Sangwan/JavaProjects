package TypeTest;

import java.util.Random;
import java.util.Scanner;

public class TypingTest{
    static String[] words = {
            "apple", "computer", "river", "house", "music",
            "keyboard", "java", "spring", "cloud", "coffee",
            "beautiful", "quick", "happy", "network", "database",
            "algorithm", "developer", "monitor", "screen", "internet"
    };

    public static String generateSentence(int wordCount) {
        Random random = new Random();
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < wordCount; i++) {
            sentence.append(words[random.nextInt(words.length)]);

            if (i < wordCount - 1) {
                sentence.append(" ");
            }
        }

        return sentence.toString();
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String expected = generateSentence(30);
        System.out.println("Type the string provided:- " + expected);
        long startTime = System.nanoTime();
        String input = s.nextLine();
        long endTime = System.nanoTime();
        double timeTaken = (endTime-startTime)/1_000_000_000.0;
        String[] expectedWords = expected.split("\\s+");
        String[] inputWords = input.split("\\s+");
        int correct = 0;
        for (int i = 0; i < Math.min(expectedWords.length, inputWords.length); i++) {
            if (expectedWords[i].equals(inputWords[i])) {
                correct++;
            }
        }
        double accuracy = (correct * 100.0) / expectedWords.length;
        System.out.printf("Accuracy: %.2f%%%n", accuracy);
        System.out.printf("Time Taken: %.2f seconds%n", timeTaken);
        int wordCount = expected.split("\\s+").length;
        double wpm = (wordCount / timeTaken) * 60;
        System.out.printf("Typing Speed: %.2f WPM%n", wpm);
    }
}