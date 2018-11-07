/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luism
 */
public class Ticket {

    private int nro_ticket;
    private double total;
    private double efectivo;
    private double cheques;
    private double vales;
     private double tarjeta;
    private double credito;
    private double cambio;
    private String cliente;
    private String vendedor;
    private double pago;
    private String terminacion;

    public String getTerminacion() {
        return terminacion;
    }

    public void setTerminacion(String terminacion) {
        this.terminacion = terminacion;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCheques() {
        return cheques;
    }

    public void setCheques(double cheques) {
        this.cheques = cheques;
    }

    public double getVales() {
        return vales;
    }

    public void setVales(double vales) {
        this.vales = vales;
    }
   

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public int getNro_ticket() {
        return nro_ticket;
    }

    public void setNro_ticket(int nro_ticket) {
        this.nro_ticket = nro_ticket;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(double tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
