package OOP.B1_QLCB;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu(String hoten, int tuoi, gioitinh gt, String diachi, String nganhDaoTao) {
        super(hoten, tuoi, gt, diachi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }
}
