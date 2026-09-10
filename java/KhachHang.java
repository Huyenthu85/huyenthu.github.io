public class KhachHang extends Nguoi {
    public String MaKH;
    public int Diemtichluy;
    public static int demKH = 1;
    public KhachHang(String hoten, int ns, String diachi, Boolean gioitinh, String sdt, String makh, int diemtichluy) {
        super(hoten, ns, diachi, gioitinh, sdt);
        this.MaKH = makh;
        this.Diemtichluy = diemtichluy;
    }
    public String getHoten() {
    return Hoten;
    }

    public int getDiemtichluy() {
    return Diemtichluy;
    }

    public String Capdo() {
        if (Diemtichluy > 1000)
            return "Hoi vien Kim Cuong";
        else if (Diemtichluy > 500)
            return "Hoi vien Vang";
        else if (Diemtichluy > 200)
            return "Hoi vien Bac";
        else
            return "Hoi vien Thuong";
    }
    public double GiamGia()
    {
        String capdo = Capdo();
        if(capdo=="Hoi vien Kim Cuong")
            return 0.3;
        else if(capdo=="Hoi vien Vang")
            return 0.15;
        else if(capdo=="Hoi vien Bac")
            return 0.06;
        else
            return 0;
    }
    public void xuat() {
        super.xuat();
        System.out.println("Ma khach hang: " + MaKH);
        System.out.println("Diem tich luy hien co: " + Diemtichluy);
        System.out.println("Cap do khach hang: " + Capdo());
        System.out.println("Phan tram giam gia dat duoc voi cap do hien tai:" + GiamGia()*100 + "%");
    }
public String getMakh() {
    return MaKH;
}
}
