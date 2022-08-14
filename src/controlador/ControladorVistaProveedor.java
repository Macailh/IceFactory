/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasProveedor;
import modelo.ModeloProducto;
import modelo.ModeloProveedor;
import modelo.ModeloTablaProveedor;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaProveedor;

/**
 *
 * @author enriq
 */
public class ControladorVistaProveedor implements MouseListener, ActionListener{
    private ModeloProveedor ModeloProveedor;
    private VistaProveedor VistaProveedor;
    private ConsultasProveedor ConsultasProveedor = new ConsultasProveedor();

    public ControladorVistaProveedor(ModeloProveedor ModeloProveedor, VistaProveedor VistaProveedor) {
        this.ModeloProveedor = ModeloProveedor;
        this.VistaProveedor = VistaProveedor;
        oyentes();
        VistaProveedor.setVisible(true);
    }

    private void oyentes() {
        VistaProveedor.BtnGuardar.addMouseListener(this);
        VistaProveedor.BtnActualizar.addMouseListener(this);
        VistaProveedor.BtnEliminar.addMouseListener(this);
        VistaProveedor.BtnBuscar.addMouseListener(this);
        VistaProveedor.BtnSalir.addMouseListener(this);
        VistaProveedor.LblSearch.addMouseListener(this);
        
        VistaProveedor.TxtIDProveedor.addActionListener(this);
        VistaProveedor.TxtNombreProveedor.addActionListener(this);
        VistaProveedor.TxtNombreContacto.addActionListener(this);
        VistaProveedor.TxtRfc.addActionListener(this);
        VistaProveedor.TxtDireccion.addActionListener(this);
        VistaProveedor.TxtCodigoPostal.addActionListener(this);
        VistaProveedor.TxtCiudad.addActionListener(this);
        VistaProveedor.TxtPais.addActionListener(this);
        VistaProveedor.TxtTelefono.addActionListener(this);
        VistaProveedor.TxtEmail.addActionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaProveedor.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaProveedor.BtnActualizar) {
            modificar();
        }else if (e.getSource()==VistaProveedor.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaProveedor.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaProveedor.BtnSalir) {
            salir();
        }else if (e.getSource()==VistaProveedor.LblSearch) {
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
        if (e.getSource()==VistaProveedor.LblSearch) {
            VistaProveedor.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private void llenarModeloConVista(){
        ModeloProveedor.setIDProveedor(Integer.parseInt(VistaProveedor.TxtIDProveedor.getText()));
        ModeloProveedor.setNombreProveedor(VistaProveedor.TxtNombreProveedor.getText());
        ModeloProveedor.setNombreContacto(VistaProveedor.TxtNombreContacto.getText());
        ModeloProveedor.setRfc(VistaProveedor.TxtRfc.getText());
        ModeloProveedor.setDireccion(VistaProveedor.TxtDireccion.getText());
        ModeloProveedor.setCodigoPostal(Integer.parseInt(VistaProveedor.TxtCodigoPostal.getText()));
        ModeloProveedor.setCiudad(VistaProveedor.TxtCiudad.getText());
        ModeloProveedor.setPais(VistaProveedor.TxtPais.getText());
        ModeloProveedor.setTelefono(VistaProveedor.TxtTelefono.getText());
        ModeloProveedor.setEmail(VistaProveedor.TxtEmail.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaProveedor.TxtIDProveedor.setText(ModeloProveedor.getIDProveedor()+"");
        VistaProveedor.TxtNombreProveedor.setText(ModeloProveedor.getNombreProveedor());
        VistaProveedor.TxtNombreContacto.setText(ModeloProveedor.getNombreContacto());
        VistaProveedor.TxtRfc.setText(ModeloProveedor.getRfc());
        VistaProveedor.TxtDireccion.setText(ModeloProveedor.getDireccion()+"");
        VistaProveedor.TxtCodigoPostal.setText(ModeloProveedor.getCodigoPostal()+"");
        VistaProveedor.TxtCiudad.setText(ModeloProveedor.getCiudad()+"");
        VistaProveedor.TxtPais.setText(ModeloProveedor.getPais()+"");
        VistaProveedor.TxtTelefono.setText(ModeloProveedor.getTelefono()+"");
        VistaProveedor.TxtEmail.setText(ModeloProveedor.getEmail()+"");
    }
    
    private void limpiarCampos(){
        VistaProveedor.TxtIDProveedor.setText("");
        VistaProveedor.TxtNombreProveedor.setText("");
        VistaProveedor.TxtNombreContacto.setText("");
        VistaProveedor.TxtRfc.setText("");
        VistaProveedor.TxtDireccion.setText("");
        VistaProveedor.TxtCodigoPostal.setText("");
        VistaProveedor.TxtCiudad.setText("");
        VistaProveedor.TxtPais.setText(""); 
        VistaProveedor.TxtTelefono.setText("");
        VistaProveedor.TxtEmail.setText("");   
    }
    
    private boolean validarCampoCodigo(){
        if (VistaProveedor.TxtIDProveedor.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaProveedor.TxtIDProveedor.getText().isEmpty()||
            VistaProveedor.TxtNombreProveedor.getText().isEmpty()||
            VistaProveedor.TxtNombreContacto.getText().isEmpty()||
            VistaProveedor.TxtRfc.getText().isEmpty()||
            VistaProveedor.TxtDireccion.getText().isEmpty()||
            VistaProveedor.TxtCodigoPostal.getText().isEmpty()||
            VistaProveedor.TxtCiudad.getText().isEmpty()||
            VistaProveedor.TxtPais.getText().isEmpty()||
            VistaProveedor.TxtTelefono.getText().isEmpty()||
            VistaProveedor.TxtEmail.getText().isEmpty()){
            return false;
        } else {
            return true;
        }
    }
    
    private void guardar(){
        if (validarTodosLosCampos()) {
            ModeloProveedor.setIDProveedor(Integer.parseInt(VistaProveedor.TxtIDProveedor.getText()));
            if (ConsultasProveedor.buscar(ModeloProveedor)==true) {
                JOptionPane.showMessageDialog(VistaProveedor, "Ese producto ya existe");
            } else {
                llenarModeloConVista();
                if (ConsultasProveedor.insertar(ModeloProveedor)==true) {
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
    
    private void modificar(){
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            ModeloProveedor ModeloTemporal = new ModeloProveedor();
            ModeloTemporal.setIDProveedor(Integer.parseInt(VistaProveedor.TxtIDProveedor.getText()));
            
            if (ConsultasProveedor.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaProveedor, "Ese producto no existe");
            } else {
                if (ConsultasProveedor.modificar(ModeloProveedor)){
                    JOptionPane.showMessageDialog(VistaProveedor, "Registro modificado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }
    }
    
    private void eliminar(){
        if (validarCampoCodigo()) {
            ModeloProveedor.setIDProveedor(Integer.parseInt(VistaProveedor.TxtIDProveedor.getText()));
            if (ConsultasProveedor.eliminar(ModeloProveedor)==false) {
                JOptionPane.showMessageDialog(VistaProveedor, "Ese producto no existe");
            } else {
                if (ConsultasProveedor.eliminar(ModeloProveedor)) {
                    JOptionPane.showMessageDialog(VistaProveedor, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaProveedor, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El compo codigo no debe estar vacio");
        }
    }
    
    private void buscar(){
        if (validarCampoCodigo()) {
            ModeloProveedor.setIDProveedor(Integer.parseInt(VistaProveedor.TxtIDProveedor.getText()));
            if (ConsultasProveedor.buscar(ModeloProveedor)==true) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(VistaProveedor, "Registro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(VistaProveedor, "Los compos no deben estar vacios");
        }
    }
    
    private void salir(){
        int opc = JOptionPane.showConfirmDialog(VistaProveedor, "¿Desea salir de prooveedores?", "Alerta!", 0, 1 );
        if (opc==0) {
            VistaProveedor.dispose();
        }
    }
    
    private void busquedaMVC(){
        ModeloTablaProveedor ModeloTablaProveedor = new ModeloTablaProveedor();
        VistaBusquedaPorDescripcion VistaBusquedaPorDescripcion = new VistaBusquedaPorDescripcion(new JFrame(), true);
        
        ControladorVistaBusquedaPorDescripcion ControladoSearch = new ControladorVistaBusquedaPorDescripcion(ModeloTablaProveedor, ModeloProveedor, VistaBusquedaPorDescripcion);
        llenarVistaConModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==VistaProveedor.TxtIDProveedor) {
            if(validaCampoEntero(VistaProveedor.TxtIDProveedor.getText(), 11)){
                VistaProveedor.TxtNombreProveedor.requestFocus();
            }else{
                VistaProveedor.TxtIDProveedor.setText("");
            }
        }
        if (e.getSource()==VistaProveedor.TxtNombreProveedor) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtNombreProveedor.getText(), 50)) {
                VistaProveedor.TxtNombreContacto.requestFocus();
            } else {
                VistaProveedor.TxtNombreProveedor.setText("");
            }            
        }
        if (e.getSource()==VistaProveedor.TxtNombreContacto) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtNombreContacto.getText(), 50)) {
                VistaProveedor.TxtRfc.requestFocus();
            } else {
                VistaProveedor.TxtNombreContacto.setText("");
            }             
        }
        if (e.getSource()==VistaProveedor.TxtRfc) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtRfc.getText(), 20)) {
                VistaProveedor.TxtDireccion.requestFocus();
            } else {
                VistaProveedor.TxtRfc.setText("");
            }              
        }
        if (e.getSource()==VistaProveedor.TxtDireccion) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtDireccion.getText(), 30)) {
                VistaProveedor.TxtCodigoPostal.requestFocus();
            } else {
                VistaProveedor.TxtDireccion.setText("");
            }              
        }
        if (e.getSource()==VistaProveedor.TxtCodigoPostal) {
            if(validaCampoEntero(VistaProveedor.TxtCodigoPostal.getText(), 5)){
                VistaProveedor.TxtCiudad.requestFocus();
            }else{
                VistaProveedor.TxtCodigoPostal.setText("");
            }
        }
        if (e.getSource()==VistaProveedor.TxtCiudad) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtCiudad.getText(), 20)) {
                VistaProveedor.TxtPais.requestFocus();
            } else {
                VistaProveedor.TxtCiudad.setText("");
            }               
        }
        if (e.getSource()==VistaProveedor.TxtPais) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtPais.getText(), 20)) {
                VistaProveedor.TxtTelefono.requestFocus();
            } else {
                VistaProveedor.TxtPais.setText("");
            }              
        }
        if (e.getSource()==VistaProveedor.TxtTelefono) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtTelefono.getText(), 20)) {
                VistaProveedor.TxtEmail.requestFocus();
            } else {
                VistaProveedor.TxtTelefono.setText("");
            }             
        }
        if (e.getSource()==VistaProveedor.TxtEmail) {
            if (validaCampoAlfanumerico(VistaProveedor.TxtEmail.getText(), 50)) {
                VistaProveedor.TxtEmail.requestFocus();
            } else {
                VistaProveedor.TxtEmail.setText("");
            }  
        }
    }
    
    private boolean validaCampoEntero(String Cadena, int longuitud){
        if (Cadena.matches("[0-9,.]+")&&Cadena.length()<longuitud+1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(VistaProveedor, "Debes teclear solo numeros  y la longuitud no debe ser mayor a "+longuitud, "Alerta!!!", 0);
            return false;
        }
    }
    
    private boolean validaCampoAlfanumerico(String Cadena, int longuitud){
        if (Cadena.length()<longuitud+1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(VistaProveedor, "La longuitud no debe ser mayor a "+longuitud, "Alerta!!!", 0);
            return false;
        }
    }
}
