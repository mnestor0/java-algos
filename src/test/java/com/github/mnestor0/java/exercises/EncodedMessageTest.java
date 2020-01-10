package com.github.mnestor0.java.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EncodedMessageTest {

    @ParameterizedTest
    @MethodSource("testData")
    public void findProductTest(String encodedString, long decodeCombinations) {
        EncodedMessage encodedMessage = new EncodedMessage();
        assertEquals(encodedMessage.countDecode(encodedString), decodeCombinations,
                String.format("Expected '%s' to return %d", encodedString, decodeCombinations));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("9", 1),
                Arguments.of("10", 2),
                Arguments.of("26", 2),
                Arguments.of("27", 1),
                Arguments.of("111", 3),
                Arguments.of("121", 3),
                Arguments.of("122", 3),
                Arguments.of("712", 2),
                Arguments.of("171", 2),
                Arguments.of("117", 3),
                Arguments.of("1111", 5),
                Arguments.of("1171", 3),
                Arguments.of("1711", 4)

        );
    }

}
