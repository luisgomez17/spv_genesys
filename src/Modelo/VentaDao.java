/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luism
 */
public class VentaDao {

    int aux = 0;
    Texto tex = new Texto();

    public int getLastId() {
        Conectarse conn = new Conectarse();

        //Objeto de tipo Usuario 
        VentaVo venta = new VentaVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'genesysmi' AND TABLE_NAME = 'sales' ");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                venta.setId_sale(resultSet.getInt(1));
            }
            //aux = venta.getId_sale();
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return venta.getId_sale();
    }

    public void InsertCompra(VentaVo venta) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO sales (id_user, subtotal, ship, total, credito, id_vendedor, nombre_vendedor, efectivo, credit, cheques, tarjeta, vales, terminacion, id_sale ) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, venta.getId_user());
            preparedStatement.setDouble(2, venta.getSubtotal());
            preparedStatement.setDouble(3, venta.getShip());
            preparedStatement.setDouble(4, venta.getTotal());
            preparedStatement.setInt(5, 0);
            preparedStatement.setInt(6, venta.getId_vendedor());
            preparedStatement.setString(7, venta.getVendedor());
            preparedStatement.setDouble(8, venta.getEfectivo());
            preparedStatement.setDouble(9, venta.getCredit());
            preparedStatement.setDouble(10, venta.getCheques());
            preparedStatement.setDouble(11, venta.getTarjeta());
            preparedStatement.setDouble(12, venta.getVales());
            preparedStatement.setString(13, venta.getTerminacion());
            preparedStatement.setInt(14, venta.getId_sale());

            String consulta = "INSERT INTO sales (id_user, subtotal, ship, total, credito, id_vendedor, nombre_vendedor,  efectivo, credit, cheques, tarjeta, vales, terminacion) " + "VALUES ('" + venta.getId_user() + "', '" + venta.getSubtotal() + "', '" + venta.getShip() + "', '" + venta.getTotal() + "','" + 0 + "', '" + venta.getId_vendedor() + "', '" + venta.getVendedor() + "', '" + venta.getEfectivo() + "','" + venta.getCredit() + "','" + venta.getCheques() + "','" + venta.getTarjeta() + "','" + venta.getVales() + "','" + venta.getTerminacion() + "');";
            tex.escribir(consulta);
            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<VentaVo> getYears() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> years = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT DISTINCT YEAR(date_sale_test) AS sales_year FROM sales_test");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo year = new VentaVo();
                year.setSales_years(resultSet.getString(1));

                years.add(year);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return years;

    }

    public ArrayList<VentaVo> getSales(String date, String fin) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.id_sale,sales.id_user,sales.subtotal,sales.ship,sales.total,sales.register_date,sales.credito,u.firstname,u.lastname "
                    + "                    FROM sales "
                    + "                    INNER JOIN users_local as u on u.id_user = sales.id_user "
                    + "                    where CAST(sales.register_date as Date) BETWEEN ? AND ?");

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, fin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesDate(String date, String date2) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.id_sale,sales.id_user,sales.subtotal,sales.ship,sales.total,sales.register_date,sales.credito,u.firstname,u.lastname "
                    + "FROM sales "
                    + "INNER JOIN users_local as u on u.id_user = sales.id_user "
                    + "where credito = 0 and CAST(sales.register_date as Date) BETWEEN ? and ? ");

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, date2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getAllSales() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.id_sale,sales.id_user,sales.subtotal,sales.ship,sales.total,sales.register_date,sales.credito,u.firstname,u.lastname "
                    + "FROM sales "
                    + "INNER JOIN users_local as u on u.id_user = sales.id_user "
                    + "where credito = 0");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesNoClient(String date) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {

            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT * FROM sales "
                    + "where credito = 0 and id_user = 0 and register_date like ? ");

            preparedStatement.setString(1, "%" + date + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public void InsertCompraCredito(VentaVo venta) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO sales (id_user, subtotal, ship, total, credito, id_vendedor, nombre_vendedor, id_sale ) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, venta.getId_user());
            preparedStatement.setDouble(2, venta.getSubtotal());
            preparedStatement.setDouble(3, venta.getShip());
            preparedStatement.setDouble(4, venta.getTotal());
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, venta.getId_vendedor());
            preparedStatement.setString(7, venta.getVendedor());
            preparedStatement.setInt(8, venta.getId_sale());

            String consulta = "INSERT INTO sales (id_user, subtotal, ship, total, credito, id_vendedor, nombre_vendedor, id_sale ) " + "VALUES ('" + venta.getId_user() + "', '" + venta.getSubtotal() + "', '" + venta.getShip() + "', '" + venta.getTotal() + "', '" + 1 + "', '" + venta.getId_vendedor() + "', '" + venta.getVendedor() + "', '" + venta.getId_sale() + "');";
            tex.escribir(consulta);
            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<VentaVo> getSalesCredit() {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.*,u.firstname,u.lastname "
                    + "FROM sales "
                    + "INNER JOIN users as u on u.id_user = sales.id_user "
                    + "where credito = 1 and total>0");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public void UpdateDeuda(VentaVo venta) {
        ConecRemoto conn = new ConecRemoto();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE sales SET ship=?, register_date=? "
                    + "WHERE id_user = ? AND  id_sale = ? ");

            preparedStatement.setDouble(1, venta.getShip());
            preparedStatement.setString(2, venta.getDate());
            preparedStatement.setInt(3, venta.getId_user());
            preparedStatement.setInt(4, venta.getId_sale());

            String consulta = "UPDATE sales SET ship='" + venta.getCredit() + "', register_date= " + venta.getDate() + "' " + "WHERE id_user = '" + venta.getId_user() + "' AND  id_sale = '" + venta.getId_sale() + "';";

            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<VentaVo> getSalesOnline() {
        ConecRemoto conn = new ConecRemoto();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.id_sale,sales.id_user,sales.subtotal,sales.total,sales.register_date,u.firstname,u.lastname "
                    + "FROM sales "
                    + "INNER JOIN users as u on u.id_user = sales.id_user "
                    + "where online = 1");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setTotal(resultSet.getDouble(4));
                sale.setDate(resultSet.getString(5));
                sale.setFirstname(resultSet.getString(6));
                sale.setLastname(resultSet.getString(7));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public VentaVo getSalesOnlineId(int id) {
        ConecRemoto conn = new ConecRemoto();
        ArrayList<VentaVo> sales = new ArrayList<>();

        VentaVo sale = new VentaVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.*,u.firstname,u.lastname "
                    + "FROM sales "
                    + "INNER JOIN users as u on u.id_user = sales.id_user "
                    + "where online = 1 and id_sale=? ");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory

                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setOnline(resultSet.getInt(8));
                sale.setFirstname(resultSet.getString(9));
                sale.setLastname(resultSet.getString(10));

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sale;

    }

    public ArrayList<VentaVo> getSalesCreditId(int id) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.id_sale,sales.id_user,sales.total,sales.register_date,u.firstname,u.lastname, sales.ship "
                    + "FROM sales "
                    + "INNER JOIN users_local as u on u.id_user = sales.id_user "
                    + "where credito = 1 and total>ship and sales.id_user=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setTotal(resultSet.getDouble(3));
                sale.setDate(resultSet.getString(4));
                sale.setFirstname(resultSet.getString(5));
                sale.setLastname(resultSet.getString(6));
                sale.setShip(resultSet.getDouble(7));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesCreditIdOnline(int id) {
        ConecRemoto conn = new ConecRemoto();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sales.id_sale,sales.id_user,sales.total,sales.register_date,u.firstname,u.lastname, sales.ship "
                    + "FROM sales "
                    + "INNER JOIN users_local as u on u.id_user = sales.id_user "
                    + "where credito = 1  and sales.id_user=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setTotal(resultSet.getDouble(3));
                sale.setDate(resultSet.getString(4));
                sale.setFirstname(resultSet.getString(5));
                sale.setLastname(resultSet.getString(6));
                sale.setShip(resultSet.getDouble(7));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesVendedorDia(int id_vendedor, String fecha) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT * "
                    + "FROM sales "
                    + "where id_vendedor = ? and register_date  > ? and register_date < ?");

            preparedStatement.setInt(1, id_vendedor);
            preparedStatement.setString(2, fecha + " " + "00:00:00");
            preparedStatement.setString(3, fecha + " " + "23:59:59");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));
                sale.setId_user(resultSet.getInt(2));
                sale.setSubtotal(resultSet.getDouble(3));
                sale.setShip(resultSet.getDouble(4));
                sale.setTotal(resultSet.getDouble(5));
                sale.setDate(resultSet.getString(6));
                sale.setCredito(resultSet.getInt(7));
                sale.setFirstname(resultSet.getString(8));
                sale.setLastname(resultSet.getString(9));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesVendedorMes(int id_vendedor, int mes, int year) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor, nombre_vendedor, DATE_FORMAT(register_date,'%d-%m-%Y') as Fecha, SUM(total)"
                    + " FROM sales where id_vendedor = ? and MONTH(register_date) = ? AND YEAR(register_date)=?"
                    + " GROUP by DATE_FORMAT(register_date,'%d-%m-%Y')");

            preparedStatement.setInt(1, id_vendedor);
            preparedStatement.setInt(2, mes);
            preparedStatement.setInt(3, year);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setDate(resultSet.getString(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesVendedorYear(int id_vendedor, int year) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor, nombre_vendedor, MONTHNAME(register_date) as Mes, SUM(total) "
                    + "FROM sales where id_vendedor = ? AND YEAR(register_date)=? "
                    + "GROUP by month(register_date)");

            preparedStatement.setInt(1, id_vendedor);
            preparedStatement.setInt(2, year);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setDate(resultSet.getString(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesVendedorPeriodoVenta(int id_vendedor, String fecha1, String fecha2) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor,nombre_vendedor,register_date as Fecha, total "
                    + " FROM sales where id_vendedor = ? "
                    + " AND CAST(register_date AS DATE) BETWEEN ? AND ?");

            preparedStatement.setInt(1, id_vendedor);
            preparedStatement.setString(2, fecha1);
            preparedStatement.setString(3, fecha2);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setDate(resultSet.getString(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesVendedorPeriodoTotal(int id_vendedor, String fecha1, String fecha2) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor,nombre_vendedor,CAST(register_date AS DATE) as Fecha, SUM(total) "
                    + " FROM sales where id_vendedor = ? "
                    + " AND CAST(register_date AS DATE) BETWEEN ? AND ? "
                    + " GROUP by CAST(register_date AS DATE)");

            preparedStatement.setInt(1, id_vendedor);
            preparedStatement.setString(2, fecha1);
            preparedStatement.setString(3, fecha2);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setDate(resultSet.getString(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesGeneralDia(String fecha) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor,nombre_vendedor,count(*),SUM(total)"
                    + " FROM sales"
                    + " where CAST(register_date AS DATE) = ?"
                    + " GROUP by id_vendedor");

            preparedStatement.setString(1, fecha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setOnline(resultSet.getInt(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesGeneralMes(int mes, int year) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor,nombre_vendedor,count(*),SUM(total)"
                    + " FROM sales"
                    + " where MONTH(register_date) = ? and YEAR(register_date) = ? "
                    + " GROUP by id_vendedor,MONTH(register_date)");

            preparedStatement.setInt(1, mes);
            preparedStatement.setInt(2, year);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setOnline(resultSet.getInt(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesGeneralYear(int year) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor,nombre_vendedor,count(*),SUM(total)"
                    + " FROM sales"
                    + " where YEAR(register_date) = ?"
                    + " GROUP by id_vendedor,YEAR(register_date)");

            preparedStatement.setInt(1, year);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setOnline(resultSet.getInt(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public ArrayList<VentaVo> getSalesGeneralPeriodo(String fecha1, String fecha2) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_vendedor,nombre_vendedor,COUNT(*), SUM(total)"
                    + " FROM sales"
                    + " where CAST(register_date AS DATE) BETWEEN ? AND ?"
                    + " GROUP by id_vendedor");

            preparedStatement.setString(1, fecha1);
            preparedStatement.setString(2, fecha2);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                VentaVo sale = new VentaVo();

                sale.setId_vendedor(resultSet.getInt(1));
                sale.setVendedor(resultSet.getString(2));
                sale.setOnline(resultSet.getInt(3));
                sale.setTotal(resultSet.getDouble(4));

                sales.add(sale);

            }

            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return sales;

    }

    public int getLastCompra() {
        ConecRemoto conn = new ConecRemoto();

        //Objeto de tipo Usuario 
        VentaVo venta = new VentaVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT MAX(id_sale) FROM sales");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                venta.setId_sale(resultSet.getInt(1));
            }
            //aux = venta.getId_sale();
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return venta.getId_sale();
    }

    public void UpdateAbono(VentaVo venta) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE sales SET ship=?, register_date=? "
                    + "WHERE id_user = ? AND  id_sale = ?");

            preparedStatement.setDouble(1, venta.getShip());
            preparedStatement.setString(2, venta.getDate());
            preparedStatement.setInt(3, venta.getId_user());
            preparedStatement.setInt(4, venta.getId_sale());

            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void InsertAbono(VentaVo venta) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO abonos (id_sale , id_user, abono, efectivo, debito, credito, vales, cheque, terminacion ) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, venta.getId_sale());
            preparedStatement.setInt(2, venta.getId_user());
            preparedStatement.setDouble(3, venta.getTotal());
            preparedStatement.setDouble(4, venta.getEfectivo());
            preparedStatement.setDouble(5, venta.getTarjeta());
            preparedStatement.setDouble(6, venta.getCredit());
            preparedStatement.setDouble(7, venta.getVales());
            preparedStatement.setDouble(8, venta.getCheques());
            preparedStatement.setString(9, venta.getTerminacion());

            String consulta = "INSERT INTO abonos (id_sale , id_user, abono, efectivo, debito, credito, vales, cheque, terminacion ) "
                    + "VALUES ('" + venta.getId_sale() + "', '" + venta.getId_user() + "', '" + venta.getTotal() + "', '" + venta.getEfectivo() + "', '" + venta.getTarjeta() + "', '" + venta.getCredit() + "', '" + venta.getVales() + "', '" + venta.getCheques() + "', '" + venta.getTerminacion() + "');";
            tex.escribir(consulta);
            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void InsertAbonoApart(VentaVo venta) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO abonos_apart (id_apart , id_user, abono, efectivo, debito, credito, vales, cheque, terminacion ) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, venta.getId_sale());
            preparedStatement.setInt(2, venta.getId_user());
            preparedStatement.setDouble(3, venta.getTotal());
            preparedStatement.setDouble(4, venta.getEfectivo());
            preparedStatement.setDouble(5, venta.getTarjeta());
            preparedStatement.setDouble(6, venta.getCredit());
            preparedStatement.setDouble(7, venta.getVales());
            preparedStatement.setDouble(8, venta.getCheques());
            preparedStatement.setString(9, venta.getTerminacion());

            String consulta = "INSERT INTO abonos_apart (id_apart , id_user, abono, efectivo, debito, credito, vales, cheque, terminacion ) "
                    + "VALUES ('" + venta.getId_sale() + "', '" + venta.getId_user() + "', '" + venta.getTotal() + "', '" + venta.getEfectivo() + "', '" + venta.getTarjeta() + "', '" + venta.getCredit() + "', '" + venta.getVales() + "', '" + venta.getCheques() + "', '" + venta.getTerminacion() + "');";
            tex.escribir(consulta);
            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void UpdateTotalNota(VentaVo venta) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE sales SET total=?, register_date=? "
                    + "WHERE id_user = ? AND  id_sale = ?");

            preparedStatement.setDouble(1, venta.getTotal());
            preparedStatement.setString(2, venta.getDate());
            preparedStatement.setInt(3, venta.getId_user());
            preparedStatement.setInt(4, venta.getId_sale());

            preparedStatement.executeUpdate();

            //Cierra todo
            conn.getConn().close();
            //resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<VentaVo> getSalesCreditDate(String f1, String f2) {
        Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT sl.id_sale,sl.subtotal,sl.total, sl.register_date , u.firstname,u.lastname " +
                    "FROM sales as sl " +
                    "JOIN users_local as u on u.id_user = sl.id_user " +
                    "WHERE  CAST(sl.register_date as date) BETWEEN ? AND ?"
                  + " AND sl.credito = 1");

            preparedStatement.setString(1, f1);
            preparedStatement.setString(2, f2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));                
                sale.setSubtotal(resultSet.getDouble(2));                
                sale.setTotal(resultSet.getDouble(3));
                sale.setDate(resultSet.getString(4));                
                sale.setFirstname(resultSet.getString(5));
                sale.setLastname(resultSet.getString(6));

                sales.add(sale);
            }
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sales;

    }
    public ArrayList<VentaVo> getAbonos(int id_venta){
    Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
            "SELECT id_abono,abono,fecha,efectivo,credito,debito,vales,cheque,terminacion"
                    + " FROM abonos"
                    + " WHERE id_sale= ? ");

            preparedStatement.setInt(1, id_venta);            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));                                
                sale.setTotal(resultSet.getDouble(2));
                sale.setDate(resultSet.getString(3));                
                sale.setEfectivo(resultSet.getDouble(4));
                sale.setCredit(resultSet.getDouble(5));
                sale.setTarjeta(resultSet.getDouble(6));
                sale.setVales(resultSet.getDouble(7));
                sale.setCheques(resultSet.getDouble(8));
                sale.setTerminacion(resultSet.getString(9));
                
                sales.add(sale);
            }
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sales;
    }
    
    public ArrayList<VentaVo> getAbonosApt(int id_venta){
    Conectarse conn = new Conectarse();
        ArrayList<VentaVo> sales = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
            "SELECT id_abono,abono,fecha,efectivo,credito,debito,vales,cheque,terminacion"
                    + " FROM abonos_apart"
                    + " WHERE id_apart= ? ");

            preparedStatement.setInt(1, id_venta);            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                VentaVo sale = new VentaVo();
                sale.setId_sale(resultSet.getInt(1));                                
                sale.setTotal(resultSet.getDouble(2));
                sale.setDate(resultSet.getString(3));                
                sale.setEfectivo(resultSet.getDouble(4));
                sale.setCredit(resultSet.getDouble(5));
                sale.setTarjeta(resultSet.getDouble(6));
                sale.setVales(resultSet.getDouble(7));
                sale.setCheques(resultSet.getDouble(8));
                sale.setTerminacion(resultSet.getString(9));
                
                sales.add(sale);
            }
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sales;
    }
    
}
