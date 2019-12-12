package com.github.mnestor0.java.exercises;

/*
    Given a string of round, curly, and square open and closing brackets,
    return whether the brackets are balanced (well-formed).
    For example, given the string "([])[]({})", you should return true.
    Given the string "([)]" or "((()", you should return false.
 */
public class Braces {

    private static final String BRACES = "{}[]()";

    public boolean testBraces(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < input.length(); ) {
            int matchingBraceIndex = findMatchingBrace(chars, i);
            if (matchingBraceIndex == -1) {
                return false;
            }
            i = matchingBraceIndex + 1;
        }
        return true;
    }

    private int findMatchingBrace(char[] chars, int i) {
        if (i >= chars.length) {
            return -1;
        }
        char currentBrace = chars[i];
        if (isMissing(currentBrace) || isClosingBrace(currentBrace)) {
            return -1;
        }
        int matchingBraceIndex = i + 1;
        while (matchingBraceIndex < chars.length) {
            if (areMatchingBraces(currentBrace, chars[matchingBraceIndex])) {
                return matchingBraceIndex;
            }
            int matchingBrace = findMatchingBrace(chars, matchingBraceIndex);
            if (matchingBrace == -1) {
                break;
            }
            matchingBraceIndex = matchingBrace + 1;
        }
        return -1;
    }

    private boolean isMissing(char brace) {
        return BRACES.indexOf(brace) == -1;
    }

    private boolean isClosingBrace(char brace) {
        return BRACES.indexOf(brace) % 2 == 1;
    }
    private boolean areMatchingBraces(char brace1, char brace2) {
        return BRACES.indexOf(brace2) == BRACES.indexOf(brace1) + 1;
    }
}
