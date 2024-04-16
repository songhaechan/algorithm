package five;

import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String s = ".png";
        System.out.println(s.matches("(.png|.jpg|.jpeg|.gif)$"));
    }
}

