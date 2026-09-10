public class Quanly extends Nhanvien implements Luong {
    private String Chucvu;
    private int Snl;
    public static final double phucapchucvu = 0.3;

    public Quanly(String hoten, int ns, String diachi, Boolean gioitinh, String sdt, String manv, int nvl,
            int sogiolam, String chucvu, int snl) {
        super(hoten, ns, diachi, gioitinh, sdt, manv, nvl, sogiolam);
        this.Chucvu = chucvu;
        this.Snl = snl;
    }

    @Override
    public double Thuong() {
        if (Snl >= 28)
            return 0.2 * Tinhluong();
        else
            return 0;
    }

    @Override
    public char Xeploai() {
        return 'A';
    }

    @Override
    public double luong() {
        return Tinhluong() + (1 + phucapchucvu) + Thuong();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuc vu: " + Chucvu);
        System.out.println("Tong so ngay lam trong thang:" + Snl);
        System.out.println("Tien thuong: " + Thuong());
        System.out.println("Luong: " + luong());
    }

}
