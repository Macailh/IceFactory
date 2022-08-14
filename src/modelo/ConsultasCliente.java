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
public class ConsultasCliente extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloCliente Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "INSERT INTO clientes (idCliente, nombreCliente, apellidoPaterno, apellidoMaterno, curp, telefono, direccion, codigoPostal) VALUES (?,?,?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdCliente());
            Ps.setString(2, Modelo.getNombreCliente());
            Ps.setString(3, Modelo.getApellidoPaterno());
            Ps.setString(4, Modelo.getApellidoMaterno());
            Ps.setString(5, Modelo.getCurp());
            Ps.setString(6, Modelo.getTelefono());
            Ps.setString(7, Modelo.getDireccion());
            Ps.setInt(8, Modelo.getCodigoPostal());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n" +e);
            return false;
        }
    }
    
    public boolean modificar(ModeloCliente Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "UPDATE clientes SET nombreCliente=?, apellidoPaterno=?, apellidoMaterno=?, curp=?, telefono=?, direccion=?, codigoPostal=? WHERE idCliente=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombreCliente());
            Ps.setString(2, Modelo.getApellidoPaterno());
            Ps.setString(3, Modelo.getApellidoMaterno());
            Ps.setString(4, Modelo.getCurp());
            Ps.setString(5, Modelo.getTelefono());
            Ps.setString(6, Modelo.getDireccion());
            Ps.setInt(7, Modelo.getCodigoPostal());
            Ps.setInt(8, Modelo.getIdCliente());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n" +e);
            return false;
        }
    }
    
    public boolean eliminar(ModeloCliente Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "DELETE FROM clientes WHERE idCliente=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdCliente());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n" +e);
            return false;
        }
    }
    
    public boolean buscar(ModeloCliente Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM clientes WHERE idCliente=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdCliente());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
               Modelo.setNombreCliente(Rs.getString("NombreCliente"));
               Modelo.setApellidoPaterno(Rs.getString("ApellidoPaterno"));
               Modelo.setApellidoMaterno(Rs.getString("ApellidoMaterno"));
               Modelo.setCurp(Rs.getString("Curp"));
               Modelo.setTelefono(Rs.getString("Telefono"));
               Modelo.setDireccion(Rs.getString("Direccion"));
               Modelo.setCodigoPostal(Rs.getInt("CodigoPostal"));
               return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n "+e);
            return false;
        }
    }
    
    public boolean buscarTodosLosClientes(DefaultTableModel Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM clientes ORDER BY nombreCliente";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("IdCliente");
                Fila[1] = Rs.getString("NombreCliente");
                Fila[2] = Rs.getString("ApellidoPaterno");
                Fila[3] = Rs.getString("ApellidoMaterno");
                Fila[4] = Rs.getString("Curp");
                Fila[5] = Rs.getInt("Telefono");
                Fila[6] = Rs.getString("Direccion");
                Fila[7] = Rs.getString("CodigoPostal");
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
            String SQL = "sELECT * FROM clientes WHERE nombreCliente like '%" + TxtConsultar.getText()+"%'";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {
                String Fila[] = new String[numeroDeCampos];
                Fila[0] = Rs.getInt("IdCliente")+"";
                Fila[1] = Rs.getString("NombreCliente");
                Fila[2] = Rs.getString("ApellidoPaterno");
                Fila[3] = Rs.getString("ApellidoMaterno");
                Fila[4] = Rs.getString("Curp");
                Fila[5] = Rs.getInt("Telefono")+"";
                Fila[6] = Rs.getString("Direccion");
                Fila[7] = Rs.getString("CodigoPostal");
                ModeloTabla.addRow(Fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: buscarFrase()\n "+e);
        }
    }
}
