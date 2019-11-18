package com.github.mnestor0.java.exercises;

import static org.junit.jupiter.api.Assertions.*;

import com.github.mnestor0.java.exercises.DoTwoNumberAddUpToK;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class DoTwoNumberAddUpToKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void verify(List<Integer> array, int target, boolean expectedOutcome) {
        Integer[] entryArray = array.toArray(new Integer[0]);
        boolean outcome = new DoTwoNumberAddUpToK().addUp(entryArray, target);
        assertEquals(expectedOutcome, outcome, String.format("%s, %s should be %b", array, target, expectedOutcome));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 10, 15, 7), 17, true),
                Arguments.of(Arrays.asList(1, 2, 3, 4), 10, false),
                Arguments.of(Arrays.asList(1, 2), 3, true),
                Arguments.of(Arrays.asList(1), 3, false)
        );
    }
}
