package Modul9_GUI.Bab8AWT;

import java.awt.*;
import java.awt.event.*;

public class MainNilai extends Frame implements ActionListener, ItemListener {
    CheckboxGroup rbGroup   = new CheckboxGroup();
    Checkbox rbASD          = new Checkbox("ASD",       rbGroup, false);
    Checkbox rbPemlan       = new Checkbox("Pemlan",    rbGroup, true);
    Checkbox rbMatkomlan    = new Checkbox("Matkomlan", rbGroup, false);
    Checkbox rbProbstat     = new Checkbox("Probstat",  rbGroup, false);

    // Text input nilai
    TextField tfTugas = new TextField();
    TextField tfKuis  = new TextField();
    TextField tfUTS   = new TextField();
    TextField tfUAS   = new TextField();

    TextField tfHasil = new TextField();

    Button btnHitung = new Button("Hitung");
    Button btnTampil = new Button("Tampilkan nilai semua matkul");

    TextArea taHasil = new TextArea("", 6, 40);

    double nilaiPemlan    = -1;
    double nilaiASD       = -1;
    double nilaiMatkomlan = -1;
    double nilaiProbstat  = -1;

    public MainNilai() {
        super("Hitung Nilai Akhir dengan GUI");
        setLayout(null);
        setSize(400, 500);
        setResizable(false);

        Label lblJudul = new Label("Hitung Nilai Akhir", Label.CENTER);
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblJudul.setBounds(0, 10, 390, 25);
        add(lblJudul);

        rbASD.setBounds(15,  44, 65, 20);
        rbPemlan.setBounds(85, 44, 75, 20);
        rbMatkomlan.setBounds(165, 44, 100, 20);
        rbProbstat.setBounds(270, 44, 90, 20);

        rbASD.addItemListener(this);
        rbPemlan.addItemListener(this);
        rbMatkomlan.addItemListener(this);
        rbProbstat.addItemListener(this);

        add(rbASD); add(rbPemlan); add(rbMatkomlan); add(rbProbstat);

        buatBarisinput("Tugas :",  30,  78); add(tfTugas);  tfTugas.setBounds(120,  78, 200, 22);
        buatBarisinput("Kuis :",   30, 110); add(tfKuis);   tfKuis.setBounds(120,  110, 200, 22);
        buatBarisinput("UTS :",    30, 142); add(tfUTS);    tfUTS.setBounds(120,   142, 200, 22);
        buatBarisinput("UAS :",    30, 174); add(tfUAS);    tfUAS.setBounds(120,   174, 200, 22);
        buatBarisinput("Rata-rata :",  30, 206); add(tfHasil);  tfHasil.setBounds(120, 206, 200, 22);
        tfHasil.setEditable(false); 

        btnHitung.setBounds(120, 242, 120, 28);
        btnHitung.addActionListener(this);
        add(btnHitung);

        Label lblRekap = new Label("HASIL NILAI SEMUA MATA KULIAH");
        lblRekap.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblRekap.setBounds(15, 282, 360, 18);
        add(lblRekap);

        taHasil.setBounds(15, 300, 360, 112);
        taHasil.setEditable(false);
        taHasil.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(taHasil);

        btnTampil.setBounds(55, 425, 270, 28);
        btnTampil.addActionListener(this);
        add(btnTampil);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }


    void buatBarisinput(String teks, int x, int y) {
        Label lbl = new Label(teks);
        lbl.setBounds(x, y, 85, 22);
        add(lbl);
    }

    public void itemStateChanged(ItemEvent e) {
        tfTugas.setText("");
        tfKuis.setText("");
        tfUTS.setText("");
        tfUAS.setText("");
        tfHasil.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHitung) {
            hitungNilai();
        } else if (e.getSource() == btnTampil) {
            tampilkanSemua();
        }
    }

    void hitungNilai() {
        try {
            double tugas = Double.parseDouble(tfTugas.getText());
            double kuis  = Double.parseDouble(tfKuis.getText());
            double uts   = Double.parseDouble(tfUTS.getText());
            double uas   = Double.parseDouble(tfUAS.getText());

            double hasil = 0;
            if (rbGroup.getSelectedCheckbox() == rbPemlan) {
                hasil = new Pemlan(tugas, kuis, uts, uas).hitungNilaiAkhir();
                nilaiPemlan = hasil;

            } else if (rbGroup.getSelectedCheckbox() == rbASD) {
                hasil = new ASD(tugas, kuis, uts, uas).hitungNilaiAkhir();
                nilaiASD = hasil;

            } else if (rbGroup.getSelectedCheckbox() == rbMatkomlan) {
                hasil = new Matkomlan(tugas, kuis, uts, uas).hitungNilaiAkhir();
                nilaiMatkomlan = hasil;

            } else if (rbGroup.getSelectedCheckbox() == rbProbstat) {
                hasil = new Probstat(tugas, kuis, uts, uas).hitungNilaiAkhir();
                nilaiProbstat = hasil;
            }

            tfHasil.setText(String.valueOf(hasil));

        } catch (NumberFormatException ex) {
            tfHasil.setText("Input tidak valid!");
        }
    }

    void tampilkanSemua() {
        String pemlan    = (nilaiPemlan    < 0) ? "-" : String.valueOf(nilaiPemlan);
        String asd       = (nilaiASD       < 0) ? "-" : String.valueOf(nilaiASD);
        String matkomlan = (nilaiMatkomlan < 0) ? "-" : String.valueOf(nilaiMatkomlan);
        String probstat  = (nilaiProbstat  < 0) ? "-" : String.valueOf(nilaiProbstat);

        taHasil.setText(
            "Pemlan    : " + pemlan    + "\n" +
            "ASD       : " + asd       + "\n" +
            "Matkomlan : " + matkomlan + "\n" +
            "Probstat  : " + probstat  + "\n"
        );
    }
    public static void main(String[] args) {
        new MainNilai();
    }
}