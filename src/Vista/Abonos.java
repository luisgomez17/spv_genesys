
package Vista;

import Controlador.Coordinador;
import Modelo.ApartadoVo;
import Modelo.VentaVo;
import javax.swing.JOptionPane;


public class Abonos extends javax.swing.JInternalFrame {
    public VentaVo aux = new VentaVo();
    public VentaVo abn = new VentaVo();
    public int estado;
    double total = 0, pagar = 0;
    public ApartadoVo ap = new ApartadoVo();
    private Coordinador miCoordinador;
     
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        lblPagar.setText(Double.toString(abn.getTotal()));
    }

    public Abonos() {
        initComponents();
    }
    
    public double sumarPagos() {
        abn.setEfectivo(Double.parseDouble(txtPago.getText()));
        abn.setCheques(Double.parseDouble(txtCheque.getText()));
        abn.setVales(Double.parseDouble(txtVale.getText()));
        abn.setTarjeta(Double.parseDouble(txtTarjeta.getText()));
        abn.setCredit(Double.parseDouble(txtCredito.getText()));
        abn.setTerminacion(txtTerm.getText());
        pagar = abn.getEfectivo() + abn.getCheques() + abn.getVales() + abn.getTarjeta() + abn.getCredit();
        pagar = (double) Math.round((pagar * 100d) / 100d);
        return pagar;
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPagar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        txtCredito = new javax.swing.JTextField();
        txtCheque = new javax.swing.JTextField();
        txtVale = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTerm = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 65, 92));
        setClosable(true);

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total a pagar:");

        lblPagar.setBackground(new java.awt.Color(255, 255, 255));
        lblPagar.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 18)); // NOI18N
        lblPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblPagar.setText("0.00");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Efectivo:");

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

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tarjeta:");

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Crédito:");

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cheques:");

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Vales:");

        txtTarjeta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTarjeta.setText("0");
        txtTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarjetaKeyTyped(evt);
            }
        });

        txtCredito.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCredito.setText("0");
        txtCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditoKeyTyped(evt);
            }
        });

        txtCheque.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCheque.setText("0");
        txtCheque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChequeKeyTyped(evt);
            }
        });

        txtVale.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtVale.setText("0");
        txtVale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValeKeyTyped(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Terminación:");

        txtTerm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTermKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVale, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(txtPago))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTarjeta)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        double monto = sumarPagos();
        if (monto > 0){
        
            switch(estado){
            case 1:
                if(abn.getTotal() <= monto){
             double cambio = monto - abn.getTotal();
             cambio = (double) Math.round((cambio * 100d) / 100d);
             JOptionPane.showMessageDialog(null, "Gracias por su abono, su cambio es de" + " " + Double.toString(cambio) + "");
            miCoordinador.insertAbono(abn);
             miCoordinador.pagarDeuda(aux);
            dispose();
            }        
            else{
        JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida", "Credito", JOptionPane.INFORMATION_MESSAGE);    
            }
            case 2:
               if(abn.getTotal() <= monto){
             double cambio = monto - abn.getTotal();
             cambio = (double) Math.round((cambio * 100d) / 100d);
             JOptionPane.showMessageDialog(null, "Gracias por su abono, su cambio es de" + " " + Double.toString(cambio) + "");
            miCoordinador.insertAbonoApart(abn);  
            miCoordinador.updateAbon(ap); 
            dispose();
            }        
            else{
        JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida", "Credito", JOptionPane.INFORMATION_MESSAGE);    
            }  
            }
        }
        else{
        JOptionPane.showMessageDialog(null, "No ha ingresado un método de pago", "Credito", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtTermKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTermKeyTyped
char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();
            evt.consume();
        }
        
        if(txtTerm.getText().length() >= 4){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTermKeyTyped

    private void txtTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarjetaKeyTyped
char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTarjetaKeyTyped

    private void txtChequeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeKeyTyped
char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtChequeKeyTyped

    private void txtCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditoKeyTyped
char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCreditoKeyTyped

    private void txtValeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValeKeyTyped
char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtValeKeyTyped

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblPagar;
    private javax.swing.JTextField txtCheque;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtTarjeta;
    private javax.swing.JTextField txtTerm;
    private javax.swing.JTextField txtVale;
    // End of variables declaration//GEN-END:variables
}
