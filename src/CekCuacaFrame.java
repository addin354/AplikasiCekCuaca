/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import org.json.JSONArray;

public class CekCuacaFrame extends javax.swing.JFrame {
 private DefaultTableModel model;
 private final String apiKey = "2de30e91cec9d137f4560c27869a7b4b";
 
    public CekCuacaFrame() {
        initComponents();
        model = (DefaultTableModel) tblCuaca.getModel();
        
        // Tambahkan kolom untuk tabel cuaca
        model.addColumn("Kota");
        model.addColumn("Suhu");
        model.addColumn("Kondisi");
        
        // ActionListener untuk tombol Cek Cuaca
        btnCekCuaca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cekCuaca();
            }
        });
        
                btnTambahFavorit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kota = txtKota.getText().trim();
                if (!kota.isEmpty() && !isKotaFavorit(kota)) {
                    cmbKotaFavorit.addItem(kota);
                }
            }
        });

        // ActionListener untuk tombol Simpan ke CSV
        btnSimpanCSV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanDataKeCSV();
            }
        });
    }
          private void cekCuaca() {
        String kota = txtKota.getText().trim();
        if (kota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota.");
            return;
        }

        try {
            // URL untuk mengambil data cuaca dari OpenWeatherMap berdasarkan nama kota
            String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + kota + "&appid=" + "2de30e91cec9d137f4560c27869a7b4b" + "&units=metric";

            // Membuat URL dan membuka koneksi
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Memeriksa respons HTTP
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) { // Jika sukses
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Membaca respons JSON
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parsing JSON
                JSONObject json = new JSONObject(response.toString());

                // Mendapatkan data suhu dan kondisi cuaca
                double suhu = json.getJSONObject("main").getDouble("temp");
                String kondisi = json.getJSONArray("weather").getJSONObject(0).getString("description");

                // Menampilkan hasil di GUI
                JOptionPane.showMessageDialog(this, "Suhu: " + suhu + "°C\nKondisi: " + kondisi);
                model.addRow(new Object[]{kota, suhu + "°C", kondisi});
                // Contoh penambahan hasil ke JTable (opsional jika menggunakan tabel)
                // model.addRow(new Object[]{kota, suhu + "°C", kondisi});

            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengambil data cuaca. Periksa nama kota atau API key.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
    // Cek apakah kota sudah ada di favorit
    private boolean isKotaFavorit(String kota) {
        for (int i = 0; i < cmbKotaFavorit.getItemCount(); i++) {
            if (cmbKotaFavorit.getItemAt(i).equalsIgnoreCase(kota)) {
                return true;
            }
        }
        return false;
    }
     private void simpanDataKeCSV() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(file)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        writer.write(model.getValueAt(i, j).toString() + ",");
                    }
                    writer.write("\n");
                }
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke CSV.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file.");
            }
        }
    }
     private void muatDataDariCSV() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                model.setRowCount(0); // Bersihkan tabel sebelum memuat data baru
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    model.addRow(data);
                }
                JOptionPane.showMessageDialog(this, "Data berhasil dimuat dari CSV.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Gagal memuat file.");
            }
        }
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtKota = new javax.swing.JTextField();
        btnCekCuaca = new javax.swing.JButton();
        cmbKotaFavorit = new javax.swing.JComboBox<>();
        btnTambahFavorit = new javax.swing.JButton();
        btnSimpanCSV = new javax.swing.JButton();
        btnMuatCSV = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCuaca = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCekCuaca.setText("Cek Cuaca");

        btnTambahFavorit.setText("Tambah Ke Favorit");

        btnSimpanCSV.setText("Simpan ke CSV");

        btnMuatCSV.setText("Muat Data dari CSV");
        btnMuatCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatCSVActionPerformed(evt);
            }
        });

        tblCuaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblCuaca);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpanCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnMuatCSV, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCekCuaca)
                                    .addComponent(btnTambahFavorit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbKotaFavorit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKota, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekCuaca))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKotaFavorit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambahFavorit))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanCSV)
                    .addComponent(btnMuatCSV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(284, 284, 284))
        );

        jButton1.setText("Kelusr");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(0, 252, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMuatCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatCSVActionPerformed
       muatDataDariCSV();
    }//GEN-LAST:event_btnMuatCSVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CekCuacaFrame().setVisible(true));
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CekCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekCuacaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekCuacaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekCuaca;
    private javax.swing.JButton btnMuatCSV;
    private javax.swing.JButton btnSimpanCSV;
    private javax.swing.JButton btnTambahFavorit;
    private javax.swing.JComboBox<String> cmbKotaFavorit;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblCuaca;
    private javax.swing.JTextField txtKota;
    // End of variables declaration//GEN-END:variables
}
