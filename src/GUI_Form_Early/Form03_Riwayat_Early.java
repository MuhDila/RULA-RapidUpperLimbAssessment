/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Form_Early;

import Database.Database;
import GUI_Custom.ScrollBarCustom;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import static java.awt.image.ImageObserver.ABORT;
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Dila
 */
public class Form03_Riwayat_Early extends javax.swing.JFrame {
    
    // Set Database
    Connection con =null;
    Statement st = null;
    
    // Menampilkan database ke tabel
    public void TampilkanData(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Umur");
        model.addColumn("Pekerjaan");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Score Final Rula");
        try{
            String sql="SELECT * FROM t_rula";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(4),res.getString(5)
                ,res.getString(6),res.getString(17)});
            }
            
            TabelHistory.setModel(model);
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Set lebar tabel
    public void LebarTabel(){
        TabelHistory.getColumnModel().getColumn(0).setPreferredWidth(90);
        TabelHistory.getColumnModel().getColumn(1).setPreferredWidth(100);
        TabelHistory.getColumnModel().getColumn(2).setPreferredWidth(140);
        TabelHistory.getColumnModel().getColumn(3).setPreferredWidth(5);
        TabelHistory.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    
    // Setting apakah data dari tabel telah dipilih
    public void CheckEmpty(){
        String NIM = Form02_Profile_Early.TFNIM.getText();
        if (NIM.equals("")) {
            JOptionPane.showMessageDialog(this, "Pilih Data dari Tabel Terlebih Dahulu", "Pesan", JOptionPane.ERROR_MESSAGE);
        } else {
            PanelLihatDetail.setBackground(new java.awt.Color(40,167,69));
            ButtonLihatDetail.setEnabled(true);
            PanelHapusData.setBackground(new java.awt.Color(220,53,69));
            ButtonHapusData.setEnabled(true);
        }
    }
    
    // Setting ganti warna panel button lihat detail setelah data dari tabel telah dipilih untuk event mouse move
    public void ChangeColorPanelButtonLanjut() {
        if (ButtonLihatDetail.isEnabled()) {
            PanelLihatDetail.setBackground(Color.BLUE);
            PanelHapusData.setBackground(Color.BLUE);
        } else {
            PanelLihatDetail.setBackground(new java.awt.Color(153,153,153));
            JOptionPane.showMessageDialog(this, "Pilih Data dari Tabel Terlebih Dahulu", "Pesan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Form03_Riwayat_Early() {
        initComponents();
        
        // Set Database
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost/db_rula","root","");
                st = con.createStatement();
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Gagal Terkoneksi ke Database", "Pesan", JOptionPane.ERROR_MESSAGE);
            }
        
        // Setting tabel
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        
        // Menampilkan database ke tabel
        TampilkanData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRiwayat = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelHistory = new GUI_Custom.TableDark();
        PanelHapusData = new GUI_Custom.PanelRound();
        ButtonHapusData = new javax.swing.JButton();
        PanelBackHistoy = new GUI_Custom.PanelRound();
        ButtonBack1 = new javax.swing.JButton();
        PanelLihatDetail = new GUI_Custom.PanelRound();
        ButtonLihatDetail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1042, 767));
        setMinimumSize(new java.awt.Dimension(1042, 767));
        setPreferredSize(new java.awt.Dimension(1042, 767));

        PanelRiwayat.setBackground(new java.awt.Color(255, 255, 255));
        PanelRiwayat.setMaximumSize(new java.awt.Dimension(1042, 768));
        PanelRiwayat.setMinimumSize(new java.awt.Dimension(1042, 768));
        PanelRiwayat.setPreferredSize(new java.awt.Dimension(1042, 768));
        PanelRiwayat.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelRiwayatMouseMoved(evt);
            }
        });
        PanelRiwayat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RULA - Rapid Upper Limb Assessment");
        PanelRiwayat.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 1022, -1));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Riwayat Perhitungan RULA");
        PanelRiwayat.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 1022, -1));

        TabelHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Alamat", "Umur", "Pekerjaan", "Jenis Kelamin", "No Telepon"
            }
        ));
        TabelHistory.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        TabelHistory.setMaximumSize(new java.awt.Dimension(525, 150));
        TabelHistory.setMinimumSize(new java.awt.Dimension(525, 150));
        TabelHistory.setPreferredScrollableViewportSize(new java.awt.Dimension(525, 150));
        TabelHistory.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TabelHistoryMouseMoved(evt);
            }
        });
        TabelHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelHistory);

        PanelRiwayat.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 980, 370));

        PanelHapusData.setBackground(new java.awt.Color(153, 153, 153));
        PanelHapusData.setRoundBottomLeft(25);
        PanelHapusData.setRoundBottomRight(25);
        PanelHapusData.setRoundTopLeft(25);
        PanelHapusData.setRoundTopRight(25);

        ButtonHapusData.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonHapusData.setForeground(new java.awt.Color(255, 255, 255));
        ButtonHapusData.setText("Hapus Data");
        ButtonHapusData.setContentAreaFilled(false);
        ButtonHapusData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonHapusData.setEnabled(false);
        ButtonHapusData.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonHapusDataMouseMoved(evt);
            }
        });
        ButtonHapusData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHapusDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHapusDataLayout = new javax.swing.GroupLayout(PanelHapusData);
        PanelHapusData.setLayout(PanelHapusDataLayout);
        PanelHapusDataLayout.setHorizontalGroup(
            PanelHapusDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHapusDataLayout.createSequentialGroup()
                .addComponent(ButtonHapusData, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        PanelHapusDataLayout.setVerticalGroup(
            PanelHapusDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonHapusData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PanelRiwayat.add(PanelHapusData, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 120, -1));

        PanelBackHistoy.setBackground(new java.awt.Color(40, 167, 69));
        PanelBackHistoy.setRoundBottomLeft(25);
        PanelBackHistoy.setRoundBottomRight(25);
        PanelBackHistoy.setRoundTopLeft(25);
        PanelBackHistoy.setRoundTopRight(25);

        ButtonBack1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonBack1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonBack1.setText("<<< BACK");
        ButtonBack1.setContentAreaFilled(false);
        ButtonBack1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonBack1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonBack1MouseMoved(evt);
            }
        });
        ButtonBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBackHistoyLayout = new javax.swing.GroupLayout(PanelBackHistoy);
        PanelBackHistoy.setLayout(PanelBackHistoyLayout);
        PanelBackHistoyLayout.setHorizontalGroup(
            PanelBackHistoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBackHistoyLayout.createSequentialGroup()
                .addComponent(ButtonBack1)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        PanelBackHistoyLayout.setVerticalGroup(
            PanelBackHistoyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonBack1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PanelRiwayat.add(PanelBackHistoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 100, -1));

        PanelLihatDetail.setBackground(new java.awt.Color(153, 153, 153));
        PanelLihatDetail.setRoundBottomLeft(25);
        PanelLihatDetail.setRoundBottomRight(25);
        PanelLihatDetail.setRoundTopLeft(25);
        PanelLihatDetail.setRoundTopRight(25);

        ButtonLihatDetail.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonLihatDetail.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLihatDetail.setText("LIHAT DETAIL");
        ButtonLihatDetail.setContentAreaFilled(false);
        ButtonLihatDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLihatDetail.setEnabled(false);
        ButtonLihatDetail.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonLihatDetailMouseMoved(evt);
            }
        });
        ButtonLihatDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLihatDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLihatDetailLayout = new javax.swing.GroupLayout(PanelLihatDetail);
        PanelLihatDetail.setLayout(PanelLihatDetailLayout);
        PanelLihatDetailLayout.setHorizontalGroup(
            PanelLihatDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonLihatDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        PanelLihatDetailLayout.setVerticalGroup(
            PanelLihatDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonLihatDetail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PanelRiwayat.add(PanelLihatDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PanelRiwayatMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRiwayatMouseMoved
        // TODO add your handling code here:
        PanelBackHistoy.setBackground(new java.awt.Color(40,167,69));
        
        // Ubah warna panel lihat detail
        if (ButtonLihatDetail.isEnabled()) {
            PanelLihatDetail.setBackground(new java.awt.Color(40,167,69));
        }
        if (ButtonHapusData.isEnabled()) {
            PanelHapusData.setBackground(new java.awt.Color(220,53,69));
        }
    }//GEN-LAST:event_PanelRiwayatMouseMoved

    private void ButtonLihatDetailMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLihatDetailMouseMoved
        // TODO add your handling code here:
        CheckEmpty();
        
        // Ubah warna panel lihat detail
        if (ButtonLihatDetail.isEnabled()) {
            PanelLihatDetail.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_ButtonLihatDetailMouseMoved

    private void ButtonLihatDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLihatDetailActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form1_UpperArm_Early().setVisible(true);
    }//GEN-LAST:event_ButtonLihatDetailActionPerformed

    private void TabelHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelHistoryMouseClicked
        // TODO add your handling code here:
        // Ketika tabel ke tekan
        int baris=TabelHistory.rowAtPoint(evt.getPoint());
        String NIM = TabelHistory.getValueAt(baris,0).toString();
        Form02_Profile_Early.TFNIM.setText(NIM);
        
        // Mengubah warna panel jika data dari tabel telah dipilih
        PanelLihatDetail.setBackground(new java.awt.Color(40,167,69));
        ButtonLihatDetail.setEnabled(true);
        PanelHapusData.setBackground(new java.awt.Color(220,53,69));
        ButtonHapusData.setEnabled(true);
    }//GEN-LAST:event_TabelHistoryMouseClicked

    private void ButtonHapusDataMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHapusDataMouseMoved
        // TODO add your handling code here:
        CheckEmpty();
        
        // Ubah warna panel
        if (ButtonHapusData.isEnabled()) {
            PanelHapusData.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_ButtonHapusDataMouseMoved

    private void ButtonHapusDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHapusDataActionPerformed
        // TODO add your handling code here:
        try{
            String sql2= "DELETE FROM t_adjustdata WHERE nim ='"+ Form02_Profile_Early.TFNIM.getText()+"'";
            String sql= "DELETE FROM t_rula WHERE nim ='"+ Form02_Profile_Early.TFNIM.getText()+"'";
            java.sql.Connection conn=(Connection)Database.configDB();
            java.sql.PreparedStatement pstm2 = conn.prepareStatement(sql2);
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm2.execute();
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil.");
            TampilkanData();
            PanelHapusData.setBackground(new java.awt.Color(220,53,69));
        }
        catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_ButtonHapusDataActionPerformed

    private void ButtonBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBack1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form02_Profile_Early().setVisible(true);
    }//GEN-LAST:event_ButtonBack1ActionPerformed

    private void ButtonBack1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBack1MouseMoved
        // TODO add your handling code here:
        PanelBackHistoy.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBack1MouseMoved

    private void TabelHistoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelHistoryMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelHistoryMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Form03_Riwayat_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form03_Riwayat_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form03_Riwayat_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form03_Riwayat_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form03_Riwayat_Early().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack1;
    private javax.swing.JButton ButtonHapusData;
    private javax.swing.JButton ButtonLihatDetail;
    private GUI_Custom.PanelRound PanelBackHistoy;
    private GUI_Custom.PanelRound PanelHapusData;
    private GUI_Custom.PanelRound PanelLihatDetail;
    private javax.swing.JPanel PanelRiwayat;
    private GUI_Custom.TableDark TabelHistory;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}