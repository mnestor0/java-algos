package com.github.mnestor0.java.exercises;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

class ProductArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void findProductTest(int[] arrayInput, int[] expectedResult) {
        ProductArray productArray = new ProductArray();
        assertArrayEquals(expectedResult, productArray.findProduct(arrayInput));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 8}, new int[]{32, 16, 8}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{120, 60, 40, 30, 24}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{2, 3, 6}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{1}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}
