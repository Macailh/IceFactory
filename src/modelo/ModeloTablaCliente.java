/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enriq
 */
public class ModeloTablaCliente {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaCliente() {
        ModeloTabla.addColumn("IDCliente");
        ModeloTabla.addColumn("NombreCliente");
        ModeloTabla.addColumn("ApellidoPaterno");
        ModeloTabla.addColumn("ApellidoMaterno");
        ModeloTabla.addColumn("Curp");
        ModeloTabla.addColumn("Telefono");
        ModeloTabla.addColumn("Direccion");
        ModeloTabla.addColumn("CodigoPostal");
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}
