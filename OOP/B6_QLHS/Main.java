package OOP.B6_QLHS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLHS qlhs = new QLHS();
        int choise= 0;
        do{
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Tìm kiếm học sinh trên 20 tuổi");
            System.out.println("3. Số lượng các học sinh có tuổi là 23 và quê ở DN");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choise = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Skip to the next iteration of the loop
            }
            switch (choise) {
                case 1:
                    System.out.print("Nhập họ tên học sinh: ");
                    scanner.nextLine(); // Clear the newline character
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập tuổi học sinh: ");
                    int tuoi = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    System.out.print("Nhập quê quán học sinh: ");
                    String queQuan = scanner.nextLine();
                    HocSinh hocSinh = new HocSinh(hoTen, tuoi, queQuan);
                    qlhs.themHocSinh(hocSinh);
                    break;
                case 2:
                    System.out.println("Danh sách học sinh trên 20 tuổi:");
                    for (HocSinh hs : qlhs.timKiemHocSinhTren20Tuoi()) {
                        System.out.println(hs.getHoTen() + " - Tuổi: " + hs.getTuoi() + " - Quê quán: " + hs.getQueQuan());
                    }
                    break;
                case 3:
                    int count = qlhs.demHocSinhTheoQueQuan();
                    System.out.println("Số lượng học sinh có tuổi là 23 và quê ở DN: " + count);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }while (choise != 5);
    }
}
