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
import modelo.ConsultasCliente;
import modelo.ModeloCliente;
import modelo.ModeloTablaCliente;
import vista.VistaBusquedaPorDescripcionCliente;

/**
 *
 * @author enriq
 */
public class ControladorVistabusquedaPorDescripcionCliente implements MouseListener, KeyListener{
    ModeloTablaCliente ModeloTablaCliente;
    ModeloCliente ModeloCliente;
    VistaBusquedaPorDescripcionCliente VistaBusquedaPorDescripcionCliente;
    ConsultasCliente consultasCliente = new ConsultasCliente();

    public ControladorVistabusquedaPorDescripcionCliente(ModeloTablaCliente ModeloTablaCliente, ModeloCliente ModeloCliente, VistaBusquedaPorDescripcionCliente VistaBusquedaPorDescripcionCliente) {
        this.ModeloTablaCliente = ModeloTablaCliente;
        this.ModeloCliente = ModeloCliente;
        this.VistaBusquedaPorDescripcionCliente = VistaBusquedaPorDescripcionCliente;
        oyentes();
        llenarTablaCliente();
        VistaBusquedaPorDescripcionCliente.setVisible(true);
    }

    private void oyentes() {
        VistaBusquedaPorDescripcionCliente.TxtNombre.addMouseListener(this);
        VistaBusquedaPorDescripcionCliente.Tabla.addMouseListener(this);
        VistaBusquedaPorDescripcionCliente.BtnAceptar.addMouseListener(this);
        VistaBusquedaPorDescripcionCliente.TxtNombre.addKeyListener(this);
    }

    private void llenarTablaCliente() {
        consultasCliente.buscarTodosLosClientes(ModeloTablaCliente.getModeloTabla());
        VistaBusquedaPorDescripcionCliente.Tabla.setModel(ModeloTablaCliente.getModeloTabla());
    }
    
    private void llenarModeloConSeleccionFilaTabla(){
        int filaSeleccionada = VistaBusquedaPorDescripcionCliente.Tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int IDCliente = Integer.parseInt(ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 0).toString());
            String NombreCliente = ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 1).toString();
            String ApellidoPaterno = ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 2).toString();
            String ApellidoMaterno = ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 3).toString();
            String Curp= ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 4).toString();
            String Telefono = ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 5).toString();
            String Direccion = ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 6).toString();
            int CodigoPostal = Integer.parseInt(ModeloTablaCliente.getModeloTabla().getValueAt(filaSeleccionada, 7).toString());
            
            ModeloCliente.setIdCliente(IDCliente);
            ModeloCliente.setNombreCliente(NombreCliente);
            ModeloCliente.setApellidoPaterno(ApellidoPaterno);
            ModeloCliente.setApellidoMaterno(ApellidoMaterno);
            ModeloCliente.setCurp(Curp);
            ModeloCliente.setTelefono(Telefono);
            ModeloCliente.setDireccion(Direccion);
            ModeloCliente.setCodigoPostal(CodigoPostal);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaBusquedaPorDescripcionCliente.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            VistaBusquedaPorDescripcionCliente.dispose();
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
        if (e.getSource()==VistaBusquedaPorDescripcionCliente.TxtNombre) {
            consultasCliente.buscarFrase(VistaBusquedaPorDescripcionCliente.TxtNombre, ModeloTablaCliente.getModeloTabla());
            
        }
    }
}
