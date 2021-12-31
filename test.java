import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author CHANDARESH
 */
public class test extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public test() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Obj = new javax.swing.JComboBox<>();
        Sub = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        res = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Obj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour", "Day", " ", " " }));
        Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObjActionPerformed(evt);
            }
        });
        getContentPane().add(Obj, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        Sub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Longest", "Highest" }));
        Sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubActionPerformed(evt);
            }
        });
        getContentPane().add(Sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        jButton1.setText("Show");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        res.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(res, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 390, 50));

        jLabel2.setBackground(java.awt.Color.lightGray);
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CALL CENTER DATA ");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 174, 59));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pexels-photo-2111759.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObjActionPerformed

    private void SubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/call_center","root","root");
            Statement stmt =con.createStatement();
            String a = (String) Obj.getSelectedItem();
            String b = (String) Sub.getSelectedItem();
            if(a=="Hour" && b=="Longest")
            {
                String query= "SELECT hour,MAX(Dur)FROM data; ";
                ResultSet rs= stmt.executeQuery(query);
                while(rs.next())
                {
                    int c = rs.getInt("Hour");
                    int d = c+1;
                    res.setText("Hour of the day when the the calls are longest from "+c+" to"+d+" hours.");
                }
                rs.close();
                stmt.close();
            }
            else if(a=="Hour" && b=="Highest")
            {
                String query= "select day,hour from data \n"+"group by hour\n"+"order by count(*)\n"+
                "desc limit 1; ";
                ResultSet rs= stmt.executeQuery(query);
                while(rs.next())
                {
                    int c = rs.getInt("Hour");
                    int d = c+1;
                    res.setText("Hour of the day when the call volume is highest is from "+c+" to"+d+" hours.");
                }
                rs.close();
                stmt.close();
            }
            else if(a=="Day" && b=="Longest")
            {
                String query= "SELECT day,MAX(Dur)FROM data; ";
                ResultSet rs= stmt.executeQuery(query);
                while(rs.next())
                {
                    int c = rs.getInt("Day");
                      switch(c)
                    {
                        case 1:
                        res.setText("Week of the day when the calls are longest is Sunday");
                        break;
                        case 2:
                        res.setText("Week of the day when the calls are longest is Monday");
                        break;
                        case 3:
                        res.setText("Week of the day when the calls are longest is Tuesday");
                        break;
                        case 4:
                        res.setText("Week of the day when the calls are longest is Wednesday");
                        break;
                        case 5:
                        res.setText("Week of the day when the calls are longest is Thursday");
                        break;
                        case 6:
                        res.setText("Week of the day when the calls are longest is Friday");
                        break;
                        case 7:
                        res.setText("Week of the day when the calls are longest is Saturday");
                        break;
                        default:
                        res.setText("Invalid");
                        break;
        }
                    
                    
                }
                rs.close();
                stmt.close();
            }
            else if(a=="Day" && b=="Highest")
            {
                String query= "select day,hour from data \n"+"group by hour\n"+"order by count(*)\n"+
                "desc limit 1;";
                ResultSet rs= stmt.executeQuery(query);
                while(rs.next())
                {
                    int c = rs.getInt("Day");
                      switch(c)
                    {
                        case 1:
                        res.setText("Week of the day when the call volume is highest is Sunday");
                        break;
                        case 2:
                        res.setText("Week of the day when the call volume is highestis Monday");
                        break;
                        case 3:
                        res.setText("Week of the day when the call volume is highest is Tuesday");
                        break;
                        case 4:
                        res.setText("Week of the day when the call volume is highest is Wednesday");
                        break;
                        case 5:
                        res.setText("Week of the day when the call volume is highest is Thursday");
                        break;
                        case 6:
                        res.setText("Week of the day when the call volume is highest is Friday");
                        break;
                        case 7:
                        res.setText("Week of the day when the call volume is highest is Saturday");
                        break;
                        default:
                        res.setText("Invalid");
                        break;
        }
                }
                rs.close();
                stmt.close();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Obj;
    private javax.swing.JComboBox<String> Sub;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField res;
    // End of variables declaration//GEN-END:variables
}
