
package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class CreditoDao {
    Texto aux = new Texto();
    public void InsertCompraCredito(CreditoVo venta){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO credit (id_user, subtotal, ship, total ) "                         
                    + "VALUES ( ?, ?, ?, ?)");
            
            
            preparedStatement.setInt(1, venta.getId_user());
            preparedStatement.setDouble(2, venta.getSubtotal());
            preparedStatement.setDouble(3, venta.getShip());
            preparedStatement.setDouble(4, venta.getTotal());
            
String consulta = "INSERT INTO credit (id_user, subtotal, ship, total ) "+ "VALUES ( '"+venta.getId_user()+"','"+venta.getSubtotal()+"' , '"+venta.getShip()+"',"+ " '"+venta.getTotal()+"');";
            aux.escribir(consulta);
            
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
