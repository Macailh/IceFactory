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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enriq
 */
public class ConsultasProducto extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "INSERT INTO productos (idProducto,nombreProducto,descripcion,categoria,existencias,precio) VALUES (?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdProducto());
            Ps.setString(2, Modelo.getNombreProducto());
            Ps.setString(3, Modelo.getDescripcion());
            Ps.setString(4, Modelo.getCategoria());
            Ps.setInt(5, Modelo.getExistencias());
            Ps.setDouble(6, Modelo.getPrecio());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: insertar()\n" +e);
            return false;
        }
    }
    
    public boolean modificar(ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "UPDATE productos SET nombreProducto=?, descripcion=?, categoria=?, existencias=?, precio=? WHERE idProducto=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombreProducto());
            Ps.setString(2, Modelo.getDescripcion());
            Ps.setString(3, Modelo.getCategoria());
            Ps.setFloat(4, Modelo.getExistencias());
            Ps.setDouble(5, Modelo.getPrecio());
            Ps.setInt(6, Modelo.getIdProducto());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: modificar()\n" +e);
            return false;
        }
    }
    
    public boolean eliminar(ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "DELETE FROM productos WHERE idProducto=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdProducto());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL: eliminar()\n" +e);
            return false;
        }
    }
    
    public boolean buscar(ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM productos WHERE idProducto=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdProducto());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
               Modelo.setNombreProducto(Rs.getString("NombreProducto"));
               Modelo.setDescripcion(Rs.getString("Descripcion"));
               Modelo.setCategoria(Rs.getString("Categoria"));
               Modelo.setExistencias(Rs.getInt("Existencias"));
               Modelo.setPrecio(Rs.getDouble("Precio"));
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
            String SQL = "SELECT * FROM productos ORDER BY nombreProducto";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("IdProducto");
                Fila[1] = Rs.getString("NombreProducto");
                Fila[2] = Rs.getString("Descripcion");
                Fila[3] = Rs.getString("Categoria");
                Fila[4] = Rs.getInt("Existencias");
                Fila[5] = Rs.getFloat("Precio");
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
            String SQL = "sELECT * FROM productos WHERE nombreProductos like '%" + TxtConsultar.getText()+"%'";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {
                String Fila[] = new String[numeroDeCampos];
                Fila[0] = Rs.getInt("IdProducto")+"";
                Fila[1] = Rs.getString("NombreProducto");
                Fila[2] = Rs.getString("Descripcion");
                Fila[3] = Rs.getString("Categoria");
                Fila[4] = Rs.getInt("Existencias")+"";
                Fila[5] = Rs.getFloat("Precio")+"";
                ModeloTabla.addRow(Fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: buscarFrase()\n "+e);
        }
    }
}
