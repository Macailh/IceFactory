/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author enriq
 */
public class VistaVentanaPrincipal extends JFrame implements Fuentes, Colores{
    JPanel PnlBar = new JPanel();
    
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    
    ImageIcon ImProducto = new ImageIcon(getClass().getResource("/imagenes/producto.png"));
    public JLabel LblProducto = new JLabel(ImProducto);
    
    ImageIcon ImUsuario = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
    public JLabel LblUsuario = new JLabel(ImUsuario);
    
    ImageIcon ImProveedor = new ImageIcon(getClass().getResource("/imagenes/proveedor.png"));
    public JLabel LblProveedor = new JLabel(ImProveedor);
    
    ImageIcon ImCliente = new ImageIcon(getClass().getResource("/imagenes/cliente.png"));
    public JLabel LblCliente = new JLabel(ImCliente);

    public VistaVentanaPrincipal() {
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setTitle("Menú Principal");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setIconImage(ImCubo.getImage());
    }

    private void agregarComponentes() {
        getContentPane().setBackground(PANEL_SECUNDARIO);
        PnlBar.setLayout(new GridLayout(4, 1));
        
        getContentPane().add(PnlBar, BorderLayout.WEST);
        PnlBar.setBackground(PANEL_PRIMARIO);
        
        PnlBar.add(LblUsuario);
        PnlBar.add(LblProducto);
        PnlBar.add(LblProveedor);
        PnlBar.add(LblCliente);
    } 
}
