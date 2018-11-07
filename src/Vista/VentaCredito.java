/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.VentaVo;
import static Vista.Inicio.escritorio;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentaCredito extends javax.swing.JInternalFrame {

    public int id_usuario;

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    DefaultTableModel modelo2 = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    String[] columnas = {"ID Venta", "ID Cliente", "Cliente", "Total", "Abonado", "Fecha"};
    String[] columnas2 = {"Cod. Artículo", "Artículo", "Color", "Talla", "Precio", "Cantidad"};
    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        actualizarCreditos(id_usuario);
        llenarTablaVenta();

    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public VentaCredito() {
        initComponents();
        //setLocationRelativeTo(null);        
        //setSize(1280, 800); 
        modelo.setColumnIdentifiers(columnas);
        tbSale.setModel(modelo);
        modelo2.setColumnIdentifiers(columnas2);
        tbProducts.setModel(modelo2);
    }

    public void llenarTablaVenta() {
        modelo.setColumnIdentifiers(columnas);
        ArrayList<VentaVo> venta = miCoordinador.salesCreditId(id_usuario);

        for (int i = 0; i < venta.size(); i++) {
            modelo.addRow(new Object[]{venta.get(i).getId_sale(), venta.get(i).getId_user(), venta.get(i).getFirstname() + " "
                + venta.get(i).getLastname(), venta.get(i).getTotal(), venta.get(i).getShip(), venta.get(i).getDate()});
        }
        //Asignamos los datos del Modelo a la tabla
        tbSale.setModel(modelo);
    }

    public void llenarTablaProducto(int sale) {
        modelo2.setColumnIdentifiers(columnas2);
        limpiarTabla(tbProducts);
        ArrayList<BagVo> listado = miCoordinador.obtenerProductosVenta(sale);

        for (int i = 0; i < listado.size(); i++) {
            modelo2.addRow(new Object[]{listado.get(i).getArt(), listado.get(i).getArt_name(), listado.get(i).getColor_name(),
                listado.get(i).getSize_name(), listado.get(i).getPrice(), listado.get(i).getQuantity()});
        }
        tbProducts.setModel(modelo2);
    }

    public void actualizarCreditos(int id_usuario) {
        ArrayList<VentaVo> local = miCoordinador.salesCreditId(id_usuario);
        ArrayList<VentaVo> online = miCoordinador.getSalesCreditIdOnline(id_usuario);

        for (int j = 0; j < local.size(); j++) {
            for (int i = 0; i < online.size(); i++) {

                if (local.get(j).getId_sale() == online.get(i).getId_sale()) {
                    double a = local.get(j).getShip();
                    double b = online.get(i).getShip();
                    
                    if(Double.compare(a, b) != 0){
                    
                    VentaVo abono = new VentaVo();
                    abono.setId_user(local.get(j).getId_user());
                    abono.setId_sale(local.get(j).getId_sale());
                    abono.setShip(online.get(i).getShip());
                    abono.setDate(local.get(j).getDate());

                    miCoordinador.updateAbono(abono);
                }                    
                }
            
            }
                
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProducts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        btnGenerate = new javax.swing.JButton();
        btnDeuda = new javax.swing.JButton();
        btnMulti = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel3.setBackground(new java.awt.Color(0, 65, 92));

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        tbProducts.setBackground(new java.awt.Color(237, 237, 237));
        tbProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbProducts.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cod. Artículo", "Artículo", "Color", "Talla", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProducts.setGridColor(new java.awt.Color(204, 204, 204));
        tbProducts.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbProducts.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProducts);

        jLabel2.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(1, 129, 176));

        jLabel1.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creditos");
        jLabel1.setAlignmentX(0.5F);

        tbSale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbSale.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        tbSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Subtotal", "Total", "Estado", "Fecha de Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSale.setGridColor(new java.awt.Color(153, 153, 153));
        tbSale.setOpaque(false);
        tbSale.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbSale.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSale);

        btnGenerate.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerate.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerate.setText("Actualizar");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        btnDeuda.setBackground(new java.awt.Color(0, 37, 145));
        btnDeuda.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnDeuda.setForeground(new java.awt.Color(255, 255, 255));
        btnDeuda.setText("Abono");
        btnDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeudaActionPerformed(evt);
            }
        });

        btnMulti.setBackground(new java.awt.Color(0, 37, 145));
        btnMulti.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnMulti.setForeground(new java.awt.Color(255, 255, 255));
        btnMulti.setText("Multipago");
        btnMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 38, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMulti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductsMouseClicked

    }//GEN-LAST:event_tbProductsMouseClicked
    private void tbSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseClicked

        int fila = tbSale.getSelectedRow();

        if ((fila > -1)) {
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProducto(aux);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_tbSaleMouseClicked
Abonos a;
    private void btnDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeudaActionPerformed
        ArrayList<VentaVo> venta = miCoordinador.salesCreditId(id_usuario);
        int seleccion = tbSale.getSelectedRow();
        double abono;
        if (seleccion >= 0) {
            VentaVo auxiliar = new VentaVo();
            VentaVo abonos = new VentaVo();
            
            String valor = JOptionPane.showInputDialog(null, "Registre el abono que desee ingresar");
            
            if (valor.isEmpty() || valor == null || JOptionPane.CANCEL_OPTION == 2) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
            } else {
                abono = Double.parseDouble(valor) + (double) tbSale.getValueAt(seleccion, 4);
                if ( abono <= venta.get(seleccion).getTotal()) {
                    

                    auxiliar.setShip(abono);
                    auxiliar.setId_user(venta.get(seleccion).getId_user());
                    auxiliar.setId_sale(venta.get(seleccion).getId_sale());
                    auxiliar.setDate(venta.get(seleccion).getDate());                    
                    
                    abonos.setId_sale(venta.get(seleccion).getId_sale());
                    abonos.setId_user(venta.get(seleccion).getId_user());
                    abonos.setTotal(Double.parseDouble(valor));
                    
                    a = new Abonos();
                    a.aux = auxiliar;
                    a.abn = abonos;
                    a.estado = 1;
                    a.setCoordinador(miCoordinador);                
                    a.setSize(500, 450);
                    escritorio.add(a).setLocation(25, 3);        
                    a.show();
                    
                    
                    limpiarTabla(tbSale);
                    actualizarCreditos(id_usuario);
                    llenarTablaVenta();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta pendiente");
        }

     }//GEN-LAST:event_btnDeudaActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        limpiarTabla(tbSale);
        actualizarCreditos(id_usuario);
        llenarTablaVenta();
    }//GEN-LAST:event_btnGenerateActionPerformed
    NotasCredito nc;    Multipago mp;
    private void btnMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiActionPerformed
        
        mp = new Multipago();
        mp.cred = id_usuario;
        mp.setCoordinador(miCoordinador);                
        mp.setSize(650, 500);
        escritorio.add(mp).setLocation(25, 3);
        //Inicio.escritorio.add(mp).setLocation(300, 30);
            mp.show();
        
    }//GEN-LAST:event_btnMultiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeuda;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnMulti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbProducts;
    private javax.swing.JTable tbSale;
    // End of variables declaration//GEN-END:variables
}
