package lesson6_developmentTools;

import org.apache.log4j.Logger;

public class OwnMath {
    private OwnMath() {} // !*!*! приватный конструктор, нельзя создавать объекты этого класса

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return Math.min(a, b); // можно так, а можно ручками тернарным
    }

    public static double divide(double a, double b) {
        if (b == 0)
            throw new IllegalArgumentException("Divider should not be zero");
        return a/b;
    }

    // Logging Example

    /*
    !*!*! Логер должен быть в одном классе в одном экземпляре,
    и неважно сколько экземпляров у этого класса, он для всех
    Создаём логер, вызывае getLogger(), передаём туда класс,
    а потом смотрим какие есть у logger методы, методы зависят
    от уровня logger (debug, error, info...)
    Файл с логами должен храниться в очень защищенном месте
     */
    private static final Logger logger = Logger.getLogger(OwnMath.class);

    public static int maxL(int a, int b) {
        int max = a > b ? a : b;
        /*
        debug режим, он будет логироваться, когда для приложения будет активирован debug мод.
        debug мод определяется в properties: log4j.rootLogger=DEBUG, stdout, file.
        в debug сыпиться информация, которая нужна только разработчикам. Зачастую нужно использовать INFO
         */
        logger.debug("Max value is: " + max);
        return max;
    }

    public static int minL(int a, int b) {
        int min = a < b ? a : b;
        logger.debug("Min value is: " + min);
        return min;
    }

    public static double divideL(double a, double b) {
        if (b == 0) {
            IllegalArgumentException ex = new IllegalArgumentException("Divider should not be zero"); // !*!*! Можно так
            // error - (warning), сюда попадают все исключения
            logger.error("Something went wrong during division operation", ex);
            throw ex;
        }
        return a/b;
    }
}
