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
import vista.VistaLogin;
import vista.VistaVentanaPrincipal;



/**
 *
 * @author enriq
 */
public class ControladorVistaLogin implements MouseListener, ActionListener{
    VistaLogin VistaLogin;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuarios ConsultasUsuarios = new ConsultasUsuarios();

    public ControladorVistaLogin(VistaLogin VistaLogin, ModeloUsuario ModeloUsuario) {
        this.VistaLogin = VistaLogin;
        this.ModeloUsuario = ModeloUsuario;
        oyentes();
        this.VistaLogin.setVisible(true);
    }
    
    private void oyentes() {
        VistaLogin.LblHide.addMouseListener(this);
        VistaLogin.BtnLogin.addMouseListener(this);
        VistaLogin.TxtUsuario.addActionListener(this);
        VistaLogin.TxtPassword.addActionListener(this);
    }
    public boolean camposValidos(){
        if (VistaLogin.TxtUsuario.getText().isEmpty() || VistaLogin.TxtPassword.getPassword().length==0) {
            return false;
        } else {
            return true;
        }
    }
    
    private void llenarModeloConCampos()throws NoSuchAlgorithmException{
        ModeloUsuario.setUsuario(VistaLogin.TxtUsuario.getText());
        
        String PasswordSinEncriptar = new String(VistaLogin.TxtPassword.getPassword());
        String PassEncriptado = encriptarPassword(PasswordSinEncriptar);
//        System.out.println(encriptarPassword(PasswordSinEncriptar)); 
        ModeloUsuario.setPassword(PassEncriptado);
        
        ModeloUsuario.setNombre("");
        ModeloUsuario.setTipo("");
    }
    
    private void buscarUsuarioPassword() throws NoSuchAlgorithmException{
        if (camposValidos()==true) {
            llenarModeloConCampos();
            if (ConsultasUsuarios.buscarLogin(ModeloUsuario)==true) {
                JOptionPane.showMessageDialog(null, "Bienvenido " + ModeloUsuario.getNombre(),
                                                                                 "Tipo " + ModeloUsuario.getTipo(), 1);
                
                VistaLogin.dispose();
                
                VistaVentanaPrincipal VistaVentanaPrincipal = new VistaVentanaPrincipal();
                ControladorVistaVentanaPrincipal ControladorVistaVentanaPrincipal = new ControladorVistaVentanaPrincipal(VistaVentanaPrincipal);
                if (ModeloUsuario.getTipo().equalsIgnoreCase("SuperAdministrador")==false) {
                    VistaVentanaPrincipal.LblUsuario.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Password incorrectos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de colocar taxto en los campos"
                                                                           +  "usuario y password");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaLogin.BtnLogin) {
            try {
                buscarUsuarioPassword();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblHide) {
            VistaLogin.TxtPassword.setEchoChar((char)0);
            VistaLogin.LblHide.setVisible(false);
            VistaLogin.LblShow.setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblHide) {
            VistaLogin.TxtPassword.setEchoChar('*');// •           

            VistaLogin.LblHide.setVisible(true);
            VistaLogin.LblShow.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private String encriptarPassword(String Password)throws NoSuchAlgorithmException{
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(Password.getBytes(),0,Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==VistaLogin.TxtUsuario) {            
            if (VistaLogin.TxtUsuario.getText().length()>20) {
                JOptionPane.showMessageDialog(VistaLogin, "La longuitud no debe ser mayor a 20", "Alerta!!!", 0);
                VistaLogin.TxtUsuario.setText("");                
            }else{
                VistaLogin.TxtPassword.requestFocus();
            }
        }
        if (e.getSource()==VistaLogin.TxtPassword) {
            if (VistaLogin.TxtPassword.getText().length()>40) {
                JOptionPane.showMessageDialog(VistaLogin, "La longuitud no debe ser mayor a 40", "Alerta!!!", 0);
                VistaLogin.TxtPassword.setText("");
            }else{
                VistaLogin.BtnLogin.doClick();
            }
            try {
                buscarUsuarioPassword();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
