/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.Conectarse;
import Modelo.Render;
import Modelo.VentaVo;
import java.awt.Color;
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
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
public class Ventas extends javax.swing.JInternalFrame {
    
 int state = 1;   
 DefaultTableModel modelo = new DefaultTableModel(){
 public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
 };
 DefaultTableModel modelo2 = new DefaultTableModel(){
 public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
 };
      String[] columnas = {"ID Venta","ID Cliente","Cliente","Subtotal","Total","Fecha","Tipo"};
  String[] columnas2 = {"Cod. Artículo","Artículo","Color","Talla","Precio","Cantidad"};
      private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
//        llenarTablaVenta();
       
        
    }
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    /**
     * Creates new form Ventas
     */
    public Ventas() {
      
        initComponents();
        tbSale.setDefaultRenderer(Object.class, new Render());
       // setLocationRelativeTo(null);        // Centering on screen...
        //setSize(1280, 800); 
        modelo.setColumnIdentifiers(columnas);
        tbSale.setModel(modelo);
        modelo2.setColumnIdentifiers(columnas2);
        tbProducts.setModel(modelo2);
        dcFecha.setDate(new Date());
    }
public void llenarTablaVenta(String fecha, String fecha2){
    
     ArrayList<VentaVo> venta = miCoordinador.obtenerVentas(fecha,fecha2);
      if(venta.size()>0){
          modelo.setColumnIdentifiers(columnas);
     for(int i = 0; i<venta.size();i++){
modelo.addRow(new Object[] {venta.get(i).getId_sale(),venta.get(i).getId_user(),venta.get(i).getFirstname()+" "+
        venta.get(i).getLastname(),venta.get(i).getSubtotal(),venta.get(i).getTotal(),
venta.get(i).getDate(),venta.get(i).getCredito()});
}
      //Asignamos los datos del Modelo a la tabla
      
      tbSale.setModel(modelo);
      tbSale.getColumnModel().getColumn(6).setMaxWidth(0);
        tbSale.getColumnModel().getColumn(6).setMinWidth(0);
        tbSale.getColumnModel().getColumn(6).setPreferredWidth(0);
        tbSale.getColumnModel().getColumn(6).setResizable(false);
}else{
            JOptionPane.showMessageDialog(null, "No se encontraron ventas");
      }}

public void llenarTablaVentaSinCliente(String fecha){
     ArrayList<VentaVo> venta = miCoordinador.ventasSinCliente(fecha);
      if(venta.size()>0){
          String[] columnas3 = {"ID Venta","Subtotal","Total","Fecha"};
    modelo.setColumnIdentifiers(columnas3);
    
     for(int i = 0; i<venta.size();i++){
modelo.addRow(new Object[] {venta.get(i).getId_sale(),
    venta.get(i).getSubtotal(),venta.get(i).getTotal(),
venta.get(i).getDate()});
}
      //Asignamos los datos del Modelo a la tabla
      tbSale.setModel(modelo);
      }
      else{
              JOptionPane.showMessageDialog(null, "No se encontraron ventas");
      }
}
    
public void llenarTablaProducto(int sale){
modelo2.setColumnIdentifiers(columnas2);
limpiarTabla(tbProducts);
ArrayList<BagVo> listado = miCoordinador.obtenerProductosVenta(sale);

for(int i =0; i<listado.size();i++){
modelo2.addRow(new Object[] {listado.get(i).getArt(),listado.get(i).getArt_name(),listado.get(i).getColor_name(),
listado.get(i).getSize_name(),listado.get(i).getPrice(),listado.get(i).getQuantity()});
}
tbProducts.setModel(modelo2);
}

public void llenarVentaOnline(){
modelo.setColumnIdentifiers(columnas);
limpiarTabla(tbProducts);
ArrayList<VentaVo> venta = miCoordinador.getSalesOnline();

for(int i =0; i<venta.size();i++){
modelo.addRow(new Object[] {venta.get(i).getId_sale(),venta.get(i).getId_user(),venta.get(i).getFirstname()+" "+
        venta.get(i).getLastname(),venta.get(i).getSubtotal(),venta.get(i).getTotal(),venta.get(i).getDate()});
}
tbSale.setModel(modelo);
}
 
