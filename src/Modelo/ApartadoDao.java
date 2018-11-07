
package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApartadoDao {
    
    Texto tex = new Texto();
    
public void InsertAparatdo(ApartadoVo apart) {
        Conectarse conn = new Conectarse();

        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "INSERT INTO apartado (id_cliente, art, color_art, id_size, amount, plazo, estado, precio) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, apart.getId_cliente());
            preparedStatement.setString(2, apart.getArt());
            preparedStatement.setString(3, apart.getColor_art());
            preparedStatement.setInt(4, apart.getId_size());
            preparedStatement.setInt(5, apart.getAmount());
            preparedStatement.setString(6, apart.getPlazo());
            preparedStatement.setString(7, apart.getEstado());
            preparedStatement.setDouble(8, apart.getPrecio());
            
            String consulta = "INSERT INTO apartado (id_cliente, art, color_art, id_size, amount, plazo, estado, precio) "
            + "VALUES ('"+apart.getId_cliente()+"', '"+apart.getArt()+"', '"+apart.getColor_art()+"', '"+apart.getId_size()+"', '"+apart.getAmount()+"', '"+apart.getPlazo()+"', '"+apart.getEstado()+" , '"+apart.getPrecio()+"');";
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
    
    public ArrayList<ApartadoVo> getProductsApartado() {
        Conectarse conn = new Conectarse();
        ArrayList<ApartadoVo> listado = new ArrayList<>();
               
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
             "SELECT apar.*, pd.name, c.color_name, sz.name, ul.firstname, ul.lastname, CAST(apar.registro as date) "
             + " FROM apartado as apar " +
             "INNER JOIN product_details as pd on pd.art = apar.art " +
             "INNER JOIN colors as c on c.color_art = apar.color_art " +
             "INNER JOIN sizes as sz on sz.id_size = apar.id_size " +
             "INNER JOIN users_local as ul on ul.id_user = apar.id_cliente ");

        
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                ApartadoVo product = new ApartadoVo();
                product.setId_apatado(resultSet.getInt(1));
                product.setId_cliente(resultSet.getInt(2));
                product.setArt(resultSet.getString(3));
                product.setColor_art(resultSet.getString(4));
                product.setId_size(resultSet.getInt(5));
                product.setAmount(resultSet.getInt(6));
                product.setRegistro(resultSet.getString(7));
                product.setPlazo(resultSet.getString(8));
                product.setEstado(resultSet.getString(9));
                product.setPrecio(resultSet.getDouble(10));
                product.setAbono(resultSet.getDouble(11));
                product.setArticulo(resultSet.getString(12));
                product.setColor(resultSet.getString(13));
                product.setTalla(resultSet.getString(14));
                product.setNombre(resultSet.getString(15));
                product.setApellidos(resultSet.getString(16));
                product.setRegistro(resultSet.getString(17));
                listado.add(product);
                
            }           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return listado;
        
    }
    
    public ArrayList<ApartadoVo> getApartadoFecha(String f1, String f2) {
        Conectarse conn = new Conectarse();
        ArrayList<ApartadoVo> listado = new ArrayList<>();
               
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
             "SELECT apar.*, pd.name, c.color_name, sz.name, ul.firstname, ul.lastname, CAST(apar.registro as date) "
             + " FROM apartado as apar " +
             "INNER JOIN product_details as pd on pd.art = apar.art " +
             "INNER JOIN colors as c on c.color_art = apar.color_art " +
             "INNER JOIN sizes as sz on sz.id_size = apar.id_size " +
             "INNER JOIN users_local as ul on ul.id_user = apar.id_cliente "
             + "WHERE CAST(apar.registro as date) BETWEEN ? AND ? ");

            preparedStatement.setString(1, f1);
            preparedStatement.setString(2, f2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                ApartadoVo product = new ApartadoVo();
                product.setId_apatado(resultSet.getInt(1));
                product.setId_cliente(resultSet.getInt(2));
                product.setArt(resultSet.getString(3));
                product.setColor_art(resultSet.getString(4));
                product.setId_size(resultSet.getInt(5));
                product.setAmount(resultSet.getInt(6));
                product.setRegistro(resultSet.getString(7));
                product.setPlazo(resultSet.getString(8));
                product.setEstado(resultSet.getString(9));
                product.setPrecio(resultSet.getDouble(10));
                product.setAbono(resultSet.getDouble(11));
                product.setArticulo(resultSet.getString(12));
                product.setColor(resultSet.getString(13));
                product.setTalla(resultSet.getString(14));
                product.setNombre(resultSet.getString(15));
                product.setApellidos(resultSet.getString(16));
                product.setRegistro(resultSet.getString(17));
                
                listado.add(product);
                
            }           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return listado;
        
    }
        
    public void UpdateApartado(ApartadoVo apart){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE apartado SET estado= 'E' "
                    + "WHERE id_apartado = ?");
                        
            preparedStatement.setInt(1, apart.getId_apatado());
            
String consulta = "UPDATE apartado SET estado='E' WHERE id_apartado = '"+apart.getId_apatado()+"';";
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
    
    public void UpdateEstado(ApartadoVo apart){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE apartado SET estado= 'V' "
                    + "WHERE id_apartado = ?");
                        
            preparedStatement.setInt(1, apart.getId_apatado());
            
String consulta = "UPDATE apartado SET estado='V' WHERE id_apartado = '"+apart.getId_apatado()+"';";
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
    
    public void UpdateAbon(ApartadoVo apart){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE apartado SET abono= ?, registro = ? "
                    + "WHERE id_apartado = ?");
                        
            preparedStatement.setDouble(1, apart.getAbono());
            preparedStatement.setString(2, apart.getRegistro());
            preparedStatement.setInt(3, apart.getId_apatado());
            
String consulta = "UPDATE apartado SET abono='"+apart.getAbono()+"', registro= '"+apart.getRegistro()+"' WHERE id_apartado = '"+apart.getId_apatado()+"';";
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
