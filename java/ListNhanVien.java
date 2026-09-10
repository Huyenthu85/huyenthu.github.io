import java.io.*;
import java.util.*;

public class ListNhanVien {
    private ArrayList<Nhanvien> danhSachNV = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 1. Nhập danh sách ban đầu
    public void nhapDanhSachBanDau() {
        System.out.print("Nhap so luong nhan vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin nhan vien thu " + (i + 1) + ":");
            System.out.println("1. Quan ly");
            System.out.println("2. Nhan vien ban hang");
            System.out.println("3. Nhan vien pha che");
            System.out.println("4. Nhan vien phu bep");
            System.out.print("Chon loai nhan vien: ");
            int loai = sc.nextInt();
            sc.nextLine();

            Nhanvien nv = null; // Khai báo đối tượng Nhanvien
            switch (loai) {
                case 1:
                    nv = new Quanly("Thu", 1998, "Dak Nong", false, "0909", "QL01", 2020, 250, "Quan ly", 28);
                    break;
                case 2:
                    nv = new Nhanvienbanhang("Nguyen", 2000, "TPHCM", false, "0987", "NV02", 2021, 200, 85000);
                    break;
                case 3:
                    nv = new Nhanvienphache("Tuyen", 2001, "TPHCM", false, "0911", "NV03", 2022, 180, 3, 60000);
                    break;
                case 4:
                    nv = new Nhanvienphubep("Phu", 1999, "TPHCM", true, "0933", "NV04", 2020, 220, 2);
                    break;
            }
            danhSachNV.add(nv);
        }
    }

    // 2. Xuất danh sách
    public void xuatDanhSach() {
        if (danhSachNV.isEmpty()) {
            System.out.println("Danh sach nhan vien trong!");
            return;
        }
        System.out.println("\n===== DANH SACH NHAN VIEN =====");
        for (Nhanvien nv : danhSachNV) {
            nv.xuat();
            System.out.println("-------------------------");
        }
    }

    // 3. Thêm nhân viên mới
    public void themNhanVien(Nhanvien nv) {
        danhSachNV.add(nv);
        System.out.println("Da them nhan vien moi!");
    }

    // 4. Sửa theo mã
    public void suaTheoMa(String ma) {
        for (Nhanvien nv : danhSachNV) {
            if (nv.Manv.equalsIgnoreCase(ma)) {
                System.out.print("Nhap so gio lam moi: ");
                nv.Sogiolam = sc.nextInt();
                System.out.println("Da cap nhat thong tin nhan vien!");
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma: " + ma);
    }

    // 5. Xoá theo mã
    public void xoaTheoMa(String ma) {
        Iterator<Nhanvien> it = danhSachNV.iterator(); // Duyệt qua từng phần tử trong sách
        while (it.hasNext()) { // Kiểm tra còn phần tử nào chưa được duyệt
            Nhanvien nv = it.next(); // Trả về phần tử theo danh sách
            if (nv.Manv.equalsIgnoreCase(ma)) {
                it.remove();
                System.out.println("Da xoa nhan vien co ma: " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma: " + ma);
    }

    // 6. Tìm kiếm gần đúng theo họ tên
    public void timGanDung(String keyword) {
        boolean found = false;
        for (Nhanvien nv : danhSachNV) {
            if (nv.Hoten.toLowerCase().contains(keyword.toLowerCase())) {
                nv.xuat();
                found = true;
            }
        }
        if (!found)
            System.out.println("Khong tim thay nhan vien nao chua tu khoa: " + keyword);
    }

    // 7. Thống kê theo loại nhân viên
    public void thongKeTheoLoai() {
        int ql = 0, bh = 0, pc = 0, pb = 0;
        for (Nhanvien nv : danhSachNV) {
            if (nv instanceof Quanly)
                ql++; // instanceof kiểm tra kiểu đối tượng
            else if (nv instanceof Nhanvienbanhang)
                bh++;
            else if (nv instanceof Nhanvienphache)
                pc++;
            else if (nv instanceof Nhanvienphubep)
                pb++;

        }
        System.out.println("\n===== THONG KE THEO LOAI NHAN VIEN =====");
        System.out.println("Quan ly: " + ql);
        System.out.println("Ban hang: " + bh);
        System.out.println("Pha che: " + pc);
        System.out.println("Phu bep: " + pb);
    }

    // 8. Thống kê lương trung bình
    public void thongKeLuongTB() {
        double tong = 0;
        int dem = 0;
        for (Nhanvien nv : danhSachNV) {
            if (nv instanceof Luong) {
                tong += ((Luong) nv).luong();
                dem++;
            }
        }
        if (dem > 0)
            System.out.println("Luong trung binh: " + (tong / dem));
        else
            System.out.println("Khong co nhan vien de thong ke!");
    }

    // 9. Ghi file text
    public void ghiFileText(String tenFile) {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(tenFile), "UTF-8"));

            for (Nhanvien nv : danhSachNV) {
                pw.println("Ma NV: " + nv.Manv);
                pw.println("Ho ten: " + nv.Hoten);
                pw.println("Nam sinh: " + nv.Ns);
                pw.println("Dia chi: " + nv.Diachi);
                pw.println("So gio lam: " + nv.Sogiolam);
                pw.println("Loai: " + nv.getClass().getSimpleName());
                if (nv instanceof Luong)
                    pw.println("Luong: " + ((Luong) nv).luong());
                pw.println("---------------------------");
            }
            pw.close();
            System.out.println("Da ghi danh sach nhan vien ra file: " + tenFile);
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // 10. Đọc file text
    public void docFileText(String tenFile) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(tenFile), "UTF-8"));
            String line;
            System.out.println("\n===== NOI DUNG FILE " + tenFile + " =====");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Tìm nhân viên
    public Nhanvien timTheoManv(String maNV) {
        for (Nhanvien nv : danhSachNV) {
            if (nv.getManv().equalsIgnoreCase(maNV)) {
                return nv;
            }
        }
        return null;
    }

    public void napDanhSachMacDinh() {
        danhSachNV.clear();
         danhSachNV.add(new Quanly("Luu Huyen Thu", 1995, "Dak Nong", false, "0906667777","QL01", 2018, 190, "Quản lý ca", 25 ));
        danhSachNV.add(new Nhanvienbanhang("Tran Thao Nguyen", 1999, "TP.HCM", true, "0901234567", "NV01", 2020, 180,50000000));
        danhSachNV.add(new Nhanvienphubep("Nguyen Thien Phu", 2000, "TP.HCM", true, "0902223333", "NV02", 2021, 160, 3));
        danhSachNV.add(new Nhanvienphache("Huynh Thi My Tuyen", 1998, "TP.HCM", false, "0904445555","NV03", 2019, 210, 2, 3500 ));
    }

    public ArrayList<Nhanvien> getDanhSachNV() {
        return danhSachNV;
    }
}
