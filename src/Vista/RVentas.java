/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.ConecRemoto;
import Modelo.Conectarse;
import Modelo.ProductoVo;
import Modelo.SubcategoryVo;
import Modelo.VentaVo;
import com.mysql.jdbc.Connection;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author bryan
 */
public class RVentas extends javax.swing.JInternalFrame {
   private Coordinador miCoordinador;
   DefaultComboBoxModel modeloSubcategory, modeloYears;
   private ProductoVo producto;
   private ArrayList<SubcategoryVo> subcategories;
   private ArrayList<VentaVo> years;

  
    /**
     * Creates new form Reportes
     */
    public RVentas() {
        initComponents();
        dc3.setEnabled(false);
        dc4.setEnabled(false);
        btnreporteventa.setEnabled(false);
        
        dc1.setEnabled(false);
        dc2.setEnabled(false);
        btnreporte.setEnabled(false);
        
        producto = new ProductoVo();
        subcategories = new ArrayList<>();
        
    }
   
     public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotonreportes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnreporteventa = new javax.swing.JButton();
        dc4 = new com.toedter.calendar.JDateChooser();
        lbSub1 = new javax.swing.JLabel();
        lbCat1 = new javax.swing.JLabel();
        dc3 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        rbVentas = new javax.swing.JRadioButton();
        rbGeneral = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnreporte = new javax.swing.JButton();
        lbCat = new javax.swing.JLabel();
        lbSub = new javax.swing.JLabel();
        dc1 = new com.toedter.calendar.JDateChooser();
        dc2 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 65, 92));

        jPanel3.setBackground(new java.awt.Color(1, 129, 176));

        btnreporteventa.setText("Generar Reporte");
        btnreporteventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteventaActionPerformed(evt);
            }
        });

        dc4.setDateFormatString("yyyy-MM-dd");

        lbSub1.setForeground(new java.awt.Color(255, 255, 255));
        lbSub1.setText("Fin:");

        lbCat1.setForeground(new java.awt.Color(255, 255, 255));
        lbCat1.setText("Inicio:");

        dc3.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbSub1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dc3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnreporteventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnreporteventa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reportes");

        rbVentas.setBackground(new java.awt.Color(255, 255, 255));
        GrupoBotonreportes.add(rbVentas);
        rbVentas.setForeground(new java.awt.Color(255, 255, 255));
        rbVentas.setText("Ventas");
        rbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVentasActionPerformed(evt);
            }
        });

        rbGeneral.setBackground(new java.awt.Color(255, 255, 255));
        GrupoBotonreportes.add(rbGeneral);
        rbGeneral.setForeground(new java.awt.Color(255, 255, 255));
        rbGeneral.setText("General");
        rbGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGeneralActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de Reporte");

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setEnabled(false);

        btnreporte.setText("Generar Reporte");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });

        lbCat.setForeground(new java.awt.Color(255, 255, 255));
        lbCat.setText("Inicio:");

        lbSub.setForeground(new java.awt.Color(255, 255, 255));
        lbSub.setText("Fin:");

        dc1.setDateFormatString("yyyy-MM-dd");

        dc2.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbSub, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(lbCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dc2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(dc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbGeneral)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rbVentas)))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbGeneral)
                    .addComponent(rbVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        
        Conectarse con = new Conectarse();
        Connection conn = (Connection) con.getConn();
        
        Date f1 = dc1.getDate();
        Date f2 = dc2.getDate();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
            String fecha1 = sdf.format(f1);
            String fecha2 = sdf.format(f2);
            
             try {

          
            JasperReport reporte = null;
            //String path = "Reportes/ReporteInventarioSub.jasper";
            
            
            
            //Filtro de parametros
            Map parametro = new HashMap();
            //nombre del parametro
            parametro.put("Inicio",fecha1);
            parametro.put("Fin",fecha2);
           
            String reportUrl = "/Reportes/reportGeneral.jasper"; //path of your report source.
             InputStream reportFile = null;
             
            //reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            reportFile = getClass().getResourceAsStream(reportUrl);

            
           JasperPrint print = JasperFillManager.fillReport(reportFile, parametro, conn);
JasperViewer Jviewer = new JasperViewer(print, false);
Jviewer.setVisible(true);
            
         /*   
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
           */
         
         
        } catch (JRException ex) {
            Logger.getLogger(RVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
            
        
    
        
       
    }//GEN-LAST:event_btnreporteActionPerformed

    private void rbGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGeneralActionPerformed
        
        dc3.setEnabled(false);
        dc4.setEnabled(false);
        btnreporteventa.setEnabled(false);
        
        dc1.setEnabled(true);
        dc2.setEnabled(true);
        btnreporte.setEnabled(true);
        
   
        
    }//GEN-LAST:event_rbGeneralActionPerformed

    private void rbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVentasActionPerformed
  
      dc3.setEnabled(true);
        dc4.setEnabled(true);
        btnreporteventa.setEnabled(true);
        
        dc1.setEnabled(false);
        dc2.setEnabled(false);
        btnreporte.setEnabled(false);
        
    }//GEN-LAST:event_rbVentasActionPerformed

    private void btnreporteventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteventaActionPerformed
        
        Conectarse con = new Conectarse();
        Connection conn = (Connection) con.getConn();

        Date f1 = dc3.getDate();
        Date f2 = dc4.getDate();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
            String fecha1 = sdf.format(f1);
            String fecha2 = sdf.format(f2);
        String reportUrl = "/Reportes/VentasDetalle.jasper"; //path of your report source.
InputStream reportFile = null;
        try {
            
            //String path = "src/Reportes/ReporteVentas.jasper";
           
            reportFile = getClass().getResourceAsStream(reportUrl);

            Map parametrov = new HashMap();
            
            parametrov.put("fch1",fecha1);
            parametrov.put("fch2",fecha2);
            
           JasperPrint print = JasperFillManager.fillReport(reportFile, parametrov, conn);
JasperViewer Jviewer = new JasperViewer(print, false);
Jviewer.setVisible(true);
           
//view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            //view.setVisible(true);
            
        } catch (JRException ex) {
        }  
    }//GEN-LAST:event_btnreporteventaActionPerformed

   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotonreportes;
    private javax.swing.JButton btnreporte;
    private javax.swing.JButton btnreporteventa;
    private com.toedter.calendar.JDateChooser dc1;
    private com.toedter.calendar.JDateChooser dc2;
    private com.toedter.calendar.JDateChooser dc3;
    private com.toedter.calendar.JDateChooser dc4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbCat;
    private javax.swing.JLabel lbCat1;
    private javax.swing.JLabel lbSub;
    private javax.swing.JLabel lbSub1;
    private javax.swing.JRadioButton rbGeneral;
    private javax.swing.JRadioButton rbVentas;
    // End of variables declaration//GEN-END:variables
}
