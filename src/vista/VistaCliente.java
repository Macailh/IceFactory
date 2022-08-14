/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Colores;
import static interfaces.Colores.PANEL_PRIMARIO;
import static interfaces.Colores.PANEL_SECUNDARIO;
import interfaces.Fuentes;
import static interfaces.Fuentes.FUENTE_TITULOS;
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
import javax.swing.JTextField;

/**
 *
 * @author enriq
 */
public class VistaCliente extends JDialog implements Fuentes, Colores{
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    
    JLabel LblTitulo = new JLabel("Clientes");
    JLabel LblIdProducto = new JLabel("ID del cliente");
    JLabel LblNombre = new JLabel("Nombre del cliente");
    JLabel LblApellidoPaterno = new JLabel("Apellido paterno");
    JLabel LblApellidoMaterno = new JLabel("Apellido materno");
    JLabel LblCurp = new JLabel("CURP");
    JLabel LblTelefono = new JLabel("Teléfono");
    JLabel LblDireccion = new JLabel("Dirección");
    JLabel LblCodigoPostal = new JLabel("Código postal");
    
    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search-icon.png"));
    public JLabel LblSearch = new JLabel(ImSearch);
    
    public JTextField TxtIdCliente = new JTextField(15);
    public JTextField TxtNombre = new JTextField(15);
    public JTextField TxtApellidoPaterno = new JTextField(15);
    public JTextField TxtApellidoMaterno = new JTextField(15);
    public JTextField TxtCurp = new JTextField(15);
    public JTextField TxtTelefono = new JTextField(15);
    public JTextField TxtDireccion = new JTextField(15);
    public JTextField TxtCodigoPostal = new JTextField(15);
    
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

    public VistaCliente() {
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
        this.setTitle("Productos");
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
        PnlInferior.setLayout(new FlowLayout());
        
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets=new Insets(0,0,20,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        PnlSuperior.add(LblTitulo, gbc);
        LblTitulo.setFont(FUENTE_TITULOS);
        
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0,5,10,0);
        PnlSuperior.add(LblIdProducto, gbc);
        LblIdProducto.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtIdCliente, gbc);
        TxtIdCliente.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombre, gbc);
        LblNombre.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombre, gbc);
        TxtNombre.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblApellidoPaterno, gbc);
        LblApellidoPaterno.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtApellidoPaterno, gbc);
        TxtApellidoPaterno.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblApellidoMaterno, gbc);
        LblApellidoMaterno.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtApellidoMaterno, gbc);
        TxtApellidoMaterno.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCurp, gbc);
        LblCurp.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCurp, gbc);
        TxtCurp.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblTelefono, gbc);
        LblTelefono.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtTelefono, gbc);
        TxtTelefono.setFont(FUENTE_TEXTFIELDS);
        
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
        
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets=new Insets(0,0,20,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        PnlSuperior.add(LblSearch, gbc);
        
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
