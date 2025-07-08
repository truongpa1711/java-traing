package OOP.B12_QLPTGT;

public class XeTai extends PhuongTien{
    public double taiTrong;
    public XeTai(String hangSanXuat, String namSanXuat, String mauXe, double giaBan, double taiTrong) {
        super(hangSanXuat, namSanXuat, mauXe, giaBan);
        this.taiTrong = taiTrong;
    }
    public double getTaiTrong() {
        return taiTrong;
    }
    public void setTaiTrong(double taiTrong) {
        this.taiTrong = taiTrong;
    }
    @Override
    public String toString() {
        return "XeTai{" +
                "ID=" + getID() +
                ", hangSanXuat='" + getHangSanXuat() + '\'' +
                ", namSanXuat='" + getNamSanXuat() + '\'' +
                ", mauXe='" + getMauXe() + '\'' +
                ", giaBan=" + getGiaBan() +
                ", taiTrong=" + taiTrong +
                '}';
    }
}
