import java.util.ArrayList;

public class DonHang {
    public String MaDH;
    private KhachHang khachhang;
    private Nhanvien nhanvien;
    public String Ngaydat;
    public String Trangthai;
    public static int demDH = 1; 
    private ArrayList<ChitietHD> dsChiTiet = new ArrayList<>();

    public DonHang(String madh, KhachHang khachhang, Nhanvien nhanvien, String ngaydat, String trangthai) {
        this.MaDH = madh;
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        this.Ngaydat = ngaydat;
        this.Trangthai = trangthai;
    }

    public void themChiTiet(ChitietHD ct) {
        dsChiTiet.add(ct);
    }

    public double Tinhtongtien() {
        double tong = 0;
        for (ChitietHD ct : dsChiTiet)
            tong += ct.ThanhTien();
        return tong-(khachhang.GiamGia()*tong);
    }

    public void capNhatDiemTichLuy() {
    double tongTien = 0;
    for (ChitietHD ct : dsChiTiet)
        tongTien += ct.ThanhTien();
    int diemMoi = (int)(tongTien / 10000); // 1 diem moi 10.000đ
    khachhang.Diemtichluy += diemMoi;
    System.out.println(">> Cap nhat " + diemMoi + " diem tich luy cho khach hang!");
}

    public void xuat() {
        System.out.println("Ma don hang: " + MaDH);
        System.out.println("Ngay dat hang: " + Ngaydat);
        System.out.println("Trang thai don hang: " + Trangthai);
        System.out.println("Thong tin khach hang:");
        khachhang.xuat();
        System.out.println("Thong tin nhan vien xu ly don hang:");
        System.out.println(" - Ma NV: " + nhanvien.Manv);
        System.out.println(" - Ho ten: " + nhanvien.Hoten);
    }
    public KhachHang getKhachhang() {
    return khachhang;
}

public Nhanvien getNhanvien() {
    return nhanvien;
}
}
