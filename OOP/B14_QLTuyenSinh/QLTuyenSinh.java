package OOP.B14_QLTuyenSinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QLTuyenSinh {
    List<Student> students=new ArrayList<>();
    //fake dữ liệu
    public void fakeData() {
        students = new ArrayList<>();

        students.add(new GoodStudent("Jonathan Doe", "01/01/2000", "Male", "0901234567", "Harvard", "Senior", 3.9, "Best Researcher"));
        students.add(new GoodStudent("Jennifer Smith", "15/05/1999", "Female", "0982345678", "MIT", "Junior", 3.8, "Top Innovator"));
        students.add(new NormalStudent("Alice Brownlee", "22/03/2001", "Female", "0913456789", "Stanford", "Sophomore", 85.5, 9.0));
        students.add(new NormalStudent("Robert Whitestone", "30/07/2002", "Male", "0314567890", "Yale", "Freshman", 80.0, 8.5));
        students.add(new GoodStudent("Christopher Green", "12/12/1998", "Male", "0355678901", "Oxford", "Senior", 3.7, "Best Innovator"));
        students.add(new GoodStudent("Emily Blackstone", "06/06/1997", "Female", "0386789012", "Cambridge", "Junior", 3.6, "Top Researcher"));
        students.add(new NormalStudent("Sophia Bluewell", "04/04/2003", "Female", "0907890123", "Princeton", "Sophomore", 78.0, 7.5));
        students.add(new NormalStudent("Liam Graystone", "08/08/2004", "Male", "0988901234", "Columbia", "Freshman", 82.0, 8.0));
        students.add(new GoodStudent("Olivia Whitestone", "03/03/1996", "Female", "0919012345", "Stanford", "Senior", 3.9, "Best Leader"));
        students.add(new GoodStudent("Noah Brownfield", "11/11/1995", "Male", "0310123456", "Yale", "Junior", 3.8, "Top Performer"));
        students.add(new NormalStudent("Ava Greenwood", "02/02/2002", "Female", "0351234567", "Harvard", "Sophomore", 75.0, 7.0));
        students.add(new NormalStudent("Ethan Blackwood", "07/07/2003", "Male", "0382345678", "MIT", "Freshman", 79.0, 7.8));
        students.add(new GoodStudent("Mia Bluestone", "05/05/1994", "Female", "0903456789", "Oxford", "Senior", 3.7, "Best Innovator"));
        students.add(new GoodStudent("Lucas Grayfield", "09/09/1993", "Male", "0984567890", "Cambridge", "Junior", 3.6, "Top Researcher"));
        students.add(new NormalStudent("Charlotte Whitewell", "01/01/2001", "Female", "0915678901", "Princeton", "Sophomore", 78.0, 7.5));
        students.add(new NormalStudent("James Brownfield", "06/06/2002", "Male", "0316789012", "Columbia", "Freshman", 82.0, 8.0));
        students.add(new GoodStudent("Amelia Greenstone", "10/10/1990", "Female", "0357890123", "Stanford", "Senior", 3.9, "Best Leader"));
        students.add(new GoodStudent("Benjamin Blackfield", "12/12/1991", "Male", "0388901234", "Yale", "Junior", 3.8, "Top Performer"));
        students.add(new NormalStudent("Isabella Bluebell", "03/03/2000", "Female", "0909012345", "Harvard", "Sophomore", 75.0, 7.0));
        students.add(new NormalStudent("William Graystone", "07/07/2001", "Male", "0980123456", "MIT", "Freshman", 79.0, 7.8));
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public QLTuyenSinh(List<Student> students) {
        this.students = students;
    }
    public QLTuyenSinh() {
        this.students = null;
    }

    public void ShowAllStudentsSortByFullName() {
        if (students == null || students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Collections.sort(students, (s1, s2) -> {
            return s1.getFullName().compareToIgnoreCase(s2.getFullName());
        });
        for (Student student : students) {
            student.ShowMyInfor();
            System.out.println("-----------------------------");
        }
    }
    public void ShowAllStudentsSortByPhoneNumber() {
        if (students == null || students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        Collections.sort(students, (s1, s2) -> {
            return s2.getPhoneNumber().compareTo(s1.getPhoneNumber());
        });
        for (Student student : students) {
            student.ShowMyInfor();
            System.out.println("-----------------------------");
        }
    }

    public void TuyenSinh(int n) {
        if (students == null || students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        List<GoodStudent> goodStudents = new ArrayList<>();
        List<NormalStudent> normalStudents = new ArrayList<>();
        for (Student student : students) {
            if (student instanceof GoodStudent) {
                goodStudents.add((GoodStudent) student);
            } else if (student instanceof NormalStudent) {
                normalStudents.add((NormalStudent) student);
            }
        }
        Collections.sort(goodStudents, (s1, s2) -> {
            if (Double.compare(s2.getGpa(), s1.getGpa()) == 0) {
                return s1.getFullName().compareToIgnoreCase(s2.getFullName());
            }
            return Double.compare(s2.getGpa(), s1.getGpa());
        });
        List<Student> selectedStudents = new ArrayList<>();
        if (goodStudents.size() > n) {
            selectedStudents.addAll(goodStudents.subList(0, n));
        } else {
            selectedStudents.addAll(goodStudents);
            n -= goodStudents.size();
        }
        Collections.sort(normalStudents, (s1, s2) -> {
            if (Double.compare(s2.getEntryTestScore(), s1.getEntryTestScore()) == 0) {
                if (Double.compare(s2.getEnglishScore(), s1.getEnglishScore()) == 0) {
                    return s1.getFullName().compareToIgnoreCase(s2.getFullName());
                }
                return Double.compare(s2.getEnglishScore(), s1.getEnglishScore());
            }
            return Double.compare(s2.getEntryTestScore(), s1.getEntryTestScore());
        });
        if (n > 0) {
            selectedStudents.addAll(normalStudents.subList(0, Math.min(n, normalStudents.size())));
        }
        System.out.println("Selected Students:");
        for (Student student : selectedStudents) {
            student.ShowMyInfor();
            System.out.println("-----------------------------");
        }
    }


}
