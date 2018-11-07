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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luism
 */
public class ColorDao {
    Texto escrib = new Texto();
    public ColorVo getColor(String id){
            Conectarse conn = new Conectarse();
  
            ColorVo color = new ColorVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT color_art,color_name,color_hex_code "
                    + "FROM colors "
                    + "WHERE color_art = ? ");

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                color.setColor_art(resultSet.getString(1));
                color.setColor_name(resultSet.getString(2));
                color.setColor_hex_code(resultSet.getString(3));
                
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return color;
    }
    
    
       public ArrayList<ColorVo> getColores() {
        ConecRemoto conn = new ConecRemoto();
        //Arreglo de Colores 
        ArrayList<ColorVo> colores = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT color_art,color_name,color_hex_code "
                    + "FROM colors "
                    + "ORDER BY color_name ASC " );
            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto color
                ColorVo color = new ColorVo();
                
                color.setColor_art(resultSet.getString(1));
                color.setColor_name(resultSet.getString(2));
                color.setColor_hex_code(resultSet.getString(3));
                
                
                //Agregado del color al arreglo
                colores.add(color);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return colores;
    }
       
       
       public void registrarColor(ColorVo color)
	{
		Conectarse conex= new Conectarse();
		
			   try {
                                String query = " insert into colors (color_art, color_name, color_hex_code)"
        + " values (?, ?, ?)";
                                
            PreparedStatement preparedStatement = conex.getConn().prepareStatement(query);
            preparedStatement.setString(1, color.getColor_art());
            preparedStatement.setString(2, color.getColor_name());
            preparedStatement.setString(3, color.getColor_hex_code());
        
String consulta = "insert into colors (color_art, color_name, color_hex_code)"+ " values ('"+color.getColor_art()+"', '"+color.getColor_name()+"', '"+color.getColor_hex_code()+"');";
            escrib.escribir(consulta);
            preparedStatement.execute();
          
          //JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
			
          conex.getConn().close();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
       
       
       public ArrayList<ColorVo> getColorArt(String art, int talla){
     Conectarse conn = new Conectarse();
            
           ArrayList<ColorVo> colores = new ArrayList<ColorVo>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT ps.color_art, c.color_name  "
                    + "from product_sizes as ps "
                    + "INNER JOIN colors as c on c.color_art = ps.color_art "
                    + "WHERE ps.art = ? AND ps.id_size = ? AND ps.amount >0");

            preparedStatement.setString(1, art);
            preparedStatement.setInt(2, talla);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                
                ColorVo color = new ColorVo();
                color.setColor_art(resultSet.getString(1));
                color.setColor_name(resultSet.getString(2));
                colores.add(color);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return colores;
    }
       
       public ArrayList<ColorVo> getColorsArt(String art){
     Conectarse conn = new Conectarse();
            
           ArrayList<ColorVo> colores = new ArrayList<ColorVo>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT DISTINCT ps.color_art, c.color_name, c.color_hex_code "
                    + "from product_sizes as ps "
                    + "INNER JOIN colors as c on c.color_art = ps.color_art "
                    + "WHERE ps.art = ? ");

            preparedStatement.setString(1, art);
            
            
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                
                ColorVo color = new ColorVo();
                color.setColor_art(resultSet.getString(1));
                color.setColor_name(resultSet.getString(2));
                color.setColor_hex_code(resultSet.getString(3));
                colores.add(color);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el color
     return colores;
    }
}
