/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.Conectarse;
import Modelo.VentaVo;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luism
 */
public class Notas extends javax.swing.JInternalFrame {

    int state = 1;
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
    String[] columnas = {"Fecha", "Num. Venta", "Cliente", "Total"};
    String[] columnas2 = {"Cod. Artículo", "Artículo", "Color", "Talla", "Precio", "Cantidad"};
    private Coordinador miCoordinador;
    ArrayList<VentaVo> venta = new ArrayList<>();

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        llenarTablaVenta();
//        llenarTablaVenta();               
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

    public Notas() {
        initComponents();
        // setLocationRelativeTo(null);        // Centering on screen...
        //setSize(1280, 800); 
        modelo.setColumnIdentifiers(columnas);
        tbSale.setModel(modelo);
        modelo2.setColumnIdentifiers(columnas2);
        tbProducts.setModel(modelo2);
        dcFecha.setDate(new Date());
    }

    public void llenarTablaVenta() {
        venta.clear();
        venta = miCoordinador.getAllSales();
        if (venta.size() > 0) {
            modelo.setColumnIdentifiers(columnas);
            for (int i = 0; i < venta.size(); i++) {
                modelo.addRow(new Object[]{venta.get(i).getDate(),venta.get(i).getId_sale(),  venta.get(i).getFirstname() + " "
                    + venta.get(i).getLastname(),  venta.get(i).getTotal()});
            }
            //Asignamos los datos del Modelo a la tabla
            tbSale.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron ventas");
        }
    }

    public void llenarTablaVentaFechas(String f1, String f2) {
        venta.clear();
        venta = miCoordinador.getSalesDate(f1, f2);

        if (venta.size() > 0) {
            modelo.setColumnIdentifiers(columnas);
            for (int i = 0; i < venta.size(); i++) {
                modelo.addRow(new Object[]{venta.get(i).getDate(), venta.get(i).getId_sale(), venta.get(i).getFirstname() + " "
                    + venta.get(i).getLastname(), venta.get(i).getTotal()});
            }
            //Asignamos los datos del Modelo a la tabla
            tbSale.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron ventas");
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        panelFecha = new javax.swing.JPanel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnSale = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        dcFecha1 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Seleccionar Venta");
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(890, 696));

        jPanel4.setBackground(new java.awt.Color(0, 65, 92));

        tbSale.setBackground(new java.awt.Color(237, 237, 237));
        tbSale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbSale.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbSale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Num. Venta", "Cliente", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSale.setGridColor(new java.awt.Color(204, 204, 204));
        tbSale.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbSale.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbSaleMouseReleased(evt);
            }
        });
        tbSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbSaleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbSale);
        if (tbSale.getColumnModel().getColumnCount() > 0) {
            tbSale.getColumnModel().getColumn(0).setResizable(false);
            tbSale.getColumnModel().getColumn(1).setResizable(false);
            tbSale.getColumnModel().getColumn(2).setResizable(false);
            tbSale.getColumnModel().getColumn(3).setResizable(false);
        }

        panelFecha.setBackground(new java.awt.Color(1, 129, 176));
        panelFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        panelFecha.setToolTipText("");
        panelFecha.setName(""); // NOI18N

        dcFecha.setDateFormatString("yyyy-MM-dd");

        btnSale.setBackground(new java.awt.Color(0, 37, 145));
        btnSale.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSale.setForeground(new java.awt.Color(255, 255, 255));
        btnSale.setText("Buscar");
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Inicio:");

        jLabel5.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Fin:");

        jLabel9.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Buscar cliente:");

        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFindKeyTyped(evt);
            }
        });

        dcFecha1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout panelFechaLayout = new javax.swing.GroupLayout(panelFecha);
        panelFecha.setLayout(panelFechaLayout);
        panelFechaLayout.setHorizontalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFind)
                            .addGroup(panelFechaLayout.createSequentialGroup()
                                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelFechaLayout.setVerticalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tbProducts.setBackground(new java.awt.Color(237, 237, 237));
        tbProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbProducts.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane3.setViewportView(tbProducts);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Ventas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Productos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 476, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        String formato = "yyyy-MM-dd";
        Date date = dcFecha.getDate();
        Date date2 = dcFecha1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        String fecha = sdf.format(date);
        String fecha2 = sdf.format(date2);
        if (fecha.isEmpty() || fecha2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha correcta");
        } else {
            limpiarTabla(tbSale);
            llenarTablaVentaFechas(fecha, fecha2);
        }
    }//GEN-LAST:event_btnSaleActionPerformed

    private void tbSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseClicked
        int fila = tbSale.getSelectedRow();

        int valor = (int) tbSale.getValueAt(fila, 1);

        llenarTablaProducto(valor);


    }//GEN-LAST:event_tbSaleMouseClicked

    private void tbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductsMouseClicked

    }//GEN-LAST:event_tbProductsMouseClicked

    private void tbSaleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseReleased

    }//GEN-LAST:event_tbSaleMouseReleased
    TableRowSorter trs;
    private void txtFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyTyped
        txtFind.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFind.getText(), 2));
            }
        });
        trs = new TableRowSorter(modelo);
        tbSale.setRowSorter(trs);

    }//GEN-LAST:event_txtFindKeyTyped

    private void tbSaleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbSaleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = tbSale.getSelectedRow();

            if ((fila > -1)) {
                VentaVo select = new VentaVo();
                select = venta.get(fila);

                miCoordinador.getNn().lblTotal.setText(Double.toString(select.getTotal()));
                miCoordinador.getNn().lbCliente.setText(select.getFirstname() + " " + select.getLastname());
                miCoordinador.getNn().seleccion = select;
                miCoordinador.getNn().agregarProducto(select.getId_sale());
                miCoordinador.getNn().productos = miCoordinador.obtenerProductosVenta(select.getId_sale()); ;
                dispose();
            }
        }
    }//GEN-LAST:event_tbSaleKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSale;
    private com.toedter.calendar.JDateChooser dcFecha;
    private com.toedter.calendar.JDateChooser dcFecha1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelFecha;
    private javax.swing.JTable tbProducts;
    private javax.swing.JTable tbSale;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
