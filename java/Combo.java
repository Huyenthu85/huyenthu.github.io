import java.util.ArrayList;

public class Combo extends Sanpham {
    private ArrayList<Sanpham> danhSachSP = new ArrayList<>();

    public Combo(String masp, String tensp, double dongia, String donvitinh, int soluongtonkho, String trangthai) {
        super(masp, tensp, dongia, donvitinh, soluongtonkho, trangthai);
    }

    public void themSanPham(Sanpham sp) {
        danhSachSP.add(sp);
    }

    @Override
public double TinhGia() {
    if (danhSachSP.isEmpty()) {
        return Dongia; 
    }
    double tong = 0;
    for (Sanpham sp : danhSachSP)
        tong += sp.TinhGia();
    return tong; 
}

    @Override
    public void xuat() {
        super.xuat();
        if (!danhSachSP.isEmpty()) {
            System.out.println("Cac san pham trong combo:");
            for (Sanpham sp : danhSachSP) {
                sp.xuat();
                System.out.println("-------------------");
            }
        }
    }
}
