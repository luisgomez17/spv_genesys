/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Coordinador;
import Modelo.ApartadoVo;
import Modelo.ProductoVo;
import Modelo.UsuarioVo;
import Modelo.VentaVo;
import Modelo.BagVo;
import Modelo.NotaVo;
import Modelo.Ticket;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luism
 */
public class Total extends javax.swing.JInternalFrame {

    private Coordinador miCoordinador;
    public ArrayList<ProductoVo> product = new ArrayList();
    public ArrayList<BagVo> bolsa = new ArrayList();
    public UsuarioVo comprador = new UsuarioVo();
    public double dineroelectronico;
    ProductoVo registro = new ProductoVo();
    public Ticket ticket = new Ticket();
    public NotaVo notados = new NotaVo();
    public static ArrayList<ApartadoVo> aprt = new ArrayList<>();

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;

    }

    public Total() {
        initComponents();

        venta.setShip(0.00);
    }

    public VentaVo venta = new VentaVo();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPagar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDinero = new javax.swing.JLabel();
        btnCanjear = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTerm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmForma = new javax.swing.JComboBox<>();
        txtDinero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 65, 92));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(1, 129, 176));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Vendedor:");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cliente:");

        lblCliente.setBackground(new java.awt.Color(255, 255, 255));
        lblCliente.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClienteMouseClicked(evt);
            }
        });

        lblVendedor.setBackground(new java.awt.Color(255, 255, 255));
        lblVendedor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        lblVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVendedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(1, 129, 176));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total a pagar:");

        lblPagar.setBackground(new java.awt.Color(255, 255, 255));
        lblPagar.setFont(new java.awt.Font("Apple SD Gothic Neo", 1, 14)); // NOI18N
        lblPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblPagar.setText("0.00");
        lblPagar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dinero electrÛnico:");

        lblDinero.setBackground(new java.awt.Color(255, 255, 255));
        lblDinero.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        lblDinero.setForeground(new java.awt.Color(255, 255, 255));
        lblDinero.setText("0.00");
        lblDinero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCanjear.setText("Utilizar");
        btnCanjear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanjearActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TerminaciÛn:");

        txtTerm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Forma de pago:");

        cmForma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Efectivo", "Credito", "Debito", "Vales", "Cheques" }));
        cmForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmFormaActionPerformed(evt);
            }
        });

        txtDinero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDinero.setText("0");
        txtDinero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDineroKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pago:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnCanjear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmForma, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(156, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(65, 65, 65)
                        .addComponent(btnCancelar)
                        .addGap(0, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCanjear, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanjearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanjearActionPerformed

        double monedero = Double.parseDouble(lblDinero.getText());
        double total = Double.parseDouble(lblPagar.getText());

        if (monedero > 0 && monedero >= total) {
            String monto = JOptionPane.showInputDialog("Monto a utilizar", monedero);

            if (Double.parseDouble(monto) <= monedero) {
                total = Math.abs(Double.parseDouble(monto) - total);
                monedero = monedero - Double.parseDouble(monto);
                comprador.setMoney(monedero);
            } else {
                JOptionPane.showMessageDialog(null, "Fondos insuficientes", "Dinero ElectrÛnico", JOptionPane.WARNING_MESSAGE);
            }

        } else if (monedero > 0 && total > monedero) {
            String monto = JOptionPane.showInputDialog("Monto a utilizar", monedero);

            if (Double.parseDouble(monto) <= monedero) {
                total = total - Double.parseDouble(monto);
                monedero = monedero - Double.parseDouble(monto);
                comprador.setMoney(monedero);
                System.out.println("Total:" + total);
            } else {
                JOptionPane.showMessageDialog(null, "Fondos insuficientes", "Dinero ElectrÛnico", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No cuentas con fondos", "Dinero ElectrÛnico", JOptionPane.WARNING_MESSAGE);

        }
        lblPagar.setText(Double.toString(total));
        lblDinero.setText(Double.toString(monedero));
        ticket.setTotal(total);
        venta.setTotal(total);


    }//GEN-LAST:event_btnCanjearActionPerformed

    public void formaPago(int metodo, double pago) {
        switch (metodo) {
            case 1:
                venta.setEfectivo(pago);
                ticket.setEfectivo(pago);
                break;
            case 2:
                venta.setCredit(pago);
                ticket.setCredito(pago);
                break;
            case 3:
                venta.setTarjeta(pago);
                ticket.setTarjeta(pago);
                break;
            case 4:
                venta.setVales(pago);
                ticket.setVales(pago);
                break;
            case 5:
                venta.setCheques(pago);
                ticket.setCheques(pago);
                break;

        }
        venta.setTotal(pago);
        ticket.setTotal(pago);

    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        String term = txtTerm.getText().trim();

        ticket.setCredito(0.00);
        ticket.setTarjeta(0.00);
        venta.setTotal(Double.parseDouble(lblPagar.getText()));
        String captura = txtDinero.getText();
        captura = captura.replaceAll(" ", "");

        if (ticket.getCliente() == "") {
            ticket.setCliente("Publico general");
        }

        if (captura.length() == 0 || Double.parseDouble(captura) < Double.parseDouble(lblPagar.getText()) || metodo == 0) {
            JOptionPane.showMessageDialog(null, "Ingresa un pago v·lido", "Pago total", JOptionPane.WARNING_MESSAGE);
        } else {
            double pago = Double.parseDouble(txtDinero.getText());
            double to = Double.parseDouble(lblPagar.getText());
            double cambio = pago - to;

            formaPago(metodo, to);
            venta.setTerminacion(term);
            ticket.setTerminacion(term);

            JOptionPane.showMessageDialog(null, "Gracias por su compra, su cambio es de" + " " + Double.toString(cambio) + "");
            miCoordinador.InsertVenta(venta);
            ticket.setCambio(cambio);
            ticket.setPago(Double.parseDouble(captura));

            for (int v = 0; v < product.size(); v++) {
                miCoordinador.UpdateProductSizesSales(product.get(v));
            }
            comprador.setMoney(comprador.getMoney() + dineroelectronico);
            miCoordinador.ActualizarMonedero(comprador);

            for (int b = 0; b < bolsa.size(); b++) {
                miCoordinador.InsertBag(bolsa.get(b));
            }
            if (notados.getSaldo() > 0) {
                miCoordinador.updateNota(notados);
            }

            if (aprt.size() > 0) {
                for (int a = 0; a < aprt.size(); a++) {

                    miCoordinador.updateApartado(aprt.get(a));
                }
            }

            imprimirFactura(ticket);

            miCoordinador.getDetalle().bag.clear();
            dispose();
            txtDinero.setText("0.0");

        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    void imprimirFactura(Ticket ticket) {
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        PrinterMatrix printer = new PrinterMatrix();

        Extenso e = new Extenso();

        e.setNumber(101.85);

        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(65, 32);
        //Imprimir * de la 2da linea a 25 en la columna 1;
        // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 80
        //printer.printCharAtCol(0, 1, 40, "=");
        //Imprimir Encabezado nombre del La EMpresa

        printer.printTextWrap(1, 2, 5, 32, "GENESYS MODA INFANTIL");
        //printer.printTextWrap(linI, linE, colI, colE, null);
        printer.printTextWrap(3, 4, 10, 32, "molm6505111i1 ");
        printer.printTextWrap(5, 6, 1, 32, "Plaza las Americas local A 13");
        printer.printTextWrap(7, 8, 3, 32, "Lazaro Cardenas, Michoacan");
        printer.printTextWrap(9, 10, 12, 32, "60950");
        printer.printTextWrap(11, 12, 4, 32, "genesys.mi@hotmail.com");
        printer.printCharAtCol(13, 1, 32, "-");
        printer.printTextWrap(13, 14, 1, 32, "No. TICKET:" + ticket.getNro_ticket());
        printer.printTextWrap(15, 16, 1, 32, "Fecha:" + dateFormat.format(date));
        printer.printTextWrap(16, 17, 1, 32, "Hora:" + hourFormat.format(date));
        printer.printCharAtCol(18, 1, 32, "-");
        printer.printTextWrap(18, 19, 2, 32, "Nombre            Cant Importe");
        printer.printCharAtCol(20, 1, 32, "-");
        int cont = 0, cont2 = 20;
        for (int i = 0; i < bolsa.size(); i++) {

            printer.printTextWrap(cont2 + i, cont2 + i + 1, 0, 18, bolsa.get(i).getArt_name() + " ");
            printer.printTextWrap(cont2 + i, cont2 + i + 1, 21, 23, bolsa.get(i).getQuantity() + " ");
            printer.printTextWrap(cont2 + i, cont2 + i + 1, 25, 32,"" + bolsa.get(i).getImporte());
            cont2 = cont2 + i + 1;
            cont = i + 2;
        }
        printer.printCharAtCol(22 + cont, 1, 32, "-");
        printer.printTextWrap(23 + cont, 29, 10, 32, "TOTAL: " + ticket.getTotal());
        printer.printTextWrap(25 + cont, 32, 0, 32, "<<<<<<<<<FORMAS DE PAGO>>>>>>>>>");
        printer.printTextWrap(28 + cont, 33, 10, 32, "EFECTIVO: " + ticket.getEfectivo());
        printer.printTextWrap(29 + cont, 35, 10, 32, "TARJETA: " + ticket.getTarjeta());
        printer.printTextWrap(30 + cont, 37, 10, 32, "CREDITO: " + ticket.getCredito());
        printer.printTextWrap(31 + cont, 39, 10, 32, "CHEQUES: " + ticket.getCheques());
        printer.printTextWrap(32 + cont, 41, 10, 32, "VALES: " + ticket.getVales());
        printer.printTextWrap(34 + cont, 45, 10, 32, "PAGO: " + ticket.getPago());
        printer.printTextWrap(37 + cont, 47, 10, 32, "CAMBIO: " + ticket.getCambio());
        //printer.printTextWrap(39 + cont, 51, 18, 32, "CAJA");
       // printer.printTextWrap(41 + cont, 53, 15, 32, "Caja 1");
        printer.printTextWrap(39 + cont, 55, 1, 32, "CLIENTE: " + ticket.getCliente());
        // printer.printTextWrap(56 + cont, 57, 10, 32, ticket.getCliente());
        printer.printTextWrap(41 + cont, 59, 1, 32, "CAJERO " + ticket.getVendedor());
        //printer.printTextWrap(60 + cont, 62, 10, 32, ticket.getVendedor());


        /*
        if(filas > 15){
        printer.printCharAtCol(filas + 1, 1, 80, "=");
        printer.printTextWrap(filas + 1, filas + 2, 1, 80, "TOTAL A PAGAR " + txtVentaTotal.getText());
        printer.printCharAtCol(filas + 2, 1, 80, "=");
        printer.printTextWrap(filas + 2, filas + 3, 1, 80, "Esta boleta no tiene valor fiscal, solo para uso interno.: + Descripciones........");
        }else{
        printer.printCharAtCol(25, 1, 80, "=");
        printer.printTextWrap(26, 26, 1, 80, "TOTAL A PAGAR " + txtVentaTotal.getText());
        printer.printCharAtCol(27, 1, 80, "=");
        printer.printTextWrap(27, 28, 1, 80, "Esta boleta no tiene valor fiscal, solo para uso interno.: + Descripciones........");

        }*/
        printer.toFile("impresion.txt");

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        //inputStream.close();
    }

    public static String removeEspecial(String input) {
        // Cadena de caracteres original a sustituir.
        String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
        // Cadena de caracteres ASCII que reemplazar·n los originales.
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String output = input;
        for (int i = 0; i < original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i
        return output;
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    int metodo;
    private void cmFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmFormaActionPerformed
        int seleccionado = cmForma.getSelectedIndex();

        switch (seleccionado) {
            case 1:
                txtTerm.setEditable(false);
                metodo = 1;
                break;
            case 2:
                txtTerm.setEditable(true);
                metodo = 2;
                break;
            case 3:
                txtTerm.setEditable(true);
                metodo = 3;
                break;
            case 4:
                txtTerm.setEditable(false);
                metodo = 4;
                break;
            case 5:
                txtTerm.setEditable(false);
                metodo = 5;
                break;
        }
    }//GEN-LAST:event_cmFormaActionPerformed

    private void txtDineroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDineroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDineroKeyTyped

    private void lblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClienteMouseClicked
        System.out.println(comprador.getMoney() + dineroelectronico);
    }//GEN-LAST:event_lblClienteMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCanjear;
    private javax.swing.JComboBox<String> cmForma;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblCliente;
    public javax.swing.JLabel lblDinero;
    public javax.swing.JLabel lblPagar;
    public javax.swing.JLabel lblVendedor;
    private javax.swing.JTextField txtDinero;
    private javax.swing.JTextField txtTerm;
    // End of variables declaration//GEN-END:variables
}
