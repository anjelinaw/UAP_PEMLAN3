package App;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<String> read(String file) {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println("File belum ada.");
        }

        return list;
    }
}
