import java.awt.*;
import javax.swing.*;

public class MainGUI extends JFrame {
    public MainGUI() {
        setTitle("Quản lý cửa hàng thức ăn nhanh & giải khát");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("MENU CHÍNH", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(lblTitle, BorderLayout.NORTH);

        JPanel panelBtn = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton btnSanPham = new JButton(" Quản lý Sản phẩm");
        JButton btnNhanVien = new JButton("Quản lý Nhân viên");
        JButton btnHoaDon = new JButton(" Tạo & Xuất hóa đơn");
        JButton btnThoat = new JButton(" Thoát chương trình");

        panelBtn.add(btnSanPham);
        panelBtn.add(btnNhanVien);
        panelBtn.add(btnHoaDon);
        panelBtn.add(btnThoat);
        add(panelBtn, BorderLayout.CENTER);

        // Xử lý nút
        btnSanPham.addActionListener(e -> new SanPhamGUI());
        btnNhanVien.addActionListener(e -> new NhanVienGUI());
        btnHoaDon.addActionListener(e -> new HoaDonGUI());
        btnThoat.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI());
    }
}
