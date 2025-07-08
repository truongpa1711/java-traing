package OOP.B7_QLGV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLGV qlgv = new QLGV();

        // Thêm giáo viên
        CBGV cbgv1 = new CBGV(5000000,100000,500000,new Nguoi("Nguyen Van A", 30, "Ha Noi"));
        CBGV cbgv2 = new CBGV(1000000,200000,200000,new Nguoi("Tran Thi B", 28, "Hai Phong"));
        CBGV cbgv3 = new CBGV(7000000,150000,300000,new Nguoi("Le Van C", 35, "Da Nang"));

        qlgv.themCBGV(cbgv1);
        qlgv.themCBGV(cbgv2);
        qlgv.themCBGV(cbgv3);
        System.out.println("Danh sách giáo viên:");
        for (CBGV cbgv : qlgv.getDanhSachCBGV()) {
            System.out.println(cbgv.getGv().getHoTen() + " - Mã số: " + cbgv.getGv().getMaSo());
            System.out.println("  Lương cơ bản: " + cbgv.getLuongCung() + " - Thưởng: " + cbgv.getLuongThuong() + " - Phạt: " + cbgv.getTienPhat());
            System.out.println("  Lương thực nhận: " + cbgv.getLuongThucNhan());
            System.out.println("-----------------------------");
        }

        // Xóa giáo viên theo mã
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã số giáo viên cần xóa: ");
        String maCBGVCanXoa = scanner.nextLine();
        qlgv.xoaCBGVTheoMa(maCBGVCanXoa);
        System.out.println("Danh sách giáo viên sau khi xóa:");
        for (CBGV cbgv : qlgv.getDanhSachCBGV()) {
            System.out.println(cbgv.getGv().getHoTen() + " - Mã số: " + cbgv.getGv().getMaSo());
            System.out.println("  Lương cơ bản: " + cbgv.getLuongCung() + " - Thưởng: " + cbgv.getLuongThuong() + " - Phạt: " + cbgv.getTienPhat());
            System.out.println("  Lương thực nhận: " + cbgv.getLuongThucNhan());
            System.out.println("-----------------------------");
        }
    }
}
