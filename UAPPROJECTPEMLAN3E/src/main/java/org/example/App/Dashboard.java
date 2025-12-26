package org.example.App;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("RESTO POS");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        /* ================= SIDEBAR ================= */
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(new Color(27, 32, 38));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));

        JLabel lblLogo = new JLabel("RESTO POS");
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        sidebar.add(lblLogo);
        sidebar.add(Box.createRigidArea(new Dimension(0, 30)));

        sidebar.add(btnSidebar("Pesanan Baru", () -> new Menu()));
        sidebar.add(Box.createRigidArea(new Dimension(0, 8)));
        sidebar.add(btnSidebar("Riwayat Pesanan", () -> new RiwayatPemesanan()));
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(btnSidebar("Keluar", () -> System.exit(0)));

        /* ================= HEADER ================= */
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(245, 247, 250));
        header.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        JLabel lblHeader = new JLabel("Dashboard Kasir");
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 22));

        JLabel lblStatus = new JLabel("Sistem Aktif");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        header.add(lblHeader, BorderLayout.WEST);
        header.add(lblStatus, BorderLayout.EAST);

        /* ================= CONTENT ================= */
        JPanel content = new JPanel();
        content.setBackground(new Color(245, 247, 250));
        content.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        JLabel lblWelcome = new JLabel("Selamat Datang di Aplikasi Pemesanan Kami");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 28));

        JLabel lblDesc = new JLabel("Silakan pilih Pesanan Baru disamping untuk memulai pemesanan anda");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblDesc.setForeground(new Color(120, 120, 120));

        gbc.gridy = 0;
        content.add(lblWelcome, gbc);

        gbc.gridy = 1;
        content.add(lblDesc, gbc);

        /* ================= ADD TO FRAME ================= */
        add(sidebar, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);

        setVisible(true);
    }

    /* ================= SIDEBAR BUTTON ================= */
    private JButton btnSidebar(String text, Runnable aksi) {
        JButton btn = new JButton(text);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(45, 52, 61));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btn.addActionListener(e -> aksi.run());
        return btn;
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
