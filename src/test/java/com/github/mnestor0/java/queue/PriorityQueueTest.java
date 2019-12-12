package com.github.mnestor0.java.queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PriorityQueueTest {

    private List<PriorityQueue<Integer>> queueList = Arrays.asList(
            new HeapOrderedCompleteBSTPriorityQueue<>(Integer.class));

    @ParameterizedTest
    @MethodSource("testData")
    void test(Integer[] toBeHeapified) {
        for (PriorityQueue<Integer> queue : queueList) {
            queue.insert(toBeHeapified);
            assertArrayIsAHeap(queue.toArray());
            queue.removeMaximum();
            assertArrayIsAHeap(queue.toArray());
            queue.insert(123456);
            assertArrayIsAHeap(queue.toArray());
        }
    }

    @Test
    void testInsertAndRemove() {
        Integer[] toBeHeapified = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (PriorityQueue<Integer> queue : queueList) {
            queue.insert(toBeHeapified);
            assertArrayIsAHeap(queue.toArray());
            queue.removeMaximum();
            assertArrayIsAHeap(queue.toArray());
            queue.insert(10);
            assertArrayIsAHeap(queue.toArray());
        }
    }

    private void assertArrayIsAHeap(Integer[] testArray) {
        for (int i = 0; i < testArray.length / 2; i++) {
            if (i * 2 + 1 < testArray.length) {
                assertTrue(testArray[i] >= testArray[i * 2 + 1], "Array is not a heap: "
                        + Arrays.toString(testArray));
            }
            if (i * 2 + 2 < testArray.length) {
                assertTrue(testArray[i] >= testArray[i * 2 + 2], "Array is not a heap: "
                        + Arrays.toString(testArray));
            }
        }
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of((Object) new Integer[0]),
                Arguments.of((Object) new Integer[] {1}),
                Arguments.of((Object) new Integer[] {1, 2}),
                Arguments.of((Object) new Integer[] {2, 1}),
                Arguments.of((Object) new Integer[] {1, 2, 3}),
                Arguments.of((Object) new Integer[] {3, 2, 1}),
                Arguments.of((Object) new Integer[] {3, 2, 1, 2, 3}),
                Arguments.of((Object) new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of((Object) new Integer[] {9, 8, 7, 6, 5, 4, 3, 2, 1}),
                Arguments.of((Object) new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
        );
    }

}