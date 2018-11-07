
package Vista;

import Controlador.Coordinador;
import Modelo.BagVo;
import Modelo.ProductoVo;
import Modelo.VentaVo;
import static Vista.Inicio.escritorio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author luism
 */
public class Traspasos extends javax.swing.JInternalFrame {
 
private Coordinador miCoordinador;

DefaultTableModel modelo = new DefaultTableModel(){
 public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
String[] columnas = {"Codigo","Artículo","Color","Talla","Local","Destino"};

     public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;     
        llenarDatosTabla();
        asignarTamano();
    }
    public Traspasos() {
        
        initComponents();
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
    public void llenarDatosTabla(){
    modelo.setColumnIdentifiers(columnas);
    asignarTamano();
ArrayList<ProductoVo> listado = miCoordinador.getTransfer();

for(int i =0; i<listado.size();i++){
modelo.addRow(new Object[] {listado.get(i).getArt(),listado.get(i).getArt_name(),listado.get(i).getColor_name(),
listado.get(i).getSize_name(),listado.get(i).getSrc2(),listado.get(i).getSrc3()});
}
tbTraspaso.setModel(modelo);
    }
    
     public void asignarTamano(){
    tbTraspaso.getColumnModel().getColumn(0).setPreferredWidth(80);
    tbTraspaso.getColumnModel().getColumn(1).setPreferredWidth(350);
    tbTraspaso.getColumnModel().getColumn(2).setPreferredWidth(140);
    tbTraspaso.getColumnModel().getColumn(3).setPreferredWidth(140);
    tbTraspaso.getColumnModel().getColumn(4).setPreferredWidth(200);
    tbTraspaso.getColumnModel().getColumn(5).setPreferredWidth(200);
    
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCambio = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTraspaso = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 65, 92));
        setClosable(true);
        setTitle("Traspasos");

        jPanel1.setBackground(new java.awt.Color(1, 129, 176));

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        btnCambio.setBackground(new java.awt.Color(0, 37, 145));
        btnCambio.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnCambio.setForeground(new java.awt.Color(255, 255, 255));
        btnCambio.setText("Recoger");
        btnCambio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCambio.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
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
                    .addComponent(btnCambio)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbTraspaso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 129, 176), 1, true));
        tbTraspaso.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        tbTraspaso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbTraspaso.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbTraspaso.setGridColor(new java.awt.Color(204, 204, 204));
        tbTraspaso.setSelectionBackground(new java.awt.Color(253, 175, 200));
        tbTraspaso.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbTraspaso.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbTraspaso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTraspasoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbTraspaso);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbTraspasoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTraspasoMouseClicked

    }//GEN-LAST:event_tbTraspasoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
ArrayList<ProductoVo> lista = miCoordinador.getTransfer();
        int fila = tbTraspaso.getSelectedRow();

if(fila>-1){
//    System.out.println(lista.get(tbTraspaso.getSelectedRow()).getId_category()+" "+ lista.get(tbTraspaso.getSelectedRow()).getArt());
miCoordinador.UpdateTransfer(lista.get(tbTraspaso.getSelectedRow()));
limpiarTabla(tbTraspaso);
llenarDatosTabla();
}
    }//GEN-LAST:event_btnCambioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbTraspaso;
    // End of variables declaration//GEN-END:variables
}
