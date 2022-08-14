/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author enriq
 */
public class ConsultasUsuarios extends Conexion {
    Connection Con = getConexion();
    
    public boolean buscarLogin(ModeloUsuario Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM usuarios WHERE Usuario = ? AND Password = ?";
            Ps = Con.prepareCall(SQL);
            
            Ps.setString(1, Modelo.getUsuario());
            Ps.setString(2, Modelo.getPassword());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre(Rs.getString("nombre"));
                Modelo.setTipo(Rs.getString("tipo"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " +e);
            return false;
        }
    }
    
    public boolean insertar(ModeloUsuario Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "INSERT INTO usuarios (Usuario, Password, Nombre, Tipo) VALUES (?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getUsuario());
            Ps.setString(2, Modelo.getPassword());
            Ps.setString(3, Modelo.getNombre());
            Ps.setString(4, Modelo.getTipo());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n" +e);
            return false;
        }
    }
    
    public boolean modificar(ModeloUsuario Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "UPDATE usuarios SET Password=?, Nombre=?, Tipo=? WHERE Usuario=?";
            Ps = Con.prepareCall(SQL);   
            Ps.setString(1, Modelo.getPassword());
            Ps.setString(2, Modelo.getNombre());
            Ps.setString(3, Modelo.getTipo());
            Ps.setString(4, Modelo.getUsuario());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n" +e);
            return false;
        }
    }
    
    public boolean eliminar(ModeloUsuario Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "DELETE FROM usuarios WHERE Usuario=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getUsuario());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n" +e);
            return false;
        }
    }
    
    public boolean buscar(ModeloUsuario Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM usuarios WHERE Usuario=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getUsuario());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
               Modelo.setPassword(Rs.getString("Password"));
               Modelo.setNombre(Rs.getString("Nombre"));
               Modelo.setTipo(Rs.getString("Tipo"));
               return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n "+e);
            return false;
        }
    }
}
