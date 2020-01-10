package com.github.mnestor0.java.exercises;

import java.util.HashMap;
import java.util.Map;

/*
  This problem was asked by Facebook.
  Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
  For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
  You can assume that the messages are decodable. For example, '001' is not allowed.

  Solution:
  If there's one digit, there's only one combination. Consider two characters at the same time.
  It there are two or more digits, iterate from end of array.
  Let's define f(x) as a possible number of decoded messages of a sequence of numbers.
  For f(1111) => Let's consider what can be the first character. It's either 'a' (1) or 'k' (11).
  Number of combinations for these options is equal to: in case of 'a' => f(111) + in case of 'k' => f(11),
  because 'a' consumed single character and 'k' consumer two character, so f(1111) = f(111) + f(11).
  Next, let's look at 111, it can start with 'a' or 'k' again, so: f(111) = f(11) + f(1).
  Next is f(11) = 2 (aa or k). Iterating back we can calculate the final result
    f(1111) = f(111) + f(11) = f(11) + f(1) + f(11) = 5
 */
public class EncodedMessage {

    private static final Map<String, String> decoders = new HashMap<>();

    public EncodedMessage() {
        int i = 1;
        for (char letter = 'a'; letter <= 'z'; letter++) {
            decoders.put(i++ + "", letter + "");
        }
    }

    public long countDecode(String encoded) {
        if (encoded.length() < 2) {
            return 1;
        }
        int currentParsedNumber;
        long last = 1, secondLast = 1, current = 0;
        for(int i = encoded.length() - 2; i >= 0; i--) {
            currentParsedNumber = Integer.parseInt(encoded.substring(i, i + 2));
            current = last;
            if (currentParsedNumber + 'a' - 1 <= 'z') {
                current += secondLast;
            }
            secondLast = last;
            last = current;
        }
        return current;
    }
}
