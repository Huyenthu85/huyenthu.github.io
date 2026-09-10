abstract public class Sanpham {
    protected String Masp;
    protected String Tensp;
    protected double Dongia;
    protected String Donvitinh;
    protected int Soluongtonkho;
    protected String trangthai;

    public Sanpham(String masp, String tensp, double dongia, String donvitinh, int soluongtonkho, String trangthai) {
        this.Masp = masp;
        this.Tensp = tensp;
        this.Dongia = dongia;
        this.Donvitinh = donvitinh;
        this.Soluongtonkho = soluongtonkho;
        this.trangthai = trangthai;
    }

    public String getMasp() {
        return Masp;
    }
    public String getTensp() {
        return Tensp;
    }
    public double getDongia() {
        return Dongia;
    }
    public int getSoluongtonkho() {
        return Soluongtonkho;
    }
    abstract public double TinhGia();

    public void xuat() {
        System.out.println("Ma san pham: " + Masp);
        System.out.println("Ten san pham: " + Tensp);
        System.out.println("Don gia: " + Dongia);
        System.out.println("Don vi tinh: " + Donvitinh);
        System.out.println("So luong: " + Soluongtonkho);
        System.out.println("Trang thai: " + trangthai);
        System.out.println("Thanh tien: " + TinhGia());
    }
}
