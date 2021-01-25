package lesson6_developmentTools.homeworkTest;

import lesson6_developmentTools.homework.TaskOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TaskOneTest {
    TaskOne taskOne;

    private static final int[] arr1 = {1, 2, 5, 8, 4, 4, 9, 3, 6};
    private static final int[] arrNew1 = {4, 9, 3, 6};
    private static final int[] arr2 = {3, 7, 8, 4, 5, 2, 9, 9, 9};
    private static final int[] arrNew2 = {4, 5, 2, 9, 9, 9};
    private static final int[] arr3 = {6, 8, 1, 1, 1, 5, 9, 2, 3};
    private static final int[] arrNew3 = {7, 6, 3, 3};
    private static final int[] arr4 = {0, 0, 4, 1, 1};
    private static final int[] arrNew4 = {4, 1, 1};

    @BeforeEach
    public void init() {
        taskOne = new TaskOne();
    }

    @ParameterizedTest
    @MethodSource("arraysEqualsProvider")
    public void shouldThrowRuntimeExceptionIfIsNotNumberFourInArray(int[]arr, int[] arrNew) {
        try {
            Assertions.assertArrayEquals(taskOne.arrayHandler(arr), arrNew);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Arguments> arraysEqualsProvider() {
        return Stream.of(
                Arguments.arguments(arr1, arrNew1),
                Arguments.arguments(arr2, arrNew2),
                Arguments.arguments(arr3, arrNew3),
                Arguments.arguments(arr4, arrNew4)
        );
    }
}