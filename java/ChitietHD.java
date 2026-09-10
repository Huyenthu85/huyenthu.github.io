public class ChitietHD 
{
    private String MaCTHD;
    private Sanpham sanPham;
    private int soLuong;
    public ChitietHD(Sanpham sanPham, int soLuong) 
    {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }
    public int getSoLuong()
    {
        return soLuong;
    }
    public Sanpham getSanPham()
    {
        return sanPham;
    }
    public double ThanhTien()
    {
        return sanPham.TinhGia() * soLuong;
    }
    public void xuat()
    {
        System.out.println("Ma chi tiet hoa don: "+MaCTHD);
        sanPham.xuat();
        System.out.println("So luong: "+soLuong);
        System.out.println("Thanh tien: "+ThanhTien());
    }
}
