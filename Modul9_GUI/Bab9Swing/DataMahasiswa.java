package Modul9_GUI.Bab9Swing;

import javax.swing.*;
import java.awt.*;

public class DataMahasiswa extends JFrame {

    public DataMahasiswa(String nama, String tgl, String noPend,
                       String noTelp, String alamat, String email) {

        super("Data Mahasiswa");
        setSize(380, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        area.setMargin(new Insets(15, 15, 15, 15));
        area.setText(
            "Nama             : " + nama   + "\n" +
            "Tanggal Lahir    : " + tgl    + "\n" +
            "No. Pendaftaran  : " + noPend + "\n" +
            "No. Telepon      : " + noTelp + "\n" +
            "Alamat           : " + alamat + "\n" +
            "E-mail           : " + email
        );

        add(new JScrollPane(area));
        setVisible(true);
    }
}