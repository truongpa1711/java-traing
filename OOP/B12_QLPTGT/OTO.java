package OOP.B12_QLPTGT;

public class OTO extends PhuongTien {
    private int soChoNgoi;
    private String kieuDongCo;

    public OTO(String hangSanXuat, String namSanXuat, String mauXe, double giaBan, int soChoNgoi, String kieuDongCo) {
        super(hangSanXuat, namSanXuat, mauXe, giaBan);
        this.soChoNgoi = soChoNgoi;
        this.kieuDongCo = kieuDongCo;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuDongCo() {
        return kieuDongCo;
    }

    public void setKieuDongCo(String kieuDongCo) {
        this.kieuDongCo = kieuDongCo;
    }

    @Override
    public String toString() {
        return "OTO{" +
                "ID=" + getID() +
                ", hangSanXuat='" + getHangSanXuat() + '\'' +
                ", namSanXuat='" + getNamSanXuat() + '\'' +
                ", mauXe='" + getMauXe() + '\'' +
                ", giaBan=" + getGiaBan() +
                ", soChoNgoi=" + soChoNgoi +
                ", kieuDongCo='" + kieuDongCo + '\'' +
                '}';
    }
}
