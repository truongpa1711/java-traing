package OOP.B2_QuanLySach;

public class Bao extends TaiLieu {
    public static int demBao = 1;
    private String ngayPhatHanh;

    public Bao(String tenNhaXuatBan, int soBanPhatHanh, String ngayPhatHanh) {
        super(tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
        this.maTaiLieu = "Bao" + demBao++;
    }
    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
