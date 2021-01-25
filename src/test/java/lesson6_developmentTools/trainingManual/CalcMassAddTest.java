package lesson6_developmentTools.trainingManual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Классный пример теста калькулятора
public class CalcMassAddTest {
    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @CsvSource({ // создаёт набор значений для аргументов теста
            "1, 1, 2",
            "2, 3, 5",
            "7, 5, 12",
            "12, 12, 24"
    })
    @ParameterizedTest
    public void massTestAdd(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    //-----

    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void testAddOperation(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    public static Stream<Arguments> dataForAddOperation() {
        List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int a = (int) (Math.random() * 1000);
            int b = (int) (Math.random() * 1000);
            int result = a + b;
            out.add(Arguments.arguments(a, b, result)); // интересный пример!
        }
        return out.stream();
    }
}