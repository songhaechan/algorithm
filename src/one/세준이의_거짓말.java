package one;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 세준이의_거짓말 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int subjects = scan.nextInt();
        scan.nextLine();
        String scores = scan.nextLine();

        String[] scoreArray = scores.split(" ");

        int maxScore = Arrays.stream(scoreArray)
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();

        double total = Arrays.stream(scoreArray)
                .mapToDouble(Double::parseDouble)
                .map(n -> n/maxScore*100)
                .sum();

        System.out.println(total/subjects);
    }
}
