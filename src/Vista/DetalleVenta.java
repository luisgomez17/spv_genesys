/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.ApartadoVo;
import Modelo.BagDao;
import Modelo.BagVo;
import Modelo.ColorVo;
import Modelo.CreditoVo;
import Modelo.NotaVo;
import Modelo.ProductoVo;
import Modelo.TallaVo;
import Modelo.VentaVo;
import static Vista.Usuarios.tbUsers;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyVetoException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author bryan
 */
public class DetalleVenta extends javax.swing.JInternalFrame {

    DefaultComboBoxModel modeloTalla;
    DefaultComboBoxModel modeloColor;
    private ArrayList<ColorVo> colores;

    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm ");

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };
    String[] columnas = {"Codigo", "Articulo", "Color", "Talla", "Precio Unitario", "Cantidad", "Importe"};

    private Coordinador miCoordinador;

    public static ArrayList<BagVo> bag = new ArrayList<BagVo>();

    public static NotaVo nota = new NotaVo();

    public static int id_usuario = 1;

    public static boolean concretado;

    public int id_venta;
    
    public static ArrayList<ApartadoVo> aprt = new ArrayList<>();

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        asignarTamano();
        txtCode.requestFocus();
        agregarProducto();
        calcularTotal();
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

    public DetalleVenta() {

        initComponents();
        txtFecha.setText(hourdateFormat.format(date));
        modelo.setColumnIdentifiers(columnas);
        tbVenta.setModel(modelo);
    }

    public void limpiarCamposProducto() {
        txtCode.setText("");
        lblArt.setText("");
        lblPrecio.setText("");
    }

    public void limpiarCamposVenta() {
        txtVendedor.setText("");
        txtCliente.setText("");
        txtDireccion.setText("");
        txtMonedero.setText("");
    }

    public  void agregarProducto() {

        //Ciclo para llenar tabla de productos
        for (int i = 0; i < bag.size(); i++) {
            modelo.addRow(new Object[]{bag.get(i).getArt(), bag.get(i).getArt_name(), bag.get(i).getColor_name(),
                bag.get(i).getSize_name(), bag.get(i).getPrice(), bag.get(i).getQuantity(), bag.get(i).getImporte()
            });
        }
        //Asignamos los datos del Modelo a la tabla
        tbVenta.setModel(modelo);
    }

    private void limpiarTable() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
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
            total += (double) tbVenta.getValueAt(i, 6);
        }
        lblTotal3.setText(Double.toString(total));
        lblTotal.setText(Double.toString(total));
    }

    public int codigoArt(String art) {
        String codigo = art.trim();
        int cadena = 0;
        if (codigo.length() > 5) {
            cadena = Integer.parseInt(codigo.substring(2, 7));
        } else if (codigo.length() == 5) {
            cadena = Integer.parseInt(codigo);
        }
        System.out.print(cadena);
        return cadena;
    }

    public String codigoArtCadena(String art) {
        String codigo = art.trim();
        String cadena = "";
        if (codigo.length() > 5) {
            cadena = codigo.substring(2, 7);
        } else if (codigo.length() == 5) {
            cadena = codigo;
        }
        System.out.print(cadena);
        return cadena;
    }

    public double dineroElectronicoVenta(String total1, String porcen1) {
        Double obtenido = 0.0;
        Double total = Double.parseDouble(total1);
        Double porcen = Double.parseDouble(porcen1);

        obtenido = (total * porcen) / 100;

        obtenido = Math.round(100d * obtenido) / 100d;
        System.out.print(obtenido);
        return obtenido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblArt = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        comboColor = new javax.swing.JComboBox<>();
        txtBackColor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comboTalla = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        comboCant = new javax.swing.JComboBox<>();
        lblPrecio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnDescuento = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        btnCredit = new javax.swing.JButton();
        btnApartado = new javax.swing.JButton();
        btnNota = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTotal3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMonedero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtVendedor = new javax.swing.JTextField();
        txtPorcen = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbIdVendedor = new javax.swing.JLabel();
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

        jLabel8.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Codigo:");

        txtCode.setBackground(new java.awt.Color(242, 242, 242));
        txtCode.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        lblBuscar.setBackground(new java.awt.Color(255, 255, 255));
        lblBuscar.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/busqueda.png"))); // NOI18N
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBuscarMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Articulo:");

        lblArt.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        lblArt.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Color:");

        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColorActionPerformed(evt);
            }
        });

        txtBackColor.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Talla:");

        comboTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        comboTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTallaActionPerformed(evt);
            }
        });
        comboTalla.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboTallaPropertyChange(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cantidad:");

        comboCant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        lblPrecio.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Precio  $");

        jButton2.setBackground(new java.awt.Color(41, 128, 185));
        jButton2.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(192, 57, 43));
        jButton3.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Eliminar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDescuento.setBackground(new java.awt.Color(211, 84, 0));
        btnDescuento.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        btnDescuento.setForeground(new java.awt.Color(255, 255, 255));
        btnDescuento.setText("Descuento");
        btnDescuento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoActionPerformed(evt);
            }
        });

        btnPagar.setBackground(new java.awt.Color(39, 174, 96));
        btnPagar.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnCredit.setBackground(new java.awt.Color(39, 174, 96));
        btnCredit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCredit.setForeground(new java.awt.Color(255, 255, 255));
        btnCredit.setText("Crédito");
        btnCredit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCredit.setEnabled(false);
        btnCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditActionPerformed(evt);
            }
        });

        btnApartado.setBackground(new java.awt.Color(255, 102, 51));
        btnApartado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnApartado.setForeground(new java.awt.Color(255, 255, 255));
        btnApartado.setText("Apartado");
        btnApartado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApartadoActionPerformed(evt);
            }
        });

        btnNota.setBackground(new java.awt.Color(102, 51, 0));
        btnNota.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNota.setForeground(new java.awt.Color(255, 255, 255));
        btnNota.setText("Nota Crédito");
        btnNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNota, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblBuscar))
                                    .addComponent(comboTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboCant, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(12, 12, 12)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(346, 346, 346))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblArt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApartado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNota, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel3.setBackground(new java.awt.Color(1, 129, 176));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Descuento:");

        lblTotal3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal3.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal3.setText("0.00");

        jLabel4.setFont(new java.awt.Font("GT Walsheim Bold", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total $");

        jLabel5.setFont(new java.awt.Font("GT Walsheim Bold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Subtotal:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotal.setText("0.00");

        lblDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDesc.setForeground(new java.awt.Color(255, 255, 255));
        lblDesc.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblTotal)
                            .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTotal3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(1, 129, 176));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vendedor:");

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(242, 242, 242));
        txtFecha.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cliente:");

        jLabel15.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dirección:");

        txtCliente.setBackground(new java.awt.Color(242, 242, 242));
        txtCliente.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCliente.setText("Publico general");
        txtCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDireccion.setBackground(new java.awt.Color(242, 242, 242));
        txtDireccion.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Monedero:");

        txtMonedero.setEditable(false);
        txtMonedero.setBackground(new java.awt.Color(242, 242, 242));
        txtMonedero.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtMonedero.setText("0.0");
        txtMonedero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconDollar.png"))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(41, 128, 185));
        btnBuscar.setFont(new java.awt.Font("GT Walsheim Bold", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtVendedor.setEditable(false);
        txtVendedor.setBackground(new java.awt.Color(242, 242, 242));
        txtVendedor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPorcen.setBackground(new java.awt.Color(242, 242, 242));
        txtPorcen.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtPorcen.setText("0");
        txtPorcen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPorcen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcenActionPerformed(evt);
            }
        });
        txtPorcen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcenKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Porcentaje:");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconPercentage.png"))); // NOI18N

        lbIdVendedor.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(txtVendedor))
                .addGap(111, 111, 111)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPorcen)
                    .addComponent(txtMonedero))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lbIdVendedor))
                            .addComponent(jLabel17)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMonedero)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPorcen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel6.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Realizar Venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPorcenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcenKeyTyped
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

        }
        if (txtPorcen.getText().length() > 2) {
            getToolkit().beep();

            evt.consume();

        }

        // &&
    }//GEN-LAST:event_txtPorcenKeyTyped

    private void txtPorcenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcenActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Vista.Usuarios us = new Usuarios();
        us.setCoordinador(miCoordinador);
        Inicio.escritorio.add(us).setLocation(25, 3);
        us.show();
        try {
            us.setMaximum(true);

            // TODO add your handling code here:
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void tbVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbVentaKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_tbVentaKeyTyped

    private void tbVentaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbVentaInputMethodTextChanged

    }//GEN-LAST:event_tbVentaInputMethodTextChanged

    private void tbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVentaMouseClicked

    }//GEN-LAST:event_tbVentaMouseClicked

    public void aplicarDesc(double desc) {
        double total = Double.parseDouble(lblTotal.getText());
        double resp = total - desc;
        if (resp < 0) {
            lblTotal3.setText("0.00");
        } else if (resp > 0) {
            lblTotal3.setText(Double.toString(resp));
        }
    }

    private void btnCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditActionPerformed
        VentaVo credito = new VentaVo();

        BagVo aux = new BagVo();
        for (int t = 0; t < bag.size(); t++) {
            aux.setId_user(bag.get(t).getId_user());
            aux.setArt(bag.get(t).getArt());
            aux.setArt_name(bag.get(t).getArt_name());
            aux.setColor_art(bag.get(t).getColor_art());
            aux.setColor_name(bag.get(t).getColor_name());
            aux.setId_size(bag.get(t).getId_size());
            aux.setSize_name(bag.get(t).getSize_name());
            aux.setSrc(bag.get(t).getSrc());
            aux.setPrice(bag.get(t).getPrice());
            aux.setQuantity(bag.get(t).getQuantity());
            aux.setId_sale(bag.get(t).getId_sale());
            miCoordinador.InsertBag(aux);
        }

        ArrayList<ProductoVo> registro = new ArrayList<>();

        for (int c = 0; c < bag.size(); c++) {
            ProductoVo aux1 = new ProductoVo();

            aux1.setAmount(bag.get(c).getQuantity());
            aux1.setArt(bag.get(c).getArt());
            aux1.setColor_art(bag.get(c).getColor_art());
            aux1.setId_size(bag.get(c).getId_size());

            registro.add(aux1);

        }
        Double totalcompra = Double.valueOf(lblTotal3.getText());
        totalcompra = (totalcompra * 0.1) + totalcompra;
        int confirmado = JOptionPane.showConfirmDialog(null,
                "Su pago total es de:" + " " + totalcompra + " " + "¿Desea dar un adelanto?");

        switch (confirmado) {
            case 0:
                String adelanto = JOptionPane.showInputDialog(null, "Adelanto $$", JOptionPane.QUESTION_MESSAGE);

                if (totalcompra >= Double.parseDouble(adelanto)) {
                    double total = totalcompra - Double.parseDouble(adelanto);

                    credito.setId_user(id_usuario);
                    credito.setSubtotal(Double.parseDouble(lblTotal3.getText()));
                    credito.setShip(0);
                    credito.setTotal(total);
                    credito.setCredito(1);
                    credito.setId_vendedor(Integer.parseInt(lbIdVendedor.getText()));
                    credito.setVendedor(txtVendedor.getText());
                    credito.setId_sale(id_venta);
                    if (credito.getId_user() != 0) {
                        miCoordinador.ingresarCredito(credito);

                        for (int v = 0; v < registro.size(); v++) {
                            miCoordinador.UpdateProductSizesSales(registro.get(v));
                        }
                        JOptionPane.showMessageDialog(null, "Operación realizada correctamente");

                        limpiarTable();
                        limpiarCamposVenta();
                        lblTotal3.setText("0.00");
                        bag.clear();

                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione un usuario válido");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida, menor al total");
                }

                break;

            case 1:

                Double totalcompra1 = Double.valueOf(lblTotal3.getText());
                totalcompra1 = (totalcompra1 * 0.1) + totalcompra1;
                credito.setId_user(id_usuario);
                credito.setSubtotal(Double.parseDouble(lblTotal3.getText()));
                credito.setShip(0);
                credito.setTotal(totalcompra1);
                credito.setCredito(1);
                credito.setId_vendedor(Integer.parseInt(lbIdVendedor.getText()));
                credito.setVendedor(txtVendedor.getText());
                credito.setId_sale(id_venta);

                if (credito.getId_user() != 0) {
                    miCoordinador.ingresarCredito(credito);
                    for (int v = 0; v < registro.size(); v++) {
                        miCoordinador.UpdateProductSizesSales(registro.get(v));
                    }
                    JOptionPane.showMessageDialog(null, "Operación realizada correctamente");

                    limpiarTable();
                    limpiarCamposVenta();
                    lblTotal3.setText("0.00");
                    bag.clear();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un usuario válido");
                }

                break;
            case 2:
                System.out.println("Cancelado");
                break;
        }
    }//GEN-LAST:event_btnCreditActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (comboColor.getSelectedIndex() > -1 && comboTalla.getSelectedIndex() > -1) {
            String codigo = txtCode.getText();
            codigo = codigo.replaceAll(" ", "");
            if (codigo.length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un articulo valido", "Venta", JOptionPane.WARNING_MESSAGE);
            } else {
                agregarBolsa();
                limpiarCamposProducto();
                limpiarTable();
                agregarProducto();
                calcularTotal();
                aplicarDesc(Double.parseDouble(lblDesc.getText()));
                //calcularImporte();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        aplicarDesc(Double.parseDouble(lblDesc.getText()));
        if (bag.size() > 0 && Double.parseDouble(lblTotal.getText()) > 0) {
            BagVo aux = new BagVo();
            for (int t = 0; t < bag.size(); t++) {
                aux.setId_user(bag.get(t).getId_user());
                aux.setArt(bag.get(t).getArt());
                aux.setArt_name(bag.get(t).getArt_name());
                aux.setColor_art(bag.get(t).getColor_art());
                aux.setColor_name(bag.get(t).getColor_name());
                aux.setId_size(bag.get(t).getId_size());
                aux.setSize_name(bag.get(t).getSize_name());
                aux.setPrice(bag.get(t).getPrice());
                aux.setQuantity(bag.get(t).getQuantity());
                aux.setId_sale(bag.get(t).getId_sale());
                //   miCoordinador.InsertBag(aux);
            }

            ArrayList<ProductoVo> registro = new ArrayList<>();

            for (int c = 0; c < bag.size(); c++) {
                ProductoVo aux1 = new ProductoVo();

                aux1.setAmount(bag.get(c).getQuantity());
                aux1.setArt(bag.get(c).getArt());
                aux1.setColor_art(bag.get(c).getColor_art());
                aux1.setId_size(bag.get(c).getId_size());

                registro.add(aux1);

            }

            Vista.Total total = new Total();
            total.setCoordinador(miCoordinador);

            total.dineroelectronico = dineroElectronicoVenta(lblTotal3.getText(), txtPorcen.getText());

            total.bolsa = (ArrayList) bag.clone();
            total.product = (ArrayList) registro.clone();
            total.lblCliente.setText(txtCliente.getText());
            total.lblVendedor.setText(txtVendedor.getText());
            total.lblPagar.setText(lblTotal3.getText());
            total.lblDinero.setText(txtMonedero.getText());
            total.comprador.setId_user(id_usuario);
            total.venta.setId_user(id_usuario);
            total.venta.setId_vendedor(Integer.parseInt(lbIdVendedor.getText()));
            total.venta.setVendedor(txtVendedor.getText());
            total.venta.setId_sale(id_venta);
            total.ticket.setNro_ticket(miCoordinador.obtenerSiguienteId());
            total.ticket.setTotal(Double.parseDouble(lblTotal3.getText()));
            total.notados = nota;
            total.aprt = (ArrayList) aprt.clone();
            if (!txtCliente.getText().equals("")) {
                total.ticket.setCliente(txtCliente.getText());
            } else {
                total.ticket.setCliente("Publico general");
            }
            total.ticket.setVendedor(txtVendedor.getText());
            //miCoordinador.getTotal().setVisible(true);
            miCoordinador.getTotal().venta.setSubtotal(Double.parseDouble(lblTotal3.getText()));

            Inicio.escritorio.add(total).setLocation(300, 30);
            total.show();

            limpiarTable();
            limpiarCamposVenta();
            lblTotal3.setText("0.00");
            txtPorcen.setText("0");
            btnCredit.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese articulos a la venta", "Venta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoActionPerformed

        int seleccion = tbVenta.getSelectedRow();

        if (seleccion >= 0) {
            double importe = (double) tbVenta.getValueAt(seleccion, 6);

            String descuento;
            descuento = JOptionPane.showInputDialog(null, "Registre el nuevo costo");
            if (descuento.isEmpty() || !descuento.matches("[0-9]*") || Double.parseDouble(descuento) > importe) {
                JOptionPane.showMessageDialog(null, "Ingresa una cantidad valida");

            } else {

                bag.get(seleccion).setImporte(Double.valueOf(descuento));

                limpiarTable();
                agregarProducto();
                calcularTotal();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla");
        }
    }//GEN-LAST:event_btnDescuentoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int seleccion = tbVenta.getSelectedRow();
        bag.remove(seleccion);
        limpiarTable();
        agregarProducto();
        calcularTotal();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lblBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMousePressed

    }//GEN-LAST:event_lblBuscarMousePressed

    public void llenarComboTalla(String art, String color) {

        ArrayList<TallaVo> talla = miCoordinador.getTallasColor(art, color);

        if (talla.size() > 0) {
            modeloTalla = new DefaultComboBoxModel();
            modeloTalla.addElement("Seleccionar...");

            for (int i = 0; i < talla.size(); i++) {
                modeloTalla.addElement(talla.get(i).getSize_name());
            }
            comboTalla.setModel(modeloTalla);
        }
    }
    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked

        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        String codigo = txtCode.getText().trim();

        ProductoVo articulo = miCoordinador.getProductoCodigo(codigo);

        if (articulo.getArt_name() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese un codigo válido", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lblArt.setText(articulo.getArt_name());

            lblPrecio.setText(Double.toString(articulo.getPrice()));

            ColorVo color = miCoordinador.buscarColor(articulo.getColor_art());
            modeloColor = new DefaultComboBoxModel();
            modeloColor.addElement(color.getColor_name());
            comboColor.setModel(modeloColor);

            TallaVo talla = miCoordinador.getTalla(articulo.getId_size());
            modeloTalla = new DefaultComboBoxModel();
            modeloTalla.addElement(talla.getSize_name());
            comboTalla.setModel(modeloTalla);

        }
        /*
        ArrayList<ColorVo> color = miCoordinador.getColorsArt(codigoArtCadena(txtCode.getText()));
        if(color.isEmpty()){
            JOptionPane.showMessageDialog(null,"Ingrese un codigo válido","ERROR",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
           
            
            String [] medidas = new String[color.size()];

            if(color.size()>0 ){
                modeloColor = new DefaultComboBoxModel();
        modeloColor.addElement("Seleccionar...");

            for (int i = 0; i < color.size(); i++) {
                modeloColor.addElement(color.get(i).getColor_name());
            }
            
            comboColor.setModel(modeloColor);
                
            }
            else{
                JOptionPane.showMessageDialog(null,"No cuenta con colores registrados","Inventario",JOptionPane.INFORMATION_MESSAGE);
            }
            
             
            
           
ProductoVo product = miCoordinador.getDetallesProducto(codigoArtCadena(txtCode.getText().trim()));
          
  lblArt.setText(product.getArt_name());
  lblPrecio.setText(Double.toString(product.getPrice()));
 
        }
         */

        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblBuscarMouseClicked

    private void comboColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColorActionPerformed
        ArrayList<ColorVo> color = miCoordinador.getColorsArt(codigoArtCadena(txtCode.getText()));

        llenarComboTalla(codigoArtCadena(txtCode.getText()), color.get(comboColor.getSelectedIndex()).getColor_art());

        // ArrayList <ColorVo> color = miCoordinador.obtenerColorProducto(codigoArtCadena(txtCode.getText()), medida.get(comboTalla.getSelectedIndex()).getId_size());
        System.out.println(color.get(comboColor.getSelectedIndex() - 1).getColor_art());

        if (color.size() > 0 && comboColor.getSelectedIndex() > 0) {
            Color col = Color.decode(color.get(comboColor.getSelectedIndex()).getColor_hex_code());
            setBackground(Color.WHITE);
            setForeground(col);

            if (isSelected) {
                setBackground(col);
                setForeground(Color.WHITE);
                txtBackColor.setBackground(col);
            }
        } else {
            setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_comboColorActionPerformed

    private void comboTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTallaActionPerformed
        // llenarComboColor(medida.get(comboTalla.getSelectedIndex()-1).getId_size());

    }//GEN-LAST:event_comboTallaActionPerformed

    private void comboTallaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboTallaPropertyChange

        // TODO add your handling code here:
    }//GEN-LAST:event_comboTallaPropertyChange

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
        char c = evt.getKeyChar();
        int ascii = (int) c;
        if (ascii < 48 || ascii > 57) {
            getToolkit().beep();

            evt.consume();

        }
    }//GEN-LAST:event_txtCodeKeyTyped

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    public Date sumarDiasAFecha(Date fecha, int dias) {
        if (dias == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private void btnApartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApartadoActionPerformed
        Date fechahora = new Date();
        Date da = sumarDiasAFecha(fechahora, 30);        
        String plazo = dateFormat.format(da);
        
        if (nota.getSaldo() > 0 && bag.size() <= 0 && id_usuario == 1) {
            JOptionPane.showMessageDialog(null, "Seleccione las opciones adecuadas para apartar productos", "Sistema de Apartado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Estas seguro de apartar estos productos?");

            if (JOptionPane.OK_OPTION == resp) {

                ArrayList<ProductoVo> registro = new ArrayList<>();

                for (int c = 0; c < bag.size(); c++) {
                    ProductoVo aux1 = new ProductoVo();
                    ApartadoVo pedido = new ApartadoVo();

                    aux1.setAmount(bag.get(c).getQuantity());
                    aux1.setArt(bag.get(c).getArt());
                    aux1.setColor_art(bag.get(c).getColor_art());
                    aux1.setId_size(bag.get(c).getId_size());
                    
                    pedido.setId_cliente(id_usuario);
                    pedido.setArt(bag.get(c).getArt());
                    pedido.setColor_art(bag.get(c).getColor_art());
                    pedido.setId_size(bag.get(c).getId_size());
                    pedido.setAmount(bag.get(c).getQuantity());
                    pedido.setPlazo(plazo);
                    pedido.setEstado("P");
                    pedido.setPrecio(bag.get(c).getPrice());
                    
                    //miCoordinador.UpdateProductSizesSales(aux1);
                    miCoordinador.insertApartado(pedido);
                                        
                }
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
                    bag.clear();
                    limpiarTable();
            limpiarCamposVenta();
            lblTotal3.setText("0.00");
            txtPorcen.setText("0");
            btnCredit.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnApartadoActionPerformed

    private void btnNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaActionPerformed
        if (id_usuario > 1) {
            Vista.NotasCredito us = new NotasCredito();
            us.id_user = id_usuario;
            us.setCoordinador(miCoordinador);
            Inicio.escritorio.add(us).setLocation(25, 3);
            us.show();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario válido", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnNotaActionPerformed

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked
       System.out.println( "Dinero Electronico"+" "+dineroElectronicoVenta(lblTotal3.getText(), txtPorcen.getText()));
    }//GEN-LAST:event_txtFechaMouseClicked

    public void agregarBolsa() {
        BagVo bagg = new BagVo();

        String codigo = txtCode.getText().trim();

        ProductoVo articulo = miCoordinador.getProductoCodigo(codigo);
        lblArt.setText(articulo.getArt_name());

        lblPrecio.setText(Double.toString(articulo.getPrice()));
        ColorVo color = miCoordinador.buscarColor(articulo.getColor_art());
        TallaVo talla = miCoordinador.getTalla(articulo.getId_size());

        int cantidad = Integer.parseInt((String) comboCant.getItemAt(comboCant.getSelectedIndex()));
        /*
        ArrayList<TallaVo> medida = miCoordinador.obtenerTallasProducto(codigoArtCadena(txtCode.getText()));
        ArrayList<ColorVo> color = miCoordinador.obtenerColorProducto(codigoArtCadena(txtCode.getText()), medida.get(comboTalla.getSelectedIndex()).getId_size());
        ProductoVo product = miCoordinador.getDetallesProductoColor(codigoArtCadena(txtCode.getText()), color.get(comboColor.getSelectedIndex()).getColor_art());
         */

        if (cantidad > 0 && articulo.getArt() != null) {

            bagg.setId_user(id_usuario);
            bagg.setArt(codigoArtCadena(txtCode.getText()));
            bagg.setArt_name(articulo.getArt_name());
            bagg.setColor_art(color.getColor_art());
            bagg.setColor_name(comboColor.getItemAt(comboColor.getSelectedIndex()));
            bagg.setId_size(talla.getId_size());
            bagg.setSize_name(comboTalla.getItemAt(comboTalla.getSelectedIndex()));
            bagg.setSrc(articulo.getSrc1());
            bagg.setPrice(articulo.getPrice());
            bagg.setQuantity(cantidad);
            bagg.setImporte(calcularImporte(cantidad, articulo.getPrice()));
            bagg.setId_sale(id_venta);

            bag.add(bagg);
        } else {
            JOptionPane.showMessageDialog(null, "No ha completado los campos necesarios", "Compra", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnApartado;
    public javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnCredit;
    private javax.swing.JButton btnDescuento;
    public static javax.swing.JButton btnNota;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> comboCant;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JComboBox<String> comboTalla;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbIdVendedor;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblBuscar;
    public static javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal3;
    private javax.swing.JTable tbVenta;
    private javax.swing.JTextField txtBackColor;
    public static javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCode;
    public static javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtMonedero;
    private javax.swing.JTextField txtPorcen;
    public javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
