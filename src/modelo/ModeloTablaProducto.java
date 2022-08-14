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
public class ModeloTablaProducto {
 DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaProducto() {
        ModeloTabla.addColumn("IDProducto");
        ModeloTabla.addColumn("NombreProducto");
        ModeloTabla.addColumn("Descripcion");
        ModeloTabla.addColumn("Categoria");
        ModeloTabla.addColumn("Existencias");
        ModeloTabla.addColumn("Precio");
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}

