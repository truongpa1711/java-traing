package Collection_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;

/*Bài 2
a. Tạo ra 1 list Student có 10.000 phần tử. class Student có các trường:
student_code kiểu là 1 String ngẫu nhiên có độ dài 16; name là kiểu String.
b. Viết function nhận vào 1 list id và trả về list Student tương ứng,
biết rằng list id đầu vào có thể tới 1.000 phần tử.*/
class Student {
    private String studentCode;
    private String name;

    public Student(String name) {
        this.studentCode = generateRandomCode();
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static String generateRandomCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int randomChar = (int) (Math.random() * 36);
            if (randomChar < 10) {
                code.append(randomChar); // Thêm số từ 0-9
            } else {
                code.append((char) ('A' + randomChar - 10)); // Thêm chữ cái từ A-Z
            }
        }
        return code.toString();
    }
}

public class B2 {


    public static ArrayList<Student> getStudentsByIds(ArrayList<Student> students,ArrayList<String> ids) {
        ArrayList<Student> studentlist = new ArrayList<>();
        HashMap<String, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            studentMap.put(student.getStudentCode(), student);
        }
        for (String id : ids) {
            if (studentMap.containsKey(id)) {
                studentlist.add(studentMap.get(id));
            }
        }
        return studentlist;
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            students.add(new Student("Student " + (i + 1)));
//            System.out.println("Student Code: " + students.get(i).getStudentCode() + ", Name: " + students.get(i).getName());
        }
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ids.add(students.get((int) (Math.random() * 10000)).getStudentCode());
        }
        ArrayList<Student> result = getStudentsByIds(students, ids);
        System.out.println("Students found for given IDs:");
        for (Student student : result) {
            System.out.println("Student Code: " + student.getStudentCode() + ", Name: " + student.getName());
        }


    }
}
