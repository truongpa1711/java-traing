package OOP.B6_QLHS;

public class HocSinh {
    private String hoTen;
    private int tuoi;
    private String QueQuan;

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getQueQuan() {
        return QueQuan;
    }
    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }

    public HocSinh(String hoTen, int tuoi, String queQuan) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.QueQuan = queQuan;
    }

}
