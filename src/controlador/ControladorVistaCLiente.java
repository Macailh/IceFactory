/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasCliente;
import modelo.ModeloCliente;
import modelo.ModeloProducto;
import modelo.ModeloTablaCliente;
import vista.VistaBusquedaPorDescripcionCliente;
import vista.VistaCliente;

/**
 *
 * @author enriq
 */
public class ControladorVistaCLiente implements MouseListener{
    private ModeloCliente ModeloCliente;
    private VistaCliente VistaCliente;
    private ConsultasCliente ConsultasCliente = new ConsultasCliente();

    public ControladorVistaCLiente(ModeloCliente ModeloCliente, VistaCliente VistaCliente) {
        this.ModeloCliente = ModeloCliente;
        this.VistaCliente = VistaCliente;
        oyentesVista();
        VistaCliente.setVisible(true);
    }

    private void oyentesVista() {
        VistaCliente.BtnGuardar.addMouseListener(this);
        VistaCliente.BtnActualizar.addMouseListener(this);
        VistaCliente.BtnEliminar.addMouseListener(this);
        VistaCliente.BtnBuscar.addMouseListener(this);
        VistaCliente.BtnSalir.addMouseListener(this);
        VistaCliente.LblSearch.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaCliente.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaCliente.BtnActualizar) {
            modificar();
        }else if (e.getSource()==VistaCliente.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaCliente.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaCliente.BtnSalir) {
            salir();
        }else if (e.getSource()==VistaCliente.LblSearch) {
            busquedaMVC();
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

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloCliente.setIdCliente(Integer.parseInt(VistaCliente.TxtIdCliente.getText()));
            if (ConsultasCliente.buscar(ModeloCliente)==true) {
                JOptionPane.showMessageDialog(VistaCliente, "Ese cliente ya existe");
            } else {
                llenarModeloConVista();
                if (ConsultasCliente.insertar(ModeloCliente)==true) {
                   JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                   limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo codigo no debe estar vacio");
        }
    }

    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            ModeloCliente ModeloTemporal = new ModeloCliente();
            ModeloTemporal.setIdCliente(Integer.parseInt(VistaCliente.TxtIdCliente.getText()));
            
            if (ConsultasCliente.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaCliente, "Ese producto no existe");
            } else {
                if (ConsultasCliente.modificar(ModeloCliente)){
                    JOptionPane.showMessageDialog(VistaCliente, "Registro modificado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }
    }

    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloCliente.setIdCliente(Integer.parseInt(VistaCliente.TxtIdCliente.getText()));
            if (ConsultasCliente.eliminar(ModeloCliente)==false) {
                JOptionPane.showMessageDialog(VistaCliente, "Ese producto no existe");
            } else {
                if (ConsultasCliente.eliminar(ModeloCliente)) {
                    JOptionPane.showMessageDialog(VistaCliente, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaCliente, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El compo codigo no debe estar vacio");
        }
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloCliente.setIdCliente(Integer.parseInt(VistaCliente.TxtIdCliente.getText()));
            if (ConsultasCliente.buscar(ModeloCliente)==true) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(VistaCliente, "Registro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(VistaCliente, "Los compos no deben estar vacios");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaCliente, "¿Desea salir de productos?", "Alerta!", 0, 1 );
        if (opc==0) {
            VistaCliente.dispose();
        }
    }
    
    private void busquedaMVC(){
        ModeloTablaCliente ModeloTablaProveedor = new ModeloTablaCliente();
        VistaBusquedaPorDescripcionCliente VistaBusquedaPorDescripcionCliente = new VistaBusquedaPorDescripcionCliente(new JFrame(), true);
        
        ControladorVistabusquedaPorDescripcionCliente ControladoSearch = new ControladorVistabusquedaPorDescripcionCliente(ModeloTablaProveedor, ModeloCliente, VistaBusquedaPorDescripcionCliente);
        llenarVistaConModelo();
    }
    
    private void llenarModeloConVista(){
        ModeloCliente.setIdCliente(Integer.parseInt(VistaCliente.TxtIdCliente.getText()));
        ModeloCliente.setNombreCliente(VistaCliente.TxtNombre.getText());
        ModeloCliente.setApellidoPaterno(VistaCliente.TxtApellidoPaterno.getText());
        ModeloCliente.setApellidoMaterno(VistaCliente.TxtApellidoMaterno.getText());
        ModeloCliente.setCurp(VistaCliente.TxtCurp.getText());
        ModeloCliente.setTelefono(VistaCliente.TxtTelefono.getText());
        ModeloCliente.setDireccion(VistaCliente.TxtDireccion.getText());
        ModeloCliente.setCodigoPostal(Integer.parseInt(VistaCliente.TxtCodigoPostal.getText()));
    }
    
    private void llenarVistaConModelo(){
        VistaCliente.TxtIdCliente.setText(ModeloCliente.getIdCliente()+"");
        VistaCliente.TxtNombre.setText(ModeloCliente.getNombreCliente());
        VistaCliente.TxtApellidoPaterno.setText(ModeloCliente.getApellidoPaterno());
        VistaCliente.TxtApellidoMaterno.setText(ModeloCliente.getApellidoMaterno());
        VistaCliente.TxtCurp.setText(ModeloCliente.getCurp());
        VistaCliente.TxtTelefono.setText(ModeloCliente.getTelefono());
        VistaCliente.TxtDireccion.setText(ModeloCliente.getDireccion());
        VistaCliente.TxtCodigoPostal.setText(ModeloCliente.getCodigoPostal()+"");
    }
    
    private void limpiarCampos(){
        VistaCliente.TxtIdCliente.setText("");
        VistaCliente.TxtNombre.setText("");
        VistaCliente.TxtApellidoPaterno.setText("");
        VistaCliente.TxtApellidoMaterno.setText("");
        VistaCliente.TxtCurp.setText("");
        VistaCliente.TxtTelefono.setText("");
        VistaCliente.TxtDireccion.setText("");
        VistaCliente.TxtCodigoPostal.setText("");
    }
    
    private boolean validarCampoCodigo(){
        return !VistaCliente.TxtIdCliente.getText().isEmpty();
    }
    
    private boolean validarTodosLosCampos(){
        return !(VistaCliente.TxtIdCliente.getText().isEmpty()||
                VistaCliente.TxtNombre.getText().isEmpty()||
                VistaCliente.TxtApellidoPaterno.getText().isEmpty()||
                VistaCliente.TxtApellidoMaterno.getText().isEmpty()||
                VistaCliente.TxtCurp.getText().isEmpty()||
                VistaCliente.TxtTelefono.getText().isEmpty()||
                VistaCliente.TxtDireccion.getText().isEmpty()||
                VistaCliente.TxtCodigoPostal.getText().isEmpty());
    }
}
