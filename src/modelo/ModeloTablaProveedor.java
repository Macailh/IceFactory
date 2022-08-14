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
public class ModeloTablaProveedor {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaProveedor() {
        ModeloTabla.addColumn("IDProveedor");
        ModeloTabla.addColumn("NombreProveedor");
        ModeloTabla.addColumn("Nombrecontacto");
        ModeloTabla.addColumn("PuestoContacto");
        ModeloTabla.addColumn("Direccion");
        ModeloTabla.addColumn("CodigoPostal");
        ModeloTabla.addColumn("Ciudad");
        ModeloTabla.addColumn("Pais");
        ModeloTabla.addColumn("Telefono");
        ModeloTabla.addColumn("Email");
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}
