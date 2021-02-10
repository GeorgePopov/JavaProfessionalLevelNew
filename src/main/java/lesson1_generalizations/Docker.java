package lesson1_generalizations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

 /*
 * класс 'портовый док', с методами 'загрузить', 'выгрузить'
 * !*!*! статические методы не имеют доступа к дженеричному типу класса,
 * т.к. статик методы принадлежат классу, а не объекту, к кторому потом попадёт дженерик.
 * А нестатичный метод получает дженерик из класса
 */
public class Docker {
    private Docker() {} // заблокируем конструктор класса, что бы небыло желания с ним поработать

    // дженерик идёт перед возвращаемым типом данных
    /*
    public static <T> void embark(Collection<T> loadings, T load) {
        loadings.add(load);
    }
    */
    // вместо void используем возврашаемый наш тип данных
    /*
    public static <T> Collection<T> embark(Collection<T> loadings, T load) {
        loadings.add(load);
        return loadings;
    }
    */

    // в данном примере принимаем массив, а возвращаем соллекцию, со своим дженеричным типом
    public static <T extends Containable> Collection<T> embark(T... load) {
        return Arrays.stream(load).collect(Collectors.toList());
    }

    // любой тип данных, который в рамках Containable, если его нужно один раз использовать ?
    public static boolean disembark(Collection<? extends Containable> values) {
        Containable containable = values.stream().filter(Objects::nonNull).findFirst().get();
        return true;
    }
}
