import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class SanPhamGUI extends JFrame {
    private ListSanPham dsSP = new ListSanPham();
    private DefaultTableModel model;
    private JTable table;

    public SanPhamGUI() {
        dsSP.nhapDanhSachBanDau();

        setTitle("📦 Quản lý sản phẩm");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ===== Tiêu đề =====
        JLabel lbl = new JLabel("📋 DANH SÁCH SẢN PHẨM", SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbl.setForeground(new Color(40, 60, 120));
        add(lbl, BorderLayout.NORTH);

        // ===== Bảng sản phẩm =====
        String[] cols = {"Mã SP", "Tên SP", "Đơn giá", "Đơn vị", "Tồn kho", "Trạng thái"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        napDuLieuVaoBang();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== Panel chứa nút =====
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnThem = new JButton("➕ Thêm");
        JButton btnSua = new JButton("✏️ Sửa");
        JButton btnXoa = new JButton("🗑️ Xóa");
        JButton btnDong = new JButton("❌ Đóng");

        panelBtn.add(btnThem);
        panelBtn.add(btnSua);
        panelBtn.add(btnXoa);
        panelBtn.add(btnDong);
        add(panelBtn, BorderLayout.SOUTH);

        // ===== Sự kiện =====
        btnThem.addActionListener(e -> themSanPham());
        btnSua.addActionListener(e -> suaSanPham());
        btnXoa.addActionListener(e -> xoaSanPham());
        btnDong.addActionListener(e -> dispose());

        setVisible(true);
    }

    // ===== Đổ dữ liệu vào bảng =====
    private void napDuLieuVaoBang() {
        model.setRowCount(0);
        for (Sanpham sp : dsSP.getDanhSach()) {
            model.addRow(new Object[]{
                sp.getMasp(),
                sp.Tensp,
                sp.Dongia,
                sp.Donvitinh,
                sp.Soluongtonkho,
                sp.trangthai
            });
        }
    }

    // ===== Thêm sản phẩm =====
    private void themSanPham() {
        JTextField txtMa = new JTextField();
        JTextField txtTen = new JTextField();
        JTextField txtGia = new JTextField();
        JTextField txtDVT = new JTextField();
        JTextField txtTon = new JTextField();
        JTextField txtTT = new JTextField();

        Object[] fields = {
            "Mã SP:", txtMa,
            "Tên SP:", txtTen,
            "Đơn giá:", txtGia,
            "Đơn vị tính:", txtDVT,
            "Tồn kho:", txtTon,
            "Trạng thái:", txtTT
        };

        int opt = JOptionPane.showConfirmDialog(this, fields, "➕ Thêm sản phẩm", JOptionPane.OK_CANCEL_OPTION);
        if (opt == JOptionPane.OK_OPTION) {
            try {
                Sanpham sp = new Monan(
                    txtMa.getText(),
                    txtTen.getText(),
                    Double.parseDouble(txtGia.getText()),
                    txtDVT.getText(),
                    Integer.parseInt(txtTon.getText()),
                    txtTT.getText(),
                    20000
                );
                dsSP.themSanPham(sp);
                napDuLieuVaoBang();
                JOptionPane.showMessageDialog(this, "✅ Đã thêm sản phẩm mới!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "⚠️ Lỗi nhập dữ liệu: " + ex.getMessage());
            }
        }
    }

    // ===== Sửa sản phẩm =====
    private void suaSanPham() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Chọn sản phẩm cần sửa!");
            return;
        }

        String ma = (String) model.getValueAt(row, 0);
        Sanpham sp = dsSP.timTheoMasp(ma);
        if (sp == null) return;

        JTextField txtTen = new JTextField(sp.Tensp);
        JTextField txtGia = new JTextField(String.valueOf(sp.Dongia));
        JTextField txtTon = new JTextField(String.valueOf(sp.Soluongtonkho));
        JTextField txtTT = new JTextField(sp.trangthai);

        Object[] fields = {
            "Tên SP:", txtTen,
            "Đơn giá:", txtGia,
            "Tồn kho:", txtTon,
            "Trạng thái:", txtTT
        };

        int opt = JOptionPane.showConfirmDialog(this, fields, "✏️ Sửa sản phẩm " + ma, JOptionPane.OK_CANCEL_OPTION);
        if (opt == JOptionPane.OK_OPTION) {
            try {
                sp.Tensp = txtTen.getText();
                sp.Dongia = Double.parseDouble(txtGia.getText());
                sp.Soluongtonkho = Integer.parseInt(txtTon.getText());
                sp.trangthai = txtTT.getText();
                napDuLieuVaoBang();
                JOptionPane.showMessageDialog(this, "✅ Cập nhật thành công!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "⚠️ Lỗi nhập dữ liệu!");
            }
        }
    }

    // ===== Xóa sản phẩm =====
    private void xoaSanPham() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Chọn sản phẩm cần xóa!");
            return;
        }
        String ma = (String) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Xóa sản phẩm " + ma + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dsSP.xoaTheoMa(ma);
            napDuLieuVaoBang();
            JOptionPane.showMessageDialog(this, "🗑️ Đã xóa sản phẩm!");
        }
    }
}
