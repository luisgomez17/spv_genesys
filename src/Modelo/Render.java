package Modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;


public class Render extends DefaultTableCellRenderer{
private Component component;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        component = super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, column);
        
        int valor = (int) table.getValueAt(row, 6);
        if(valor > 0){
           component.setBackground(Color.yellow); 
            }else{
           component.setBackground(Color.WHITE); 
            }
            
        
        
        
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
        
}
