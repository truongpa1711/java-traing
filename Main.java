import java.util.ArrayList;
import java.util.List;

class Utility {
    static void addNumbers(List<? super Double> list) {
        list.add(1.0);
        list.add(2.0);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        Utility.addNumbers(numbers);
        System.out.println(numbers); // In ra: [1, 2]
    }
}