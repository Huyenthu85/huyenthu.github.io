import java.time.LocalDate;

public class Nhanvienphubep extends Nhanvien implements Luong {
    private int Snn;
    public static final double phucapyte = 0.2;

    public Nhanvienphubep(String hoten, int ns, String diachi, Boolean gioitinh, String sdt, String manv, int nvl,
            int sogiolam, int snn) {
        super(hoten, ns, diachi, gioitinh, sdt, manv, nvl, sogiolam);
        this.Snn = snn;
    }

    public String Kinhnghiem() {
        int sonamlam = LocalDate.now().getYear() - Nvl;
        if (sonamlam >= 5)
            return "Dau bep";
        else if (sonamlam >= 3)
            return "Pho bep";
        else
            return "Phu bep";
    }

    @Override
    public char Xeploai() {
        if (Snn <= 1)
            return 'A';
        else if (Snn <=3)
            return 'B';
        else if (Snn <=5)
            return 'C';
        else
            return 'D';
    }

    @Override
    public double Thuong() 
    {
        String kn=Kinhnghiem();
        if (kn.equals("Dau bep"))
        {
            return 0.2 * Tinhluong();
        }
        else if (kn.equals("Pho bep"))
        {
            return 0.1 * Tinhluong();
        }
        else
            return 0;
    }

    @Override
    public double luong() {
        return Tinhluong() + Thuong() + (1 + phucapyte);
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("So ngay nghi trong thang: " + Snn);
        System.out.println("Xep loai nhan vien phu bep: " + Xeploai());
        System.out.println("Tien thuong: " + Thuong());
        System.out.println("Kinh nghiem: " + Kinhnghiem());
        System.out.println("Luong: " + luong());
    }

}
