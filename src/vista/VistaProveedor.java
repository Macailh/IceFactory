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
public class VistaProveedor extends JDialog implements Fuentes, Colores{
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    
    JLabel LblTitulo = new JLabel("Proveedores");
    JLabel LblIDProveedor = new JLabel("ID Proveedor");
    JLabel LblNombreProveedor = new JLabel("Nombre de proveedor");
    JLabel LblNombreContacto = new JLabel("Nombre de contacto");
    JLabel LblRFC = new JLabel("RFC");
    JLabel LblDireccion = new JLabel("Dirección");
    JLabel LblCodigoPostal = new JLabel("Código Postal");
    JLabel LblCiudad = new JLabel("Ciudad");
    JLabel LblPais = new JLabel("País");
    JLabel LblTelefono = new JLabel("Teléfono");
    JLabel LblEmail = new JLabel("Email");
    
    public JTextField TxtIDProveedor = new JTextField(15);
    public JTextField TxtNombreProveedor = new JTextField(15);
    public JTextField TxtNombreContacto = new JTextField(15);
    public JTextField TxtRfc = new JTextField(15);
    public JTextField TxtDireccion = new JTextField(15);
    public JTextField TxtCodigoPostal = new JTextField(15);
    public JTextField TxtCiudad = new JTextField(15);
    public JTextField TxtPais = new JTextField(15);
    public JTextField TxtTelefono = new JTextField(15);
    public JTextField TxtEmail = new JTextField(15);
    
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
    
    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search-icon.png"));
    public JLabel LblSearch = new JLabel(ImSearch);
    
    GridBagConstraints gbc = new GridBagConstraints();

    public VistaProveedor() {
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 570);
        this.setTitle("Proveedores");
        this.setModal(true);
        this.setIconImage(ImCubo.getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

    private void agregarComponentes() {
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
        PnlSuperior.add(LblIDProveedor, gbc);
        LblIDProveedor.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtIDProveedor, gbc);
        TxtIDProveedor.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombreProveedor, gbc);
        LblNombreProveedor.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombreProveedor, gbc);
        TxtNombreProveedor.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombreContacto, gbc);
        LblNombreContacto.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombreContacto, gbc);
        TxtNombreContacto.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblRFC, gbc);
        LblRFC.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtRfc, gbc);
        TxtRfc.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblDireccion, gbc);
        LblDireccion.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtDireccion, gbc);
        TxtDireccion.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCodigoPostal, gbc);
        LblCodigoPostal.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCodigoPostal, gbc);
        TxtCodigoPostal.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCiudad, gbc);
        LblCiudad.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCiudad, gbc);
        TxtCiudad.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblPais, gbc);
        LblPais.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtPais, gbc);
        TxtPais.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblTelefono, gbc);
        LblTelefono.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtTelefono, gbc);
        TxtTelefono.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblEmail, gbc);
        LblEmail.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtEmail, gbc);
        TxtEmail.setFont(FUENTE_TEXTFIELDS);
        
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets=new Insets(0,0,20,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        PnlSuperior.add(LblSearch, gbc);
        
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
