package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotaDao {
    Texto tex = new Texto();
    
public void InsertNota(NotaVo nota) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO notas (id_cliente, id_venta, id_vendedor,saldo, tipo ) "
                    + "VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, nota.getId_cliente());
            preparedStatement.setInt(2, nota.getId_venta());
            preparedStatement.setInt(3, nota.getId_vendedor());
            preparedStatement.setDouble(4, nota.getSaldo());
            preparedStatement.setInt(5, nota.getTipo());
            
            String consulta = "INSERT INTO notas (id_cliente, id_venta, id_vendedor,saldo, tipo ) "
            + "VALUES ('"+nota.getId_cliente()+"', '"+nota.getId_venta()+"', '"+nota.getId_vendedor()+"', '"+nota.getSaldo()+"', '"+nota.getTipo()+"');";
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

     public ArrayList<NotaVo> getNotas(int usuario) {
       Conectarse conn = new Conectarse();
        
        ArrayList<NotaVo> notas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_nota,id_venta, saldo, fecha"
                            + " FROM notas"
                            + " WHERE id_cliente = ? and tipo=1 ");

            preparedStatement.setInt(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                NotaVo nota = new NotaVo();
                nota.setId_nota(resultSet.getInt(1));
                nota.setId_venta(resultSet.getInt(2));
                nota.setSaldo(resultSet.getDouble(3));
                nota.setFecha(resultSet.getString(4));
                
                notas.add(nota);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna las notas
        return notas;
    }

     public ArrayList<NotaVo> getNotasFecha(int usuario, String fecha1, String fecha2) {
       Conectarse conn = new Conectarse();
        
        ArrayList<NotaVo> notas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_nota,id_venta, saldo, fecha"
                            + " FROM notas"
                            + " WHERE id_cliente = ? and tipo=1 and CAST(fecha as Date) BETWEEN ? and ? ");

            preparedStatement.setInt(1, usuario);
            preparedStatement.setString(2, fecha1);
            preparedStatement.setString(3, fecha2);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                NotaVo nota = new NotaVo();
                nota.setId_nota(resultSet.getInt(1));
                nota.setId_venta(resultSet.getInt(2));
                nota.setSaldo(resultSet.getDouble(3));
                nota.setFecha(resultSet.getString(4));
                
                notas.add(nota);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna las notas
        return notas;
    }
     
     public void updateNota(NotaVo producto){
        Conectarse conn = new Conectarse();
        //ConecRemoto conn = new ConecRemoto();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE notas SET tipo = 2, fecha = ? "                            
                    + "WHERE id_nota = ? ");
                        
            preparedStatement.setString(1, producto.getFecha());
            preparedStatement.setInt(2, producto.getId_nota());
            
String consulta ="UPDATE notas SET tipo = 2, fecha = '"+producto.getFecha()+"' "                            
                    + "WHERE id_nota = '"+producto.getId_nota()+"' ;";
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
}
