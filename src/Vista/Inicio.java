package Vista;

import Controlador.Coordinador;
import Modelo.ConecRemoto;
import Modelo.HiloSync;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.UIManager;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Inicio extends javax.swing.JFrame {

    ConecRemoto remoto = new ConecRemoto();
    public int venta;
    public int local;
private Coordinador miCoordinador;
    private Dimension dim;
File documento = new File("src/Modelo/Consulta.txt");
    
public void setCoordinador(Coordinador miCoordinador) {
       this.miCoordinador = miCoordinador;
       venta = miCoordinador.getLastCompra();
       
    }

    public Inicio() {
        //this.setResizable(false);
        initComponents();   
       this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
    }

    public void adminOpciones(){
    addProduct.setEnabled(true);
    updateProduct.setEnabled(true);
    apartado.setEnabled(true);
    
    itemViewColor.setEnabled(true);
    itemAddColor.setEnabled(true);
    
    listClientes.setEnabled(true);
    addCliente.setEnabled(true);
    addVendedor.setEnabled(true);
    listVende.setEnabled(true);
    
    itemVenta.setEnabled(true);
    listSales.setEnabled(true);
    itemCredit.setEnabled(true);
    nt.setEnabled(true);
    
    report.setEnabled(true);
    
    invenTienda.setEnabled(true);
    trass.setEnabled(true);
    }
    
    public void userOpciones(){
    addProduct.setEnabled(true);
    updateProduct.setEnabled(true);
    apartado.setEnabled(true);
    
    itemViewColor.setEnabled(false);
    itemAddColor.setEnabled(false);
    
    listClientes.setEnabled(true);
    addCliente.setEnabled(true);
    addVendedor.setEnabled(false);
    listVende.setEnabled(false);
    
    itemVenta.setEnabled(true);
    listSales.setEnabled(false);
    itemCredit.setEnabled(false);
    nt.setEnabled(true);
    
    report.setEnabled(true);
    
    invenTienda.setEnabled(true);
    trass.setEnabled(true);
    }
    
    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = escritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        try{
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {                
                cerrado = false;                 
                activos[i].setIcon(false);
                 activos[i].toFront();
               // JOptionPane.showMessageDialog(this, "Otra ventana se encuentra \nya  abierta !!!", "Aviso", 0,
                 //e       new ImageIcon(getClass().getResource("/Imagenes/adver1.png")));
            }
            i++;}                                             
                
       
    }   catch (PropertyVetoException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
         return cerrado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/nuevaimagen.jpg"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProduct = new javax.swing.JMenu();
        addProduct = new javax.swing.JMenuItem();
        updateProduct = new javax.swing.JMenuItem();
        apartado = new javax.swing.JMenuItem();
        menuColors = new javax.swing.JMenu();
        itemViewColor = new javax.swing.JMenuItem();
        itemAddColor = new javax.swing.JMenuItem();
        menuUsers = new javax.swing.JMenu();
        listClientes = new javax.swing.JMenuItem();
        addCliente = new javax.swing.JMenuItem();
        addVendedor = new javax.swing.JMenuItem();
        listVende = new javax.swing.JMenuItem();
        menuSale = new javax.swing.JMenu();
        itemVenta = new javax.swing.JMenuItem();
        listSales = new javax.swing.JMenuItem();
        itemCredit = new javax.swing.JMenuItem();
        nt = new javax.swing.JMenuItem();
        abonos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        report = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        invenTienda = new javax.swing.JMenuItem();
        trass = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        escritorio.setBackground(new java.awt.Color(0, 65, 92));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        txtUsuario.setEditable(false);
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbId.setEnabled(false);
        lbId.setVisible(false);

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lbId, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(494, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setOpaque(false);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(263, 50));
        jMenuBar1.setRequestFocusEnabled(false);

        menuProduct.setBorder(null);
        menuProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_producto.png"))); // NOI18N
        menuProduct.setText("Productos");
        menuProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_add.png"))); // NOI18N
        addProduct.setText("Agregar nuevo");
        addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductMouseClicked(evt);
            }
        });
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        menuProduct.add(addProduct);

        updateProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_actualizar.png"))); // NOI18N
        updateProduct.setText("Actualizar producto");
        updateProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateProductMouseClicked(evt);
            }
        });
        updateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProductActionPerformed(evt);
            }
        });
        menuProduct.add(updateProduct);

        apartado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/apart.png"))); // NOI18N
        apartado.setText("Apartado");
        apartado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apartadoActionPerformed(evt);
            }
        });
        menuProduct.add(apartado);

        jMenuBar1.add(menuProduct);
        menuProduct.getAccessibleContext().setAccessibleDescription("");

        menuColors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_color.png"))); // NOI18N
        menuColors.setText("Colores");
        menuColors.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuColors.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemViewColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_colores.png"))); // NOI18N
        itemViewColor.setText("Ver Lista");
        itemViewColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemViewColorActionPerformed(evt);
            }
        });
        menuColors.add(itemViewColor);

        itemAddColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_addcolor.png"))); // NOI18N
        itemAddColor.setText("Agregar Color");
        itemAddColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddColorActionPerformed(evt);
            }
        });
        menuColors.add(itemAddColor);

        jMenuBar1.add(menuColors);

        menuUsers.setBorder(null);
        menuUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_usuario.png"))); // NOI18N
        menuUsers.setText("Usuarios");
        menuUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuUsers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        listClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_usuarios.png"))); // NOI18N
        listClientes.setText("Lista Clientes");
        listClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listClientesActionPerformed(evt);
            }
        });
        menuUsers.add(listClientes);

        addCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_agregar.png"))); // NOI18N
        addCliente.setText("Agregar Cliente");
        addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClienteActionPerformed(evt);
            }
        });
        menuUsers.add(addCliente);

        addVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_vendedor.png"))); // NOI18N
        addVendedor.setText("Agregar Vendedor");
        addVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVendedorActionPerformed(evt);
            }
        });
        menuUsers.add(addVendedor);

        listVende.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_list_vendedor.png"))); // NOI18N
        listVende.setText("Vendedores");
        listVende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listVendeActionPerformed(evt);
            }
        });
        menuUsers.add(listVende);

        jMenuBar1.add(menuUsers);

        menuSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_venta.png"))); // NOI18N
        menuSale.setText("Ventas");
        menuSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_pago.png"))); // NOI18N
        itemVenta.setText("Realizar Venta");
        itemVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVentaActionPerformed(evt);
            }
        });
        menuSale.add(itemVenta);

        listSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_ventas.png"))); // NOI18N
        listSales.setText("Lista de Ventas");
        listSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSalesActionPerformed(evt);
            }
        });
        menuSale.add(listSales);

        itemCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_credito.png"))); // NOI18N
        itemCredit.setText("Creditos");
        itemCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreditActionPerformed(evt);
            }
        });
        menuSale.add(itemCredit);

        nt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nota.png"))); // NOI18N
        nt.setText("Notas Crédito");
        nt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntActionPerformed(evt);
            }
        });
        menuSale.add(nt);

        abonos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abn.png"))); // NOI18N
        abonos.setText("Abonos");
        abonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonosActionPerformed(evt);
            }
        });
        menuSale.add(abonos);

        jMenuBar1.add(menuSale);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_reporte.png"))); // NOI18N
        jMenu1.setText("Reportes");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_reportes.png"))); // NOI18N
        report.setText("Reportes Inventario");
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        jMenu1.add(report);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ico_rventas.png"))); // NOI18N
        jMenuItem1.setText("Reportes Venta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_invent.png"))); // NOI18N
        jMenu2.setText("Inventario");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        invenTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_tienda.png"))); // NOI18N
        invenTienda.setText("Inventario por tienda");
        invenTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invenTiendaActionPerformed(evt);
            }
        });
        jMenu2.add(invenTienda);

        trass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_transfer.png"))); // NOI18N
        trass.setText("Traspasos");
        trass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trassActionPerformed(evt);
            }
        });
        jMenu2.add(trass);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Productos pt;
    private void updateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProductActionPerformed

        if (estacerrado(pt)) {

            pt = new Productos();
            pt.setCoordinador(miCoordinador);

            escritorio.add(pt).setLocation(100, 0);
            pt.show();

           
        }
    }//GEN-LAST:event_updateProductActionPerformed
    DetalleVenta dv;
    private void itemVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVentaActionPerformed
        if (estacerrado(dv)) {
            dv = new DetalleVenta();
            dv.setCoordinador(miCoordinador);
            dv.txtVendedor.setText(txtUsuario.getText());
            dv.lbIdVendedor.setText(lbId.getText());   
            dv.id_venta = venta;
            dv.bag.clear();
            escritorio.add(dv).setLocation(25, 3);
            dv.show();

            try {
                dv.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// miCoordinador.getDetalle().setVisible(true);
    }//GEN-LAST:event_itemVentaActionPerformed
    Reportes rp;
    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        if (estacerrado(dv)) {
            rp = new Reportes();
            rp.setCoordinador(miCoordinador);
            escritorio.add(rp).setLocation(300, 30);
            rp.show();

        }
    }//GEN-LAST:event_reportActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        if (estacerrado(pt)) {

            pt = new Productos();
            pt.setCoordinador(miCoordinador);
            escritorio.add(pt).setLocation(100, 0);
            pt.show();

          
        }
