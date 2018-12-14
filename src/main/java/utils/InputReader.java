package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static List<String> readFile(String fileName) {
        Path path = Paths.get(System.getenv("INPUT_PATH") + fileName);
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
            return Files.readString(Paths.get(System.getenv("INPUT_PATH") +  fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
