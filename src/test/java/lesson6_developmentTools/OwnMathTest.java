package lesson6_developmentTools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Все методы в тестах должны начинаться со слов should или test.
 *
 * Test states:
 * 1. Green - everything is OK. Expected result is equal to actual
 * 2. Yellow - everything is OK. Expected result is not equal to actual
 * 3. Red - something went wrong (probably unexpected exception).
 *
 * !*!*! Можно все тесты, которые есть в папке test в проекте maven, запустить через maven,
 * mvn test или mvn clean install, нажимаем на 'maven', на кнопку 'm'.
 *
 * Хорошо, когда в методе один assert или несколько но немного.
 *
 * @EmptySource только для объектов.
 *
 * Хороший метод, который тестирует один маленький сценарий, чем проще метод тем лучше.
 *
 * !*!*! assert-тов очень много, у нас тут assertEquals, а есть которые сравнивают массивы, придёт не null и т.д.
 */
public class OwnMathTest {
    @Test                                       // тест для одного сценария
    void shouldReturnMaxValueFromTwoPassed() {
        Assertions.assertEquals(2, OwnMath.max(1, 2));
    }

    @Test
    void shouldReturnMinValueFromTwoPassed() {
        Assertions.assertEquals(1, OwnMath.min(1, 2));
    }

    //-----

    @ParameterizedTest // тест для нескольких сценариев
    @MethodSource("maxParametersProvider") // с помощью него мы сами создаём объём данных,который мы хотим вернуть
    void shouldReturnMaxValueFromTwoPassed(int expected, int a, int b) {
        Assertions.assertEquals(expected, OwnMath.max(a, b));
    }

    /*
    Arguments набор аргументов, который будем возвращать. Arguments необходимо обернуть в Stream
    Появился Arguments это из зависимости, которую подключили в maven.
    Часто такой метод называют со словом Provider.
    Stream это словно массив или коллекция
     */
    private static Stream<Arguments> maxParametersProvider() {
        return Stream.of(
                Arguments.arguments(2, 1, 2),
                Arguments.arguments(1, 1, 1),
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(1, -1, 1)
        );
    }

    //-----

    // ожидание исключения, делаем проверку в самом методе и throw new делаем
    @Test
    void  shouldThrowIllegalArgumentExceptionWhenPassedAsDivider() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                OwnMath.divide(4, 0);
            }
        });
    }

    @ParameterizedTest
    @MethodSource("divisionParametersProvider")
    void shouldReturnDividedValue(double expected, double a, double b) {
        Assertions.assertEquals(expected, OwnMath.divide(a, b));
    }

    private static Stream<Arguments> divisionParametersProvider() {
        return Stream.of(
                Arguments.arguments(2, 4, 2),
                Arguments.arguments(2.5, 5, 2)
        );
    }

    // Logging Example

    @Test                                       // тест для одного сценария
    void shouldReturnMaxValueFromTwoPassedL() {
        Assertions.assertEquals(2, OwnMath.maxL(1, 2));
    }

    @Test
    void shouldReturnMinValueFromTwoPassedL() {
        Assertions.assertEquals(1, OwnMath.minL(1, 2));
    }

    @ParameterizedTest
    @MethodSource("divisionParametersProviderL")
    void shouldReturnDividedValueL(double expected, double a, double b) {
        Assertions.assertEquals(expected, OwnMath.divideL(a, b));
    }

    private static Stream<Arguments> divisionParametersProviderL() {
        return Stream.of(
                Arguments.arguments(2, 4, 0),
                Arguments.arguments(2.5, 5, 2)
        );
    }
}