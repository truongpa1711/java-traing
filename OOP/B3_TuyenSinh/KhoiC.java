package OOP.B3_TuyenSinh;

public class KhoiC extends ThiSinh {
    private double van;
    private double su;
    private double dia;

    public KhoiC(String hoTen, String diaChi, String mucUuTien, double van, double su, double dia) {
        super(hoTen, diaChi, mucUuTien);
        this.van = van;
        this.su = su;
        this.dia = dia;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getSu() {
        return su;
    }

    public void setSu(double su) {
        this.su = su;
    }

    public double getDia() {
        return dia;
    }

    public void setDia(double dia) {
        this.dia = dia;
    }
}
