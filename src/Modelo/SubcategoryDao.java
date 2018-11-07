package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubcategoryDao {
    public ArrayList<SubcategoryVo> getSubcategories(Integer id_category) {
        Conectarse conn = new Conectarse();
        //ConecRemoto conn = new ConecRemoto();
        ArrayList<SubcategoryVo> subcategories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.getConn().prepareStatement(
                    "SELECT id_category, id_subcategory, name AS subcategory_name "
                    + "FROM subcategories "
                    + "WHERE id_category = ?");

            preparedStatement.setInt(1, id_category);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Muestra resultados de la consulta SQL
            while (resultSet.next()) {
                //Objeto de tipo sucategory
                SubcategoryVo subcategory = new SubcategoryVo();
                
                subcategory.setId_category(resultSet.getInt(1));
                subcategory.setId_subcategory(resultSet.getInt(2));
                subcategory.setSucategory_name(resultSet.getString(3));
                
                subcategories.add(subcategory);
            }
            //Cierra todo
            conn.getConn().close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Retorna el usuario
        return subcategories;
    }
}
