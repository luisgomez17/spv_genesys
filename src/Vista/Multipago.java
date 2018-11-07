/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.ProductoVo;
import Modelo.UsuarioVo;
import Modelo.VentaVo;
import Modelo.BagVo;
import Modelo.Ticket;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luism
 */
public class Multipago extends javax.swing.JInternalFrame {

    public int cred;
    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    String[] columnas = {"Nro. Venta", "Total a pagar", "Abonado", "Fecha"};
    private Coordinador miCoordinador;
    public ArrayList<VentaVo> creditos;
    VentaVo abono = new VentaVo();
    VentaVo pagos = new VentaVo();

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        llenarCreditos();
    }
    double total = 0, pagar = 0;
    int metodo;
    public Multipago() {
        initComponents();

    }

    public void llenarCreditos() {

        modelo.setColumnIdentifiers(columnas);
        creditos = miCoordinador.salesCreditId(cred);
        for (int i = 0; i < creditos.size(); i++) {
            modelo.addRow(new Object[]{creditos.get(i).getId_sale(), creditos.get(i).getTotal(), creditos.get(i).getShip(), creditos.get(i).getDate()});
            total += creditos.get(i).getTotal();
        }
        total = (double) Math.round((total * 100d) / 100d);
        tbCreditos.setModel(modelo);
        lblPagar.setText(Double.toString(total));
    }

    public void formaPago(int metodo , double pago) {
       
        
        switch(metodo){
            case 1:
                abono.setEfectivo(pago);
                break;
            case 2:
                abono.setCredit(pago);
                break;
            case 3:
                abono.setTarjeta(pago);
                break;
            case 4:
                abono.setVales(pago);
                break;
            case 5:
                abono.setCheques(pago);
                break;
                
        }
        abono.setTotal(pago);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblVendedor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCreditos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPagar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTerm = new javax.swing.JTextField();
        cmForma = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDinero = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 65, 92));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(1, 129, 176));

        lblVendedor.setBackground(new java.awt.Color(255, 255, 255));
        lblVendedor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        lblVendedor.setForeground(new java.awt.Color(255, 255, 255));

        tbCreditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nro. Venta", "Total a pagar", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbCreditos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total a pagar:");

        lblPagar.setBackground(new java.awt.Color(255, 255, 255));
        lblPagar.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        lblPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblPagar.setText("0.00");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pago:");

        txtPago.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPago.setText("0");
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Terminación:");

        txtTerm.setEditable(false);
        txtTerm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTermKeyTyped(evt);
            }
        });

        cmForma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Efectivo", "Credito", "Debito", "Vales", "Cheques" }));
        cmForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmFormaActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Forma de pago:");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Abono");

        txtDinero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDinero.setText("0");
        txtDinero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDineroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmForma, 0, 136, Short.MAX_VALUE)
                                .addComponent(txtTerm)
                                .addComponent(txtDinero))
                            .addComponent(txtPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(63, 63, 63)
                        .addComponent(lblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed

    }//GEN-LAST:event_txtPagoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        double aux1, aux2, aux3;
        double total = 0;
        double pago = Double.parseDouble(txtPago.getText());
        double dinero = Double.parseDouble(txtDinero.getText());
        double cambio = dinero - pago;
        cambio = (double) Math.round((cambio * 100d) / 100d);
        
        if (pago > 0 && metodo > 0 && pago <= dinero) {
            for (int i = 0; i < creditos.size(); i++) {

                if (creditos.get(i).getShip() + pago <= creditos.get(i).getTotal() && pago > 0) {
                    System.out.println(creditos.get(i).getShip());
                    aux1 = creditos.get(i).getShip();
                    aux2 = pago;
                    aux3 = aux1 + aux2;
                    aux3 = (double) Math.round((aux3 * 100d) / 100d);
                    creditos.get(i).setShip(aux3);
                    
                    formaPago(metodo,pago);
                    abono.setId_sale(creditos.get(i).getId_sale());
                    abono.setId_user(creditos.get(i).getId_user());
                    abono.setTotal(pago);
                    
                    miCoordinador.insertAbono(abono);
                    miCoordinador.pagarDeuda(creditos.get(i));
                    pago=0;
                } else if (creditos.get(i).getShip() + pago > creditos.get(i).getTotal() && pago > 0) {
                    aux1 = (creditos.get(i).getShip() + pago) ; 
                    aux1 = (double) Math.round((aux1 * 100d) / 100d);
                    aux2 = aux1 - creditos.get(i).getTotal();
                    aux2 = (double) Math.round((aux2 * 100d) / 100d);
                    aux3 = creditos.get(i).getTotal() - creditos.get(i).getShip();
                    aux3 = (double) Math.round((aux3 * 100d) / 100d);
                    creditos.get(i).setShip(creditos.get(i).getTotal());
                    
                    formaPago(metodo,aux3);
                    abono.setId_sale(creditos.get(i).getId_sale());
                    abono.setId_user(creditos.get(i).getId_user());
                    abono.setTotal(aux3);
                    
                    miCoordinador.insertAbono(abono);
                    miCoordinador.pagarDeuda(creditos.get(i));
                    pago= aux2;
                    
                }
            }
JOptionPane.showMessageDialog(null, "Gracias por su abono, su cambio es de" + " " + Double.toString(cambio) + "");
             dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado un método de pago", "Credito", JOptionPane.INFORMATION_MESSAGE);
        }
             
    }//GEN-LAST:event_btnAceptarActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped


    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtTermKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTermKeyTyped
        char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();

            evt.consume();
        }

        if (txtTerm.getText().length() >= 4) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTermKeyTyped

    private void cmFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmFormaActionPerformed
        int seleccionado = cmForma.getSelectedIndex();

        switch (seleccionado) {
            case 1:
                System.out.println("Efectivo");
                txtTerm.setEditable(false);
                metodo = 1;
                break;
            case 2:
                txtTerm.setEditable(true);
                metodo = 2;
                break;
            case 3:
                txtTerm.setEditable(true);
                metodo = 3;
                break;
            case 4:
                txtTerm.setEditable(false);
                metodo = 4;
                break;
            case 5: 
                txtTerm.setEditable(false);
                metodo = 5; 
                break;
        }

    }//GEN-LAST:event_cmFormaActionPerformed

    private void txtDineroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDineroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDineroKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmForma;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblPagar;
    public javax.swing.JLabel lblVendedor;
    private javax.swing.JTable tbCreditos;
    private javax.swing.JTextField txtDinero;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTerm;
    // End of variables declaration//GEN-END:variables
}
