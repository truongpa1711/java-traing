package OOP.B2_QuanLySach;

public class Sach extends TaiLieu {
    private static int demSach = 1;
    private String tenTacGia;
    private int soTrang;

    public Sach(String tenNhaXuatBan, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(tenNhaXuatBan, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
        this.maTaiLieu = "Sach" + demSach++;
    }
    public String getTenTacGia() {
        return tenTacGia;
    }
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
    public int getSoTrang() {
        return soTrang;
    }
    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
}
