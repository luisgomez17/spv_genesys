package Modelo;

import Vista.Texto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {
Texto aux = new Texto();
    public UsuarioVo getUsuario(Integer id) {
        ConecRemoto conn = new ConecRemoto();

        //Objeto de tipo Usuario 
        UsuarioVo usuario = new UsuarioVo();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, firstname, lastname, email, "
                    + "id_country, id_state, id_location, cp, "
                    + "direction, phone, rfc, register_date, money, sta.state, loc.location  "
                    + "FROM users_local as u "
                             + "INNER JOIN states as sta on sta.id = u.id_state "
                    +"INNER JOIN locations as loc on loc.id = u.id_location "
                    + "WHERE id_user = ?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setId_country(resultSet.getInt(5));
                usuario.setId_state(resultSet.getInt(6));
                usuario.setId_location(resultSet.getInt(7));
                usuario.setCp(resultSet.getInt(8));
                usuario.setDirection(resultSet.getString(9));
                usuario.setPhone(resultSet.getString(10));
                usuario.setRfc(resultSet.getString(11));
                usuario.setRegister_date(resultSet.getString(12));
                usuario.setMoney(resultSet.getDouble(13));
                usuario.setEstado(resultSet.getString(14));
                usuario.setLocalidad(resultSet.getString(15));
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
    
    public ArrayList<UsuarioVo> getUsuarios() {
        ConecRemoto conn = new ConecRemoto();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> usuarios = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, firstname, lastname, email, "
                    + "id_country, id_state, id_location, cp, "
                    + "direction, phone, rfc, register_date, money "
                    + "FROM users_local as u ");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setId_country(resultSet.getInt(5));
                usuario.setId_state(resultSet.getInt(6));
                usuario.setId_location(resultSet.getInt(7));
                usuario.setCp(resultSet.getInt(8));
                usuario.setDirection(resultSet.getString(9));
                usuario.setPhone(resultSet.getString(10));
                usuario.setRfc(resultSet.getString(11));
                usuario.setRegister_date(resultSet.getString(12));
                usuario.setMoney(resultSet.getDouble(13));

                
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
    
     public void UpdateMonedero(UsuarioVo usuario){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "UPDATE users_local SET money=? "
                    + "WHERE id_user = ?");
            
            preparedStatement.setDouble(1, usuario.getMoney());
            preparedStatement.setInt(2, usuario.getId_user());
            
String consulta = "UPDATE users_local SET money='"+usuario.getMoney()+"' "+ "WHERE id_user = '"+usuario.getId_user()+"';";
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
     
      public ArrayList<UsuarioVo> getEstados() {
        Conectarse conn = new Conectarse();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> estados = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT * FROM states ORDER BY state ASC");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_state(resultSet.getInt(1));
                usuario.setEstado(resultSet.getString(2));
                
                //Agregado del usuario al arreglo
                estados.add(usuario);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return estados;
    }
      
      public ArrayList<UsuarioVo> getLocalidadesPorEstado(int id) {
        Conectarse conn = new Conectarse();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> localidades = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
"SELECT id_location,lc.location from states_locations as sl \n" +
"INNER JOIN locations AS lc ON lc.id = sl.id_location\n" +
"INNER JOIN states as st ON st.id = sl.id_state\n" +
"where id_state = ? order by location ASC ");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_location(resultSet.getInt(1));
                usuario.setLocalidad(resultSet.getString(2));
                
                //Agregado del usuario al arreglo
                localidades.add(usuario);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna los usuarios
        return localidades;
    }
      
        public void agregarUsuario(UsuarioVo user){
        Conectarse conn = new Conectarse();
        
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
"INSERT INTO users_local (user_key, firstname, lastname, email, password, id_country, id_state, "
+ "id_location, cp, direction, phone, company_name, rfc, money) "
+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1,"");
            preparedStatement.setString(2, user.getFirstname());
            preparedStatement.setString(3, user.getLastname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, "");
            preparedStatement.setInt(6, user.getId_country());
            preparedStatement.setInt(7, user.getId_state());
            preparedStatement.setInt(8, user.getId_location());
            preparedStatement.setInt(9, user.getCp());
            preparedStatement.setString(10, user.getDirection());
            preparedStatement.setString(11, user.getPhone());
            preparedStatement.setString(12, "");
            preparedStatement.setString(13, user.getRfc());
            preparedStatement.setDouble(14, 0.0);
            
String consulta ="INSERT INTO users_local (user_key, firstname, lastname, email, password, id_country, id_state, "
+ "id_location, cp, direction, phone, company_name, rfc, money) "
+ "VALUES ('', '"+user.getFirstname()+"', '"+user.getLastname()+"', '"+user.getEmail()+"', '', '"+user.getId_country()+"', '"+user.getId_state()+"', '"+user.getId_location()+"', '"+user.getCp()+"', '"+user.getDirection()+"', '"+user.getPhone()+"','','"+user.getRfc()+"','"+0.0+"');";
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
         public ArrayList<UsuarioVo> getUsuariosBusqueda(String nombre) {
        ConecRemoto conn = new ConecRemoto();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> usuarios = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, firstname, lastname, email, "
                    + "id_country, id_state, id_location, cp, "
                    + "direction, phone, rfc, register_date, money, sta.state, loc.location "
                    + "FROM users_local as u "
                    + "INNER JOIN states as sta on sta.id = u.id_state "
                    +"INNER JOIN locations as loc on loc.id = u.id_location "
                    + "WHERE firstname LIKE ? OR lastname LIKE ? ");
            
            preparedStatement.setString(1,"%" +  nombre + "%");
            preparedStatement.setString(2,"%" +  nombre + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setId_country(resultSet.getInt(5));
                usuario.setId_state(resultSet.getInt(6));
                usuario.setId_location(resultSet.getInt(7));
                usuario.setCp(resultSet.getInt(8));
                usuario.setDirection(resultSet.getString(9));
                usuario.setPhone(resultSet.getString(10));
                usuario.setRfc(resultSet.getString(11));
                usuario.setRegister_date(resultSet.getString(12));
                usuario.setMoney(resultSet.getDouble(13));
                usuario.setEstado(resultSet.getString(14));
                usuario.setLocalidad(resultSet.getString(15));
                
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
 public ArrayList<UsuarioVo> getUsuariosCredito() {
        ConecRemoto conn = new ConecRemoto();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> usuarios = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT DISTINCT u.id_user, u.firstname, u.lastname, u.email, u.cp,u.direction, u.phone, u.rfc "
                    + "FROM users_local as u "
                    + "INNER JOIN sales as sl on sl.id_user = u.id_user "
                    + "where sl.credito=1 and sl.total>0");

            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setCp(resultSet.getInt(5));
                usuario.setDirection(resultSet.getString(6));
                usuario.setPhone(resultSet.getString(7));
                usuario.setRfc(resultSet.getString(8));
             
                
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
 public ArrayList<UsuarioVo> getUsuariosBusquedaCredito(String nombre) {
        ConecRemoto conn = new ConecRemoto();
        //Arreglo de Usuarios 
        ArrayList<UsuarioVo> usuarios = new ArrayList();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_user, firstname, lastname, email, "
                    + "id_country, id_state, id_location, cp, "
                    + "direction, phone, rfc, register_date, money, sta.state, loc.location "
                    + "FROM users as u "
                    + "INNER JOIN states as sta on sta.id = u.id_state "
                    +"INNER JOIN locations as loc on loc.id = u.id_location "
                    +"INNER JOIN sales as sl on sl.id_user = u.id_user "
                    + "WHERE firstname LIKE ? OR lastname LIKE ? and s1.credito=1  and sl.total>0");
            
            preparedStatement.setString(1,"%" +  nombre + "%");
            preparedStatement.setString(2,"%" +  nombre + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            //Resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto Usuario
                UsuarioVo usuario = new UsuarioVo();
                
                usuario.setId_user(resultSet.getInt(1));
                usuario.setFirstname(resultSet.getString(2));
                usuario.setLastname(resultSet.getString(3));
                usuario.setEmail(resultSet.getString(4));
                usuario.setId_country(resultSet.getInt(5));
                usuario.setId_state(resultSet.getInt(6));
                usuario.setId_location(resultSet.getInt(7));
                usuario.setCp(resultSet.getInt(8));
                usuario.setDirection(resultSet.getString(9));
                usuario.setPhone(resultSet.getString(10));
                usuario.setRfc(resultSet.getString(11));
                usuario.setRegister_date(resultSet.getString(12));
                usuario.setMoney(resultSet.getDouble(13));
                usuario.setEstado(resultSet.getString(14));
                usuario.setLocalidad(resultSet.getString(15));
                
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
