/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import modelo.ModeloCliente;
import modelo.ModeloProducto;
import modelo.ModeloProveedor;
import modelo.ModeloUsuario;
import vista.VistaCliente;
import vista.VistaProductos;
import vista.VistaProveedor;
import vista.VistaUsuarios;
import vista.VistaVentanaPrincipal;

/**
 *
 * @author enriq
 */
public class ControladorVistaVentanaPrincipal implements MouseListener{
    VistaVentanaPrincipal VistaVentanaPrincipal;

    public ControladorVistaVentanaPrincipal(VistaVentanaPrincipal VistaVentanaPrincipal) {
        this.VistaVentanaPrincipal = VistaVentanaPrincipal;
        oyentes();
        this.VistaVentanaPrincipal.setVisible(true);
        
    }

    private void oyentes() {
        VistaVentanaPrincipal.LblProducto.addMouseListener(this);
        VistaVentanaPrincipal.LblUsuario.addMouseListener(this);
        VistaVentanaPrincipal.LblProveedor.addMouseListener(this);
        VistaVentanaPrincipal.LblCliente.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaVentanaPrincipal.LblProducto) {
            ModeloProducto ModeloProducto = new ModeloProducto();
            VistaProductos VistaProductos = new VistaProductos();
            ControladorVistaProducto ControladorVistaProducto = new ControladorVistaProducto(ModeloProducto, VistaProductos);
        }else if (e.getSource()==VistaVentanaPrincipal.LblUsuario) {
            ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaUsuarios vistaUsuarios = new VistaUsuarios();
            ControladorVistaUsuario ControladorVistaUsuario = new ControladorVistaUsuario(ModeloUsuario, vistaUsuarios);
        }else if (e.getSource()==VistaVentanaPrincipal.LblProveedor) {
            ModeloProveedor ModeloProveedor = new ModeloProveedor();
            VistaProveedor VistaProveedor = new VistaProveedor();
            ControladorVistaProveedor ControladorVistaProveedor = new ControladorVistaProveedor(ModeloProveedor, VistaProveedor);
        }else if (e.getSource()==VistaVentanaPrincipal.LblCliente) {
            ModeloCliente ModeloCliente = new ModeloCliente();
            VistaCliente VistaCliente = new VistaCliente();
            ControladorVistaCLiente ControladorVistaCliente = new ControladorVistaCLiente(ModeloCliente, VistaCliente);
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
        if (e.getSource()== VistaVentanaPrincipal.LblUsuario) {
            VistaVentanaPrincipal.LblUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()== VistaVentanaPrincipal.LblProducto) {
            VistaVentanaPrincipal.LblProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()== VistaVentanaPrincipal.LblProveedor) {
            VistaVentanaPrincipal.LblProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()== VistaVentanaPrincipal.LblCliente) {
            VistaVentanaPrincipal.LblCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
