package OOP.B12_QLPTGT;

public class PhuongTien {
    public static int count = 0; // Biến đếm số lượng phương tiện
    private int ID;
    private String hangSanXuat;
    private String namSanXuat;
    private String mauXe;
    private double giaBan;

    public PhuongTien(String hangSanXuat, String namSanXuat, String mauXe, double giaBan) {
        this.ID = ++count; // Tăng biến đếm và gán ID
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.mauXe = mauXe;
        this.giaBan = giaBan;
    }
    public int getID() {
        return ID;
    }
    public String getHangSanXuat() {
        return hangSanXuat;
    }
    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public String getNamSanXuat() {
        return namSanXuat;
    }
    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }
    public String getMauXe() {
        return mauXe;
    }
    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    @Override
    public String toString() {
        return "PhuongTien{" +
                "ID=" + ID +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", mauXe='" + mauXe + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }
}
