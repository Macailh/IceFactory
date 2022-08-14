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
import modelo.ConsultasProveedor;
import modelo.ModeloProveedor;
import modelo.ModeloTablaProveedor;
import vista.VistaBusquedaPorDescripcion;

/**
 *
 * @author enriq
 */
public class ControladorVistaBusquedaPorDescripcion implements MouseListener, KeyListener{
    ModeloTablaProveedor ModeloTablaProveedor;
    ModeloProveedor ModeloProveedor;
    VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion;
    ConsultasProveedor ConsultasProveedor = new ConsultasProveedor();

    public ControladorVistaBusquedaPorDescripcion(ModeloTablaProveedor ModeloTablaProveedor, ModeloProveedor ModeloProveedor, VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion) {
        this.ModeloTablaProveedor = ModeloTablaProveedor;
        this.ModeloProveedor = ModeloProveedor;
        this.VistaBusquedaPorDescripcion = VistaBusquedaPorDescripcion;
        oyentes();
        llenarTablaProveedor();
        VistaBusquedaPorDescripcion.setVisible(true);
    }

    private void oyentes() {
        VistaBusquedaPorDescripcion.TxtNombre.addMouseListener(this);
        VistaBusquedaPorDescripcion.Tabla.addMouseListener(this);
        VistaBusquedaPorDescripcion.BtnAceptar.addMouseListener(this);
        VistaBusquedaPorDescripcion.TxtNombre.addKeyListener(this);
    }

    private void llenarTablaProveedor() {
        ConsultasProveedor.buscarTodosLosProductos(ModeloTablaProveedor.getModeloTabla());
        VistaBusquedaPorDescripcion.Tabla.setModel(ModeloTablaProveedor.getModeloTabla());
    }
    
    private void llenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = VistaBusquedaPorDescripcion.Tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int IDProveedor = Integer.parseInt(ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 0).toString());
            String NombreProveedor = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 1).toString();
            String NombreContacto = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 2).toString();
            String PuestoContacto = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 3).toString();
            String Direccion = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 4).toString();
            int CodigoPostal = Integer.parseInt(ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 5).toString());
            String Ciudad = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 6).toString();
            String Pais = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 7).toString();
            String Telefono = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 8).toString();
            String Email = ModeloTablaProveedor.getModeloTabla().getValueAt(filaSeleccionada, 9).toString();
            
            ModeloProveedor.setIDProveedor(IDProveedor);
            ModeloProveedor.setNombreProveedor(NombreProveedor);
            ModeloProveedor.setNombreContacto(NombreContacto);
            ModeloProveedor.setRfc(PuestoContacto);
            ModeloProveedor.setDireccion(Direccion);
            ModeloProveedor.setCodigoPostal(CodigoPostal);
            ModeloProveedor.setCiudad(Ciudad);
            ModeloProveedor.setPais(Pais);
            ModeloProveedor.setTelefono(Telefono);
            ModeloProveedor.setEmail(Email);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaBusquedaPorDescripcion.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            VistaBusquedaPorDescripcion.dispose();
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
        if (e.getSource()==VistaBusquedaPorDescripcion.TxtNombre) {
            ConsultasProveedor.buscarFrase(VistaBusquedaPorDescripcion.TxtNombre, ModeloTablaProveedor.getModeloTabla());
            
        }
    }
}
