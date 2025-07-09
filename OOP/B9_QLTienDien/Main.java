package OOP.B9_QLTienDien;

public class Main {
    public static void main(String[] args) {
        QLTD qltd = new QLTD();

        khachHang kh1 = new khachHang();
        kh1.setHoTen("Nguyen Van A");
        kh1.setSoNha("123 Nguyen Trai");
        kh1.setMaSoCongTo("CT001");

        BienLai bl1 = new BienLai();
        bl1.setKhachHang(kh1);
        bl1.setChiSoCu(100);
        bl1.setChiSoMoi(150);
        bl1.setSoTien();

        qltd.themBienLai(bl1);

        System.out.println("Danh sách biên lai:");
        for (BienLai bl : qltd.getDanhSachBienLai()) {
            System.out.println(bl);
        }
        // Sửa thông tin khách hàng theo ma biên lai
        khachHang khMoi = new khachHang();
        khMoi.setHoTen("Nguyen Van B");
        khMoi.setSoNha("456 Le Loi");
        khMoi.setMaSoCongTo("CT002");
        qltd.suaKhachHangTheoMa("CT001", khMoi);
        System.out.println("Danh sách biên lai sau khi sửa thông tin khách hàng:");
        for (BienLai bl : qltd.getDanhSachBienLai()) {
            System.out.println(bl);
        }
        // Xóa biên lai theo mã số công tơ
        qltd.xoaBienLaiTheoMa("CT002");
        System.out.println("Danh sách biên lai sau khi xóa:");
        for (BienLai bl : qltd.getDanhSachBienLai()) {
            System.out.println(bl);
        }

    }
}
