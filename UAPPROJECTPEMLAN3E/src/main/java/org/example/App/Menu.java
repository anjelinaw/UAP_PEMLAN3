package org.example.App;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame {

    ArrayList<JCheckBox> listMenu = new ArrayList<>();
    ArrayList<Integer> listHarga = new ArrayList<>();
    JLabel lblTotal;

    public Menu() {
        setTitle("Menu Makanan & Minuman");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelUtama = new JPanel();
        panelUtama.setLayout(new BoxLayout(panelUtama, BoxLayout.Y_AXIS));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        /* ========== MENU MAKANAN ========== */
        JLabel lblMakanan = new JLabel("Menu Makanan");
        lblMakanan.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblMakanan.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelUtama.add(lblMakanan);
        panelUtama.add(Box.createRigidArea(new Dimension(0, 8)));

        tambahMenu(panelUtama, "Nasi Goreng", 15000);
        tambahMenu(panelUtama, "Ayam Geprek", 12000);
        tambahMenu(panelUtama, "CapCay", 18000);
        tambahMenu(panelUtama, "Bakso Malang", 18000);


        panelUtama.add(Box.createRigidArea(new Dimension(0, 15)));

        /* ========== MENU MINUMAN ========== */
        JLabel lblMinuman = new JLabel("Menu Minuman");
        lblMinuman.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblMinuman.setAlignmentX(Component.LEFT_ALIGNMENT);

        panelUtama.add(lblMinuman);
        panelUtama.add(Box.createRigidArea(new Dimension(0, 8)));

        tambahMenu(panelUtama, "Es Teh", 5000);
        tambahMenu(panelUtama, "Es Jeruk", 7000);
        tambahMenu(panelUtama, "Es Buah", 10000);
        tambahMenu(panelUtama, "Jus Buah", 7000);


        /* ========== BAGIAN BAWAH ========== */
        lblTotal = new JLabel("Total: Rp 0");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JButton btnLanjut = new JButton("Lanjut");
        btnLanjut.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLanjut.addActionListener(e -> lanjut());

        JPanel bawah = new JPanel(new BorderLayout());
        bawah.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        bawah.add(lblTotal, BorderLayout.WEST);
        bawah.add(btnLanjut, BorderLayout.EAST);

        add(new JScrollPane(panelUtama), BorderLayout.CENTER);
        add(bawah, BorderLayout.SOUTH);

        setVisible(true);
    }

    /* ========== TAMBAH MENU ========== */
    private void tambahMenu(JPanel panel, String nama, int harga) {
        JCheckBox cb = new JCheckBox(nama + " - Rp " + harga);
        cb.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cb.setAlignmentX(Component.LEFT_ALIGNMENT);
        cb.addActionListener(e -> updateTotal());

        listMenu.add(cb);
        listHarga.add(harga);
        panel.add(cb);
    }

    /* ========== HITUNG TOTAL ========== */
    private void updateTotal() {
        int total = 0;
        for (int i = 0; i < listMenu.size(); i++) {
            if (listMenu.get(i).isSelected()) {
                total += listHarga.get(i);
            }
        }
        lblTotal.setText("Total: Rp " + total);
    }

    /* ========== LANJUT KE PESANAN ========== */
    private void lanjut() {
        StringBuilder menuDipilih = new StringBuilder();
        int total = 0;

        for (int i = 0; i < listMenu.size(); i++) {
            if (listMenu.get(i).isSelected()) {
                menuDipilih.append(listMenu.get(i).getText()).append("\n");
                total += listHarga.get(i);
            }
        }

        if (menuDipilih.length() == 0) {
            JOptionPane.showMessageDialog(this, "Pilih menu terlebih dahulu!");
            return;
        }

        new PesananDineinTakeaway(menuDipilih.toString(), total);
        dispose();
    }
}
