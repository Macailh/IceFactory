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
import javax.swing.JTextField;


/**
 *
 * @author enriq
 */
public class VistaProductos extends JDialog implements Fuentes, Colores{
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/search-icon.png"));
    
    public JLabel LblSearch = new JLabel(ImSearch);
    JLabel LblTitulo = new JLabel("Productos");
    JLabel LblIdProducto = new JLabel("ID del producto");
    JLabel LblNombre = new JLabel("Nombre del producto");
    JLabel LblDescripcion = new JLabel("Descripción");
    JLabel LblCategoria = new JLabel("Categoría");
    JLabel LblExistencias = new JLabel("Existencias");
    JLabel LblPrecio = new JLabel("Precio");
    
    public JTextField TxtIdProducto = new JTextField(15);
    public JTextField TxtNombre = new JTextField(15);
    public JTextField TxtDescripcion = new JTextField(15);
    public JTextField TxtCategoria = new JTextField(15);
    public JTextField TxtExistencias = new JTextField(15);
    public JTextField TxtPrecio = new JTextField(15);
    
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
    

    public VistaProductos() {
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
        
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets=new Insets(0,0,20,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        PnlSuperior.add(LblTitulo, gbc);
        LblTitulo.setFont(FUENTE_TITULOS);
        
//        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0,5,10,0);
        PnlSuperior.add(LblIdProducto, gbc);
        LblIdProducto.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtIdProducto, gbc);
        TxtIdProducto.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombre, gbc);
        LblNombre.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombre, gbc);
        TxtNombre.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblDescripcion, gbc);
        LblDescripcion.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtDescripcion, gbc);
        TxtDescripcion.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCategoria, gbc);
        LblCategoria.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCategoria, gbc);
        TxtCategoria.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblExistencias, gbc);
        LblExistencias.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtExistencias, gbc);
        TxtExistencias.setFont(FUENTE_TEXTFIELDS);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblPrecio, gbc);
        LblPrecio.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtPrecio, gbc);
        TxtPrecio.setFont(FUENTE_TEXTFIELDS);
        
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
