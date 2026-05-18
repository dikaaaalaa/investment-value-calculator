import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// DHIKALAFFAIZ MARISKY//255150707111015// TEKNOLOGI INFORMASI

public class Exercise15_05 extends JFrame {

    public Exercise15_05() {
        setTitle("Exercise15_05");
        
        // Membuat Komponen Input (Text Field)
        JTextField tfJumlahInvestasi = new JTextField(10);
        JTextField tfJumlahTahun = new JTextField(10);
        JTextField tfSukuBungaTahunan = new JTextField(10);
        JTextField tfNilaiMasaDepan = new JTextField(10);
        
        // Mengatur agar kolom Nilai Masa Depan tidak bisa diedit manual
        tfNilaiMasaDepan.setEditable(false);
        
        // Mengatur teks rata kanan di dalam kolom
        tfJumlahInvestasi.setHorizontalAlignment(JTextField.RIGHT);
        tfJumlahTahun.setHorizontalAlignment(JTextField.RIGHT);
        tfSukuBungaTahunan.setHorizontalAlignment(JTextField.RIGHT);
        tfNilaiMasaDepan.setHorizontalAlignment(JTextField.RIGHT);

        // Membuat Tombol Hitung
        JButton btnHitung = new JButton("Calculate");

        // Membuat Tata Letak menggunakan GridBagLayout (mirip GridPane di JavaFX)
        JPanel panelUtama = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Jarak antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Baris 0: Investment Amount
        gbc.gridx = 0; gbc.gridy = 0;
        panelUtama.add(new JLabel("Investment Amount:"), gbc);
        gbc.gridx = 1;
        panelUtama.add(tfJumlahInvestasi, gbc);
        
        // Baris 1: Number of Years
        gbc.gridx = 0; gbc.gridy = 1;
        panelUtama.add(new JLabel("Number of Years:"), gbc);
        gbc.gridx = 1;
        panelUtama.add(tfJumlahTahun, gbc);
        
        // Baris 2: Annual Interest Rate
        gbc.gridx = 0; gbc.gridy = 2;
        panelUtama.add(new JLabel("Annual Interest Rate:"), gbc);
        gbc.gridx = 1;
        panelUtama.add(tfSukuBungaTahunan, gbc);
        
        // Baris 3: Future value
        gbc.gridx = 0; gbc.gridy = 3;
        panelUtama.add(new JLabel("Future value:"), gbc);
        gbc.gridx = 1;
        panelUtama.add(tfNilaiMasaDepan, gbc);
        
        // Baris 4: Tombol Calculate (Rata Kanan)
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        panelUtama.add(btnHitung, gbc);

        // Menambahkan panel utama ke dalam Frame
        add(panelUtama);

        // Menangani logika aksi ketika tombol "Calculate" diklik
        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Mengambil nilai angka dari input teks
                    double jumlahInvestasi = Double.parseDouble(tfJumlahInvestasi.getText());
                    int tahun = Integer.parseInt(tfJumlahTahun.getText());
                    double bungaTahunan = Double.parseDouble(tfSukuBungaTahunan.getText());

                    // Menghitung Suku Bunga Bulanan
                    double bungaBulanan = bungaTahunan / 1200;

                    // Menghitung Nilai Masa Depan dengan Rumus
                    double nilaiMasaDepan = jumlahInvestasi * Math.pow(1 + bungaBulanan, tahun * 12);

                    // Menampilkan hasil dengan format mata uang $
                    tfNilaiMasaDepan.setText(String.format("$%.2f", nilaiMasaDepan));
                    
                } catch (NumberFormatException ex) {
                    tfNilaiMasaDepan.setText("Input Tidak Valid");
                }
            }
        });

        // Pengaturan Jendela Aplikasi
        pack();
        setLocationRelativeTo(null); // Jendela muncul di tengah layar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Menjalankan GUI di thread yang aman
        SwingUtilities.invokeLater(() -> {
            new Exercise15_05().setVisible(true);
        });
    }
}
