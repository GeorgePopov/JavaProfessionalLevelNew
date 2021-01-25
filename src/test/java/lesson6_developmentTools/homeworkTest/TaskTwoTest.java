package lesson6_developmentTools.homeworkTest;

import lesson6_developmentTools.homework.TaskTwo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TaskTwoTest {
    TaskTwo taskTwo;

    private static final int[] arr1 = {1, 1, 1, 1, 1};
    private static final int[] arr2 = {4, 1, 4, 1, 1};
    private static final int[] arr3 = {4, 4, 4, 4, 4, 4, 4, 4};
    private static final int[] arr4 = {1, 1, 1};

    @BeforeEach
    public void init() {
        taskTwo = new TaskTwo();
    }

    @ParameterizedTest
    @MethodSource("checkArrayProvider")
    @DisplayName("This is a test method")
    public void shouldReturnFalseIfIsNotOneOrFourInArray(int[] arr) {
        Assertions.assertFalse(taskTwo.checkStructureArray(arr), "Is not one ore four in this method!");
    }

    private static Stream<Arguments> checkArrayProvider() {
        return Stream.of(
                Arguments.arguments(arr1),
                Arguments.arguments(arr2),
                Arguments.arguments(arr3),
                Arguments.arguments(arr4)
        );
    }
}