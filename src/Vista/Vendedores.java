package Vista;

import Controlador.Coordinador;
import Modelo.ColorVo;
import Modelo.SystemVo;
import Modelo.VentaVo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author luism
 */
public class Vendedores extends javax.swing.JInternalFrame {

    private Coordinador miCoordinador;
    private int seleccion1;
    private int seleccion2;
    DefaultTableModel modelo = new DefaultTableModel() {

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

    };
    
    DefaultTableModel modelo2 = new DefaultTableModel() {
  public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        } };
    
    String[] columnas = {"ID", "Usuario", "Nombre", "Apellidos"};
    String[] columnas2 = {"ID", "Vendedor", "Ventas", "Total"};

    JFreeChart Grafica;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();

    public Vendedores() {
        initComponents();

    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    private void limpiarTable() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    private void limpiarTable2() {
        while (modelo2.getRowCount() > 0) {
            modelo2.removeRow(0);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        btnBuscar2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVendedores = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        comboOpt = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        date2 = new com.toedter.calendar.JDateChooser();
        btnBuscar3 = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboOpt2 = new javax.swing.JComboBox<>();
        date3 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date4 = new com.toedter.calendar.JDateChooser();
        btnBuscar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráficas por usuario"));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Día", "Mes", "Año", "Período", "" }));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Usuario:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Fecha inicio:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Fecha fin:");

        btnBuscar2.setBackground(new java.awt.Color(0, 37, 145));
        btnBuscar2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscar2.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar2.setText("Graficar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar2)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 65, 92));

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        btnBuscar.setBackground(new java.awt.Color(0, 37, 145));
        btnBuscar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGenerar.setBackground(new java.awt.Color(0, 37, 145));
        btnGenerar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        tbVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "ID", "Usuario", "Nombre", "Apellidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVendedores);
        if (tbVendedores.getColumnModel().getColumnCount() > 0) {
            tbVendedores.getColumnModel().getColumn(0).setResizable(false);
            tbVendedores.getColumnModel().getColumn(1).setResizable(false);
            tbVendedores.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel5.setBackground(new java.awt.Color(1, 129, 176));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Graficas por usuario"));

        comboOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Dia", "Mes", "Año", "Periodo venta", "Periodo total" }));
        comboOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOptActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Usuario:");

        lbId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        date1.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Fecha inicio:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Fecha fin:");

        date2.setEnabled(false);

        btnBuscar3.setBackground(new java.awt.Color(0, 37, 145));
        btnBuscar3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscar3.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar3.setText("Graficar");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });

        lbName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar3))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(comboOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(1, 129, 176));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ventas generales"));

        comboOpt2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Dia", "Mes", "Año", "Periodo" }));
        comboOpt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOpt2ActionPerformed(evt);
            }
        });

        date3.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Fecha inicio:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Fecha fin:");

        date4.setEnabled(false);

        btnBuscar1.setBackground(new java.awt.Color(0, 37, 145));
        btnBuscar1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar1.setText("Generar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(comboOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnBuscar1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(date4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        limpiarTable();
        ArrayList<SystemVo> vendedores = miCoordinador.getListVendedores();

        modelo.setColumnIdentifiers(columnas);

        for (int j = 0; j < vendedores.size(); j++) {
            modelo.addRow(new Object[]{vendedores.get(j).getId_user(), vendedores.get(j).getUser(), vendedores.get(j).getNombre(), vendedores.get(j).getApellidos()});
        }

        tbVendedores.setModel(modelo);

        /*
        Datos.addValue(1, "Negocio 1", "Lunes");
Datos.addValue(2, "Negocio 1", "Martes");
Datos.addValue(3, "Negocio 1", "MiÃ©rcoles");
Datos.addValue(4, "Negocio 1", "Jueves");
Datos.addValue(5, "Negocio 1", "Viernes");
Datos.addValue(6, "Negocio 1", "SÃ¡bado");
Datos.addValue(7, "Negocio 1", "Domingo");

Grafica = ChartFactory.createBarChart("Visitas diarias","DÃ­as", "Visitas", Datos,PlotOrientation.VERTICAL, true, true, false);

ChartPanel Panel = new ChartPanel(Grafica);
JFrame Ventana = new JFrame("Ventas");
Ventana.getContentPane().add(Panel);
Ventana.pack();
Ventana.setVisible(true);
Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         */
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limpiarTable();

        String nombre = txtName.getText();
        ArrayList<SystemVo> vendedor = miCoordinador.getVendedoresNombre(nombre);
        modelo.setColumnIdentifiers(columnas);

        for (int i = 0; i < vendedor.size(); i++) {
            modelo.addRow(new Object[]{vendedor.get(i).getId_user(), vendedor.get(i).getUser(), vendedor.get(i).getNombre(), vendedor.get(i).getApellidos()});
        }

        tbVendedores.setModel(modelo);


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
   int aux = seleccion2;
        //System.out.println(seleccion1);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatomes = new SimpleDateFormat("MM");
        SimpleDateFormat formatoa = new SimpleDateFormat("yyyy");
        ArrayList<VentaVo> ventas;
        
        switch (aux) {
            case 1:
            limpiarTable2();
                String Fecha = formato.format(date3.getDate());
                ventas = miCoordinador.getSalesGeneralDia(Fecha);

              modelo2.setColumnIdentifiers(columnas2);

        for (int i = 0; i < ventas.size(); i++) {
            modelo2.addRow(new Object[]{ventas.get(i).getId_vendedor(),ventas.get(i).getVendedor(),ventas.get(i).getOnline(),ventas.get(i).getTotal()});
        }
        

        tbVentas.setModel(modelo2);
break;
            case 2:
            limpiarTable2();
                int mes = Integer.parseInt(formatomes.format(date3.getDate()));
                int a = Integer.parseInt(formatoa.format(date3.getDate()));
                ventas = miCoordinador.getSalesGeneralMes(mes, a);

              modelo2.setColumnIdentifiers(columnas2);

        for (int i = 0; i < ventas.size(); i++) {
            modelo2.addRow(new Object[]{ventas.get(i).getId_vendedor(),ventas.get(i).getVendedor(),ventas.get(i).getOnline(),ventas.get(i).getTotal()});
        }    
            tbVentas.setModel(modelo2);    
                break;

            case 3:
                limpiarTable2();
                int year = Integer.parseInt(formatoa.format(date3.getDate()));
                ventas = miCoordinador.getSalesGeneralYear(year);

              modelo2.setColumnIdentifiers(columnas2);

        for (int i = 0; i < ventas.size(); i++) {
            modelo2.addRow(new Object[]{ventas.get(i).getId_vendedor(),ventas.get(i).getVendedor(),ventas.get(i).getOnline(),ventas.get(i).getTotal()});
        }    
            tbVentas.setModel(modelo2); 
                break;
            case 4:
                limpiarTable2();
                String Fecha1 = formato.format(date3.getDate());
                String Fecha2 = formato.format(date4.getDate());
                ventas = miCoordinador.getSalesGeneralPeriodo(Fecha1, Fecha2); 

              modelo2.setColumnIdentifiers(columnas2);

        for (int i = 0; i < ventas.size(); i++) {
            modelo2.addRow(new Object[]{ventas.get(i).getId_vendedor(),ventas.get(i).getVendedor(),ventas.get(i).getOnline(),ventas.get(i).getTotal()});
        }
        

        tbVentas.setModel(modelo2);
                break;
            case 5:
                break;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
        int aux = seleccion1;
        //System.out.println(seleccion1);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatomes = new SimpleDateFormat("MM");
        SimpleDateFormat formatoa = new SimpleDateFormat("yyyy");
        ArrayList<VentaVo> ventas;
        int id = Integer.parseInt(lbId.getText());
        switch (aux) {
            case 1:
                Datos.clear();
                String Fecha = formato.format(date1.getDate());
                ventas = miCoordinador.getSalesVendedorDia(id, Fecha);

                for (int i = 0; i < ventas.size(); i++) {
                    Datos.addValue(ventas.get(i).getTotal(), ventas.get(i).getDate(), "");
                }
                Grafica = ChartFactory.createBarChart("Ventas del dÃ­a", "Ventas", "Totales", Datos, PlotOrientation.VERTICAL, true, true, false);

                break;
            case 2:
                Datos.clear();
                int Fecha2 = Integer.parseInt(formatomes.format(date1.getDate()));
                int Fecha3 = Integer.parseInt(formatoa.format(date1.getDate()));
                ventas = miCoordinador.getSalesVendedorMes(id, Fecha2, Fecha3);

                for (int i = 0; i < ventas.size(); i++) {
                    Datos.addValue(ventas.get(i).getTotal(), ventas.get(i).getDate(), "");
                }
                Grafica = ChartFactory.createBarChart("Ventas del mes", "Ventas", "Totales", Datos, PlotOrientation.VERTICAL, true, true, false);
                break;

            case 3:
                Datos.clear();
                int year = Integer.parseInt(formatoa.format(date1.getDate()));
                ventas = miCoordinador.getSalesVendedorYear(id, year);

                for (int i = 0; i < ventas.size(); i++) {
                    Datos.addValue(ventas.get(i).getTotal(), ventas.get(i).getDate(), "");
                }
                Grafica = ChartFactory.createBarChart("Ventas del aÃ±o", "Ventas", "Totales", Datos, PlotOrientation.VERTICAL, true, true, false);

                break;
            case 4:
                Datos.clear();
                String inicio = formato.format(date1.getDate());
                String fin = formato.format(date2.getDate());
                
                ventas = miCoordinador.getSalesVendedorPeriodoVenta(id, inicio, fin);

                for (int i = 0; i < ventas.size(); i++) {
                    Datos.addValue(ventas.get(i).getTotal(), ventas.get(i).getDate(), "");

                }
                Grafica = ChartFactory.createBarChart("Ventas registradas", "Ventas", "Totales", Datos, PlotOrientation.VERTICAL, true, true, false);
                break;
            case 5:
                Datos.clear();
                String ini = formato.format(date1.getDate());
                String fina = formato.format(date2.getDate());
                ventas = miCoordinador.getSalesVendedorPeriodoTotal(id, ini, fina);
                
                for (int i = 0; i < ventas.size(); i++) {
                    Datos.addValue(ventas.get(i).getTotal(), ventas.get(i).getDate(), "");

                }
                Grafica = ChartFactory.createBarChart("Ventas registradas", "Ventas", "Totales", Datos, PlotOrientation.VERTICAL, true, true, false);
                
                break;
        }
        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("Ventas");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);

        Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_btnBuscar3ActionPerformed

    private void tbVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVendedoresMouseClicked
        int fila = tbVendedores.getSelectedRow();

        if (fila > -1) {
            int id = (int) tbVendedores.getValueAt(fila, 0);
            String nombre = (String) tbVendedores.getValueAt(fila, 2) + " " + (String) tbVendedores.getValueAt(fila, 3);
            lbId.setText(Integer.toString(id));
            lbName.setText(nombre);
        }
    }//GEN-LAST:event_tbVendedoresMouseClicked

    private void comboOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOptActionPerformed
        int aux = comboOpt.getSelectedIndex();

        switch (aux) {
            case 1:
                date1.setEnabled(true);
                date2.setEnabled(false);
                seleccion1 = 1;
                break;
            case 2:
                date1.setEnabled(true);
                date2.setEnabled(false);
                seleccion1 = 2;
                break;
            case 3:
                date1.setEnabled(true);
                date2.setEnabled(false);
                seleccion1 = 3;
                break;
            case 4:
                date1.setEnabled(true);
                date2.setEnabled(true);
                seleccion1 = 4;
                break;
            case 5:
                date1.setEnabled(true);
                date2.setEnabled(true);
                seleccion1 = 5;
                break;
        }
    }//GEN-LAST:event_comboOptActionPerformed

    private void comboOpt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOpt2ActionPerformed
         int aux = comboOpt2.getSelectedIndex();

        switch (aux) {
            case 1:
                date3.setEnabled(true);
                date4.setEnabled(false);
                seleccion2 = 1;
                break;
            case 2:
                date3.setEnabled(true);
                date4.setEnabled(false);
                seleccion2 = 2;
                break;
            case 3:
                date3.setEnabled(true);
                date4.setEnabled(false);
                seleccion2 = 3;
                break;
            case 4:
                date3.setEnabled(true);
                date4.setEnabled(true);
                seleccion2 = 4;
                break;
            case 5:
                date3.setEnabled(true);
                date4.setEnabled(true);
                seleccion2 = 5;
                break;
        }
    }//GEN-LAST:event_comboOpt2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> comboOpt;
    private javax.swing.JComboBox<String> comboOpt2;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private com.toedter.calendar.JDateChooser date3;
    private com.toedter.calendar.JDateChooser date4;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbName;
    private javax.swing.JTable tbVendedores;
    private javax.swing.JTable tbVentas;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
