package day5;

import utils.InputReader;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class AlchemicalReduction {

    public static int part1(String input) {

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
        return input.length();
    }

    private static boolean doesReact(char firstLetter, char secondLetter) {
        return Math.abs(firstLetter - secondLetter) == 32;
    }

    public static int part2() {
        String input = InputReader.readString("day5input");
        String stringToModify = input;
        int min = 800000;
        int current = 0;
        for (int i = 65; i < 91; i++) {
            stringToModify = input;
            String  character = String.valueOf((char)i);
            String modifiedString = stringToModify.replace(character, "").replace(character.toLowerCase(), "");
            current = part1( modifiedString);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }
}
