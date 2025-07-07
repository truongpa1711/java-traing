package Interface_Abstract.student_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true){
            System.out.println("---------------------");
            System.out.println("Student Management");
            System.out.println("1. Insert Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.println("---------------------");
            try {
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                if(choice<1 || choice>4){
                    System.out.println("Invalid choice");
                    continue;
                }
            }catch (Exception e){
                System.out.println("Invalid choice");
                sc.nextLine();
                continue;
            }
            switch(choice){
                case 1:
                    Student s = new Student();
                    System.out.print("Enter FullName: ");
                    s.setFullName(sc.nextLine());
                    System.out.print("Enter Date Of Birth: ");
                    s.setDateofBirth(sc.nextLine());
                    System.out.print("Enter Native: ");
                    s.setNative(sc.nextLine());
                    System.out.print("Enter Class: ");
                    s.setClass(sc.nextLine());
                    System.out.print("Enter PhoneNo: ");
                    s.setPhoneNo(sc.nextLine());
                    System.out.print("Enter Mobile: ");
                    s.setMobile(sc.nextInt());
                    students.add(s);
                    break;
                case 2:
                    if(students.isEmpty()){
                        System.out.println("No students found");
                    }
                    else{
                        System.out.println("List Students: ");
                        for (Student student:students){
                            student.Display();
                        }
                    }
                    break;
                case 3:

                    if (students.isEmpty()){
                        System.out.println("Students is empty");
                    }
                    else{
                        System.out.print("Enter Search Student: ");
                        String search = sc.nextLine();
                        boolean found = false;
                        for (Student student:students){
                            if(student.getFullName().equals(search)){
                                student.Display();
                                found = true;
                            }
                        }
                        if(!found){
                            System.out.println("No students found");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exit Program");
                    return;
            }
        }

    }
}
