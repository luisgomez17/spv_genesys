package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TallaDao {
    public ArrayList<TallaVo> getTallas(Integer id_category, Integer id_type_product){
            Conectarse conn = new Conectarse();
            //ConecRemoto conn = new ConecRemoto();
            ArrayList<TallaVo> tallas = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_size, id_category, id_type_product, "
                    + "name AS size_name "
                    + "FROM sizes "
                    + "WHERE id_category = ? AND id_type_product = ?");

            preparedStatement.setInt(1, id_category);
            preparedStatement.setInt(2, id_type_product);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                TallaVo talla = new TallaVo();
                talla.setId_size(resultSet.getInt(1));
                talla.setId_category(resultSet.getInt(2));
                talla.setId_type_product(resultSet.getInt(3));
                talla.setSize_name(resultSet.getString(4));
                
                tallas.add(talla);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return tallas;
    }
    
    public ArrayList<TallaVo> obtener_tallas(String art){
     Conectarse conn = new Conectarse();
            
           ArrayList<TallaVo> tallas = new ArrayList<TallaVo>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT pd.id_size,sz.name "
                    + "from product_sizes as pd "
                    + "INNER JOIN sizes as sz on sz.id_size = pd.id_size "
                    + "WHERE art =? and amount >0");

            preparedStatement.setString(1, art);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                
                TallaVo talla = new TallaVo();
                talla.setId_size(resultSet.getInt(1));
                talla.setSize_name(resultSet.getString(2));
                
                tallas.add(talla);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return tallas;
    }
    
    public ArrayList<TallaVo> getTallasColor(String art, String color){
     Conectarse conn = new Conectarse();
            
           ArrayList<TallaVo> tallas = new ArrayList<TallaVo>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT pd.id_size,sz.name "
                  + "from product_sizes as pd "
                  + "INNER JOIN sizes as sz on sz.id_size = pd.id_size "
                  + "WHERE art =? and color_art = ? ");

            preparedStatement.setString(1, art);
            preparedStatement.setString(2, color);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                
                TallaVo talla = new TallaVo();
                talla.setId_size(resultSet.getInt(1));
                talla.setSize_name(resultSet.getString(2));
                
                tallas.add(talla);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return tallas;
    }
    
    public TallaVo getTalla(int idTalla){
            Conectarse conn = new Conectarse();
            //ConecRemoto conn = new ConecRemoto();
            TallaVo talla = new TallaVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_size, id_category, id_type_product, "
                    + "name AS size_name "
                    + "FROM sizes "
                    + "WHERE id_size = ? ");

            preparedStatement.setInt(1, idTalla);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                
                talla.setId_size(resultSet.getInt(1));
                talla.setId_category(resultSet.getInt(2));
                talla.setId_type_product(resultSet.getInt(3));
                talla.setSize_name(resultSet.getString(4));
                
                
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return talla;
    }
    
}
