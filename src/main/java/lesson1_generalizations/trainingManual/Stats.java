package lesson1_generalizations.trainingManual;

public class Stats<T extends Number> {
    private T[] nums;

    public Stats(T... nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<?> another) {
        return Math.abs(this.avg() - another.avg()) < 0.0001;
    }
}

class WildcardDemoApp {
    public static void main(String args[]) {
        Stats<Integer> iStats = new Stats<>(1, 2, 3, 4, 5);
        System.out.println("Среднее iStats = " + iStats.avg());


        Stats<Double> dStats = new Stats<>(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("Среднее dStats = " + dStats.avg());


        Stats<Float> fStats = new Stats<>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        System.out.println("Среднее fStats = " + fStats.avg());

        System.out.print("Средние iStats и dStats ");
        if (iStats.sameAvg(dStats)) {
            System.out.println("равны");
        } else {
            System.out.println("отличаются");
        }

        System.out.print("Средние iStats и fStats");
        if (iStats.sameAvg(fStats)) {
            System.out.println("равны");
        } else {
            System.out.println("отличаются");
        }
    }
}