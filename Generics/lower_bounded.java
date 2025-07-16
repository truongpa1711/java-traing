package Generics;

import java.util.List;

public class lower_bounded {
    // Chấp nhận bất kỳ kiểu nào là T hoặc cha của T
    public void addNumbers(List<? super Integer> list) {
        list.add(1); // Thêm số nguyên vào danh sách
        list.add(2);
        list.add(3);
    }

    public static void main(String[] args) {
        lower_bounded lb = new lower_bounded();

        // Example usage with a list of Integers
        List<Integer> intList = new java.util.ArrayList<>();
        lb.addNumbers(intList);
        System.out.println(intList);

        // Example usage with a list of Number (super Integer)
        List<Number> numberList = new java.util.ArrayList<>();
        lb.addNumbers(numberList);
        System.out.println(numberList);

        // Example usage with a list of Object (super Number)
        List<Object> objectList = new java.util.ArrayList<>();
        lb.addNumbers(objectList);
        System.out.println(objectList);

        // Example usage with a list of Strings (not allowed, will cause compile-time error)
//        List<String> stringList = new java.util.ArrayList<>();
//        lb.addNumbers(stringList); // This line will cause a compile-time error

    }
}
