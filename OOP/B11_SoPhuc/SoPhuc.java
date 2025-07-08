package OOP.B11_SoPhuc;

public class SoPhuc {
    private double PhanThuc;
    private double PhanAo;

    public double getPhanThuc() {
        return PhanThuc;
    }
    public void setPhanThuc(double phanThuc) {
        PhanThuc = phanThuc;
    }
    public double getPhanAo() {
        return PhanAo;
    }
    public void setPhanAo(double phanAo) {
        PhanAo = phanAo;
    }
    public SoPhuc(double phanThuc, double phanAo) {
        this.PhanThuc = phanThuc;
        this.PhanAo = phanAo;
    }

}
