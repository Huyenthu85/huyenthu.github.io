import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ChiTietHoaDonDialog extends JDialog {
    private DonHang donHang;

    public ChiTietHoaDonDialog(JFrame parent, HoaDon hd) {
        super(parent, "Chi tiết hóa đơn " + hd.getMaHD(), true);

        // ===== Lấy DonHang, KH, NV =====
        this.donHang = hd.getDonHang();
        KhachHang kh = getPrivateKH(donHang);
        Nhanvien nv = getPrivateNV(donHang);

        setSize(700, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        // ===== Tiêu đề =====
        JLabel lbl = new JLabel("CHI TIẾT HÓA ĐƠN", SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lbl.setForeground(new Color(50, 80, 140));
        add(lbl, BorderLayout.NORTH);

        // ===== Bảng sản phẩm =====
        String[] cols = {"Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== Đổ dữ liệu sản phẩm =====
        ArrayList<ChitietHD> ds = getPrivateChiTiet(donHang);
        double tong = 0;
        for (ChitietHD ct : ds) {
            String ten = ct.getSanPham().getTensp();
            double gia = ct.getSanPham().TinhGia();
            double thanh = ct.ThanhTien();
            tong += thanh;
            model.addRow(new Object[]{ten, ct.getSoLuong(), gia, thanh});
        }

        // ===== Thông tin tổng kết =====
        double giamGia = (kh != null) ? kh.GiamGia() * tong : 0;
        double thanhToan = tong - giamGia;
        int diem = (int) (tong / 10000);

        JPanel panelBottom = new JPanel(new GridLayout(5, 1));
        panelBottom.add(new JLabel("👤 Khách hàng: " + (kh != null ? kh.Hoten : "?")));
        panelBottom.add(new JLabel("🧾 Nhân viên xử lý: " + (nv != null ? nv.Hoten : "?")));
        panelBottom.add(new JLabel(String.format("💰 Tổng cộng: %.0f VND", tong)));
        panelBottom.add(new JLabel(String.format("🎁 Giảm giá: %.0f VND", giamGia)));
        panelBottom.add(new JLabel(String.format("✅ Thành tiền: %.0f VND — Cộng thêm %d điểm", thanhToan, diem)));

        for (Component c : panelBottom.getComponents()) {
            ((JLabel) c).setFont(new Font("Segoe UI", Font.PLAIN, 15));
        }

        add(panelBottom, BorderLayout.SOUTH);
    }

    // ======= Lấy danh sách chi tiết bằng Reflection =======
    @SuppressWarnings("unchecked")
    private ArrayList<ChitietHD> getPrivateChiTiet(DonHang dh) {
        try {
            var f = dh.getClass().getDeclaredField("dsChiTiet");
            f.setAccessible(true);
            return (ArrayList<ChitietHD>) f.get(dh);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private KhachHang getPrivateKH(DonHang dh) {
        try {
            var f = dh.getClass().getDeclaredField("khachhang");
            f.setAccessible(true);
            return (KhachHang) f.get(dh);
        } catch (Exception e) {
            return null;
        }
    }

    private Nhanvien getPrivateNV(DonHang dh) {
        try {
            var f = dh.getClass().getDeclaredField("nhanvien");
            f.setAccessible(true);
            return (Nhanvien) f.get(dh);
        } catch (Exception e) {
            return null;
        }
    }
}
