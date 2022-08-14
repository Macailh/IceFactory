/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static interfaces.Fuentes.FUENTE_LABELS;
import static interfaces.Fuentes.FUENTE_TEXTFIELDS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author enriq
 */
public class VistaBusquedaPorDescripcion extends JDialog{
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    JLabel LblNombre = new JLabel("Proveedor a buscar");
    public JTextField TxtNombre = new JTextField(20);
    
    ImageIcon ImAceptar = new ImageIcon(getClass().getResource("/imagenes/aceptar.png"));
    public JButton BtnAceptar = new JButton("Aceptar", ImAceptar);
    
    JPanel Pnlsuperior = new JPanel();
    JPanel PnlCentral = new JPanel();
    JPanel Pnlinferior = new JPanel();
    
    public JTable Tabla = new JTable();
    
    JScrollPane ScrollTabla = new JScrollPane(Tabla);

    public VistaBusquedaPorDescripcion(Frame owner, boolean modal) {
        super(owner, modal);
        configuracionInicial();
        agregarComponentes();
    }

    private void configuracionInicial() {
        this.setSize(700, 570);
        this.setTitle("Proveedores");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        resizeColumnWidth(Tabla);
        Tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setIconImage(ImCubo.getImage());
    }

    private void agregarComponentes() {
        this.add(Pnlsuperior, BorderLayout.NORTH);
        Pnlsuperior.setLayout(new FlowLayout());
        this.add(PnlCentral, BorderLayout.CENTER);
        PnlCentral.setLayout(new FlowLayout());
        this.add(Pnlinferior, BorderLayout.SOUTH);
        Pnlinferior.setLayout(new FlowLayout());

        Pnlsuperior.add(LblNombre);
        Pnlsuperior.add(TxtNombre);
        PnlCentral.add(ScrollTabla);
        Pnlinferior.add(BtnAceptar);
    }
    
    private void resizeColumnWidth(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        //Se obtiene el total de las columnas
        for (int column = 0; column < table.getColumnCount(); column++) {
            //Establecemos un valor minimo para el ancho de la columna
            int width = 150; //Min Width
            //Obtenemos el numero de filas de la tabla
            for (int row = 0; row < table.getRowCount(); row++) {
                //Obtenemos el renderizador de la tabla
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                //Creamos un objeto para preparar el renderer
                Component comp = table.prepareRenderer(renderer, row, column);
                //Establecemos el width segun el valor maximo del ancho de la columna
                width = Math.max(comp.getPreferredSize().width + 1, width);

            }
            //Se establece una condicion para no sobrepasar el valor de 300
            //Esto es Opcional
            if (width > 300) {
                width = 300;
            }
            //Se establece el ancho de la columna
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
