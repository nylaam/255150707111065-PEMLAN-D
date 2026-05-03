package Modul9_GUI.Bab9Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormDaftarUlang extends JFrame implements ActionListener {

    JTextField tfNama   = new JTextField(20);
    JTextField tfTgl    = new JTextField(20);
    JTextField tfNoPend = new JTextField(20);
    JTextField tfNoTelp = new JTextField(20);
    JTextArea  taAlamat = new JTextArea(3, 20);
    JTextField tfEmail  = new JTextField(20);

    JButton btnSubmit = new JButton("Submit");

    public FormDaftarUlang() {
        super("Form Daftar Ulang Mahasiswa Baru");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblJudul = new JLabel("Form Daftar Ulang Mahasiswa Baru", SwingConstants.CENTER);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblJudul.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        add(lblJudul, BorderLayout.NORTH);

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        panelForm.add(new JLabel("Nama Lengkap :"));
        panelForm.add(tfNama);

        panelForm.add(new JLabel("Tanggal Lahir :"));
        panelForm.add(tfTgl);

        panelForm.add(new JLabel("Nomor Pendaftaran :"));
        panelForm.add(tfNoPend);

        panelForm.add(new JLabel("No. Telepon :"));
        panelForm.add(tfNoTelp);

        panelForm.add(new JLabel("Alamat :"));
        panelForm.add(new JScrollPane(taAlamat));

        panelForm.add(new JLabel("E-mail :"));
        panelForm.add(tfEmail);

        add(panelForm, BorderLayout.CENTER);

        JPanel panelBtn = new JPanel();
        panelBtn.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        btnSubmit.addActionListener(this);
        panelBtn.add(btnSubmit);
        add(panelBtn, BorderLayout.SOUTH);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            prosesSubmit();
        }
    }


    boolean validasiForm() {
        if (tfNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Lengkap wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tfNama.requestFocus(); return false;
        }
        if (tfTgl.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tanggal Lahir wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tfTgl.requestFocus(); return false;
        }
        if (tfNoPend.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor Pendaftaran wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tfNoPend.requestFocus(); return false;
        }
        if (tfNoTelp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No. Telepon wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tfNoTelp.requestFocus(); return false;
        }
        if (taAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            taAlamat.requestFocus(); return false;
        }
        if (tfEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "E-mail wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tfEmail.requestFocus(); return false;
        }
        return true;
    }


    void prosesSubmit() {
        if (!validasiForm()) return;

        int pilihan = JOptionPane.showConfirmDialog(
            this,
            "Apakah anda yakin data yang Anda isi sudah benar?",
            "Konfirmasi",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (pilihan == JOptionPane.OK_OPTION) {
            new DataMahasiswa(
                tfNama.getText(),
                tfTgl.getText(),
                tfNoPend.getText(),
                tfNoTelp.getText(),
                taAlamat.getText(),
                tfEmail.getText()
            );
        }
    }


    public static void main(String[] args) {
        new FormDaftarUlang();
    }
}