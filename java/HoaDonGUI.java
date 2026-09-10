import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class HoaDonGUI extends JFrame {
    private ArrayList<HoaDon> dsHD = new ArrayList<>();
    private DefaultTableModel model;
    private JTable table;

    // ✅ THÊM 2 DÒNG NÀY
    private ListNhanVien listNV = new ListNhanVien();
    private ListSanPham listSP = new ListSanPham();
    private NhanVienGUI NVGui = new NhanVienGUI();

    public HoaDonGUI() {
        setTitle("🧾 Quản lý Hóa đơn");
        setSize(950, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel lbl = new JLabel("DANH SÁCH HÓA ĐƠN", SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbl.setForeground(new Color(90, 50, 140));
        add(lbl, BorderLayout.NORTH);

        String[] cols = { "Mã HĐ", "Ngày lập", "PTTT", "Khách hàng", "Nhân viên", "Tổng tiền", "Ghi chú" };
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnThem = new JButton("➕ Thêm");
        JButton btnXem = new JButton("🔍 Xem chi tiết");
        JButton btnXoa = new JButton("🗑️ Xóa");
        JButton btnDong = new JButton("❌ Đóng");
        panelBtn.add(btnThem);
        panelBtn.add(btnXem);
        panelBtn.add(btnXoa);
        panelBtn.add(btnDong);
        add(panelBtn, BorderLayout.SOUTH);

        btnThem.addActionListener(e -> themHoaDon());
        btnDong.addActionListener(e -> dispose());
        btnXem.addActionListener(e -> xemChiTiet());
        btnXoa.addActionListener(e -> xoaHoaDon());

        setVisible(true);
    }

    // ======= Thêm hóa đơn mới =======
    private void themHoaDon() {
        // ===== Khởi tạo danh sách nhân viên và sản phẩm mẫu =====
        listSP.nhapDanhSachBanDau();
        listNV.napDanhSachMacDinh();
        // ===== 1. Nhập thông tin hóa đơn =====
        JTextField txtMaHD = new JTextField("HD" + HoaDon.demHD++);
        JTextField txtNgay = new JTextField();
        String[] ptttList = { "Tiền mặt", "Chuyển khoản", "Ví điện tử" };
        JComboBox<String> cbPTTT = new JComboBox<>(ptttList);
        JTextField txtGhiChu = new JTextField();

        Object[] f1 = {
                "Mã hóa đơn:", txtMaHD,
                "Ngày lập (dd/MM/yyyy):", txtNgay,
                "Phương thức thanh toán:", cbPTTT,
                "Ghi chú:", txtGhiChu
        };
        int opt = JOptionPane.showConfirmDialog(this, f1, "📄 Thông tin hóa đơn", JOptionPane.OK_CANCEL_OPTION);
        if (opt != JOptionPane.OK_OPTION)
            return;

        // ===== 2. Nhập thông tin khách hàng =====
        JTextField txtTenKH = new JTextField();
        JTextField txtMaKH = new JTextField("KH" + KhachHang.demKH++);
        JTextField txtDiem = new JTextField("0");
        Object[] fKH = { "Tên KH:", txtTenKH, "Mã KH:", txtMaKH, "Điểm tích lũy:", txtDiem };
        JOptionPane.showConfirmDialog(this, fKH, "👤 Thông tin khách hàng", JOptionPane.OK_OPTION);

        KhachHang kh = new KhachHang(
                txtTenKH.getText(), 2000, "HCM", true, "090", txtMaKH.getText(),
                Integer.parseInt(txtDiem.getText()));

        // ===== 3. Nhập mã nhân viên → tự hiện thông tin =====
        JTextField txtMaNV = new JTextField();
        JTextField txtTenNV = new JTextField();
        txtTenNV.setEditable(false);

        Object[] fNV = { "Mã NV:", txtMaNV, "Tên NV:", txtTenNV };

        // Khi gõ mã nhân viên → tự cập nhật
        txtMaNV.addCaretListener(e -> {
            Nhanvien nv = listNV.timTheoManv(txtMaNV.getText());
            if (nv != null)
                txtTenNV.setText(nv.Hoten);
            else
                txtTenNV.setText("");
        });

        int okNV = JOptionPane.showConfirmDialog(this, fNV, "👔 Nhân viên xử lý", JOptionPane.OK_CANCEL_OPTION);
        if (okNV != JOptionPane.OK_OPTION)
            return;

        Nhanvien nhanvien = listNV.timTheoManv(txtMaNV.getText());
        if (nhanvien == null) {
            JOptionPane.showMessageDialog(this, "⚠️ Không tìm thấy nhân viên này!");
            return;
        }

        // ===== 4. Tạo đơn hàng =====
        DonHang dh = new DonHang("DH" + DonHang.demDH++, kh, nhanvien, txtNgay.getText(), "Đã thanh toán");

        // ===== 5. Nhập chi tiết sản phẩm =====
        while (true) {
            JTextField txtMaSP = new JTextField();
            JTextField txtTenSP = new JTextField();
            JTextField txtGia = new JTextField();
            JTextField txtSL = new JTextField();
            txtTenSP.setEditable(false);
            txtGia.setEditable(false);

            Object[] fSP = {
                    "Mã sản phẩm:", txtMaSP,
                    "Tên sản phẩm:", txtTenSP,
                    "Giá:", txtGia,
                    "Số lượng:", txtSL
            };

            // Khi gõ mã SP → tự cập nhật
            txtMaSP.addCaretListener(e -> {
                Sanpham sp = listSP.timTheoMasp(txtMaSP.getText());
                if (sp != null) {
                    txtTenSP.setText(sp.getTensp());
                    txtGia.setText(String.valueOf(sp.TinhGia()));
                } else {
                    txtTenSP.setText("");
                    txtGia.setText("");
                }
            });

            int chon = JOptionPane.showConfirmDialog(this, fSP, "🥤 Nhập chi tiết sản phẩm",
                    JOptionPane.OK_CANCEL_OPTION);
            if (chon != JOptionPane.OK_OPTION)
                break;

            Sanpham sp = listSP.timTheoMasp(txtMaSP.getText());
            if (sp == null) {
                JOptionPane.showMessageDialog(this, "⚠️ Không tìm thấy sản phẩm này!");
                continue;
            }

            int soLuong = Integer.parseInt(txtSL.getText());
            ChitietHD ct = new ChitietHD(sp, soLuong);
            dh.themChiTiet(ct);

            int tiep = JOptionPane.showConfirmDialog(this, "Thêm sản phẩm khác?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (tiep != JOptionPane.YES_OPTION)
                break;
        }

        // ===== 6. Tạo hóa đơn và thêm vào danh sách =====
        HoaDon hd = new HoaDon(
                txtMaHD.getText(),
                dh,
                txtNgay.getText(),
                cbPTTT.getSelectedItem().toString(),
                txtGhiChu.getText());
        dsHD.add(hd);
        napBang();
        JOptionPane.showMessageDialog(this, "✅ Đã thêm hóa đơn thành công!");
    }

    // ======= Cập nhật bảng =======
    private void napBang() {
        model.setRowCount(0);
        for (HoaDon hd : dsHD) {
            DonHang dh = hd.getDonHang();
            double tong = (dh != null) ? dh.Tinhtongtien() : 0;
            model.addRow(new Object[] {
                    hd.getMaHD(), hd.getNgaylap(), hd.getPTTT(),
                    dh != null ? dh.getKhachhang().getMakh() : "?",
                    dh != null ? dh.getNhanvien().getManv() : "?",
                    String.format("%.0f", tong), hd.getGhichu()
            });
        }
    }

    // ======= Xem chi tiết hóa đơn =======
    private void xemChiTiet() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Chọn hóa đơn cần xem chi tiết!");
            return;
        }
        HoaDon hd = dsHD.get(row);
        new ChiTietHoaDonDialog(this, hd).setVisible(true);
    }

    // ======= Xóa hóa đơn =======
    private void xoaHoaDon() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Chọn hóa đơn cần xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa hóa đơn này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dsHD.remove(row);
            napBang();
            JOptionPane.showMessageDialog(this, "🗑️ Đã xóa hóa đơn thành công!");
        }
    }

}
