package App;

import javax.swing.*;
import java.awt.*;

public class PesananDineinTakeaway extends JFrame {

    JTextField txtNama, txtMeja;
    JComboBox<String> cmbJenis;
    JTextArea areaMenu;
    int total;

    public PesananDineinTakeaway (String menu, int totalHarga) {
        total = totalHarga;

        setTitle("Data Pesanan");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        txtNama = new JTextField();
        txtMeja = new JTextField();
        cmbJenis = new JComboBox<>(new String[]{"Dine In", "Take Away"});

        cmbJenis.addActionListener(e ->
                txtMeja.setEnabled(cmbJenis.getSelectedItem().equals("Dine In"))
        );

        form.add(new JLabel("Nama Customer"));
        form.add(txtNama);
        form.add(new JLabel("Jenis Pesanan"));
        form.add(cmbJenis);
        form.add(new JLabel("No Meja"));
        form.add(txtMeja);

        areaMenu = new JTextArea(menu);
        areaMenu.setEditable(false);

        JButton btnSimpan = new JButton("Simpan Pesanan");
        btnSimpan.addActionListener(e -> simpan());

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(areaMenu), BorderLayout.CENTER);
        add(btnSimpan, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void simpan() {
        if (txtNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama wajib diisi!");
            return;
        }

        String nama = txtNama.getText();
        String jenis = cmbJenis.getSelectedItem().toString();
        String meja = jenis.equals("Dine In") ? txtMeja.getText() : "-";

        SimpanPesanan.simpan(nama, jenis, meja, String.valueOf(total));

        JOptionPane.showMessageDialog(this, "Pesanan berhasil disimpan!");
        dispose();
    }
}
