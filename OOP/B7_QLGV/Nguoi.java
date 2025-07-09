package OOP.B7_QLGV;

public class Nguoi {
    public static final String DEFAULT_MA_SO = "0000";
    private String hoTen;
    private int tuoi;
    private String queQuan;
    private String maSo;

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
        return queQuan;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public String getMaSo() {
        return maSo;
    }

    public Nguoi(String hoTen, int tuoi, String queQuan) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.maSo = DEFAULT_MA_SO+ (int)(Math.random() * 10000); // Tạo mã số ngẫu nhiên
    }
    public Nguoi() {
        // Constructor mặc định
    }

}
