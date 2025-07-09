package Generics;

import java.util.List;
// Chấp nhận bất kỳ kiểu nào là T hoặc bất kỳ kiểu nào khác
public class Wildcard {
    // Method that accepts a list of any type using wildcard
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
    class A {
        public static int a = 10;
        private String b = "Hello";
        public A() {
            // Default constructor
        }
    }
    public static void main(String[] args) {
        A A = new Wildcard().new A();
        // Example usage of wildcard in a method
        printList(List.of("Apple", "Banana", "Cherry"));
        printList(List.of(1, 2, 3, 4, 5));
        printList(List.of(1.1, 2.2, 3.3));
        printList(List.of(A.a, "Banana", 3.3,A,A.b));

    }
}
