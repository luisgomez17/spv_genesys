/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Coordinador;
import static Vista.Inicio.escritorio;

import Vista.Traspasos;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author luism
 */
public class HiloSync {
  static Traspasos tr;
  
static File documento = new File("src/Modelo/Consulta.txt");
static ConecRemoto remoto = new ConecRemoto();
static Timer tiempo = new Timer();  
static Coordinador miCoordinador= new Coordinador();
   
public static void ejecutaTareaCadaXTiempo(){
             AccionProgramada accionProgramada = new AccionProgramada();  //La programamos
             
             tiempo.scheduleAtFixedRate(accionProgramada,0,30000);
         }

    static boolean estacerrado(Object obj) {
        JInternalFrame[] activos = escritorio.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
              
            }
            i++;
        }
        return cerrado;
    }
static class AccionProgramada extends TimerTask{
 
    @Override
   public void run() {

       remoto.importarQuery(documento);
       comprobarTraspasos();
  
   }

}


static void comprobarTraspasos(){
ArrayList<ProductoVo> traspasos = miCoordinador.getTransfer();

if(traspasos.size()>0){
         
        DesktopNotify.showDesktopMessage("Traspasos", "Cuenta con traspasos pendientes por confirmar.", DesktopNotify.INPUT_REQUEST, new ActionListener(){@Override public void actionPerformed(ActionEvent evt){
         if (estacerrado(tr)) {
            tr = new Traspasos();
            tr.setCoordinador(miCoordinador);
            escritorio.add(tr).setLocation(0, 0);
            tr.show();

        }
            //Podemos utilizar un formulario Frame o cualquier otro
            //new Formulario().setVisible(true);
            
            //Tambien podemos mostrar mensajes simples, sin iconos
            //DesktopNotify.setDefaultTheme(NotifyTheme.Light);
            //DesktopNotify.showDesktopMessage("", "TambiÃ©n puede mostrar mensajes sin un tÃ­tulo, sin un Ã­cono, con un Ã­cono personalizado, un tema de color diferente, o con la combinaciÃ³n de elementos que desee.", DesktopNotify.INFORMATION);
            
        }});

   

    
System.out.println("Cuenta con traspasos pendientes");
}

                }}
