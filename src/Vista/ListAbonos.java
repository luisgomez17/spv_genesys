/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.ApartadoVo;
import Modelo.BagVo;
import Modelo.VentaVo;
import static Vista.Inicio.escritorio;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListAbonos extends javax.swing.JInternalFrame {

    private Coordinador miCoordinador;

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }};
    
    DefaultTableModel modelo2 = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }};
    
    DefaultTableModel mdabonos = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }};
    String[] columnas = {"Nro. Venta", "Cliente", "Subtotal", "Total", "Fecha"};
    String[] columnas2 = {"Nro. Apartado", "Cliente", "Producto", "Color", "Talla","Precio","Fecha"};
    String[] columna = {"Abono", "Efectivo", "Credito", "Cheque", "Vale","Debito","Fecha"};
    TableRowSorter trs;

   int state;

    ArrayList<ApartadoVo> lista = new ArrayList<>();
    ArrayList<VentaVo> ventas = new ArrayList<>();

    public ListAbonos() {
        initComponents();        
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;              
    } 
    
    public void getVentasCredit(String f1, String f2) {
        limpiarTabla(tbApart);
        ventas = miCoordinador.getSalesCreditDate(f1, f2);
        if (ventas.size() > 0) {
            modelo.setColumnIdentifiers(columnas);
            for (int i = 0; i < ventas.size(); i++) {
                modelo.addRow(new Object[]{ventas.get(i).getId_sale(),ventas.get(i).getFirstname() + " " + ventas.get(i).getLastname(),
                ventas.get(i).getSubtotal(), ventas.get(i).getTotal(), ventas.get(i).getDate()});
            }
            tbApart.setModel(modelo);
            state = 1;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron articulos apartados");
        }
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

    public void getApartadoFecha(String f1, String f2) { 
        limpiarTabla(tbApart);
        lista = miCoordinador.getApartadoFecha(f1, f2);
        if (lista.size() > 0) {
            modelo2.setColumnIdentifiers(columnas2);
            for (int i = 0; i < lista.size(); i++) {
                modelo2.addRow(new Object[]{lista.get(i).getId_apatado(),lista.get(i).getNombre() + " " + lista.get(i).getApellidos(), lista.get(i).getArticulo(), lista.get(i).getColor(),
                    lista.get(i).getTalla(), lista.get(i).getPrecio(), lista.get(i).getRegistro()});
            }
            //Asignamos los datos del Modelo a la tabla
            tbApart.setModel(modelo2);
            state = 2;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron articulos apartados");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dc1 = new com.toedter.calendar.JDateChooser();
        dc2 = new com.toedter.calendar.JDateChooser();
        btnFind = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbCre = new javax.swing.JRadioButton();
        rbApar = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAbn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbApart = new javax.swing.JTable();

        setClosable(true);
        setTitle("Sistema de Apartado");

        jPanel1.setBackground(new java.awt.Color(0, 65, 92));

        jPanel5.setBackground(new java.awt.Color(1, 129, 176));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Inicio:");

        jLabel7.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Fin:");

        dc1.setDateFormatString("yyyy-MM-dd");

        dc2.setDateFormatString("yyyy-MM-dd");

        btnFind.setBackground(new java.awt.Color(0, 37, 145));
        btnFind.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setText("Buscar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Nombre del cliente:");

        buttonGroup1.add(rbCre);
        rbCre.setText("Credito");

        buttonGroup1.add(rbApar);
        rbApar.setText("Apartado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dc1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(dc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbApar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbCre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbCre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbApar)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tbAbn.setBackground(new java.awt.Color(237, 237, 237));
        tbAbn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbAbn.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbAbn.setModel(new javax.swing.table.DefaultTableModel(
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
                "Abono", "Fecha", "Efectivo", "Credito", "Cheque", "Vale", "Debito", "Terminación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAbn.setGridColor(new java.awt.Color(204, 204, 204));
        tbAbn.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbAbn.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbAbn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAbnMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbAbnMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbAbn);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Abonos");

        tbApart.setBackground(new java.awt.Color(237, 237, 237));
        tbApart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbApart.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbApart.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nro. Venta", "Cliente", "Subtotal", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbApart.setToolTipText("");
        tbApart.setGridColor(new java.awt.Color(204, 204, 204));
        tbApart.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbApart.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbApart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbApartMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbApartMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbApart);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbAbnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAbnMouseClicked

    }//GEN-LAST:event_tbAbnMouseClicked

    private void tbAbnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAbnMouseReleased
        int fila = tbAbn.getSelectedRow();
        /*
        if ((fila > -1) && state==1){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProducto(aux);
        }

        else if ((fila > -1) && state==2){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProductoOnline(aux);
        }*/
    }//GEN-LAST:event_tbAbnMouseReleased

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String formato = "yyyy-MM-dd";
        Date date = dc1.getDate();
        Date date2 = dc2.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        String fecha = sdf.format(date);
        String fecha2 = sdf.format(date2);

        if(rbCre.isSelected()){        
        getVentasCredit(fecha,fecha2);
        }
        else if(rbApar.isSelected()){
        getApartadoFecha(fecha,fecha2);
        }
        
        
        //llenarTablaVenta(fecha);
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
        txtCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtCliente.getText(), 1));
            }
        });
        trs = new TableRowSorter(modelo);
        tbApart.setRowSorter(trs);
    }//GEN-LAST:event_txtClienteKeyTyped
    
    private void tbApartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbApartMouseClicked
        int fila = tbApart.getSelectedRow();
        
        if ((fila > -1) && state==1){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarAbonosCredito(aux);
        }

        else if ((fila > -1) && state==2){
            int aux = (int) modelo2.getValueAt(fila, 0);            
            llenarAbonosApt(aux);
        }
        
    }//GEN-LAST:event_tbApartMouseClicked
    
    
    
    public void llenarAbonosCredito(int aux){
        limpiarTabla(tbAbn);
       ArrayList<VentaVo> abonos = miCoordinador.getAbonos(aux);
        if (abonos.size() > 0) {
            mdabonos.setColumnIdentifiers(columna);
            for (int i = 0; i < abonos.size(); i++) {
            mdabonos.addRow(new Object[]{abonos.get(i).getTotal(), abonos.get(i).getEfectivo(),
            abonos.get(i).getCredit(),abonos.get(i).getCheques(),abonos.get(i).getVales(), abonos.get(i).getTarjeta(),abonos.get(i).getDate()});
            }
            tbAbn.setModel(mdabonos);
            
        } else {
            
        }
    }
    
    public void llenarAbonosApt(int venta){
    limpiarTabla(tbAbn);
        ArrayList<VentaVo>abonos = miCoordinador.getAbonosApt(venta);
        if (abonos.size() > 0) {
            mdabonos.setColumnIdentifiers(columna);
            for (int i = 0; i < abonos.size(); i++) {
            mdabonos.addRow(new Object[]{abonos.get(i).getTotal(), abonos.get(i).getEfectivo(),
            abonos.get(i).getCredit(),abonos.get(i).getCheques(),abonos.get(i).getVales(), abonos.get(i).getTarjeta(),abonos.get(i).getDate()});
            }
            tbAbn.setModel(mdabonos);
            
        } else {
            
        }
    }
    
    private void tbApartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbApartMouseReleased
   
    }//GEN-LAST:event_tbApartMouseReleased
Abonos a;
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
    private javax.swing.JButton btnFind;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dc1;
    private com.toedter.calendar.JDateChooser dc2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbApar;
    private javax.swing.JRadioButton rbCre;
    private javax.swing.JTable tbAbn;
    private javax.swing.JTable tbApart;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
