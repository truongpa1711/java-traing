package OOP.B8_QLMUONSACH;

public class Main {
    public static void main(String[] args) {
        QLMS qlms = new QLMS();

        // Tạo sinh viên
        SinhVien sv1 = new SinhVien();
        sv1.setHoTen("Nguyen Van A");
        sv1.setTuoi(20);
        sv1.setLop("CNTT1");
        // Tạo sinh viên khác
        SinhVien sv2 = new SinhVien();
        sv2.setHoTen("Tran Thi B");
        sv2.setTuoi(21);
        sv2.setLop("CNTT2");

        // Tạo phiếu mượn sách
        TheMuon theMuon1 = new TheMuon("PM001", "2023-10-01", "2023-10-15", 123, sv1);
        TheMuon theMuon2 = new TheMuon("PM002", "2023-10-02", "2023-10-16", 456, sv2);
        // Thêm phiếu mượn vào danh sách
        qlms.themPhieuMuon(theMuon1);
        qlms.themPhieuMuon(theMuon2);

        // Hiển thị danh sách phiếu mượn
        System.out.println("Danh sách phiếu mượn:");
        for (TheMuon tm : qlms.getDanhSachMuonSach()) {
            System.out.println(tm);
        }

        // Xóa phiếu mượn theo mã
        qlms.xoaPhieuMuonTheoMa("PM001");

        // Hiển thị lại danh sách sau khi xóa
        System.out.println("Danh sách phiếu mượn sau khi xóa:");
        for (TheMuon tm : qlms.getDanhSachMuonSach()) {
            System.out.println(tm);
        }
    }
}
