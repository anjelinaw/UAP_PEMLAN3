package App;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpanPesanan {

    public static void simpan(String nama, String jenis, String meja, String total) {
        try (FileWriter fw = new FileWriter("pesanan.csv", true)) {
            String waktu = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            fw.write(nama + "," + jenis + "," + meja + "," + total + "," + waktu + "\n");
        } catch (Exception e) {
            System.out.println("Gagal menyimpan pesanan");
        }
    }
}
