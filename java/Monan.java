public class Monan extends Sanpham
{
    private int Phiphunau;
    public Monan(String masp, String tensp, double dongia,String donvitinh, int soluongtonkho, String trangthai, int phiphunau) {
        super(masp, tensp, dongia,donvitinh, soluongtonkho, trangthai);
        this.Phiphunau = phiphunau;
    }
    @Override
    public double TinhGia()
    {
        return Dongia * 1.1 + Phiphunau;
    }
    @Override
    public void xuat()
    {
        super.xuat();
        System.out.println("Phi phu nau: "+Phiphunau);
    }
}
