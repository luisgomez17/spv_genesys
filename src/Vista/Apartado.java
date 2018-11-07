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

/**
 *
 * @author luism
 */
public class Apartado extends javax.swing.JInternalFrame {

    private Coordinador miCoordinador;

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    String[] columnas = {"Cliente", "Articulo", "Color", "Talla", "Cantidad", "Precio", "Registro", "Vencimiento", " Estado","Abono"};
    TableRowSorter trs;

    public String vendedor;
    public int id_vendedor;
    public int id_venta;

    ArrayList<ApartadoVo> lista = new ArrayList<>();

    public Apartado() {
        initComponents();
        
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;      
        getApartado();
        actualizarEstado();
    }

    public void actualizarEstado(){
        Date actual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
            Date aux;
            try {
                for (int i = 0; i < lista.size(); i++) {
            String fecha = lista.get(i).getPlazo();
            aux = sdf.parse(fecha);
                    if( aux.before(actual)){
            miCoordinador.updateEstado(lista.get(i));
            }
                }
            } catch (ParseException ex) {
                Logger.getLogger(Apartado.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiarTabla(tbApart);
            getApartado();
            }
    
    
    public void getApartado() {
        lista.clear();
        lista = miCoordinador.getProductsApartado();
        if (lista.size() > 0) {
            modelo.setColumnIdentifiers(columnas);
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{lista.get(i).getNombre() + " " + lista.get(i).getApellidos(), lista.get(i).getArticulo(), lista.get(i).getColor(),
                    lista.get(i).getTalla(), lista.get(i).getAmount(), lista.get(i).getPrecio(), lista.get(i).getRegistro(), lista.get(i).getPlazo(), lista.get(i).getEstado(), lista.get(i).getAbono()});
            }
            //Asignamos los datos del Modelo a la tabla
            tbApart.setModel(modelo);
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
        lista.clear();
        lista = miCoordinador.getApartadoFecha(f1, f2);
        if (lista.size() > 0) {
            modelo.setColumnIdentifiers(columnas);
            for (int i = 0; i < lista.size(); i++) {
                modelo.addRow(new Object[]{lista.get(i).getNombre() + " " + lista.get(i).getApellidos(), lista.get(i).getArticulo(), lista.get(i).getColor(),
                    lista.get(i).getTalla(), lista.get(i).getAmount(), lista.get(i).getPrecio(), lista.get(i).getRegistro(), lista.get(i).getPlazo(), lista.get(i).getEstado(),
                    lista.get(i).getAbono()});
            }
            //Asignamos los datos del Modelo a la tabla
            tbApart.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron articulos apartados");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dc1 = new com.toedter.calendar.JDateChooser();
        dc2 = new com.toedter.calendar.JDateChooser();
        btnFind = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        btnRecoger = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnAbono = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
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

        jLabel8.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Estado");

        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Baghdad", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Nombre del cliente:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E", "V", "P" }));
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        btnRecoger.setBackground(new java.awt.Color(0, 37, 145));
        btnRecoger.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnRecoger.setForeground(new java.awt.Color(255, 255, 255));
        btnRecoger.setText("Recoger");
        btnRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecogerActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(0, 37, 145));
        btnQuitar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAbono.setBackground(new java.awt.Color(0, 37, 145));
        btnAbono.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAbono.setForeground(new java.awt.Color(255, 255, 255));
        btnAbono.setText("Abonar");
        btnAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonoActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRecoger)
                .addGap(18, 18, 18)
                .addComponent(btnQuitar)
                .addGap(18, 18, 18)
                .addComponent(btnAbono)
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
                            .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecoger, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tbApart.setBackground(new java.awt.Color(237, 237, 237));
        tbApart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbApart.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbApart.setModel(new javax.swing.table.DefaultTableModel(
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
                "Cliente", "Articulo", "Color", "Talla", "Cantidad", "Registro", "Vencimiento", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        jScrollPane1.setViewportView(tbApart);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbApartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbApartMouseClicked

    }//GEN-LAST:event_tbApartMouseClicked

    private void tbApartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbApartMouseReleased
        int fila = tbApart.getSelectedRow();
        /*
        if ((fila > -1) && state==1){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProducto(aux);
        }

        else if ((fila > -1) && state==2){
            int aux = (int) modelo.getValueAt(fila, 0);
            llenarTablaProductoOnline(aux);
        }*/
    }//GEN-LAST:event_tbApartMouseReleased

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String formato = "yyyy-MM-dd";
        Date date = dc1.getDate();
        Date date2 = dc2.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        String fecha = sdf.format(date);
        String fecha2 = sdf.format(date2);

        limpiarTabla(tbApart);
        getApartadoFecha(fecha, fecha2);
        //llenarTablaVenta(fecha);
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
        txtCliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtCliente.getText(), 0));
            }
        });
        trs = new TableRowSorter(modelo);
        tbApart.setRowSorter(trs);
    }//GEN-LAST:event_txtClienteKeyTyped

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed

    }//GEN-LAST:event_cbEstadoActionPerformed

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        String estado = cbEstado.getSelectedItem().toString();

        trs = new TableRowSorter(modelo);
        tbApart.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(estado, 8));
    }//GEN-LAST:event_cbEstadoItemStateChanged
    DetalleVenta dv;
    private void btnRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecogerActionPerformed
        int fila = tbApart.getSelectedRow();
        //DetalleVenta venta = new DetalleVenta(); 

        if ((fila > -1)) {
            if (estacerrado(dv)) {
                dv = new DetalleVenta();

                BagVo art = new BagVo();
                int id = lista.get(fila).getId_cliente();

                art.setArt(lista.get(fila).getArt());
                art.setColor_art(lista.get(fila).getColor_art());
                art.setId_size(lista.get(fila).getId_size());
                art.setQuantity(lista.get(fila).getAmount());
                art.setArt_name(lista.get(fila).getArticulo());
                art.setColor_name(lista.get(fila).getColor());
                art.setSize_name(lista.get(fila).getTalla());
                art.setPrice(lista.get(fila).getPrecio());
                art.setImporte(lista.get(fila).getPrecio() * lista.get(fila).getAmount());
                art.setSrc("");
                art.setId_user(id_vendedor);
                art.setId_sale(id_venta);
                

                miCoordinador.getDetalle().id_usuario = id;
                miCoordinador.getDetalle().bag.add(art);
                dv.txtCliente.setText(lista.get(fila).getNombre() + " " + lista.get(fila).getApellidos());
                dv.txtVendedor.setText(vendedor);
                dv.lbIdVendedor.setText(Integer.toString(id_vendedor));
                dv.id_venta = id_venta;
                miCoordinador.getDetalle().btnCredit.setEnabled(true);

                miCoordinador.getDetalle().aprt.add(lista.get(fila));

                dv.setCoordinador(miCoordinador);
                escritorio.add(dv).setLocation(25, 3);
                dv.show();

                try {
                    dv.setMaximum(true);

                    // TODO add your handling code here:
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            /*
                
                miCoordinador.getDetalle().txtCliente.setText(cliente);
                miCoordinador.getDetalle().txtDireccion.setText(direccion);
                miCoordinador.getDetalle().txtMonedero.setText(Double.toString(electronico));
                miCoordinador.getDetalle().btnCredit.setEnabled(true);

                dispose(); */
        }
    }//GEN-LAST:event_btnRecogerActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuitarActionPerformed
Abonos a;
    private void btnAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonoActionPerformed
int seleccion = tbApart.getSelectedRow();
        double abono;
        if (seleccion >= 0) {
            ApartadoVo auxiliar = new ApartadoVo();
            VentaVo abonos = new VentaVo();
            
            String valor = JOptionPane.showInputDialog(null, "Registre el abono que desee ingresar");
            
            if (valor.isEmpty() || valor == null ) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
            } else {
                abono = Double.parseDouble(valor) + (double) tbApart.getValueAt(seleccion, 9);
                if ( abono <= lista.get(seleccion).getPrecio()) {
                    

                    auxiliar.setAbono(abono);
                    auxiliar.setId_apatado(lista.get(seleccion).getId_apatado());
                    auxiliar.setRegistro(lista.get(seleccion).getRegistro());
                    
                    abonos.setId_sale(lista.get(seleccion).getId_apatado());
                    abonos.setId_user(lista.get(seleccion).getId_cliente());
                    abonos.setTotal(Double.parseDouble(valor));
                    
                    a = new Abonos();
                    a.ap = auxiliar;
                    a.abn = abonos;
                    a.estado = 2;
                    a.setCoordinador(miCoordinador);                
                    a.setSize(500, 450);
                    escritorio.add(a).setLocation(25, 3);        
                    a.show();
                    
                    
                    limpiarTabla(tbApart);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta pendiente");
        }
    }//GEN-LAST:event_btnAbonoActionPerformed

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
    private javax.swing.JButton btnAbono;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRecoger;
    private javax.swing.JComboBox<String> cbEstado;
    private com.toedter.calendar.JDateChooser dc1;
    private com.toedter.calendar.JDateChooser dc2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbApart;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
