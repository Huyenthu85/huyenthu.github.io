import java.io.*;
import java.util.*;

public class ListSanPham {
    private ArrayList<Sanpham> danhSachSP = new ArrayList<>();


public void nhapDanhSachBanDau() {
    System.out.println("\n--- NHAP DANH SACH SAN PHAM MAU ---");

    // Món ăn
    danhSachSP.add(new Monan("M01", "Burger Bo", 40000, "Phan", 0, "Dang ban", 20000));
    danhSachSP.add(new Monan("M02", "Burger Ga", 45000, "Phan", 0, "Dang ban", 20000));
    danhSachSP.add(new Monan("M03", "Pizza Hai San", 85000, "Cai", 0, "Dang ban", 30000));
    danhSachSP.add(new Monan("M04", "Mi Y Sot Bo", 60000, "Dia", 0, "Dang ban", 20000));
    danhSachSP.add(new Monan("M05", "Salad Rau Cu", 35000, "Dia", 5, "Dang ban", 20000));

    // Thức uống
    danhSachSP.add(new ThucUong("T01", "Ca Phe Sua", 39000, "Ly", 0, "Dang ban", 10000, "It da"));
    danhSachSP.add(new ThucUong("T02", "Tra Sua Tran Chau", 45000, "Ly", 0, "Dang ban", 15000, "Duong vua"));
    danhSachSP.add(new ThucUong("T03", "Sinh To Xoai", 25000, "Ly", 0, "Dang ban", 10000, "It duong"));
    danhSachSP.add(new ThucUong("T04", "Sting", 15000, "Ly", 70, "Dang ban", 5000, "50% da"));
    danhSachSP.add(new ThucUong("T05", "Nuoc suoi", 10000, "Ly", 80, "Dang ban", 5000, "Uong lanh"));

    // Combo
    danhSachSP.add(new Combo("C01", "Combo Burger + Coffee", 70000, "Combo", 0, "Dang ban"));
    danhSachSP.add(new Combo("C02", "Combo Pizza + Sting", 90000, "Combo", 0, "Dang ban"));
    danhSachSP.add(new Combo("C03", "Combo Mi Y + Ca Phe", 90000, "Combo", 0, "Dang ban"));
    danhSachSP.add(new Combo("C04", "Combo Salad + Sinh to", 50000, "Combo", 0, "Dang ban"));
    danhSachSP.add(new Combo("C05", "Combo Burger + Tra Sua", 80000, "Combo", 0, "Dang ban"));

    System.out.println(">> Da khoi tao danh sach mau.");
}
    // ===== Ham phu de tranh them trung ma =====
private void themNeuChuaCo(Sanpham sp) {
    for (Sanpham s : danhSachSP) {
        if (s.Masp.equalsIgnoreCase(sp.Masp)) return; // da co -> bo qua
    }
    danhSachSP.add(sp);
}
    public void themSanPham(Sanpham sp) {
        danhSachSP.add(sp);
    }

    
    public void xuatDanhSach() {
        if (danhSachSP.isEmpty()) {
            System.out.println("Danh sach san pham trong!");
            return;
        }
        System.out.println("\n===== DANH SACH SAN PHAM =====");
        for (Sanpham sp : danhSachSP) {
            sp.xuat();
            System.out.println("-------------------------");
        }
    }

    public void xoaTheoMa(String ma) {
        boolean found = false;
        Iterator<Sanpham> it = danhSachSP.iterator();
        while (it.hasNext()) {
            Sanpham sp = it.next();
            if (sp.Masp.equalsIgnoreCase(ma)) {
                it.remove();
                found = true;
                System.out.println(" Da xoa san pham co ma: " + ma);
                break;
            }
        }
        if (!found)
            System.out.println(" Khong tim thay san pham co ma: " + ma);
    }

