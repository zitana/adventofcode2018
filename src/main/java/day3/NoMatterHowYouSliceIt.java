package day3;

import utils.InputReader;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoMatterHowYouSliceIt {

    public static int[][] FABRIC = new int[1000][1000];

    public static int countOverlappingInches() {
        List<String> claims = InputReader.readFile("day3input");

        Pattern pattern = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
        Matcher matcher;

        int xCoordinate;
        int yCoordinate;
        int width;
        int height;


        for (String claim : claims) {
            matcher = pattern.matcher(claim);
            matcher.matches();

            xCoordinate = Integer.parseInt(matcher.group(2));
            yCoordinate = Integer.parseInt(matcher.group(3));
            width = Integer.parseInt(matcher.group(4));
            height = Integer.parseInt(matcher.group(5));

            for (int i = xCoordinate; i < xCoordinate + width; i++) {
                for (int j = yCoordinate; j < yCoordinate + height; j++) {
                    FABRIC[i][j] += 1;
                }
            }
        }
        int overlappingInchCount = 0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (FABRIC[i][j] > 1) {
                    overlappingInchCount++;
                }
            }

        }

        return overlappingInchCount;
    }

    public static String findNotOverlappingClaim() {
        List<String> claims = InputReader.readFile("day3input");

        Pattern pattern = Pattern.compile("#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)");
        Matcher matcher;

        for (String claim : claims) {
            matcher = pattern.matcher(claim);

            if (isNotOverlapping(
                    Integer.parseInt(matcher.group(2)),
                    Integer.parseInt(matcher.group(3)),
                    Integer.parseInt(matcher.group(4)),
                    Integer.parseInt(matcher.group(5)))) {
                return matcher.group(1);
            }

        }
        return null;
    }

    private static boolean isNotOverlapping(int xCoordinate, int yCoordinate, int width, int height) {
        for (int i = xCoordinate; i < xCoordinate + width; i++) {
            for (int j = yCoordinate; j < yCoordinate + height; j++) {
                if (FABRIC[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
