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
        String expected = generateSentence(10);
        System.out.println("Type the string provided:- " + expected);
        long startTime = System.nanoTime();
        String input = s.nextLine();
        long endTime = System.nanoTime();
        double timeTaken = (endTime-startTime)/1_000_000_000.0;
        System.out.println("Time taken to type the string is " + timeTaken + " seconds and your typing speed is " + 10/timeTaken + " words per second!");
        System.out.println(expected.equals(input));
    }
}