    // ===== SUA SAN PHAM =====
public void suaTheoMa(String ma, int muc, Scanner sc) {
    for (Sanpham sp : danhSachSP) {
        if (sp.Masp.equalsIgnoreCase(ma)) {
            switch (muc) {
                case 1 -> {
                    System.out.print("Nhap don gia moi: ");
                    sp.Dongia = sc.nextDouble();
                    sc.nextLine();
                }
                case 2 -> {
                    System.out.print("Nhap so luong ton kho moi: ");
                    sp.Soluongtonkho = sc.nextInt();
                    sc.nextLine();
                }
                case 3 -> {
                    System.out.print("Nhap trang thai moi: ");
                    sp.trangthai = sc.nextLine();
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
            System.out.println(">> Da cap nhat san pham co ma: " + ma);
            return;
        }
    }
    System.out.println("Khong tim thay san pham co ma: " + ma);
}

    // ===== 4. Tim kiem theo ma =====
    public void timTheoMa(String ma) {
        for (Sanpham sp : danhSachSP) {
            if (sp.Masp.equalsIgnoreCase(ma)) {
                System.out.println(" Tim thay san pham:");
                sp.xuat();
                return;
            }
        }
        System.out.println(" Khong tim thay san pham co ma: " + ma);
    }

    // ===== 5. Tim gan đung theo ten =====
    public void timGanDung(String keyword) {
        boolean found = false;
        for (Sanpham sp : danhSachSP) {
            if (sp.Tensp.toLowerCase().contains(keyword.toLowerCase())) {
                sp.xuat();
                found = true;
            }
        }
        if (!found)
            System.out.println(" Khong tim thay san pham nao chua tu khoa: " + keyword);
    }

    // ===== 6. Thong ke theo loai =====
    public void thongKeTheoLoai() {
        int countMonAn = 0, countThucUong = 0, countCombo = 0;
        for (Sanpham sp : danhSachSP) {
            if (sp instanceof Monan) countMonAn++;
            else if (sp instanceof ThucUong) countThucUong++;
            else if (sp instanceof Combo) countCombo++;
        }
        System.out.println("\n===== THONG KE THEO LOAI =====");
        System.out.println(" Mon an: " + countMonAn);
        System.out.println(" Thuc uong: " + countThucUong);
        System.out.println(" Combo: " + countCombo);
    }

    // ===== 7. Thong ke tong gia tri hang ton kho =====
    public void thongKeGiaTriTonKho() {
        double tong = 0;
        for (Sanpham sp : danhSachSP)
            tong += sp.TinhGia() * sp.Soluongtonkho;
        System.out.println(" Tong gia tri hang ton kho: " + tong);
    }

    // 8. Ghi file text
    public void ghiFileText(String tenFile) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(tenFile));
            for (Sanpham sp : danhSachSP) {
                pw.println("Ma SP: " + sp.Masp);
                pw.println("Ten SP: " + sp.Tensp);
                pw.println("Don gia: " + sp.Dongia);
                pw.println("Don vi tinh: " + sp.Donvitinh);
                pw.println("So luong ton kho: " + sp.Soluongtonkho);
                pw.println("Trang thai: " + sp.trangthai);
                pw.println("Gia tinh toan: " + sp.TinhGia());
                pw.println("---------------------------");
            }
            pw.close();
            System.out.println(" Da ghi danh sach san pham ra file text: " + tenFile);
        } catch (IOException e) {
            System.out.println(" Loi ghi file text: " + e.getMessage());
        }
    }

    // 9. Đọc file text
    public void docFileText(String tenFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String line;
            System.out.println("\n===== NOI DUNG FILE " + tenFile + " =====");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(" Loi doc file text: " + e.getMessage());
        }
    }
    // 10. Sửa sản phẩm
public void suaTheoMa(String ma) {
    for (Sanpham sp : danhSachSP) {
        if (sp.Masp.equalsIgnoreCase(ma)) {
            System.out.print("Nhap don gia moi: ");
            double dg = new Scanner(System.in).nextDouble();
            sp.Dongia = dg;
            System.out.println("Da cap nhat san pham co ma: " + ma);
            return;
        }
    }
    System.out.println("Khong tim thay san pham co ma: " + ma);
}
    // 11. Thống kê giá cao nhất
public void thongKeGiaCaoNhat() {
    if (danhSachSP.isEmpty()) {
        System.out.println("Danh sach trong!");
        return;
    }

    double maxGia = danhSachSP.get(0).TinhGia();
    for (Sanpham sp : danhSachSP)
        if (sp.TinhGia() > maxGia)
            maxGia = sp.TinhGia();

    System.out.println("\n===== SAN PHAM CO GIA CAO NHAT =====");
    for (Sanpham sp : danhSachSP)
        if (Math.abs(sp.TinhGia() - maxGia) < 1e-6)
            sp.xuat();
}
// 12. Lọc theo loại
public void locTheoLoai(String loai) {
    boolean found = false;
    System.out.println("\n===== LOC SAN PHAM THEO LOAI: " + loai.toUpperCase() + " =====");
    for (Sanpham sp : danhSachSP) {
        if (loai.equalsIgnoreCase("monan") && sp instanceof Monan
         || loai.equalsIgnoreCase("thucuong") && sp instanceof ThucUong
         || loai.equalsIgnoreCase("combo") && sp instanceof Combo) {
            sp.xuat();
            found = true;
        }
    }
    if (!found)
        System.out.println("Khong tim thay san pham thuoc loai: " + loai);
}
//13. Thống kê tồn kho thấp
public void thongKeTonKhoThap(int nguong) {
    System.out.println("\n===== SAN PHAM CO TON KHO <= " + nguong + " =====");
    boolean found = false;
    for (Sanpham sp : danhSachSP) {
        if (sp.Soluongtonkho <= nguong) {
            sp.xuat();
            found = true;
        }
    }
    if (!found)
        System.out.println("Tat ca san pham deu con nhieu hang trong kho!");
}
public Sanpham timTheoMasp(String maSP) {
    for (Sanpham sp : danhSachSP) {  
        if (sp.getMasp().equalsIgnoreCase(maSP)) {
            return sp;
        }
    }
    return null; 
}
public ArrayList<Sanpham> getDanhSach() {
    return danhSachSP;
}

}
