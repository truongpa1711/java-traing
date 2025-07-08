package OOP.B5_QLKHACHSAN;

public class Phong {
    private Nguoi Khach;
    private int soNgayThue;
    public enum LoaiPhong {
        A(500), // $500
        B(300), // $300
        C(100); // $100

        private final int gia;

        LoaiPhong(int gia) {
            this.gia = gia;
        }

        public int getGia() {
            return gia;
        }
    }
    private LoaiPhong loaiPhong;

    public Nguoi getKhach() {
        return Khach;
    }
    public void setKhach(Nguoi khach) {
        this.Khach = khach;
    }
    public int getSoNgayThue() {
        return soNgayThue;
    }
    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }
    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }
    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
    public int tinhTien() {
        return soNgayThue * loaiPhong.getGia();
    }

}
