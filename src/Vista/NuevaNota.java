package Vista;

import Controlador.Coordinador;
import Modelo.BagDao;
import Modelo.BagVo;
import Modelo.ColorVo;
import Modelo.CreditoVo;
import Modelo.NotaVo;
import Modelo.ProductoVo;
import Modelo.SystemVo;
import Modelo.TallaVo;
import Modelo.VentaVo;
import static Vista.Inicio.escritorio;
import static Vista.Usuarios.tbUsers;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyVetoException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class NuevaNota extends javax.swing.JInternalFrame {

    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm ");

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    String[] columnas = {"Codigo", "Articulo", "Color", "Talla", "Precio Unitario", "Cantidad", "Importe"};

    private Coordinador miCoordinador;

    public int local;

    DefaultComboBoxModel caja = new DefaultComboBoxModel();

    public int id_venta;

    public static VentaVo seleccion;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        asignarTamano();
        listarVendedores();
    }

    public void asignarTamano() {
        tbVenta.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbVenta.getColumnModel().getColumn(1).setPreferredWidth(250);
        tbVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbVenta.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbVenta.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbVenta.getColumnModel().getColumn(5).setPreferredWidth(20);
        tbVenta.getColumnModel().getColumn(6).setPreferredWidth(50);

    }

    public NuevaNota() {

        initComponents();
        modelo.setColumnIdentifiers(columnas);
        tbVenta.setModel(modelo);
        asignarTamano();
    }

    ArrayList<SystemVo> vendedores;

    public void listarVendedores() {
        caja.addElement("Seleccionar");
        vendedores = miCoordinador.getListVendedores();
        for (int i = 0; i < vendedores.size(); i++) {
            caja.addElement(vendedores.get(i).getNombre());
        }
        //Asignamos los datos del Modelo a la tabla
        cbVend.setModel(caja);

    }

    public static ArrayList<BagVo> productos;

    public void agregarProducto(int idsale) {

        productos = miCoordinador.obtenerProductosVenta(idsale);

        for (int i = 0; i < productos.size(); i++) {
            modelo.addRow(new Object[]{productos.get(i).getArt(), productos.get(i).getArt_name(), productos.get(i).getColor_name(),
                productos.get(i).getSize_name(), productos.get(i).getPrice(), productos.get(i).getQuantity(), productos.get(i).getImporte()
            });
        }
        //Asignamos los datos del Modelo a la tabla
        tbVenta.setModel(modelo);
        asignarTamano();
    }

    public void actualizarProducto() {

        for (int i = 0; i < productos.size(); i++) {
            modelo.addRow(new Object[]{productos.get(i).getArt(), productos.get(i).getArt_name(), productos.get(i).getColor_name(),
                productos.get(i).getSize_name(), productos.get(i).getPrice(), productos.get(i).getQuantity(), productos.get(i).getImporte()
            });
        }
        //Asignamos los datos del Modelo a la tabla
        tbVenta.setModel(modelo);
        asignarTamano();
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

    public double calcularImporte(int cantidad, double precio) {

        double importe = 0;
        double cant = (double) cantidad;
        importe = cant * precio;

        return importe;
    }

    public void calcularTotal() {
        double total = 0;
        for (int i = 0; i < tbVenta.getRowCount(); i++) {
            total += (double) tbVenta.getValueAt(i, 4);
        }
        lblTotal.setText(Double.toString(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lblArt = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbVend = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1308, 774));

        jPanel1.setBackground(new java.awt.Color(0, 65, 92));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbVenta.setFont(new java.awt.Font("GT Walsheim Regular", 0, 11)); // NOI18N
        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Articulo", "Color", "Talla", "Precio Unitario", "Cantidad", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVenta.setRowHeight(30);
        tbVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVentaMouseClicked(evt);
            }
        });
        tbVenta.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tbVentaInputMethodTextChanged(evt);
            }
        });
        tbVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbVentaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tbVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(1, 129, 176));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblArt.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N

        lblPrecio.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        jButton1.setText("Nueva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("GT Walsheim Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total $");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("0.00");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        jButton3.setText("Recargar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lbCliente.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        lbCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCliente.setText(" ");

        jLabel3.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vendedor:");

        jLabel4.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cliente:");

        cbVend.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remover.png"))); // NOI18N
        jButton4.setText("Borrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnPagar.setBackground(new java.awt.Color(39, 174, 96));
        btnPagar.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Finalizar");
        btnPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(112, 112, 112)
                                    .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbVend, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbVend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel6.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nota de Crédito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbVentaKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_tbVentaKeyTyped

    private void tbVentaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbVentaInputMethodTextChanged

    }//GEN-LAST:event_tbVentaInputMethodTextChanged

    private void tbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVentaMouseClicked

    }//GEN-LAST:event_tbVentaMouseClicked
    Notas nota;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (estacerrado(nota)) {
            nota = new Notas();
            nota.setCoordinador(miCoordinador);
            nota.setSize(880, 650);
            escritorio.add(nota).setLocation(250, 0);
            nota.show();

        }
    }//GEN-LAST:event_jButton1ActionPerformed
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
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selec = tbVenta.getSelectedRow();
        if (selec > -1) {
            productos.remove(selec);
            limpiarTabla(tbVenta);
            actualizarProducto();
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un artículo de la lista.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        agregarProducto(seleccion.getId_sale());
        limpiarTabla(tbVenta);
        actualizarProducto();
        calcularTotal();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpiarTabla(tbVenta);
        productos.clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        NotaVo nota = new NotaVo();
        ProductoVo product = new ProductoVo();
        if (productos.size() > 0 && cbVend.getSelectedIndex() > -1 && seleccion.getId_user() > 1) {

            String[] options = {"Mantener nota", "Devolver dinero", "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(miCoordinador.getNn(), "Selecciona al menos una opción", "Nota de Crédito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (opcion) {
                case 0:
                    double total = seleccion.getTotal() - Double.parseDouble(lblTotal.getText());
                    seleccion.setTotal(total);

                    nota.setId_cliente(seleccion.getId_user());
                    nota.setId_venta(seleccion.getId_sale());
                    nota.setId_vendedor(vendedores.get(cbVend.getSelectedIndex()).getId_user());
                    nota.setSaldo(Double.parseDouble(lblTotal.getText()));
                    nota.setTipo(1);

                    miCoordinador.InsertNota(nota);
                    miCoordinador.updateTotalNota(seleccion);

                    for (int i = 0; i < productos.size(); i++) {

                        product.setArt(productos.get(i).getArt());
                        product.setColor_art(productos.get(i).getColor_art());
                        product.setId_size(productos.get(i).getId_size());
                        product.setId_local(local);

                        miCoordinador.UpdateSizesNota(product);
                        miCoordinador.borrarBag(productos.get(i).getId_bag());
                    }
                    /*
                    
                     */
                    limpiarTabla(tbVenta);
                    productos.clear();
                    JOptionPane.showMessageDialog(null, "Transacción exitosa");
                    break;
                case 1:
                    String[] metodos = {
                        "Efectivo"};

                    String resp = (String) JOptionPane.showInputDialog(miCoordinador.getNn(), "Seleccione un método de pago", "Devolución", JOptionPane.DEFAULT_OPTION, null, metodos, metodos[0]);
                
                    double total2 = seleccion.getTotal() - Double.parseDouble(lblTotal.getText()) ;                    
                    seleccion.setTotal(total2);
                    
                    nota.setId_cliente(seleccion.getId_user());
                    nota.setId_venta(seleccion.getId_sale());
                    nota.setId_vendedor(vendedores.get(cbVend.getSelectedIndex()-1).getId_user());                    
                    nota.setSaldo(Double.parseDouble(lblTotal.getText()));
                    nota.setTipo(2);
                    
                    miCoordinador.InsertNota(nota);
                    miCoordinador.updateTotalNota(seleccion);
                    
                    for(int i = 0 ; i < productos.size(); i++){
                                        
                    product.setArt(productos.get(i).getArt());
                    product.setColor_art(productos.get(i).getColor_art());
                    product.setId_size(productos.get(i).getId_size());
                    product.setId_local(local);
                    
                    miCoordinador.UpdateSizesNota(product);
                    miCoordinador.borrarBag(productos.get(i).getId_bag());                                        
                    }
                    /*
                    
*/  
                    limpiarTabla(tbVenta);
                    productos.clear();
                    JOptionPane.showMessageDialog(null, "Transacción exitosa");    
                    break;
                case 2:
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos necesarios", "Nota Crédito", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> cbVend;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblPrecio;
    public static javax.swing.JLabel lblTotal;
    private static javax.swing.JTable tbVenta;
    // End of variables declaration//GEN-END:variables
}
