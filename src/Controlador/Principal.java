package Controlador;

import Vista.Colores;
import Vista.DetalleVenta;
import Vista.Inicio;
import Vista.Inventario;
import Vista.Login;
import Vista.Productos;
import Vista.Reportes;
import Vista.Total;
import Vista.Usuarios;
import Vista.Ventas;
import Vista.VentaCredito;
import Vista.*;


public class Principal {
    Coordinador miCoordinador;
    
    private void Iniciar(){
        /**Se instancian las clases*/
        miCoordinador= new Coordinador();
        Login login = new Login();
        Productos productos = new Productos();
        Usuarios usuario = new Usuarios();
        Ventas venta = new Ventas();
        DetalleVenta detalle = new DetalleVenta();
        Reportes reportes = new Reportes();
        VentaCredito credito = new VentaCredito();
        Total total = new Total();
        
        
        Inventario inventario = new Inventario();
        NotasCredito notas = new NotasCredito();
        Traspasos traspaso = new Traspasos();
        Usuario usu = new Usuario();
        UsuariosCredito usucre = new UsuariosCredito();
        cambiarProducto cambio = new cambiarProducto();
        Colores color = new Colores();
        Inicio inicio = new Inicio();        
        Login1 lo = new Login1();
        Vendedores vendedores = new Vendedores();
        Multipago multi = new Multipago();
        Notas notas2 = new Notas();
        NuevaNota nn = new NuevaNota();
        Apartado apartado = new Apartado();
        RVentas rventas = new RVentas();
        ListAbonos lstabn = new ListAbonos();
        /**Se establecen las relaciones entre clases*/
        
        login.setCoordinador(miCoordinador);
        productos.setCoordinador(miCoordinador);
        usuario.setCoordinador(miCoordinador);
        venta.setCoordinador(miCoordinador);
        detalle.setCoordinador(miCoordinador);
        reportes.setCoordinador(miCoordinador);
        total.setCoordinador(miCoordinador);
        credito.setCoordinador(miCoordinador);
        color.setCoordinador(miCoordinador);
        inicio.setCoordinador(miCoordinador);
        inventario.setCoordinador(miCoordinador);
        notas.setCoordinador(miCoordinador);
        traspaso.setCoordinador(miCoordinador);
        usu.setCoordinador(miCoordinador);
        usucre.setCoordinador(miCoordinador);
        cambio.setCoordinador(miCoordinador);
        lo.setCoordinador(miCoordinador);
        vendedores.setCoordinador(miCoordinador);
        multi.setCoordinador(miCoordinador);
        notas2.setCoordinador(miCoordinador);
        nn.setCoordinador(miCoordinador);
        apartado.setCoordinador(miCoordinador);
        rventas.setCoordinador(miCoordinador);
        lstabn.setCoordinador(miCoordinador);
        /*Se establecen relaciones con la clase coordinador*/
        
        miCoordinador.setLogin(login);
        miCoordinador.setColor(color);
        miCoordinador.setProductos(productos);
        miCoordinador.setDetalle(detalle);
         miCoordinador.setLogin(login);
        miCoordinador.setColor(color);
        miCoordinador.setInicio(inicio);
        miCoordinador.setUsuario(usuario);
        miCoordinador.setVenta(venta);
        miCoordinador.setTotal(total);
        miCoordinador.setReporte(reportes);
        miCoordinador.setCredito(credito);
        miCoordinador.setLogin1(lo);
        miCoordinador.setVendedores(vendedores);
        miCoordinador.setMulti(multi);
        miCoordinador.setNc(notas2);
        miCoordinador.setNn(nn);
        miCoordinador.setApartado(apartado); 
        miCoordinador.setRventas(rventas); 
        miCoordinador.setListabn(lstabn); 
        lo.setVisible(true);
        
     
        
        
        /*Se establecen relaciones con la clase coordinador*/
       
      //  color.setVisible(true);
   // usuario.setVisible(true);
     //  detalle.setVisible(true);
       // productos.setVisible(true);
       // reportes.setVisible(true);
       // total.setVisible(true);
//inicio.setVisible(true);

    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.Iniciar();
            }
        });
    }
}