//miCoordinador.getProductos().setVisible(true); 
    }//GEN-LAST:event_addProductActionPerformed

    private void addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductMouseClicked

    private void updateProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProductMouseClicked

    }//GEN-LAST:event_updateProductMouseClicked
Inventario in;
    Colores cl;
    private void itemViewColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemViewColorActionPerformed
        if (estacerrado(cl)) {
            cl = new Colores();
            cl.setCoordinador(miCoordinador);
            cl.setSize(600, 575);
            escritorio.add(cl).setLocation(350, 0);
            /*
            dim = super.getToolkit().getScreenSize();
            
            */
            cl.show();
            //cl.show(true);
            
        }
    }//GEN-LAST:event_itemViewColorActionPerformed
    Usuarios us;
    Ventas vt;
    VentaCredito vc;
    private void itemAddColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddColorActionPerformed
        if (estacerrado(cl)) {
            cl = new Colores();
            cl.setCoordinador(miCoordinador);
            cl.setSize(600, 575);
            escritorio.add(cl).setLocation(350, 0);
            cl.show();
           
        }
    }//GEN-LAST:event_itemAddColorActionPerformed
    private void listClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listClientesActionPerformed
        if (estacerrado(us)) {
            us = new Usuarios();
            us.setCoordinador(miCoordinador);
         //   escritorio.add(us).setSize(856, 514);
            escritorio.add(us).setLocation(25, 3);
            us.show();
            try {
                us.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_listClientesActionPerformed
    private void listSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSalesActionPerformed
        if (estacerrado(vt)) {
            vt = new Ventas();
            vt.setCoordinador(miCoordinador);
            escritorio.add(vt).setLocation(25, 3);
            vt.show();

            try {
                vt.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_listSalesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Esta a punto de salir\nde la aplicación.\n¿Desea continuar?", "Cerrar", JOptionPane.YES_NO_OPTION, 0,
                new ImageIcon(getClass().getResource("/Imagenes/adver1.png"))) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_formWindowClosing
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
        HiloSync.ejecutaTareaCadaXTiempo();
    }//GEN-LAST:event_formWindowOpened
Usuario usua;
    private void addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteActionPerformed
   if (estacerrado(usua)) {
            usua = new Usuario();
            usua.setCoordinador(miCoordinador);
            usua.setSize(670, 400);
            escritorio.add(usua).setLocation(300, 0);
            usua.show();
           
        }
    }//GEN-LAST:event_addClienteActionPerformed
Traspasos tr;
    private void trassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trassActionPerformed
          if (estacerrado(tr)) {
            tr = new Traspasos();
            tr.setCoordinador(miCoordinador);
            escritorio.add(tr).setLocation(50, 0);
            tr.show();

        }
    }//GEN-LAST:event_trassActionPerformed
