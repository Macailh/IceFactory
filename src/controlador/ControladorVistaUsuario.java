/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuarios;
import modelo.ModeloUsuario;
import vista.VistaUsuarios;

/**
 *
 * @author enriq
 */
public class ControladorVistaUsuario  implements MouseListener, ActionListener{
    private ModeloUsuario ModeloUsuario;
    private VistaUsuarios VistaUsuarios;
    private ConsultasUsuarios ConsultasUsuarios = new ConsultasUsuarios();

    public ControladorVistaUsuario(ModeloUsuario ModeloUsuario, VistaUsuarios VistaUsuarios) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaUsuarios = VistaUsuarios;
        oyentes();
        VistaUsuarios.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaUsuarios.BtnGuardar) {
            try {
                guardar();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource()==VistaUsuarios.BtnActualizar) {
            try {
                modificar();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource()==VistaUsuarios.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaUsuarios.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaUsuarios.BtnSalir) {
            salir();
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

    private void oyentes() {
        VistaUsuarios.BtnGuardar.addMouseListener(this);
        VistaUsuarios.BtnActualizar.addMouseListener(this);
        VistaUsuarios.BtnEliminar.addMouseListener(this);
        VistaUsuarios.BtnBuscar.addMouseListener(this);
        VistaUsuarios.BtnSalir.addMouseListener(this);
        VistaUsuarios.TxtUsuario.addActionListener(this);
        VistaUsuarios.TxtPassword.addActionListener(this);
        VistaUsuarios.TxtNombre.addActionListener(this);
        VistaUsuarios.TxtTipo.addActionListener(this);
//        VistaUsuarios.LblSearch.addMouseListener(this);
    }
    
    private void llenarModeloConVista() throws NoSuchAlgorithmException{
        ModeloUsuario.setUsuario(VistaUsuarios.TxtUsuario.getText());
        String PasswordSinEncriptar = new String(VistaUsuarios.TxtPassword.getPassword());
        String PassEncriptado = encriptarPassword(PasswordSinEncriptar);
//        System.out.println(encriptarPassword(PasswordSinEncriptar)); 
        ModeloUsuario.setPassword(PassEncriptado);
        ModeloUsuario.setNombre(VistaUsuarios.TxtNombre.getText());
        ModeloUsuario.setTipo(VistaUsuarios.TxtTipo.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaUsuarios.TxtUsuario.setText(ModeloUsuario.getUsuario());
//        VistaUsuarios.TxtPassword.setText(ModeloUsuario.getPassword());
        VistaUsuarios.TxtNombre.setText(ModeloUsuario.getNombre());
        VistaUsuarios.TxtTipo.setText(ModeloUsuario.getTipo());
    }
    
    private void limpiarCampos(){
        VistaUsuarios.TxtUsuario.setText("");
        VistaUsuarios.TxtPassword.setText("");
        VistaUsuarios.TxtNombre.setText("");
        VistaUsuarios.TxtTipo.setText("");   
    }
    
    private boolean validarCampoUsuario(){
        if (VistaUsuarios.TxtUsuario.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaUsuarios.TxtUsuario.getText().isEmpty()||
            VistaUsuarios.TxtPassword.getText().isEmpty()||
            VistaUsuarios.TxtNombre.getText().isEmpty()||
            VistaUsuarios.TxtTipo.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    private void guardar() throws NoSuchAlgorithmException{
        if (validarTodosLosCampos()) {
            ModeloUsuario.setUsuario(VistaUsuarios.TxtUsuario.getText());
            if (ConsultasUsuarios.buscar(ModeloUsuario)==true) {
                JOptionPane.showMessageDialog(VistaUsuarios, "Ese producto ya existe");
            } else {
                llenarModeloConVista();
                if (ConsultasUsuarios.insertar(ModeloUsuario)==true) {
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
    
    private void modificar() throws NoSuchAlgorithmException{
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            ModeloUsuario ModeloTemporal = new ModeloUsuario();
            ModeloTemporal.setUsuario(VistaUsuarios.TxtUsuario.getText());
            
            if (ConsultasUsuarios.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaUsuarios, "Ese producto no existe");
            } else {
                if (ConsultasUsuarios.modificar(ModeloUsuario)){
                    JOptionPane.showMessageDialog(VistaUsuarios, "Registro modificado correctamente");
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
        if (validarCampoUsuario()) {
            ModeloUsuario.setUsuario(VistaUsuarios.TxtUsuario.getText());
            if (ConsultasUsuarios.eliminar(ModeloUsuario)==false) {
                JOptionPane.showMessageDialog(VistaUsuarios, "Ese producto no existe");
            } else {
                if (ConsultasUsuarios.eliminar(ModeloUsuario)) {
                    JOptionPane.showMessageDialog(VistaUsuarios, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaUsuarios, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El compo codigo no debe estar vacio");
        }
    }
    
    private void buscar(){
        if (validarCampoUsuario()) {
            ModeloUsuario.setUsuario(VistaUsuarios.TxtUsuario.getText());
            if (ConsultasUsuarios.buscar(ModeloUsuario)==true) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(VistaUsuarios, "Registro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(VistaUsuarios, "Los compos no deben estar vacios");
        }
    }
    
    private void salir(){
        int opc = JOptionPane.showConfirmDialog(VistaUsuarios, "¿Desea salir de usuarios?", "Alerta!", 0, 1 );
        if (opc==0) {
            VistaUsuarios.dispose();
        }
    }
    
    private String encriptarPassword(String Password)throws NoSuchAlgorithmException{
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(Password.getBytes(),0,Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==VistaUsuarios.TxtUsuario) {
            
            if (VistaUsuarios.TxtUsuario.getText().length()>20) {
                JOptionPane.showMessageDialog(VistaUsuarios, "La longuitud no debe ser mayor a 20", "Alerta!!!", 0);
                VistaUsuarios.TxtUsuario.setText("");
            }else{
                VistaUsuarios.TxtPassword.requestFocus();
            }
        }
        if (e.getSource()==VistaUsuarios.TxtPassword) {
            
            if (VistaUsuarios.TxtPassword.getText().length()>40) {
                JOptionPane.showMessageDialog(VistaUsuarios, "La longuitud no debe ser mayor a 40", "Alerta!!!", 0);
                VistaUsuarios.TxtPassword.setText("");
            }else{
                VistaUsuarios.TxtNombre.requestFocus();
            }
        }
        if (e.getSource()==VistaUsuarios.TxtNombre) {
            
            if (VistaUsuarios.TxtNombre.getText().length()>50) {
                JOptionPane.showMessageDialog(VistaUsuarios, "La longuitud no debe ser mayor a 50", "Alerta!!!", 0);
                VistaUsuarios.TxtNombre.setText("");
            }else{
                VistaUsuarios.TxtTipo.requestFocus();
            }
        }
        if (e.getSource()==VistaUsuarios.TxtTipo) {
            if (VistaUsuarios.TxtTipo.getText().length()>20) {
                JOptionPane.showMessageDialog(VistaUsuarios, "La longuitud no debe ser mayor a 20", "Alerta!!!", 0);
                VistaUsuarios.TxtTipo.setText("");
            }
        }
    }
}
