package day5;

import utils.InputReader;

import java.io.IOException;

public class AlchemicalReduction {

    public static void part1() {
        String input = InputReader.readString("day5input");

        boolean shrinking = true;
        while (shrinking) {
            for (int i = 0; i < input.length() - 2; i++) {
                if (doesReact(input.charAt(i), input.charAt(i + 1))) {
                    input = input.replace(input.substring(i, i + 2), "");
                    shrinking = true;
                    break;
                }
                shrinking = false;
            }
        }
        System.out.println(input);
        System.out.println(input.length());
    }

    public static boolean doesReact(char firstLetter, char secondLetter) {
        return Math.abs(firstLetter - secondLetter) == 32;
    }
}
