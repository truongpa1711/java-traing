package OOP.B2_QuanLySach;

public class TaiLieu {
    protected String maTaiLieu;
    protected String tenNhaXuatBan;
    protected int soBanPhatHanh;

    public TaiLieu(String tenNhaXuatBan, int soBanPhatHanh) {
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }
    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }
    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }
    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }
    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }


}
