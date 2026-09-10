public class Nhanvienbanhang extends Nhanvien implements Luong {
    private double Doanhso;

    public Nhanvienbanhang(String hoten, int ns, String diachi, Boolean gioitinh, String sdt, String manv, int nvl,
            int sogiolam, double doanhso) {
        super(hoten, ns, diachi, gioitinh, sdt, manv, nvl, sogiolam);
        this.Doanhso = doanhso;
    }

    @Override
    public char Xeploai() {
        if (Doanhso >= 10000)
            return 'A';
        else if (Doanhso >= 5000)
            return 'B';
        else if (Doanhso >= 200)
            return 'C';
        else
            return 'D';
    }

    @Override
    public double Thuong() {
        char xl = Xeploai();
        switch (xl) {
            case 'A':
                return 0.2 * Doanhso;
            case 'B':
                return 0.1 * Doanhso;
            case 'C':
                return 0.05 * Doanhso;
            default:
                return 0;
        }
    }

    @Override
    public double luong() {
        return Tinhluong() + Thuong();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Doanh so ban hang: " + Doanhso);
        System.out.println("Xep loai nhan vien ban hang: " + Xeploai());
        System.out.println("Tien thuong: " + Thuong());
        System.out.println("Luong: " + luong());
    }
}
