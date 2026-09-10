public class Nhanvienphache extends Nhanvien implements Luong {
    private int Snn;
    private double Soluonglyphache;
    public static double phucapnangnhoc = 0.1;

    public Nhanvienphache(String hoten, int ns, String diachi, Boolean gioitinh, String sdt, String manv, int nvl,
            int sogiolam, int snn, double soluonglyphache) {
        super(hoten, ns, diachi, gioitinh, sdt, manv, nvl, sogiolam);
        this.Snn = snn;
        this.Soluonglyphache = soluonglyphache;
    }
    @Override
    public char Xeploai() {
        if (Snn <= 1)
            return 'A';
        if (Snn <= 3)
            return 'B';
        if (Snn <= 5)
            return 'C';
        else
            return 'D';
    }

    @Override
    public double Thuong() {
        if (Soluonglyphache > 1000)
            return Tinhluong() * 0.2;
        if (Soluonglyphache > 500)
            return Tinhluong() * 0.15;
        else
            return 0;
    }

    @Override
    public double luong() {
        return Tinhluong() + Thuong() + (1 + phucapnangnhoc);
    }
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("So ngay nghi trong thang: "+Snn);
        System.out.println("So luong san pham da pha che duoc trong thang: "+Soluonglyphache);
        System.out.println("Xep loai nhan vien pha che: "+Xeploai());
        System.out.println("Tien thuong: "+Thuong());
        System.out.println("Luong: "+luong());
    }
}
