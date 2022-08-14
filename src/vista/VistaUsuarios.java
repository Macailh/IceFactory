/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author enriq
 */
public class VistaUsuarios extends JDialog implements Fuentes, Colores{
//    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search-icon.png"));
//    public JLabel LblSearch = new JLabel(ImSearch);
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    
    JLabel LblTitulo = new JLabel("Usuarios");
    JLabel LblUsuario = new JLabel("Usuario");
    JLabel LblPassword = new JLabel("Password");
    JLabel LblNombre = new JLabel("Nombre");
    JLabel LblTipo = new JLabel("Tipo");
    
    public JTextField TxtUsuario = new JTextField(15);
    public JPasswordField TxtPassword = new JPasswordField(15);
    public JTextField TxtNombre = new JTextField(15);
    public JTextField TxtTipo = new JTextField(15);
    
    ImageIcon ImGuardar = new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
    public JButton BtnGuardar = new JButton("Guardar", ImGuardar);
    ImageIcon ImBuscar = new ImageIcon(getClass().getResource("/imagenes/buscar.png"));
    public JButton BtnBuscar = new JButton("Buscar", ImBuscar);
    ImageIcon ImEliminar = new ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
    public JButton BtnEliminar = new JButton("Eliminar", ImEliminar);
    ImageIcon ImActualizar = new ImageIcon(getClass().getResource("/imagenes/actualizar.png"));
    public JButton BtnActualizar = new JButton("Actualizar", ImActualizar);
    ImageIcon ImSalir = new ImageIcon(getClass().getResource("/imagenes/salir.png"));
    public JButton BtnSalir = new JButton("Salir", ImSalir);
    
    JPanel PnlSuperior = new JPanel();
    JPanel PnlInferior = new JPanel();
    
    GridBagConstraints gbc = new GridBagConstraints();

    public VistaUsuarios() {
        configuracion();
        agregarcomponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
        this.setTitle("Usuarios");
        this.setModal(true);
        this.setIconImage(ImCubo.getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

    private void agregarcomponentes() {
        this.add(PnlSuperior, BorderLayout.CENTER);
        PnlSuperior.setBackground(PANEL_PRIMARIO);
        
        this.add(PnlInferior, BorderLayout.SOUTH);
        PnlInferior.setBackground(PANEL_SECUNDARIO);
        
        PnlSuperior.setLayout(new GridBagLayout());
        
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets=new Insets(0,0,20,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        PnlSuperior.add(LblTitulo, gbc);
        LblTitulo.setFont(FUENTE_TITULOS);
        
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0,5,10,0);
        PnlSuperior.add(LblUsuario, gbc);
        LblUsuario.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtUsuario, gbc);
        TxtUsuario.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblPassword, gbc);
        LblPassword.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtPassword, gbc);
        TxtPassword.setFont(FUENTE_TEXTFIELDS);
        TxtPassword.setEchoChar('*');
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombre, gbc);
        LblNombre.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombre, gbc);
        TxtNombre.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblTipo, gbc);
        LblTipo.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtTipo, gbc);
        TxtTipo.setFont(FUENTE_TEXTFIELDS);
        
        PnlInferior.setLayout(new FlowLayout());
        
        PnlInferior.add(BtnGuardar);
        BtnGuardar.setFont(FUENTE_BOTONES);
        BtnGuardar.setBackground(BTN_GREEN);
        
        PnlInferior.add(BtnBuscar);
        BtnBuscar.setFont(FUENTE_BOTONES);
        BtnBuscar.setBackground(BTN_YELLOW);
        
        PnlInferior.add(BtnActualizar);
        BtnActualizar.setFont(FUENTE_BOTONES);
        BtnActualizar.setBackground(BTN_PURPLE);
        
        PnlInferior.add(BtnEliminar);
        BtnEliminar.setFont(FUENTE_BOTONES);
        BtnEliminar.setBackground(BTN_BLUE);
        
        PnlInferior.add(BtnSalir);
        BtnSalir.setFont(FUENTE_BOTONES);
        BtnSalir.setBackground(BTN_RED);
    }
}