public void llenarTablaProductoOnline(int sale){
modelo2.setColumnIdentifiers(columnas2);
limpiarTabla(tbProducts);
ArrayList<BagVo> listado = miCoordinador.getProductsSaleOnline(sale);

for(int i =0; i<listado.size();i++){
modelo2.addRow(new Object[] {listado.get(i).getArt(),listado.get(i).getArt_name(),listado.get(i).getColor_name(),
listado.get(i).getSize_name(),listado.get(i).getPrice(),listado.get(i).getQuantity()});
}
tbProducts.setModel(modelo2);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSale = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnOnline = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSale = new javax.swing.JTextField();
        btnOnline1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        panelFecha = new javax.swing.JPanel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnSale = new javax.swing.JButton();
        btnCorte = new javax.swing.JButton();
        btnSinRegistro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dc2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(890, 696));

        jPanel3.setBackground(new java.awt.Color(237, 237, 237));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 65, 92));

        tbSale.setBackground(new java.awt.Color(237, 237, 237));
        tbSale.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbSale.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
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
        tbSale.setGridColor(new java.awt.Color(204, 204, 204));
        tbSale.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbSale.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbSaleMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSaleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSale);

        jPanel5.setBackground(new java.awt.Color(1, 129, 176));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Buscar por fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnOnline.setBackground(new java.awt.Color(0, 37, 145));
        btnOnline.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnOnline.setForeground(new java.awt.Color(255, 255, 255));
        btnOnline.setText("En Línea");
        btnOnline.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnlineActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Mostrar las Ventas en línea:");

        txtSale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaleKeyTyped(evt);
            }
        });

        btnOnline1.setBackground(new java.awt.Color(0, 37, 145));
        btnOnline1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnOnline1.setForeground(new java.awt.Color(255, 255, 255));
        btnOnline1.setText("Buscar");
        btnOnline1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnline1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Buscar Venta:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOnline))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSale, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOnline1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnOnline, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOnline1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        panelFecha.setBackground(new java.awt.Color(1, 129, 176));
        panelFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Buscar por fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
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

        btnCorte.setBackground(new java.awt.Color(0, 37, 145));
        btnCorte.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnCorte.setForeground(new java.awt.Color(255, 255, 255));
        btnCorte.setText("Corte de caja");
        btnCorte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorteActionPerformed(evt);
            }
        });

        btnSinRegistro.setBackground(new java.awt.Color(0, 37, 145));
        btnSinRegistro.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSinRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnSinRegistro.setText("Sin Registrar");
        btnSinRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinRegistroActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Buscar ventas del día");

        jLabel5.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Buscar ventas de clientes no registrados");

        jLabel9.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Realizar corte de caja");

        dc2.setDateFormatString("yyyy-MM-dd");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Fin:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Inicio:");

        javax.swing.GroupLayout panelFechaLayout = new javax.swing.GroupLayout(panelFecha);
        panelFecha.setLayout(panelFechaLayout);
        panelFechaLayout.setHorizontalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSinRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnCorte, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelFechaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelFechaLayout.setVerticalGroup(
            panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnSinRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(12, Short.MAX_VALUE))
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
        jLabel1.setText("Productos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(111, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSinRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinRegistroActionPerformed
        String formato = "yyyy-MM-dd";
        Date date = dcFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        String   fecha = sdf.format(date);

        llenarTablaVentaSinCliente(fecha);
    }//GEN-LAST:event_btnSinRegistroActionPerformed

    private void btnCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorteActionPerformed

        Conectarse con = new Conectarse();
        Connection conn = (Connection) con.getConn();
        //Formato
        String formato = "yyyy-MM-dd";
        Date date = dcFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        String   fecha = sdf.format(date);

        try {

            //System.out.println(sdf.format(date));
            JasperReport reporte = null;
            String path = "src/Reportes/CorteCaja.jasper";
            //Filtro de parametros
            Map parametro = new HashMap();
            //nombre del parametro
            parametro.put("fecha",sdf.format(date));

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte,parametro,conn);

            JasperViewer view = new JasperViewer(jprint,false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnCorteActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        String formato = "yyyy-MM-dd";
        Date date = dcFecha.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        Date date2 = dc2.getDate();
        
        String fecha = sdf.format(date);
        String f2 = sdf.format(date2);
        llenarTablaVenta(fecha,f2);
        state=1;

    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnOnline1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnline1ActionPerformed
        btnOnline1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if(!txtSale.getText().isEmpty()){
            int id = Integer.parseInt(txtSale.getText());
            VentaVo venta = miCoordinador.getSalesOnlineId(id);
            if(venta.getId_sale()!=0){
                limpiarTabla(tbSale);
                modelo.addRow(new Object[] {venta.getId_sale(),venta.getId_user(),venta.getFirstname()+" "+
                    venta.getLastname(),venta.getSubtotal(),venta.getTotal(),venta.getDate()});

            tbSale.setModel(modelo);
            state=2;

        }
        else{
            JOptionPane.showMessageDialog(null, "No se encontrÃ³ la venta solicitada");
        }
        }
        btnOnline1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnOnline1ActionPerformed

    private void txtSaleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaleKeyTyped
        char c=evt.getKeyChar();
        int ascii = (int)c;
        if(ascii<48 || ascii>57) {
            getToolkit().beep();

            evt.consume();

        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtSaleKeyTyped

    private void btnOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnlineActionPerformed

        limpiarTabla(tbSale);
        btnOnline.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        llenarVentaOnline();// TODO add your handling code here:
        state=2;
        btnOnline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnOnlineActionPerformed

    private void tbSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseClicked

    }//GEN-LAST:event_tbSaleMouseClicked

    private void tbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbProductsMouseClicked

    private void tbSaleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSaleMouseReleased
        int fila = tbSale.getSelectedRow();

        if ((fila > -1) && state==1){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProducto(aux);
        }

        else if ((fila > -1) && state==2){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProductoOnline(aux);
        }
    }//GEN-LAST:event_tbSaleMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCorte;
    private javax.swing.JButton btnOnline;
    private javax.swing.JButton btnOnline1;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnSinRegistro;
    private com.toedter.calendar.JDateChooser dc2;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelFecha;
    private javax.swing.JTable tbProducts;
    private javax.swing.JTable tbSale;
    private javax.swing.JTextField txtSale;
    // End of variables declaration//GEN-END:variables
}
