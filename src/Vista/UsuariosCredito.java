/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.ColorVo;
import Modelo.ProductoVo;
import Modelo.TallaVo;
import Modelo.UsuarioVo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.DetalleVenta;
import static Vista.Inicio.escritorio;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

/**
 *
 * @author luism
 */
public class UsuariosCredito extends javax.swing.JInternalFrame {
  private Coordinador miCoordinador;
  DefaultTableModel modelo = new DefaultTableModel(){
  public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
  };
      String[] columnas = {"ID","Nombre(s)","Apellidos","Email","Cod. Postal","Direccion","Telefono","RFC"};
     
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
//asignarTamaÃ±o();
        imprimirUsuarios();

        
    }
    /**
     * Create new form Usuarios
     */
    public UsuariosCredito() {
        initComponents();
       // setLocationRelativeTo(null);        // Centering on screen...
       // setSize(1300, 800); 
       //modelo = (DefaultTableModel) tbUsers.getModel();
          
       modelo.setColumnIdentifiers(columnas);
        tbUsers.setModel(modelo);
        
    }

    public void imprimirUsuarios(){
      modelo.setColumnIdentifiers(columnas);
      asignarTamano(); 
      ArrayList<UsuarioVo> user = miCoordinador.getUsuariosCredito();
      

      
      
      for (int i =0; i<user.size();i++){
       modelo.addRow(new Object[] {user.get(i).getId_user(),user.get(i).getFirstname(),user.get(i).getLastname(),user.get(i).getEmail(),
       user.get(i).getCp(),user.get(i).getDirection(),
       user.get(i).getPhone(),user.get(i).getRfc()});
      }
      //Asignamos los datos del Modelo a la tabla
      tbUsers.setModel(modelo);
    }
    
     public void imprimirUsuariosSeleccionados(ArrayList<Integer> valores){
      modelo.setColumnIdentifiers(columnas);
      asignarTamano(); 
      ArrayList<UsuarioVo> user = miCoordinador.getUsuariosCredito();
      

      
      
      for (int i =0; i<valores.size();i++){
       modelo.addRow(new Object[] {user.get(valores.get(i)).getId_user(),user.get(valores.get(i)).getFirstname(),user.get(valores.get(i)).getLastname(),user.get(valores.get(i)).getEmail(),
       user.get(valores.get(i)).getCp(),user.get(valores.get(i)).getDirection(),
       user.get(valores.get(i)).getPhone(),user.get(valores.get(i)).getRfc()});
      }
      //Asignamos los datos del Modelo a la tabla
      tbUsers.setModel(modelo);
    }
      public void asignarTamano(){
    tbUsers.getColumnModel().getColumn(0).setPreferredWidth(30);
    tbUsers.getColumnModel().getColumn(1).setPreferredWidth(150);
    tbUsers.getColumnModel().getColumn(2).setPreferredWidth(150);
    tbUsers.getColumnModel().getColumn(3).setPreferredWidth(200);
    tbUsers.getColumnModel().getColumn(4).setPreferredWidth(60);
    tbUsers.getColumnModel().getColumn(5).setPreferredWidth(300);
    tbUsers.getColumnModel().getColumn(6).setPreferredWidth(80);
    tbUsers.getColumnModel().getColumn(7).setPreferredWidth(100);
    
    
    
   
    
    }
    
         private void limpiarTable(){
while(modelo.getRowCount()>0){
modelo.removeRow(0);
}
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        btnGenerate1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 65, 92));

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        tbUsers.setBackground(new java.awt.Color(237, 237, 237));
        tbUsers.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbUsers.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Usuario", "Nombre(s)", "Apellidos", "Email", "CÃ³digo Postal", "DirecciÃ³n", "TelÃ©fono", "RFC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsers.setGridColor(new java.awt.Color(255, 255, 255));
        tbUsers.setRowHeight(20);
        tbUsers.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbUsers.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsers);

        jLabel2.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Creditos por cliente");

        jPanel3.setBackground(new java.awt.Color(1, 129, 176));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        txtSearch1.setBackground(new java.awt.Color(242, 242, 242));
        txtSearch1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch1.setCaretColor(new java.awt.Color(51, 51, 51));
        txtSearch1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearch1KeyTyped(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 37, 145));
        btnSearch.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnGenerate.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate.setText("Generar Lista");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerate1.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate1.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate1.setText("Ver Creditos");
        btnGenerate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerate1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
//        int aux = Integer.parseInt(txtSearch.getText());
        String name = txtSearch1.getText().trim();
        
        modelo.setColumnIdentifiers(columnas);
        int filas  = tbUsers.getRowCount();
        ArrayList<Integer> al = new ArrayList<Integer>();

        if(!name.isEmpty()){
          
        for(int i=0;i<filas;i++){
           String cadena1 = String.valueOf(tbUsers.getValueAt(i, 1)) ;
           String cadena2 = String.valueOf(tbUsers.getValueAt(i, 2)) ;
        if(cadena1.contains(name) || cadena2.contains(name)){
        al.add(i);
        
        }
        
        }
        
        if(al.size()>0){
        limpiarTable();
        imprimirUsuariosSeleccionados(al);
        }
        
        }
        else{
        JOptionPane.showMessageDialog(null, "No se encontró ningún resultado");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsersMouseClicked
     int fila = tbUsers.getSelectedRow();
      //DetalleVenta venta = new DetalleVenta(); 

      
               if ((fila > -1)){
        
          
          
         }        // TODO add your handling code here:
    }//GEN-LAST:event_tbUsersMouseClicked

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
limpiarTable();        
imprimirUsuarios();
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1KeyTyped
VentaCredito vc;
    private void btnGenerate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerate1ActionPerformed
 
        int fila = tbUsers.getSelectedRow();
      //DetalleVenta venta = new DetalleVenta(); 

               if ((fila > -1)){
         int id = (int) tbUsers.getValueAt(fila, 0);          
         if (estacerrado(vc)) {
            vc = new VentaCredito();
            vc.id_usuario = id;
            vc.setCoordinador(miCoordinador);
            escritorio.add(vc).setLocation(25, 3);
            vc.show();
            try {
                vc.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
         }   
               else{
               JOptionPane.showMessageDialog(null, "No se encontró ningún resultado");
               }
    }//GEN-LAST:event_btnGenerate1ActionPerformed


 public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = escritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
                JOptionPane.showMessageDialog(this, "Otra ventana se encuentra \nya  abierta !!!", "Aviso", 0,
                        new ImageIcon(getClass().getResource("/Imagenes/adver1.png")));
            }
            i++;
        }
        return cerrado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnGenerate1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbUsers;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}
