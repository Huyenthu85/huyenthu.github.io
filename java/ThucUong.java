public class ThucUong extends Sanpham
{
    private double Giatopping;
    private String note;
    public ThucUong(String masp, String tensp, double dongia,String donvitinh, int soluongtonkho, String trangthai, double giatopping, String note) {
        super(masp, tensp, dongia,donvitinh, soluongtonkho, trangthai);
        this.Giatopping = giatopping;
        this.note = note;
    }
    @Override
    public double TinhGia()
    {
        return Dongia *1.1 + Giatopping;
    }   
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Gia topping: "+Giatopping);
        System.out.println("Ghi chu: "+note);
    }
}

