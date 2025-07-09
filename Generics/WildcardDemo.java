package Generics;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// Định nghĩa lớp Animal
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }

    @Override
    public String toString() {
        return "Animal";
    }
}

// Định nghĩa lớp Dog kế thừa từ Animal
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public String toString() {
        return "Dog";
    }
}

// Định nghĩa lớp Bulldog kế thừa từ Dog
class Bulldog extends Dog {
    @Override
    void makeSound() {
        System.out.println("Grrr!");
    }

    @Override
    public String toString() {
        return "Bulldog";
    }
}

// Định nghĩa lớp Cat kế thừa từ Animal
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public String toString() {
        return "Cat";
    }
}

public class WildcardDemo {
    // Unbounded Wildcard: Chấp nhận mọi List generic
    public static void printList(List<?> list) {
        System.out.println("Unbounded Wildcard - Printing list:");
        for (Object obj : list) {
            System.out.println("  " + obj);
        }
        // list.add(new Dog()); // Lỗi: Không thể thêm phần tử
        list.add(null); // Chỉ có thể thêm null
    }

    // Upper Bounded Wildcard: Chấp nhận List của Animal hoặc các lớp con
    public static void makeAnimalsSound(List<? extends Animal> animals) {
        System.out.println("Upper Bounded Wildcard - Making animals sound:");
        for (Animal animal : animals) {
            if (animal != null) { // Kiểm tra null để tránh NullPointerException
                animal.makeSound();
            } else {
                System.out.println("  (null element)");
            }
        }
        // animals.add(new Dog()); // Lỗi: Không thể thêm phần tử
        // animals.add(null); // Xóa dòng này để tránh thêm null
    }

    // Lower Bounded Wildcard: Chấp nhận List của Dog hoặc các lớp cha
    public static void addDog(List<? super Dog> list) {
        System.out.println("Lower Bounded Wildcard - Adding dogs:");
        list.add(new Dog());
        list.add(new Bulldog());
        // list.add(new Animal()); // Lỗi: Animal không phải Dog hoặc lớp con
        // list.add(new Cat());    // Lỗi: Cat không phải Dog hoặc lớp con
        System.out.println("  Added Dog and Bulldog to list: " + list);
    }

    public static void main(String[] args) {
        // Tạo các List để kiểm tra
        List<Animal> animalList = new ArrayList<>(Arrays.asList(new Animal(), new Cat()));
        List<Dog> dogList = new ArrayList<>(Arrays.asList(new Dog(), new Bulldog()));
        List<Cat> catList = new ArrayList<>(Arrays.asList(new Cat()));
        List<Object> objectList = new ArrayList<>(Arrays.asList(new Object()));

        // Thử Unbounded Wildcard
        System.out.println("=== Testing Unbounded Wildcard ===");
        printList(animalList);
        printList(dogList);
        printList(catList);
        printList(objectList);

        // Thử Upper Bounded Wildcard
        System.out.println("\n=== Testing Upper Bounded Wildcard ===");
        makeAnimalsSound(animalList);
        makeAnimalsSound(dogList);
        makeAnimalsSound(catList);
        // makeAnimalsSound(objectList); // Lỗi: Object không phải Animal hoặc lớp con

        // Thử Lower Bounded Wildcard
        System.out.println("\n=== Testing Lower Bounded Wildcard ===");
        addDog(dogList);
        addDog(animalList);
        addDog(objectList);
        // addDog(catList); // Lỗi: Cat không phải Dog hoặc lớp cha
    }
}