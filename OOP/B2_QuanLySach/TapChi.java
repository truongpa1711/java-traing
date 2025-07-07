package OOP.B2_QuanLySach;

public class TapChi extends TaiLieu {
    public static int demTapChi = 1;
    private int soPhatHanh;
    private String thangPhatHanh;

    public TapChi(String tenNhaXuatBan, int soBanPhatHanh, int soPhatHanh, String thangPhatHanh) {
        super(tenNhaXuatBan, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
        this.maTaiLieu = "TapChi" + demTapChi++;
    }
    public int getSoPhatHanh() {
        return soPhatHanh;
    }
    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }
    public String getThangPhatHanh() {
        return thangPhatHanh;
    }
    public void setThangPhatHanh(String thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

}
