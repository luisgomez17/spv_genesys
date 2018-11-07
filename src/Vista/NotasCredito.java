package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.NotaVo;
import Modelo.ProductoVo;
import Modelo.UsuarioVo;
import Modelo.VentaVo;
import static Vista.Inicio.escritorio;
import static Vista.Usuarios.tbUsers;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author luism
 */
public class NotasCredito extends javax.swing.JInternalFrame {

    public int id_venta;
    public int id_user;
    private Coordinador miCoordinador;

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    String[] columnas = {"Num. Venta", "Saldo", "Fecha"};

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        llenarDatosTabla(id_user);
        asignarTamano();
        nomCliente(id_user);
        
    }

    public NotasCredito() {
        initComponents();
        jPanel2.setVisible(false);
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

    public void nomCliente(int id) {
        UsuarioVo cliente = new UsuarioVo();
        cliente = miCoordinador.buscarUsuario(id);
        lbCliente.setText(cliente.getFirstname() + " " + cliente.getLastname());

    }
    ArrayList<NotaVo> listado;

    public void llenarDatosTabla(int id) {
        modelo.setColumnIdentifiers(columnas);

        listado = miCoordinador.getNotas(id);

        for (int i = 0; i < listado.size(); i++) {
            modelo.addRow(new Object[]{listado.get(i).getId_venta(), listado.get(i).getSaldo(), listado.get(i).getFecha()});
        }
        tbNotas.setModel(modelo);
    }

    public void asignarTamano() {
        tbNotas.getColumnModel().getColumn(0).setPreferredWidth(60);
        tbNotas.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbNotas.getColumnModel().getColumn(2).setPreferredWidth(100);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dc1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dc2 = new com.toedter.calendar.JDateChooser();
        btnSalir1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCambio = new javax.swing.JButton();
        btnDevolucion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNotas = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 65, 92));
        setClosable(true);
        setTitle("Notas Credito");

        jPanel3.setBackground(new java.awt.Color(0, 65, 92));

        jPanel1.setBackground(new java.awt.Color(1, 129, 176));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente:");

        lbCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCliente.setForeground(new java.awt.Color(240, 240, 240));
        lbCliente.setText(" ");

        jLabel3.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Notas");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha inicio:");

        dc1.setDateFormatString("yyyy-MM-dd");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha fin:");

        dc2.setDateFormatString("yyyy-MM-dd");

        btnSalir1.setBackground(new java.awt.Color(0, 37, 145));
        btnSalir1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSalir1.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir1.setText("Buscar");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCliente)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        btnCambio.setBackground(new java.awt.Color(0, 37, 145));
        btnCambio.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnCambio.setForeground(new java.awt.Color(255, 255, 255));
        btnCambio.setText("Cambiar");
        btnCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCambio.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        btnDevolucion.setBackground(new java.awt.Color(0, 37, 145));
        btnDevolucion.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolucion.setText("Devolver");
        btnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 37, 145));
        btnSalir.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDevolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tbNotas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbNotas.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbNotas.setGridColor(new java.awt.Color(204, 204, 204));
        tbNotas.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbNotas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbNotas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNotasMouseClicked(evt);
            }
        });
        tbNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbNotasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbNotas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNotasMouseClicked

    }//GEN-LAST:event_tbNotasMouseClicked
    cambiarProducto cambio;
    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        /*
        int fila = tbNotas.getSelectedRow();
ArrayList<BagVo> listado = miCoordinador.getProductsCreditOnline(id_venta);


if(fila>-1){
        cambio = new cambiarProducto();
        cambio.id_bag =listado.get(tbNotas.getSelectedRow()).getId_bag();
        System.out.println(listado.get(tbNotas.getSelectedRow()).getId_bag());
        cambio.id_venta = Integer.parseInt(lbCompra.getText());
        System.out.println(Integer.parseInt(lbCompra.getText()));
        cambio.id_user = id_user;
        cambio.total = Double.parseDouble(lbTotal.getText());
        cambio.setCoordinador(miCoordinador);
            escritorio.add(cambio).setLocation(300,200);
            cambio.show();     
}
else{
JOptionPane.showMessageDialog(null, "Seleccione un producto de la lista");
}*/
    }//GEN-LAST:event_btnCambioActionPerformed

    private void btnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionActionPerformed
        /*
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de realizar esta devolución?", "Confirmación", JOptionPane.YES_NO_OPTION);
int fila = tbNotas.getSelectedRow();
ArrayList<BagVo> listado = miCoordinador.getProductsCreditOnline(id_venta);
ProductoVo tallas1 = new ProductoVo();
ProductoVo amount1 = new ProductoVo();
Double totalventa = Double.parseDouble(lbTotal.getText());    
VentaVo venta = new VentaVo();

if(fila>-1 && resp == JOptionPane.YES_OPTION){

int id_bag = listado.get(tbNotas.getSelectedRow()).getId_bag();
System.out.println(id_bag);

//Actualizar talla del producto +1
BagVo producto1 = miCoordinador.getBag(id_bag);

amount1 = miCoordinador.getAmountProducto(producto1.getArt(), producto1.getColor_art(), producto1.getId_size());
tallas1.setArt(producto1.getArt());
tallas1.setColor_art(producto1.getColor_art());
tallas1.setId_size(producto1.getId_size());
tallas1.setAmount(amount1.getAmount() + 1);
tallas1.setId_local(amount1.getId_local());

//Actualizar total de la venta
totalventa = totalventa - producto1.getPrice();
venta.setId_sale(id_venta);
venta.setId_user(id_user);
venta.setTotal(totalventa);

//Ejecutar consultas
miCoordinador.UpdateProductSizes(tallas1);
miCoordinador.pagarDeuda(venta);
miCoordinador.borrarBag(id_bag);
limpiarTabla(tbNotas);
llenarDatosTabla(id_venta);

//Cerrar
JOptionPane.showMessageDialog(null, "Transacción exitosa");
dispose();

}
else{
JOptionPane.showMessageDialog(null, "Elija un producto nuevamente o cancele");
}
         */
    }//GEN-LAST:event_btnDevolucionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
 String formato = "yyyy-MM-dd";
        Date date = dc1.getDate();
        Date date2 = dc2.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        String fecha = sdf.format(date);
        String fecha2 = sdf.format(date2);
        
        if(fecha.trim().isEmpty() || fecha2.trim().isEmpty() || fecha.length() == 0 || fecha2.length() == 0){
        JOptionPane.showMessageDialog(null, "Elija una fecha correcta");
        }
        else{
        listado = miCoordinador.getNotasFecha(id_user, fecha, fecha2);
        limpiarTabla(tbNotas);
        if(listado.size() > 0){
        for (int i = 0; i < listado.size(); i++) {
            modelo.addRow(new Object[]{listado.get(i).getId_venta(), listado.get(i).getSaldo(), listado.get(i).getFecha()});
        }
        tbNotas.setModel(modelo);}
        else{
        JOptionPane.showMessageDialog(null, "Sin resultados");
        }
        }       
// getNotasFecha();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void tbNotasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNotasKeyPressed
 if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = tbNotas.getSelectedRow();
            //DetalleVenta venta = new DetalleVenta(); 

            if ((fila > -1)) {
                int resp=JOptionPane.showConfirmDialog(null,"¿Estas seguro de utilizar esta nota?");
                
                if (JOptionPane.OK_OPTION == resp) {
                    miCoordinador.getDetalle().nota =listado.get(tbNotas.getSelectedRow());                    
                    String desc = Double.toString(listado.get(tbNotas.getSelectedRow()).getSaldo());
                    miCoordinador.getDetalle().lblDesc.setText(desc);
                    dispose();
                } 
                
                
                
                
                
            }
        }     
    }//GEN-LAST:event_tbNotasKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private com.toedter.calendar.JDateChooser dc1;
    private com.toedter.calendar.JDateChooser dc2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lbCliente;
    private javax.swing.JTable tbNotas;
    // End of variables declaration//GEN-END:variables
}
