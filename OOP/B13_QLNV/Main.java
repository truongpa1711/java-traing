package OOP.B13_QLNV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLNV qlnv = new QLNV();
        Certificate certificate1 = new Certificate("cert1", "Java", "01/01/2022");
        Certificate certificate2 = new Certificate("cert2", "Python", "01/02/2022");
        Certificate certificate3 = new Certificate("cert3", "C++", "01/03/2022");
        Certificate certificate4 = new Certificate("cert4", "JavaScript", "01/04/2022");
        List<Certificate> Tcertificates = new ArrayList<>();
        Tcertificates.add(certificate1);
        Tcertificates.add(certificate2);
        List<Certificate> Dcertificates = new ArrayList<>();
        Dcertificates.add(certificate3);
        Dcertificates.add(certificate4);
        Employee intern=new Intern("intern1","Phạm Anh Trường", "17/11/2003", "0123321145", "truong@gmail.com", Tcertificates, "CNTT", "HK1", "HUST");
        Employee fresher=new Fresher("fresher1","Nguyễn Lê Ngọc Duyên","05/10/2009","0221144566", "duyen@gmail.com",Dcertificates, "01/01/2023", "Gioi", "DHQG");
        Employee experience=new Experience("experience1","Phạm A","02/02/2002","0133211566","a@gmail.com", Tcertificates, 5, "Java");
        qlnv.themNhanVien(intern);
        qlnv.themNhanVien(fresher);
        qlnv.themNhanVien(experience);

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Hiển thị tất cả nhân viên");
            System.out.println("2. Hiển thị nhân viên theo loại");
            System.out.println("3. Thêm nhân viên");
            System.out.println("4. Sửa thông tin nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline

            switch (choice) {
                case 1:
                    qlnv.hienThiNhanVien();
                    break;
                case 2:
                    System.out.println("Chọn loại nhân viên (1: Experience, 2: Fresher, 3: Intern): ");
                    int typeChoice = scanner.nextInt();
                    Employee.Employee_type type = null;
                    switch (typeChoice) {
                        case 1:
                            type = Employee.Employee_type.Experience;
                            break;
                        case 2:
                            type = Employee.Employee_type.Fresher;
                            break;
                        case 3:
                            type = Employee.Employee_type.Intern;
                            break;
                        default:
                            System.out.println("Loại nhân viên không hợp lệ.");
                            continue;
                    }
                    qlnv.hienThiNhanVienTheoLoai(type);
                    break;
                case 3:
                    System.out.print("Nhập ID nhân viên:");
                    String id = scanner.nextLine();

                    String fullName;
                    while (true) {
                        System.out.print("Nhập họ tên: ");
                        fullName = scanner.nextLine();
                        try {
                            ValidateInput.validateFullName(fullName);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.FullNameException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    String birthDay;
                    while (true) {
                        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                        birthDay = scanner.nextLine();
                        try {
                            ValidateInput.validateBirthDay(birthDay);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.BirthDayException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    String phone;
                    while (true) {
                        System.out.print("Nhập số điện thoại: ");
                        phone = scanner.nextLine();
                        try {
                            ValidateInput.validatePhone(phone);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.PhoneException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    String email;
                    while (true) {
                        System.out.print("Nhập email: ");
                        email = scanner.nextLine();
                        try {
                            ValidateInput.validateEmail(email);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.EmailException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Chọn loại nhân viên (1: Experience, 2: Fresher, 3: Intern): ");
                    int employeeTypeChoice = scanner.nextInt();
                    Employee.Employee_type employeeType = null;
                    switch (employeeTypeChoice) {
                        case 1:
                            employeeType = Employee.Employee_type.Experience;
                            break;
                        case 2:
                            employeeType = Employee.Employee_type.Fresher;
                            break;
                        case 3:
                            employeeType = Employee.Employee_type.Intern;
                            break;
                        default:
                            System.out.println("Loại nhân viên không hợp lệ.");
                            continue;
                    }
                    List<Certificate> certificates = new ArrayList<>();
                    System.out.print("Nhập số lượng chứng chỉ: ");
                    int numCertificates = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự newline
                    for (int i = 0; i < numCertificates; i++) {
                        System.out.print("Nhập ID chứng chỉ: ");
                        String certId = scanner.nextLine();
                        System.out.print("Nhập tên chứng chỉ: ");
                        String certName = scanner.nextLine();
                        System.out.print("Nhập ngày cấp chứng chỉ (dd/MM/yyyy): ");
                        String certDate = scanner.nextLine();
                        certificates.add(new Certificate(certId, certName, certDate));
                    }
                    Employee newEmployee = null;
                    switch (employeeType) {
                        case Experience:
                            System.out.print("Nhập số năm kinh nghiệm: ");
                            int expInYear = scanner.nextInt();
                            scanner.nextLine(); // Đọc ký tự newline
                            System.out.print("Nhập kỹ năng chuyên môn: ");
                            String proSkill = scanner.nextLine();
                            newEmployee = new Experience(id, fullName, birthDay, phone, email, certificates, expInYear, proSkill);
                            break;
                        case Fresher:
                            System.out.print("Nhập ngày tốt nghiệp (dd/MM/yyyy): ");
                            String graduationDate = scanner.nextLine();
                            System.out.print("Nhập xếp loại tốt nghiệp: ");
                            String graduationRank = scanner.nextLine();
                            System.out.print("Nhập trường đại học: ");
                            String university = scanner.nextLine();
                            newEmployee = new Fresher(id, fullName, birthDay, phone, email, certificates, graduationDate, graduationRank, university);
                            break;
                        case Intern:
                            System.out.print("Nhập chuyên ngành: ");
                            String major = scanner.nextLine();
                            System.out.print("Nhập học kỳ: ");
                            String semester = scanner.nextLine();
                            System.out.print("Nhập trường đại học: ");
                            String internUniversity = scanner.nextLine();
                            newEmployee = new Intern(id, fullName, birthDay, phone, email, certificates, major, semester, internUniversity);
                            break;
                    }
                    if (newEmployee != null) {
                        qlnv.themNhanVien(newEmployee);
                        System.out.println("Nhân viên đã được thêm thành công.");
                    }
                    else {
                        System.out.println("Không thể thêm nhân viên.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID nhân viên cần sửa: ");
                    String editId = scanner.nextLine();
                    if(!qlnv.kiemTraNhanVien(editId)) {
                        System.out.println("Nhân viên không tồn tại.");
                        continue;
                    }
                    System.out.print("Nhập họ tên mới: ");
                    String newFullName;
                    while (true) {
                        System.out.print("Nhập họ tên mới: ");
                        newFullName = scanner.nextLine();
                        try {
                            ValidateInput.validateFullName(newFullName);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.FullNameException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    String newBirthDay;
                    while (true) {
                        System.out.print("Nhập ngày sinh mới (dd/MM/yyyy): ");
                        newBirthDay = scanner.nextLine();
                        try {
                            ValidateInput.validateBirthDay(newBirthDay);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.BirthDayException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    String newPhone;
                    while (true) {
                        System.out.print("Nhập số điện thoại mới: ");
                        newPhone = scanner.nextLine();
                        try {
                            ValidateInput.validatePhone(newPhone);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.PhoneException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    String newEmail;
                    while (true) {
                        System.out.print("Nhập email mới: ");
                        newEmail = scanner.nextLine();
                        try {
                            ValidateInput.validateEmail(newEmail);  // gọi hàm đã sửa
                            break;  // nếu hợp lệ thì thoát vòng lặp
                        } catch (exception.EmailException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Chọn loại nhân viên (1: Experience, 2: Fresher, 3: Intern): ");
                    int newEmployeeTypeChoice = scanner.nextInt();
                    Employee.Employee_type newEmployeeType = null;
                    switch (newEmployeeTypeChoice) {
                        case 1:
                            newEmployeeType = Employee.Employee_type.Experience;
                            break;
                        case 2:
                            newEmployeeType = Employee.Employee_type.Fresher;
                            break;
                        case 3:
                            newEmployeeType = Employee.Employee_type.Intern;
                            break;
                        default:
                            System.out.println("Loại nhân viên không hợp lệ.");
                            continue;
                    }
                    List<Certificate> newCertificates = new ArrayList<>();
                    System.out.print("Nhập số lượng chứng chỉ mới: ");
                    int newNumCertificates = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự newline
                    for (int i = 0; i < newNumCertificates; i++) {
                        System.out.print("Nhập ID chứng chỉ mới: ");
                        String certId = scanner.nextLine();
                        System.out.print("Nhập tên chứng chỉ mới: ");
                        String certName = scanner.nextLine();
                        System.out.print("Nhập ngày cấp chứng chỉ mới (dd/MM/yyyy): ");
                        String certDate = scanner.nextLine();
                        newCertificates.add(new Certificate(certId, certName, certDate));
                    }
                    Employee updatedEmployee = null;
                    switch (newEmployeeType) {
                        case Experience:
                            System.out.print("Nhập số năm kinh nghiệm mới: ");
                            int newExpInYear = scanner.nextInt();
                            scanner.nextLine(); // Đọc ký tự newline
                            System.out.print("Nhập kỹ năng chuyên môn mới: ");
                            String newProSkill = scanner.nextLine();
                            updatedEmployee = new Experience(editId, newFullName, newBirthDay, newPhone, newEmail, newCertificates, newExpInYear, newProSkill);
                            break;
                        case Fresher:
                            System.out.print("Nhập ngày tốt nghiệp mới (dd/MM/yyyy): ");
                            String newGraduationDate = scanner.nextLine();
                            System.out.print("Nhập xếp loại tốt nghiệp mới: ");
                            String newGraduationRank = scanner.nextLine();
                            System.out.print("Nhập trường đại học mới: ");
                            String newUniversity = scanner.nextLine();
                            updatedEmployee = new Fresher(editId, newFullName, newBirthDay, newPhone, newEmail, newCertificates, newGraduationDate, newGraduationRank, newUniversity);
                            break;
                        case Intern:
                            System.out.print("Nhập chuyên ngành mới: ");
                            String newMajor = scanner.nextLine();
                            System.out.print("Nhập học kỳ mới: ");
                            String newSemester = scanner.nextLine();
                            System.out.print("Nhập trường đại học mới: ");
                            String internUniversity = scanner.nextLine();
                            updatedEmployee = new Intern(editId, newFullName, newBirthDay, newPhone, newEmail, newCertificates, newMajor, newSemester, internUniversity);
                            break;
                    }
                    if (updatedEmployee != null) {
                        qlnv.suaNhanVien(editId, updatedEmployee);
                        System.out.println("Thông tin nhân viên đã được cập nhật.");
                    } else {
                        System.out.println("Không thể cập nhật thông tin nhân viên.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập ID nhân viên cần xóa: ");
                    String deleteId = scanner.nextLine();
                    qlnv.xoaNhanVien(deleteId);
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

    }
}
