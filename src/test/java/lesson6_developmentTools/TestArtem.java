package lesson6_developmentTools;

import lesson6_developmentTools.trainingManual.Calculator;
import org.junit.jupiter.api.*;

public class TestArtem {
    Calculator calculator;

    @BeforeEach
    public void init() {
        System.out.println("init");
        calculator = new Calculator();
    }

    @Test
    public void testAdd1() {
        Assertions.assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testAdd2() {
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Exception")
    public void testAdd3() {
        Assertions.assertEquals(6, calculator.add(2, 5), "2 + 5 = 7");
    }

    @AfterEach // это необходимо для закрытия каких нибудь ресурсов в тесте, если они автоматически не закрываются
    public void shutdown() {
        System.out.println("end");
    }
}