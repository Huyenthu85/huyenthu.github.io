import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNhanVien dsNV = new ListNhanVien();
        ListSanPham dsSP = new ListSanPham();

        int chon;
        do {
            System.out.println("\n========== MENU CHINH ==========");
            System.out.println("1. Quan ly nhan vien");
            System.out.println("2. Quan ly san pham");
            System.out.println("3. Tao hoa don va xuat hoa don");
            System.out.println("0. Thoat chuong trinh");
            System.out.print(">> Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    menuNhanVien(dsNV, sc);
                    break;
                case 2:
                    menuSanPham(dsSP, sc);
                    break;
                case 3:
                    taoHoaDon(dsNV, dsSP, sc);
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ==================== MENU NHAN VIEN ====================
    private static void menuNhanVien(ListNhanVien dsNV, Scanner sc) {
        int chon;
        do {
            System.out.println("\n===== MENU QUAN LY NHAN VIEN =====");
            System.out.println("1. Nhap danh sach nhan vien (nhap tu ban phim)");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Them 1 nhan vien moi");
            System.out.println("4. Sua theo ma");
            System.out.println("5. Xoa theo ma");
            System.out.println("6. Tim gan dung theo ten");
            System.out.println("7. Thong ke theo loai");
            System.out.println("8. Thong ke luong trung binh");
            System.out.println("9. Ghi ra file nhanvien.txt");
            System.out.println("10. Doc file nhanvien.txt");
            System.out.println("0. Quay lai menu chinh");
            System.out.print(">> Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                // ===== 1. NHẬP DANH SÁCH NHÂN VIÊN TỪ BÀN PHÍM =====
                case 1 -> dsNV.nhapDanhSachBanDau();
                // ===== 2. XUẤT DANH SÁCH =====
                case 2 -> dsNV.xuatDanhSach();

                // ===== 3. THÊM 1 NHÂN VIÊN MỚI =====
                case 3 -> {
                    Nhanvien nv = nhapNhanVienTuBanPhim(sc);
                    if (nv != null) {
                        dsNV.themNhanVien(nv);
                        System.out.println(">> Da them nhan vien moi!");
                    }
                }

                // ===== 4. SỬA =====
                case 4 -> {
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String maSua = sc.nextLine();
                    dsNV.suaTheoMa(maSua);
                }

                // ===== 5. XÓA =====
                case 5 -> {
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maXoa = sc.nextLine();
                    dsNV.xoaTheoMa(maXoa);
                }

                // ===== 6. TÌM GẦN ĐÚNG =====
                case 6 -> {
                    System.out.print("Nhap tu khoa can tim: ");
                    String kw = sc.nextLine();
                    dsNV.timGanDung(kw);
                }

                // ===== 7. THỐNG KÊ =====
                case 7 -> dsNV.thongKeTheoLoai();
                case 8 -> dsNV.thongKeLuongTB();

                // ===== 9. GHI FILE =====
                case 9 -> dsNV.ghiFileText("nhanvien.txt");

                // ===== 10. ĐỌC FILE =====
                case 10 -> dsNV.docFileText("nhanvien.txt");

                case 0 -> System.out.println("Quay lai menu chinh...");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ==================== HÀM HỖ TRỢ NHẬP NHÂN VIÊN ====================
    private static Nhanvien nhapNhanVienTuBanPhim(Scanner sc) {
        System.out.println("1. Quan ly");
        System.out.println("2. Nhan vien ban hang");
        System.out.println("3. Nhan vien pha che");
        System.out.println("4. Nhan vien phu bep");
        System.out.print("Chon loai nhan vien: ");
        int loai = sc.nextInt();
        sc.nextLine();

        System.out.print("Ho ten: ");
        String hoten = sc.nextLine();
        System.out.print("Nam sinh: ");
        int ns = sc.nextInt();
        sc.nextLine();
        System.out.print("Dia chi: ");
        String diachi = sc.nextLine();
        System.out.print("Gioi tinh (nam=true, nu=false): ");
        boolean gt = sc.nextBoolean();
        sc.nextLine();
        System.out.print("So dien thoai: ");
        String sdt = sc.nextLine();
        System.out.print("Ma nhan vien: ");
        String manv = sc.nextLine();
        System.out.print("Nam vao lam: ");
        int nvl = sc.nextInt();
        System.out.print("So gio lam: ");
        int sogiolam = sc.nextInt();
        sc.nextLine();

        Nhanvien nv = null;

        switch (loai) {
            case 1 -> {
                System.out.print("Chuc vu: ");
                String chucvu = sc.nextLine();
                System.out.print("So ngay lam: ");
                int snl = sc.nextInt();
                nv = new Quanly(hoten, ns, diachi, gt, sdt, manv, nvl, sogiolam, chucvu, snl);
            }
            case 2 -> {
                System.out.print("Doanh so: ");
                double doanhso = sc.nextDouble();
                nv = new Nhanvienbanhang(hoten, ns, diachi, gt, sdt, manv, nvl, sogiolam, doanhso);
            }
            case 3 -> {
                System.out.print("So ngay nghi: ");
                int snn = sc.nextInt();
                System.out.print("So luong ly pha che: ");
                double sluong = sc.nextDouble();
                nv = new Nhanvienphache(hoten, ns, diachi, gt, sdt, manv, nvl, sogiolam, snn, sluong);
            }
            case 4 -> {
                System.out.print("So ngay nghi: ");
                int snn = sc.nextInt();
                nv = new Nhanvienphubep(hoten, ns, diachi, gt, sdt, manv, nvl, sogiolam, snn);
            }
            default -> System.out.println("Loai nhan vien khong hop le!");
        }

        return nv;
    }

    // ==================== MENU SAN PHAM ====================
    private static void menuSanPham(ListSanPham dsSP, Scanner sc) {
        int chon;
        do {
            System.out.println("\n===== MENU QUAN LY SAN PHAM =====");
            System.out.println("1. Nhap danh sach mau ban dau");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Them / Xoa / Sua san pham");
            System.out.println("4. Tim kiem san pham theo ten gan dung");
            System.out.println("5. Thong ke theo loai");
            System.out.println("6. Thong ke tong gia tri ton kho");
            System.out.println("7. Ghi ra file sanpham.txt");
            System.out.println("8. Doc file sanpham.txt");
            System.out.println("9. Thong ke san pham gia cao nhat");
            System.out.println("10. Loc san pham theo loai");
            System.out.println("11. Thong ke ton kho thap");
            System.out.println("0. Quay lai menu chinh");
            System.out.print(">> Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsSP.nhapDanhSachBanDau();
                case 2 -> dsSP.xuatDanhSach();
                case 3 -> {
                    System.out.println("\n=== CHUC NANG THEM / SUA SAN PHAM ===");
                    System.out.println("1. Them san pham moi");
                    System.out.println("2. Sua san pham theo ma");
                    System.out.println("3. Xoa san pham theo ma");
                    System.out.print(">> Chon: ");
                    int ch = sc.nextInt();
                    sc.nextLine();

                    switch (ch) {
                        case 1 -> { // ===== THEM SAN PHAM =====
                            System.out.println("\n--- THEM SAN PHAM MOI ---");
                            System.out.println("1. Mon an");
                            System.out.println("2. Thuc uong");
                            System.out.println("3. Combo");
                            System.out.print("Chon loai san pham: ");
                            int loai = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Ma SP: ");
                            String masp = sc.nextLine();
                            System.out.print("Ten SP: ");
                            String tensp = sc.nextLine();
                            System.out.print("Don gia: ");
                            double dongia = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Don vi tinh: ");
                            String dvt = sc.nextLine();
                            System.out.print("So luong ton kho: ");
                            int sltk = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Trang thai (Dang ban / Het hang): ");
                            String trangthai = sc.nextLine();

                            Sanpham sp = null;
                            if (loai == 1) {
                                System.out.print("Phi phu nau: ");
                                int phi = sc.nextInt();
                                sc.nextLine();
                                sp = new Monan(masp, tensp, dongia, dvt, sltk, trangthai, phi);
                            } else if (loai == 2) {
                                System.out.print("Gia topping: ");
                                double gt = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Ghi chu: ");
                                String note = sc.nextLine();
                                sp = new ThucUong(masp, tensp, dongia, dvt, sltk, trangthai, gt, note);
                            } else if (loai == 3) {
                                System.out.print("Giam gia combo: ");
                                double giam = sc.nextDouble();
                                sc.nextLine();
                                sp = new Combo(masp, tensp, dongia, dvt, sltk, trangthai);
                            }

                            if (sp != null) {
                                dsSP.themSanPham(sp);
                                System.out.println(">> Da them san pham moi thanh cong!");
                            }
                        }

                        case 2 -> { // ===== SUA SAN PHAM =====
                            System.out.print("\nNhap ma san pham can sua: ");
                            String maSua = sc.nextLine();

                            System.out.println("1. Sua don gia");
                            System.out.println("2. Sua so luong ton kho");
                            System.out.println("3. Sua trang thai");
                            System.out.print("Chon muc can sua: ");
                            int muc = sc.nextInt();
                            sc.nextLine();

                            dsSP.suaTheoMa(maSua, muc, sc);
                        }

                        case 3 -> { // ===== XOA =====
                            System.out.print("Nhap ma san pham can xoa: ");
                            String ma = sc.nextLine();
                            dsSP.xoaTheoMa(ma);
                        }

                        default -> System.out.println("Lua chon khong hop le!");
                    }
                }
                case 4 -> {
                    System.out.print("Nhap ten gan dung can tim: ");
                    String kw = sc.nextLine();
                    dsSP.timGanDung(kw);
                }
                case 5 -> dsSP.thongKeTheoLoai();
                case 6 -> dsSP.thongKeGiaTriTonKho();
                case 7 -> dsSP.ghiFileText("sanpham.txt");
                case 8 -> dsSP.docFileText("sanpham.txt");
                case 9 -> dsSP.thongKeGiaCaoNhat();
                case 10 -> {
                    System.out.print("Nhap loai (monan / thucuong / combo): ");
                    String loai = sc.nextLine();
                    dsSP.locTheoLoai(loai);
                }
                case 11 -> {
                    System.out.print("Nhap nguong ton kho: ");
                    int nguong = sc.nextInt();
                    dsSP.thongKeTonKhoThap(nguong);
                }
                case 0 -> System.out.println("Quay lai menu chinh...");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ==================== TAO HOA DON ====================
    private static void taoHoaDon(ListNhanVien dsNV, ListSanPham dsSP, Scanner sc) {
        System.out.println("\n===== TAO HOA DON =====");

        // ===== NHAP KHACH HANG =====
        System.out.println("\n--- NHAP THONG TIN KHACH HANG ---");
        System.out.print("Ho ten: ");
        String tenKH = sc.nextLine();
        System.out.print("Nam sinh: ");
        int nsKH = sc.nextInt();
        sc.nextLine();
        System.out.print("Dia chi: ");
        String diachiKH = sc.nextLine();
        System.out.print("Gioi tinh (nam=true, nu=false): ");
        boolean gtKH = sc.nextBoolean();
        sc.nextLine();
        System.out.print("So dien thoai: ");
        String sdtKH = sc.nextLine();
        String maKH = "KH" + String.format("%03d", KhachHang.demKH++);
        System.out.println("Ma khach hang: " + maKH);

        System.out.print("Diem tich luy hien co: ");
        int diem = sc.nextInt();
        sc.nextLine();

        KhachHang kh = new KhachHang(tenKH, nsKH, diachiKH, gtKH, sdtKH, maKH, diem);

        // ===== NHAP NHAN VIEN BAN HANG =====
        System.out.println("\n--- CHON NHAN VIEN XU LY HOA DON ---");
        System.out.print("Nhap ma nhan vien: ");
        String maNV = sc.nextLine();

        // Tim nhan vien theo ma
        Nhanvien nv = dsNV.timTheoManv(maNV);
        if (nv == null) {
            System.out.println(" Khong tim thay nhan vien co ma: " + maNV);
            System.out.println("Moi nhap thong tin moi:");
            nv = nhapNhanVienTuBanPhim(sc);
            dsNV.themNhanVien(nv);
        } else {
            System.out.println(" Da tim thay nhan vien:");
            nv.xuat();
        }

        // ===== NHAP DANH SACH SAN PHAM TRONG HOA DON =====
        System.out.println("\n--- NHAP CAC SAN PHAM TRONG HOA DON ---");
        ArrayList<ChitietHD> dsChiTiet = new ArrayList<>();

        System.out.print("Nhap so luong san pham trong hoa don: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nSan pham thu " + (i + 1) + ":");
            System.out.println("1. Mon an");
            System.out.println("2. Thuc uong");
            System.out.println("3. Combo");
            System.out.print("Chon loai san pham: ");
            int loai = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhap ma san pham: ");
            String maSP = sc.nextLine();

            // Tìm sản phẩm theo mã trong danh sách
            Sanpham sp = dsSP.timTheoMasp(maSP);

            if (sp == null) {
                System.out.println(" Khong tim thay san pham co ma " + maSP);
                System.out.println(">> Moi nhap thong tin san pham moi:");
                // Cho nhập thủ công như trước
                System.out.print("Ten SP: ");
                String tensp = sc.nextLine();
                System.out.print("Don gia: ");
                double dongia = sc.nextDouble();
                sc.nextLine();
                System.out.print("Don vi tinh: ");
                String dvt = sc.nextLine();
                System.out.print("So luong ton kho: ");
                int sltk = sc.nextInt();
                sc.nextLine();
                System.out.print("Trang thai (Dang ban / Het hang): ");
                String tt = sc.nextLine();
                System.out.println("Chon loai san pham:");
                System.out.println("1. Mon an");
                System.out.println("2. Thuc uong");
                System.out.println("3. Combo");
                System.out.print(">> Chon: ");
                int loaisp = sc.nextInt();
                sc.nextLine();

                if (loai == 1) {
                    System.out.print("Phi phu nau: ");
                    int phi = sc.nextInt();
                    sc.nextLine();
                    sp = new Monan(maSP, tensp, dongia, dvt, sltk, tt, phi);
                } else if (loai == 2) {
                    System.out.print("Gia topping: ");
                    double gt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ghi chu: ");
                    String note = sc.nextLine();
                    sp = new ThucUong(maSP, tensp, dongia, dvt, sltk, tt, gt, note);
                } else if (loai == 3) {
                    System.out.print("Giam gia combo: ");
                    double giam = sc.nextDouble();
                    sc.nextLine();
                    sp = new Combo(maSP, tensp, dongia, dvt, sltk, tt);
                } else {
                    System.out.println("Loai san pham khong hop le!");
                }

                dsSP.themSanPham(sp);
            } else {
                System.out.println(" Da tim thay san pham:");
                sp.xuat();
            }

            System.out.print("So luong mua: ");
            int slMua = sc.nextInt();
            sc.nextLine();

            dsChiTiet.add(new ChitietHD(sp, slMua));
        }

        // ===== NHAP THONG TIN HOA DON =====
        System.out.println("\n--- THONG TIN HOA DON ---");

        // Tự động tạo mã hóa đơn & mã đơn hàng
        String maHD = "HD" + String.format("%03d", HoaDon.demHD++);
        String maDH = "DH" + String.format("%03d", DonHang.demDH++);

        System.out.println(">> Ma hoa don tu dong: " + maHD);
        System.out.println(">> Ma don hang tu dong: " + maDH);

        System.out.print("Ngay lap: ");
        String ngayLap = sc.nextLine();
        System.out.print("Phuong thuc thanh toan: ");
        String pttt = sc.nextLine();
        System.out.print("Trang thai don hang: ");
        String ttDH = sc.nextLine();
        System.out.print("Ghi chu: ");
        String ghichu = sc.nextLine();

        // ===== TAO DON HANG + HOA DON =====
        DonHang dh = new DonHang(maDH, kh, nv, ngayLap, ttDH);
        for (ChitietHD ct : dsChiTiet)
            dh.themChiTiet(ct);

        HoaDon hd = new HoaDon(maHD, dh, ngayLap, pttt, ghichu);
        System.out.println("\n===== HOA DON CHI TIET =====");
        hd.xuat();

        System.out.println("\n--- DANH SACH SAN PHAM DA MUA ---");
        for (ChitietHD ct : dsChiTiet) {
            Sanpham spMua = ct.getSanPham();
            System.out.printf("Ma SP: %-8s | Ten SP: %-20s | So luong: %-3d | Don gia: %-10.2f | Thanh tien: %-10.2f\n",
                    spMua.getMasp(), spMua.getTensp(), ct.getSoLuong(), spMua.getDongia(), ct.ThanhTien());
        
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Tong tien: %.2f VND\n", dh.Tinhtongtien());

        // Cap nhat diem tich luy khach hang
        dh.capNhatDiemTichLuy();
    }
}}
