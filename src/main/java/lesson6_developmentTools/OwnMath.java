package lesson6_developmentTools;

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
}
