public class HoaDon 
{
    private String MaHD;
    private DonHang donHang;
    private String Ngaylap;
    private String PTTT;
    private String Ghichu;
    public static int demHD = 1;
    public HoaDon(String maHD, DonHang donHang, String ngaylap, String PTTT, String ghichu) {
        this.MaHD = maHD;
        this.donHang = donHang;
        this.Ngaylap = ngaylap;
        this.PTTT = PTTT;
        this.Ghichu = ghichu;
    }
    public String getMaHD() {
    return MaHD;
}

public String getNgaylap() {
    return Ngaylap;
}

public String getPTTT() {
    return PTTT;
}

public String getGhichu() {
    return Ghichu;
}

public DonHang getDonHang() {
    return donHang;
}

    public void xuat()
    {
        System.out.println("Ma hoa don: "+MaHD);
        System.out.println("Ngay lap: "+Ngaylap);
        System.out.println("Phuong thuc thanh toan: "+PTTT);
        System.out.println("Ghi chu: "+Ghichu);
        System.out.println("Thong tin don hang:");
        donHang.xuat();
        System.out.println("Tong tien thanh toan: "+donHang.Tinhtongtien());
    }
}
