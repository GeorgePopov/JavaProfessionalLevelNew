package lesson6_developmentTools.homework;
/*
Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */
public class TaskTwo {

    public boolean checkStructureArray(int[] arr) {
        boolean result = false;
        boolean numberOne = chekNumberOne(arr);
        boolean numberFour = chekNumberFour(arr);

        if (numberOne && numberFour)
            result = true;

        return result;
    }

    private boolean chekNumberFour(int[] arr) {
        boolean result = false;
        for (int o : arr) {
            if (o == 4) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean chekNumberOne(int[] arr) {
        boolean result = false;
        for (int o : arr) {
            if (o == 1) {
                result = true;
                break;
            }
        }
        return result;
    }
}