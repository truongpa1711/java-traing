package OOP.B4_QLDC;

import java.util.HashSet;
import java.util.Scanner;

public class QLDC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n hộ dân: ");
        int n=scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới sau khi nhập số
        KhuPho khuPho = new KhuPho();
        HashSet<String> SoCmSet = new HashSet<>();
        for (int i=0;i<n;i++){
            HoGiaDinh hoGiaDinh = new HoGiaDinh();
            System.out.println("Nhập thông tin hộ gia đình thứ " + (i + 1) + ":");
            System.out.print("Số nhà: ");
            hoGiaDinh.setSoNha(scanner.nextLine());
            System.out.print("Số thành viên: ");
            int soThanhVien = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới sau khi nhập số
            for(int j=0;j<soThanhVien;j++){
                Nguoi nguoi=new Nguoi();
                System.out.println("Nhập thông tin thành viên thứ " + (j + 1) + ":");
                System.out.print("Họ tên: ");
                nguoi.setHoTen(scanner.nextLine());
                System.out.print("Tuổi: ");
                nguoi.setTuoi(scanner.nextInt());
                scanner.nextLine(); // Đọc dòng mới sau khi nhập số
                System.out.print("Nghề nghiệp: ");
                nguoi.setNgheNghiep(scanner.nextLine());
                String soCm;
                do {
                    System.out.print("Số CMND: ");
                    soCm = scanner.nextLine();
                    if (SoCmSet.contains(soCm)) {
                        System.out.println("Số CMND đã tồn tại, vui lòng nhập lại.");
                    }
                } while (SoCmSet.contains(soCm));
                nguoi.setSoCm(soCm);
                SoCmSet.add(soCm);
                hoGiaDinh.getDanhSachThanhVien().add(nguoi);
            }
            khuPho.getDanhSachHoGiaDinh().add(hoGiaDinh);
        }
        System.out.println("Thông tin khu phố:");
        for (HoGiaDinh hoGiaDinh : khuPho.getDanhSachHoGiaDinh()) {
            System.out.println("Số nhà: " + hoGiaDinh.getSoNha());
            for (Nguoi nguoi : hoGiaDinh.getDanhSachThanhVien()) {
                System.out.println("Họ tên: " + nguoi.getHoTen() + ", Tuổi: " + nguoi.getTuoi() +
                                   ", Nghề nghiệp: " + nguoi.getNgheNghiep() + ", Số CMND: " + nguoi.getSoCm());
            }
        }
    }
}
