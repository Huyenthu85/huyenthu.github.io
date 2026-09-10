abstract public class Nhanvien extends Nguoi {
    public String Manv;
    public int Nvl;
    public int Sogiolam;
    public static final int Luongcoban = 25000;

    public Nhanvien(String hoten, int ns, String diachi, Boolean gioitinh, String sdt, String manv, int nvl,
            int sogiolam) {
        super(hoten, ns, diachi, gioitinh, sdt);
        this.Manv = manv;
        this.Nvl = nvl;
        this.Sogiolam = sogiolam;
    }

    public String getManv() {
        return Manv;
    }

    public double Tinhluong() {
        return Sogiolam * Luongcoban;
    }

    abstract public char Xeploai();

    abstract public double Thuong();

    public void xuat() 
    {
        super.xuat();
        System.out.println("Ma nhan vien: " + Manv);
        System.out.println("Nam vao lam: " + Nvl);
        System.out.println("So gio lam: " + Sogiolam);
    }
}
