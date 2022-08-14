/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author enriq
 */
public class Conexion {
    private final String Servidor = "localhost";
    private final String Database = "fabricahielo";
    private final String Usuario = "root";
    private final String Password = "";
    private final String Puerto = "3306";
    private final String Url = "jdbc:mysql://"+Servidor+":"+Puerto+"/"+Database+"?useUnicode=true&character_set_server=utf8mb4_unicode_ci";
    
    private static Connection Con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = (Connection) DriverManager.getConnection(Url, Usuario,Password);
            System.out.println("Conexion establecida con la base de datos "+Database);
        } catch (SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
    }
    
    public Connection getConexion(){
        return Con;
    }
}