UsuariosCredito usu;
    private void itemCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreditActionPerformed
   if (estacerrado(usu)) {
            usu = new UsuariosCredito();
            usu.setCoordinador(miCoordinador);
            escritorio.add(usu).setLocation(25, 3);
            usu.show();
   }// TODO add your handling code here:
    }//GEN-LAST:event_itemCreditActionPerformed

    private void invenTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invenTiendaActionPerformed
 if (estacerrado(in)) {

             in = new Inventario();
            in.setCoordinador(miCoordinador);
            escritorio.add(in).setLocation(25, 3);
            in.show();

            try {
                in.setMaximum(true);

                // TODO add your handling code here:
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_invenTiendaActionPerformed
AgregarVendedor add;
    private void addVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVendedorActionPerformed
 
   if (estacerrado(add)) {
            add = new AgregarVendedor();
            add.setCoordinador(miCoordinador);
            add.setSize(480, 430);
            escritorio.add(add).setLocation(300, 0);
            add.show();
           
        }
 // TODO add your handling code here:
    }//GEN-LAST:event_addVendedorActionPerformed
Vendedores v;
    private void listVendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listVendeActionPerformed

        if (estacerrado(v)) {
            v = new Vendedores();
            v.setCoordinador(miCoordinador);
            v.setSize(880, 550);
            escritorio.add(v).setLocation(250, 0);
            v.show();
           
        }       
    }//GEN-LAST:event_listVendeActionPerformed
