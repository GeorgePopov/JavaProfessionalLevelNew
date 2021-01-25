package lesson6_developmentTools.trainingManual;

import org.junit.jupiter.api.*;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void testAdd() {
        calculator = new Calculator();
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("5 - 2 = 3") // можно указать название метода для консоли
    public void testSub() {
        calculator = new Calculator();
        Assertions.assertEquals(4, calculator.sub(5, 2), "5 - 2 should equal 3"); // правильный ответ для консоли
    }

    @BeforeEach // теперь ненужно создавать экз.класса в каждом методе
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void testMul() {
        Assertions.assertEquals(9, calculator.mul(3, 3));
    }

    @Test
    @Disabled("Деление на ноль пока тестировать ненужно") // можно поставить в оъявлении класса, тогда пропустят все тесты
    public void testDiv() {
        Assertions.assertEquals(1, calculator.div(2, 2));
    }

    @Test
    public void shouldMyTest() {
        Assertions.assertFalse(calculator.myTest("a", "b"));
    }
}