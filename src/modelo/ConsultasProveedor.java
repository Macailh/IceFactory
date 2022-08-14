/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enriq
 */
public class ConsultasProveedor extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloProveedor Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "INSERT INTO proveedores (idProveedor, nombreProveedor, contacto, Rfc, direccion, codigoPostal, ciudad, pais, telefono, email) VALUES (?,?,?,?,?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIDProveedor());
            Ps.setString(2, Modelo.getNombreProveedor());
            Ps.setString(3, Modelo.getNombreContacto());
            Ps.setString(4, Modelo.getRfc());
            Ps.setString(5, Modelo.getDireccion());
            Ps.setInt(6, Modelo.getCodigoPostal());
            Ps.setString(7, Modelo.getCiudad());
            Ps.setString(8, Modelo.getPais());
            Ps.setString(9, Modelo.getTelefono());
            Ps.setString(10, Modelo.getEmail());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n" +e);
            return false;
        }
    }
    
    public boolean modificar(ModeloProveedor Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "UPDATE proveedores SET nombreProveedor=?, contacto=?, rfc=?, direccion=?, codigoPostal=?, ciudad=?, pais=?, telefono=?, email=? WHERE idProveedor=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombreProveedor());
            Ps.setString(2, Modelo.getNombreContacto());
            Ps.setString(3, Modelo.getRfc());
            Ps.setString(4, Modelo.getDireccion());
            Ps.setInt(5, Modelo.getCodigoPostal());
            Ps.setString(6, Modelo.getCiudad());
            Ps.setString(7, Modelo.getPais());
            Ps.setString(8, Modelo.getTelefono());
            Ps.setString(9, Modelo.getEmail());
            Ps.setInt(10, Modelo.getIDProveedor());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n" +e);
            return false;
        }
    }
    
    public boolean eliminar(ModeloProveedor Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "DELETE FROM proveedores WHERE idProveedor=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIDProveedor());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n" +e);
            return false;
        }
    }
    
    public boolean buscar(ModeloProveedor Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM proveedores WHERE idProveedor=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIDProveedor());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
               Modelo.setNombreProveedor(Rs.getString("NombreProveedor"));
               Modelo.setNombreContacto(Rs.getString("Contacto"));
               Modelo.setRfc(Rs.getString("Rfc"));
               Modelo.setDireccion(Rs.getString("Direccion"));
               Modelo.setCodigoPostal(Rs.getInt("CodigoPostal"));
               Modelo.setCiudad(Rs.getString("Ciudad"));
               Modelo.setPais(Rs.getString("Pais"));
               Modelo.setTelefono(Rs.getString("Telefono"));
               Modelo.setEmail(Rs.getString("Email"));
               return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n "+e);
            return false;
        }
    }
    
    public boolean buscarTodosLosProductos(DefaultTableModel Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM proveedores ORDER BY nombreProveedor";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("IdProveedor");
                Fila[1] = Rs.getString("NombreProveedor");
                Fila[2] = Rs.getString("Contacto");
                Fila[3] = Rs.getString("Rfc");
                Fila[4] = Rs.getString("Direccion");
                Fila[5] = Rs.getInt("CodigoPostal");
                Fila[6] = Rs.getString("Ciudad");
                Fila[7] = Rs.getString("Pais");
                Fila[8] = Rs.getString("Telefono");
                Fila[9] = Rs.getString("Email");
                Modelo.addRow(Fila);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: buscarTodosLosProductos()\n "+e);
            return false;
        }  
    }
    
    public void buscarFrase(JTextField TxtConsultar, DefaultTableModel ModeloTabla){
        try {
            PreparedStatement Ps;
            String SQL = "sELECT * FROM proveedores WHERE nombreProveedor like '%" + TxtConsultar.getText()+"%'";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {
                String Fila[] = new String[numeroDeCampos];
                Fila[0] = Rs.getInt("IdProveedor")+"";
                Fila[1] = Rs.getString("NombreProveedor");
                Fila[2] = Rs.getString("Contacto");
                Fila[3] = Rs.getString("Rfc");
                Fila[4] = Rs.getString("Direccion");
                Fila[5] = Rs.getInt("CodigoPostal")+"";
                Fila[6] = Rs.getString("Ciudad");
                Fila[7] = Rs.getString("Pais");
                Fila[8] = Rs.getString("Telefono");
                Fila[9] = Rs.getString("Email");
                ModeloTabla.addRow(Fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: buscarFrase()\n "+e);
        }
    }
}
