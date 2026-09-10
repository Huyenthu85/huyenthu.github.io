import java.time.LocalDate;
public class Nguoi 
{
    protected String Hoten;
    protected int Ns;
    protected String Diachi;
    protected Boolean Gioitinh;
    protected String Sdt;
    public Nguoi(String hoten, int ns, String diachi, Boolean gioitinh, String sdt) 
    {
        this.Hoten = hoten;
        this.Ns = ns;
        this.Diachi = diachi;
        this.Gioitinh = gioitinh;
        this.Sdt = sdt;
    }
    public int Tinhtuoi()
    {
        return LocalDate.now().getYear()-Ns;
    }
    public void xuat()
    {
        System.out.println("Ho ten: " + Hoten);
        System.out.println("Nam sinh: " + Ns);
        System.out.println("Dia chi: " + Diachi);
        System.out.println("Gioi tinh: " + (Gioitinh ? "Nam" : "Nu"));
        System.out.println("So dien thoai: " + Sdt);
    }
}
