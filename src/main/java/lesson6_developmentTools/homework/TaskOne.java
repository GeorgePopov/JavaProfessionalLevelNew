package lesson6_developmentTools.homework;
/*
Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */
public class TaskOne {

    public int[] arrayHandler(int[] arr) {
        int startIndex = 0;
        int sizeNewArray = 0;

        if (!chekArray(arr))
            throw new RuntimeException("Number four is missing in this array");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                startIndex = i;
            }
        }

        for (int i = startIndex; i <  arr.length; i++) {
            sizeNewArray++;
        }

        int[] arrNew = new int[sizeNewArray];
        System.arraycopy(arr, startIndex, arrNew, 0, sizeNewArray);

        return arrNew;
    }

    private boolean chekArray(int[] arr) {
        boolean result = false;
        for (int o : arr) {
            if (o == 4) {
                result = true;
                break;
            }
        }
        return result;
    }
}