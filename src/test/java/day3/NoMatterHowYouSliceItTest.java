package day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoMatterHowYouSliceItTest {

    @Test
    void countOverlappingInches() {
        System.out.println("Number of overlapping inches:");
        System.out.println(NoMatterHowYouSliceIt.countOverlappingInches());
        System.out.println(NoMatterHowYouSliceIt.findNotOverlappingClaim());
    }
}