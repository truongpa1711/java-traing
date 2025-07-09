package Generics;

import java.util.List;

//Chấp nhận bất kỳ kiểu nào là T hoặc con của T
public class upper_bounded {
    public void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        upper_bounded ub = new upper_bounded();

        // Example usage with a list of Integers
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        ub.printNumbers(intList);

        // Example usage with a list of Doubles
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        ub.printNumbers(doubleList);

        // Example usage with a list of Floats
        List<Float> floatList = List.of(1.1f, 2.2f, 3.3f);
        ub.printNumbers(floatList);

        // Example usage with a list of Strings (not allowed, will cause compile-time error)
//        List<String> stringList = List.of("Hello", "World");
//        ub.printNumbers(stringList);
    }
}
