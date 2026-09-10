import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NhanVienGUI extends JFrame {
    private ListNhanVien dsNV = new ListNhanVien();
    private DefaultTableModel model;
    private JTable table;

    public NhanVienGUI() {
        setTitle("👔 Quản lý Nhân viên");
        setSize(950, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel lbl = new JLabel("DANH SÁCH NHÂN VIÊN", SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbl.setForeground(new Color(40, 70, 120));
        add(lbl, BorderLayout.NORTH);

        String[] cols = {"Mã NV", "Họ tên", "Giới tính", "Năm vào làm", "Số giờ", "Loại", "Lương", "Thưởng", "Xếp loại"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnCapNhat = new JButton("🔄 Cập nhật danh sách");
        JButton btnThem = new JButton("➕ Thêm");
        JButton btnSua = new JButton("✏️ Sửa");
        JButton btnXoa = new JButton("🗑️ Xóa");
        JButton btnDong = new JButton("❌ Đóng");

        panelBtn.add(btnCapNhat);
        panelBtn.add(btnThem);
        panelBtn.add(btnSua);
        panelBtn.add(btnXoa);
        panelBtn.add(btnDong);
        add(panelBtn, BorderLayout.SOUTH);

        // ===== Sự kiện các nút =====
        btnCapNhat.addActionListener(e -> napDanhSachMacDinh());
        btnThem.addActionListener(e -> themNhanVien());
        btnSua.addActionListener(e -> suaNhanVien());
        btnXoa.addActionListener(e -> xoaNhanVien());
        btnDong.addActionListener(e -> dispose());

        setVisible(true);
    }

    // =========================================================
    // 🔹 HÀM NHẬP DANH SÁCH BAN ĐẦU BẰNG GIAO DIỆN
    // =========================================================
    public void napDanhSachMacDinh() {
        dsNV.getDanhSachNV().clear(); // Xóa dữ liệu cũ nếu có

        dsNV.themNhanVien(new Nhanvienbanhang(
                "Tran Thao Nguyen", 1999, "TP.HCM", true, "0901234567",
                "NV01", 2020, 180, 50000000 // doanh số
        ));

        dsNV.themNhanVien(new Nhanvienphubep(
                "Nguyen Thien Phu", 2000, "TP.HCM", true, "0902223333",
                "NV02", 2021, 160, 3 // số ngày nghỉ
        ));

        dsNV.themNhanVien(new Nhanvienphache(
                "Huynh Thi My Tuyen", 1998, "TP.HCM", false, "0904445555",
                "NV03", 2019, 210, 2, 3500 // 2 ngày nghỉ, 3500 ly
        ));

        dsNV.themNhanVien(new Quanly(
                "Luu Huyen Thu", 1995, "Dak Nong", false, "0906667777",
                "QL01", 2018, 190, "Quản lý ca", 25 // 25 ngày làm
        ));

        napDuLieuVaoBang();
        JOptionPane.showMessageDialog(this, "✅ Đã tải danh sách nhân viên mặc định của quán!");
    }

    // =========================================================
    // 🔹 NẠP DỮ LIỆU LÊN BẢNG
    // =========================================================
    private void napDuLieuVaoBang() {
        model.setRowCount(0);
        for (Nhanvien nv : dsNV.getDanhSachNV()) {
            String loai = nv.getClass().getSimpleName();
            double luong = (nv instanceof Luong) ? ((Luong) nv).luong() : nv.Tinhluong();
            model.addRow(new Object[]{
                nv.getManv(),
                nv.Hoten,
                nv.Gioitinh ? "Nam" : "Nữ",
                nv.Nvl,
                nv.Sogiolam,
                loai,
                String.format("%.0f", luong),
                String.format("%.0f", nv.Thuong()),
                nv.Xeploai()
            });
        }
    }

    // =========================================================
    // 🔹 THÊM NHÂN VIÊN MỚI
    // =========================================================
    private void themNhanVien() {
        String[] loaiNV = {"Nhanvienbanhang", "Nhanvienphubep", "Nhanvienphache", "Quanly"};
        String loai = (String) JOptionPane.showInputDialog(this, "Chọn loại nhân viên:", "Loại nhân viên",
                JOptionPane.QUESTION_MESSAGE, null, loaiNV, loaiNV[0]);
        if (loai == null) return;

        JTextField txtHoten = new JTextField();
        JTextField txtNS = new JTextField();
        JTextField txtDiachi = new JTextField();
        JTextField txtGioitinh = new JTextField();
        JTextField txtSDT = new JTextField();
        JTextField txtMa = new JTextField();
        JTextField txtNVL = new JTextField();
        JTextField txtGio = new JTextField();

        Object[] fields = {
            "Họ tên:", txtHoten,
            "Năm sinh:", txtNS,
            "Địa chỉ:", txtDiachi,
            "Giới tính (true=Nam, false=Nữ):", txtGioitinh,
            "SĐT:", txtSDT,
            "Mã NV:", txtMa,
            "Năm vào làm:", txtNVL,
            "Số giờ làm:", txtGio
        };

        Nhanvien nv = null;

        if (loai.equals("Nhanvienbanhang")) {
            JTextField txtDS = new JTextField();
            Object[] f = append(fields, new Object[]{"Doanh số:", txtDS});
            if (showConfirm("Thêm nhân viên bán hàng", f)) {
                nv = new Nhanvienbanhang(
                    txtHoten.getText(),
                    Integer.parseInt(txtNS.getText()),
                    txtDiachi.getText(),
                    Boolean.parseBoolean(txtGioitinh.getText()),
                    txtSDT.getText(),
                    txtMa.getText(),
                    Integer.parseInt(txtNVL.getText()),
                    Integer.parseInt(txtGio.getText()),
                    Double.parseDouble(txtDS.getText())
                );
            }
        } else if (loai.equals("Nhanvienphubep")) {
            JTextField txtSNN = new JTextField();
            Object[] f = append(fields, new Object[]{"Số ngày nghỉ:", txtSNN});
            if (showConfirm("Thêm nhân viên phụ bếp", f)) {
                nv = new Nhanvienphubep(
                    txtHoten.getText(),
                    Integer.parseInt(txtNS.getText()),
                    txtDiachi.getText(),
                    Boolean.parseBoolean(txtGioitinh.getText()),
                    txtSDT.getText(),
                    txtMa.getText(),
                    Integer.parseInt(txtNVL.getText()),
                    Integer.parseInt(txtGio.getText()),
                    Integer.parseInt(txtSNN.getText())
                );
            }
        } else if (loai.equals("Nhanvienphache")) {
            JTextField txtSNN = new JTextField();
            JTextField txtSLPC = new JTextField();
            Object[] f = append(fields, new Object[]{
                "Số ngày nghỉ:", txtSNN,
                "Số lượng ly pha chế:", txtSLPC
            });
            if (showConfirm("Thêm nhân viên pha chế", f)) {
                nv = new Nhanvienphache(
                    txtHoten.getText(),
                    Integer.parseInt(txtNS.getText()),
                    txtDiachi.getText(),
                    Boolean.parseBoolean(txtGioitinh.getText()),
                    txtSDT.getText(),
                    txtMa.getText(),
                    Integer.parseInt(txtNVL.getText()),
                    Integer.parseInt(txtGio.getText()),
                    Integer.parseInt(txtSNN.getText()),
                    Double.parseDouble(txtSLPC.getText())
                );
            }
        } else if (loai.equals("Quanly")) {
            JTextField txtChucvu = new JTextField();
            JTextField txtSNL = new JTextField();
            Object[] f = append(fields, new Object[]{"Chức vụ:", txtChucvu, "Số ngày làm:", txtSNL});
            if (showConfirm("Thêm quản lý", f)) {
                nv = new Quanly(
                    txtHoten.getText(),
                    Integer.parseInt(txtNS.getText()),
                    txtDiachi.getText(),
                    Boolean.parseBoolean(txtGioitinh.getText()),
                    txtSDT.getText(),
                    txtMa.getText(),
                    Integer.parseInt(txtNVL.getText()),
                    Integer.parseInt(txtGio.getText()),
                    txtChucvu.getText(),
                    Integer.parseInt(txtSNL.getText())
                );
            }
        }

        if (nv != null) {
            dsNV.themNhanVien(nv);
            if (nv instanceof Luong) ((Luong) nv).luong();
            nv.Thuong();
            nv.Xeploai();
            napDuLieuVaoBang();
            JOptionPane.showMessageDialog(this, "✅ Đã thêm nhân viên thành công!");
        }
    }

    private boolean showConfirm(String title, Object[] fields) {
        int opt = JOptionPane.showConfirmDialog(this, fields, title, JOptionPane.OK_CANCEL_OPTION);
        return opt == JOptionPane.OK_OPTION;
    }

    private Object[] append(Object[] base, Object[] extra) {
        Object[] result = new Object[base.length + extra.length];
        System.arraycopy(base, 0, result, 0, base.length);
        System.arraycopy(extra, 0, result, base.length, extra.length);
        return result;
    }

    // =========================================================
    // 🔹 SỬA NHÂN VIÊN
    // =========================================================
    private void suaNhanVien() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Chọn nhân viên cần sửa!");
            return;
        }

        String ma = (String) model.getValueAt(row, 0);
        Nhanvien nv = dsNV.timTheoManv(ma);
        if (nv == null) return;

        // ===== Tùy loại nhân viên =====
        if (nv instanceof Nhanvienbanhang) {
            Nhanvienbanhang bh = (Nhanvienbanhang) nv;
            JTextField txtTen = new JTextField(bh.Hoten);
            JTextField txtGio = new JTextField(String.valueOf(bh.Sogiolam));
            JTextField txtDS = new JTextField(String.valueOf(getPrivateField(bh, "Doanhso")));

            Object[] fields = {
                "Họ tên:", txtTen,
                "Số giờ làm:", txtGio,
                "Doanh số:", txtDS
            };

            if (showConfirm("✏️ Sửa nhân viên bán hàng", fields)) {
                bh.Hoten = txtTen.getText();
                bh.Sogiolam = Integer.parseInt(txtGio.getText());
                setPrivateField(bh, "Doanhso", Double.parseDouble(txtDS.getText()));
                bh.luong();
                bh.Thuong();
                bh.Xeploai();
                napDuLieuVaoBang();
            }
        } else if (nv instanceof Nhanvienphubep) {
            Nhanvienphubep pb = (Nhanvienphubep) nv;
            JTextField txtTen = new JTextField(pb.Hoten);
            JTextField txtGio = new JTextField(String.valueOf(pb.Sogiolam));
            JTextField txtSNN = new JTextField(String.valueOf(getPrivateField(pb, "Snn")));

            Object[] fields = {
                "Họ tên:", txtTen,
                "Số giờ làm:", txtGio,
                "Số ngày nghỉ:", txtSNN
            };

            if (showConfirm("✏️ Sửa nhân viên phụ bếp", fields)) {
                pb.Hoten = txtTen.getText();
                pb.Sogiolam = Integer.parseInt(txtGio.getText());
                setPrivateField(pb, "Snn", Integer.parseInt(txtSNN.getText()));
                pb.luong();
                pb.Thuong();
                pb.Xeploai();
                napDuLieuVaoBang();
            }
        } else if (nv instanceof Nhanvienphache) {
            Nhanvienphache pc = (Nhanvienphache) nv;
            JTextField txtTen  = new JTextField(pc.Hoten);
            JTextField txtGio  = new JTextField(String.valueOf(pc.Sogiolam));
            JTextField txtSNN  = new JTextField(String.valueOf(getPrivateField(pc, "Snn")));
            JTextField txtSLPC = new JTextField(String.valueOf(getPrivateField(pc, "Soluonglyphache")));

            Object[] fields = {
                "Họ tên:", txtTen,
                "Số giờ làm:", txtGio,
                "Số ngày nghỉ:", txtSNN,
                "Số lượng ly pha chế:", txtSLPC
            };

            if (showConfirm("✏️ Sửa nhân viên pha chế", fields)) {
                pc.Hoten     = txtTen.getText();
                pc.Sogiolam  = Integer.parseInt(txtGio.getText());
                setPrivateField(pc, "Snn", Integer.parseInt(txtSNN.getText()));
                setPrivateField(pc, "Soluonglyphache", Double.parseDouble(txtSLPC.getText()));
                pc.luong();
                pc.Thuong();
                pc.Xeploai();
                napDuLieuVaoBang();
            }
        } else if (nv instanceof Quanly) {
            Quanly ql = (Quanly) nv;
            JTextField txtTen = new JTextField(ql.Hoten);
            JTextField txtGio = new JTextField(String.valueOf(ql.Sogiolam));
            JTextField txtChucvu = new JTextField(getPrivateField(ql, "Chucvu").toString());
            JTextField txtSNL = new JTextField(String.valueOf(getPrivateField(ql, "Snl")));

            Object[] fields = {
                "Họ tên:", txtTen,
                "Số giờ làm:", txtGio,
                "Chức vụ:", txtChucvu,
                "Số ngày làm:", txtSNL
            };

            if (showConfirm("✏️ Sửa quản lý", fields)) {
                ql.Hoten = txtTen.getText();
                ql.Sogiolam = Integer.parseInt(txtGio.getText());
                setPrivateField(ql, "Chucvu", txtChucvu.getText());
                setPrivateField(ql, "Snl", Integer.parseInt(txtSNL.getText()));
                ql.luong();
                ql.Thuong();
                ql.Xeploai();
                napDuLieuVaoBang();
            }
        }
    }

    // =========================================================
    // 🔹 HỖ TRỢ TRUY CẬP BIẾN PRIVATE
    // =========================================================
    private Object getPrivateField(Object obj, String fieldName) {
        try {
            var f = obj.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception e) {
            return null;
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            var f = obj.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(obj, value);
        } catch (Exception ignored) {}
    }

    // =========================================================
    // 🔹 XÓA NHÂN VIÊN
    // =========================================================
    private void xoaNhanVien() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "⚠️ Chọn nhân viên cần xóa!");
            return;
        }
        String ma = (String) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Xóa nhân viên " + ma + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dsNV.xoaTheoMa(ma);
            napDuLieuVaoBang();
        }
    }

    // =========================================================
    // 🔹 MAIN TEST
    // =========================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NhanVienGUI());
    }
}
