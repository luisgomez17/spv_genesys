package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luism
 */
public class LocalDao {
    
    public ArrayList<LocalVo> getLocales() {
        Conectarse conn = new Conectarse();
        ArrayList<LocalVo> listado = new ArrayList<>();
        
        
        try{
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
             "SELECT * FROM locales ");

        
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                LocalVo local = new LocalVo();
                local.setId_local(resultSet.getInt(1));
                local.setNombre(resultSet.getString(2));
                
               
                listado.add(local);
                

            }

           
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return listado;
        
    }
    
}
