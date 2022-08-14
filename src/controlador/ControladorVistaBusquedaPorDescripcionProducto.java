/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasProducto;
import modelo.ModeloProducto;
import modelo.ModeloTablaProducto;
import vista.VistaBusquedaPorDescripcionProducto;

/**
 *
 * @author enriq
 */
public class ControladorVistaBusquedaPorDescripcionProducto implements MouseListener, KeyListener{
    ModeloTablaProducto ModeloTablaProducto;
    ModeloProducto ModeloProducto;
    VistaBusquedaPorDescripcionProducto VistaBusquedaPorDescripcionProducto;
    ConsultasProducto ConsultasProducto = new ConsultasProducto();

    public ControladorVistaBusquedaPorDescripcionProducto(ModeloTablaProducto ModeloTablaProducto, ModeloProducto ModeloProducto, VistaBusquedaPorDescripcionProducto VistaBusquedaPorDescripcionProducto) {
        this.ModeloTablaProducto = ModeloTablaProducto;
        this.ModeloProducto = ModeloProducto;
        this.VistaBusquedaPorDescripcionProducto = VistaBusquedaPorDescripcionProducto;
        oyentes();
        llenarTablaProveedor();
        VistaBusquedaPorDescripcionProducto.setVisible(true);
    }

    private void oyentes() {
        VistaBusquedaPorDescripcionProducto.TxtNombre.addMouseListener(this);
        VistaBusquedaPorDescripcionProducto.Tabla.addMouseListener(this);
        VistaBusquedaPorDescripcionProducto.BtnAceptar.addMouseListener(this);
        VistaBusquedaPorDescripcionProducto.TxtNombre.addKeyListener(this);
    }

    private void llenarTablaProveedor() {
        ConsultasProducto.buscarTodosLosProductos(ModeloTablaProducto.getModeloTabla());
        VistaBusquedaPorDescripcionProducto.Tabla.setModel(ModeloTablaProducto.getModeloTabla());
    }
    
    private void llenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = VistaBusquedaPorDescripcionProducto.Tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int IDProducto = Integer.parseInt(ModeloTablaProducto.getModeloTabla().getValueAt(filaSeleccionada, 0).toString());
            String NombreProducto = ModeloTablaProducto.getModeloTabla().getValueAt(filaSeleccionada, 1).toString();
            String Descripcion = ModeloTablaProducto.getModeloTabla().getValueAt(filaSeleccionada, 2).toString();
            String Categoria = ModeloTablaProducto.getModeloTabla().getValueAt(filaSeleccionada, 3).toString();
            int Existencias = Integer.parseInt(ModeloTablaProducto.getModeloTabla().getValueAt(filaSeleccionada, 4).toString());
            double Precio = Double.parseDouble(ModeloTablaProducto.getModeloTabla().getValueAt(filaSeleccionada, 5).toString());
            
            ModeloProducto.setIdProducto(IDProducto);
            ModeloProducto.setNombreProducto(NombreProducto);
            ModeloProducto.setDescripcion(Descripcion);
            ModeloProducto.setCategoria(Categoria);
            ModeloProducto.setExistencias(Existencias);
            ModeloProducto.setPrecio(Precio);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaBusquedaPorDescripcionProducto.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            VistaBusquedaPorDescripcionProducto.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()==VistaBusquedaPorDescripcionProducto.TxtNombre) {
            ConsultasProducto.buscarFrase(VistaBusquedaPorDescripcionProducto.TxtNombre, ModeloTablaProducto.getModeloTabla());
            
        }
    }
}
