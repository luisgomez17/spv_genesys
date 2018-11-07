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
import javax.swing.JOptionPane;

/**
 *
 * @author luism
 */
public class SystemDao {
    Texto escrib = new Texto();
    public SystemVo getUser(String id, String pass){
           
        Conectarse conn = new Conectarse();
        //ConecRemoto conn = new ConecRemoto();
              SystemVo usuario = new SystemVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, user, password, Nombre, Apellidos, id_perfil, id_local  "
                    + "FROM users_system "
                    + "WHERE user =? and password =? ");

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                
                usuario.setId_user(resultSet.getInt(1));
                usuario.setUser(resultSet.getString(2));
                usuario.setPassword(resultSet.getString(3));
                usuario.setNombre(resultSet.getString(4));
                usuario.setApellidos(resultSet.getString(5));
                usuario.setId_perfil(resultSet.getInt(6));
                usuario.setId_local(resultSet.getInt(7));
                
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return usuario;
    }
    
     public void registrarVendedor(SystemVo vendedor)
	{
		Conectarse conex= new Conectarse();
		
			   try {
        String query = " insert into users_system (user, password, Nombre, Apellidos, id_perfil, id_local)"
        + " values (?, ?, ?, ?, ?, ?)";
                                
            PreparedStatement preparedStatement = conex.getConn().prepareStatement(query);
            preparedStatement.setString(1, vendedor.getUser());
            preparedStatement.setString(2, vendedor.getPassword());
            preparedStatement.setString(3, vendedor.getNombre());
            preparedStatement.setString(4, vendedor.getApellidos());
            preparedStatement.setInt(5, vendedor.getId_perfil());
            preparedStatement.setInt(6, vendedor.getId_local());
          
        
String consulta = "insert into users_system (user, password, Nombre, Apellidos, id_perfil, id_local)"+ " values ('"+vendedor.getUser()+"', '"+vendedor.getPassword()+"', '"+vendedor.getNombre()+"', '"+vendedor.getApellidos()+"', '"+vendedor.getId_perfil()+"', '"+vendedor.getId_local()+"');";
            escrib.escribir(consulta);
            preparedStatement.execute();
          
          //JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
			
          conex.getConn().close();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
       
   
     
      public ArrayList<SystemVo> getListVendedores() {
        Conectarse conn = new Conectarse();
        //Arreglo de Usuarios 
        ArrayList<SystemVo> usuarios = new ArrayList();
        try {
           PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, user, Nombre, Apellidos  "
                    + "FROM users_system ");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                while (resultSet.next()) {
                SystemVo usuario = new SystemVo();
                usuario.setId_user(resultSet.getInt(1));
                usuario.setUser(resultSet.getString(2));
                usuario.setNombre(resultSet.getString(3));
                usuario.setApellidos(resultSet.getString(4));
                
                
                usuarios.add(usuario);
                        
                }
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return usuarios;
    }
     
      public ArrayList<SystemVo> getVendedoresNombre(String nombre) {
        Conectarse conn = new Conectarse();
        //Arreglo de Usuarios 
        ArrayList<SystemVo> usuarios = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, user, Nombre, Apellidos  "
                    + "FROM users_system "
                    + "where Nombre like ? OR Apellidos like ?");
            
            preparedStatement.setString(1,"%" +  nombre + "%");
            preparedStatement.setString(2,"%" +  nombre + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
               SystemVo usuario = new SystemVo();
                usuario.setId_user(resultSet.getInt(1));
                usuario.setUser(resultSet.getString(2));
                usuario.setNombre(resultSet.getString(3));
                usuario.setApellidos(resultSet.getString(4));
                
                //Agregado del usuario al arreglo
                usuarios.add(usuario);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return usuarios;
    }
      
      
    }

