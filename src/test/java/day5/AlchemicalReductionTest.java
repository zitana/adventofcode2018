package day5;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlchemicalReductionTest {

    @Test
    void part1() {
        String input = InputReader.readString("day5input");
        AlchemicalReduction.part1(input);
        System.out.println(AlchemicalReduction.part2());
    }
}