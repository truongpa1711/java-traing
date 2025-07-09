package OOP.B12_QLPTGT;

public class XEMAY extends PhuongTien{
    public String congSuat;

    public XEMAY(String hangSanXuat, String namSanXuat, String mauXe, double giaBan, String congSuat) {
        super(hangSanXuat, namSanXuat, mauXe, giaBan);
        this.congSuat = congSuat;
    }
    public String getCongSuat() {
        return congSuat;
    }
    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XEMAY{" +
                "ID=" + getID() +
                ", hangSanXuat='" + getHangSanXuat() + '\'' +
                ", namSanXuat='" + getNamSanXuat() + '\'' +
                ", mauXe='" + getMauXe() + '\'' +
                ", giaBan=" + getGiaBan() +
                ", congSuat='" + congSuat + '\'' +
                '}';
    }
}
