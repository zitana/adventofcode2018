package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static List<String> readFile(String fileName) {
        Path path = Paths.get("/media/zita/02A8E9AC0A9FAFB0/Programming/adventofcode/src/main/resources/" + fileName);
        List<String> strings = new ArrayList<>();
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static String readString(String fileName) {
        try {
            return Files.readString(Paths.get("/media/zita/02A8E9AC0A9FAFB0/Programming/adventofcode/src/main/resources/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
