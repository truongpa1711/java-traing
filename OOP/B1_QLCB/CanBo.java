package OOP.B1_QLCB;

public class CanBo {
    protected String hoten;
    protected int tuoi;
    public enum gioitinh{
        NAM, NU, KHAC
    };
    protected gioitinh gt;
    protected String diachi;

    public CanBo(String hoten, int tuoi, gioitinh gt, String diachi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gt = gt;
        this.diachi = diachi;
    }
    public CanBo(){}

    public String getHoTen() {
        return hoten;
    }
    public void setHoTen(String hoten) {
        this.hoten = hoten;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public gioitinh getGioiTinh() {
        return gt;
    }
    public void setGioiTinh(gioitinh gt) {
        this.gt = gt;
    }
    public String getDiaChi() {
        return diachi;
    }
    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }



}
