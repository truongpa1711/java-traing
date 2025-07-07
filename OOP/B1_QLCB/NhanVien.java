package OOP.B1_QLCB;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String hoten, int tuoi, gioitinh gt, String diachi, String congViec) {
        super(hoten, tuoi, gt, diachi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
}