NuevaNota nn;
    private void ntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntActionPerformed
   
        if (estacerrado(nn)) {
            nn = new NuevaNota();
            nn.local = local;
            nn.setCoordinador(miCoordinador);
            nn.setSize(1350, 550);
            
            escritorio.add(nn).setLocation(10, 3);
            nn.show();
   }
    }//GEN-LAST:event_ntActionPerformed
Apartado apart;
    private void apartadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apartadoActionPerformed
if (estacerrado(apart)) {

            apart = new Apartado();
           apart.vendedor =(txtUsuario.getText());
            apart.id_vendedor =Integer.parseInt(lbId.getText());   
            apart.id_venta = venta;
            
            apart.setCoordinador(miCoordinador);
            
            
            escritorio.add(apart).setLocation(100, 0);
            apart.show();

           
        }
    }//GEN-LAST:event_apartadoActionPerformed
RVentas rv;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
   if (estacerrado(rv)) {
            rv = new RVentas();
            rv.setCoordinador(miCoordinador);
            escritorio.add(rv).setLocation(300, 30);
            rv.show();

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
ListAbonos abn;
    private void abonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonosActionPerformed
if (estacerrado(abn)) {
            abn = new ListAbonos();            
           abn.setCoordinador(miCoordinador);
            abn.setSize(1350, 550);
            
            escritorio.add(abn).setLocation(10, 3);
            abn.show();
   }
    }//GEN-LAST:event_abonosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
/*
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Tu resoluciÃ³n es de " + screenSize.width + "x" + screenSize.height);
        Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abonos;
    private javax.swing.JMenuItem addCliente;
    private javax.swing.JMenuItem addProduct;
    private javax.swing.JMenuItem addVendedor;
    private javax.swing.JMenuItem apartado;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem invenTienda;
    private javax.swing.JMenuItem itemAddColor;
    private javax.swing.JMenuItem itemCredit;
    private javax.swing.JMenuItem itemVenta;
    private javax.swing.JMenuItem itemViewColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbId;
    private javax.swing.JMenuItem listClientes;
    private javax.swing.JMenuItem listSales;
    private javax.swing.JMenuItem listVende;
    private javax.swing.JMenu menuColors;
    private javax.swing.JMenu menuProduct;
    private javax.swing.JMenu menuSale;
    private javax.swing.JMenu menuUsers;
    private javax.swing.JMenuItem nt;
    private javax.swing.JMenuItem report;
    private javax.swing.JMenuItem trass;
    public javax.swing.JTextField txtUsuario;
    private javax.swing.JMenuItem updateProduct;
    // End of variables declaration//GEN-END:variables

}
