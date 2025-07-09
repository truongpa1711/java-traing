package OOP.B13_QLNV;

public class Certificate {
    public static int count = 0;
    private String CertificatedID;
    private String CertificatedName;
    private String CertificatedRank;
    private String CertificatedDate;

    public Certificate(String certificatedName, String certificatedRank, String certificatedDate) {
        this.CertificatedID = "CT" + ++count; // Tăng biến đếm và gán ID
        this.CertificatedName = certificatedName;
        this.CertificatedRank = certificatedRank;
        this.CertificatedDate = certificatedDate;
    }
    public String getCertificatedID() {
        return CertificatedID;
    }
    public String getCertificatedName() {
        return CertificatedName;
    }
    public void setCertificatedName(String certificatedName) {
        this.CertificatedName = certificatedName;
    }
    public String getCertificatedRank() {
        return CertificatedRank;
    }
    public void setCertificatedRank(String certificatedRank) {
        this.CertificatedRank = certificatedRank;
    }
    public String getCertificatedDate() {
        return CertificatedDate;
    }
    public void setCertificatedDate(String certificatedDate) {
        this.CertificatedDate = certificatedDate;
    }
    @Override
    public String toString() {
        return "Certificate{" +
                "CertificatedID='" + CertificatedID + '\'' +
                ", CertificatedName='" + CertificatedName + '\'' +
                ", CertificatedRank='" + CertificatedRank + '\'' +
                ", CertificatedDate='" + CertificatedDate + '\'' +
                '}';
    }
}
