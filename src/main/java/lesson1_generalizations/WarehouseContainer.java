package lesson1_generalizations;

/* <T> в Container и <T> в WarehouseContainer - ни какой связи не имеют.
* Но когда мы ставим <T> в WarehouseContainer, он меняет у Container,
*  а Container у методов put, get, так что они взаимосвязаны
* WarehouseContainer<T extends Containable> - сужаем тип данных до конкретного и его наследников (фильтрация)
* В данном примере <T extends Containable> это автоматически мигрирует и на Container<T>
*/
public class WarehouseContainer<T extends Containable> implements Container<T> {
    private T o;

    @Override
    public void put(T o) {
        this.o = o;
    }

    @Override
    public T get() {
        return o;
    }

    @Override
    public String toString() {
        return "WarehouseContainer{" +
                "o=" + o +
                '}';
    }
}