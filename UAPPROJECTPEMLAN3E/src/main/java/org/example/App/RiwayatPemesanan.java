package org.example.App;

import javax.swing.*;

public class RiwayatPemesanan extends JFrame {

    public RiwayatPemesanan() {
        setTitle("Riwayat Pesanan");
        setSize(600, 400);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        area.append("NAMA | JENIS | MEJA | TOTAL | WAKTU\n");
        area.append("--------------------------------------------------\n");

        for (String line : FileUtil.read("pesanan.csv")) {
            String[] d = line.split(",");
            if (d.length == 5) {
                area.append(d[0] + " | " + d[1] + " | " + d[2]
                        + " | Rp " + d[3] + " | " + d[4] + "\n");
            }
        }

        add(new JScrollPane(area));
        setVisible(true);
    }
}
