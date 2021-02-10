package lesson1_generalizations;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
//        example2();

        Collection<Containable> embark = Docker.embark( // вызываем статичный метод, через класс
                new Food("F"),
                new Toy("T"),
                new Food("FF"),
                new Toy("TT")
        );
        System.out.println(embark);
    }

    private static void example2() {
        WarehouseContainer<Toy> containerT = new WarehouseContainer<>();
        containerT.put(new Toy("Soldier"));
        System.out.println(containerT.get());
        System.out.println(containerT);

        Container<Food> containerF = new WarehouseContainer<>();
        containerF.put(new Food("Banana"));
        System.out.println(containerF.get());
        System.out.println(containerF);
    }

    private static void example() {
        /*
        WarehouseContainer container = new WarehouseContainer();
        container.put("String");
        if (container.get() instanceof Integer) { // Пример как делать проверку, кастовать, instanceof использовать редко
            int val = (int) container.get() * 100;
            System.out.println("Val: " + val);
        } else {
            System.err.println("Cannot cast");
        }
        */
    }
}