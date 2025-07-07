package Interface_Abstract.marks_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        ArrayList<StudentMark> studentMarks = new ArrayList<>();

        while (true){
            System.out.println("------------------------");
            System.out.println("1. Insert new student");
            System.out.println("2. View list of students");
            System.out.println("3. Average Mark");
            System.out.println("4. Exit");
            System.out.println("-----------------------");
            System.out.print("Enter your choice: ");
            try{
                choice = sc.nextInt();
                sc.nextLine();
                if(choice < 1||choice > 4){
                    System.out.println("Invalid choice");
                    continue;
                }
            }catch (Exception e){
                System.out.println("Please enter a valid option");
                sc.nextLine();
                continue;
            }
            switch(choice){
                case 1:
                    StudentMark studentMark = new StudentMark();
                    System.out.print("Enter student fullname: ");
                    studentMark.setFullName(sc.nextLine());
                    System.out.print("Enter class name: ");
                    studentMark.setClass(sc.nextLine());
                    System.out.print("Enter semester: ");
                    studentMark.setSemester(sc.nextInt());
                    float[] marsk= new float[5];
                    for (int i = 0; i < 5; i++){
                        System.out.print("Enter mark "+(i+1)+": ");
                        while (true){
                            try {
                                marsk[i] = sc.nextFloat();
                                break;
                            }catch (Exception e){
                                System.out.println("Please enter a valid mark");
                                continue;
                            }
                        }
                    }
                    studentMark.setSubjectMarkList(marsk);
                    studentMarks.add(studentMark);
                    break;
                case 2:
                    System.out.println("List of students: ");
                    if(studentMarks.size() == 0){
                        System.out.println("No students found");
                    }else {
                        for (StudentMark student: studentMarks){
                            student.Display();
                        }
                    }
                    break;
                case 3:
                    System.out.println("List of students: ");
                    if(studentMarks.size() == 0){
                        System.out.println("No students found");
                    }
                    else {
                        for (StudentMark student: studentMarks){
                            student.AveCal();
                            student.Display();
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
