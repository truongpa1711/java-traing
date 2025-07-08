package OOP.B7_QLGV;

public class CBGV {
    private float luongCung;
    private float luongThuong;
    private float tienPhat;
    private float luongThucNhan;
    private Nguoi gv;

    public float getLuongCung() {
        return luongCung;
    }
    public void setLuongCung(float luongCung) {
        this.luongCung = luongCung;
    }
    public float getLuongThuong() {
        return luongThuong;
    }
    public void setLuongThuong(float luongThuong) {
        this.luongThuong = luongThuong;
    }
    public float getTienPhat() {
        return tienPhat;
    }
    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }
    public float getLuongThucNhan() {
        return luongThucNhan;
    }
    public void setLuongThucNhan() {
        this.luongThucNhan = luongCung + luongThuong - tienPhat;
    }
    public Nguoi getGv() {
        return gv;
    }
    public void setGv(Nguoi gv) {
        this.gv = gv;
    }
    public CBGV(float luongCung, float luongThuong, float tienPhat, Nguoi gv) {
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
        this.gv = gv;
        setLuongThucNhan(); // Tính lương thực nhận ngay khi khởi tạo
    }

}
