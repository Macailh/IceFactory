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
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.ModeloProducto;
import modelo.ModeloTablaProducto;
import modelo.ModeloTablaProveedor;
import vista.VistaBusquedaPorDescripcion;
import vista.VistaBusquedaPorDescripcionProducto;
import vista.VistaProductos;

/**
 *
 * @author enriq
 */
public class ControladorVistaProducto implements MouseListener{
    private ModeloProducto ModeloProducto;
    private VistaProductos VistaProductos;
    private ConsultasProducto ConsultasProducto = new ConsultasProducto();

    public ControladorVistaProducto(ModeloProducto ModeloProducto, VistaProductos VistaProductos) {
        this.ModeloProducto = ModeloProducto;
        this.VistaProductos = VistaProductos;
        oyentesVista();
        VistaProductos.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaProductos.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaProductos.BtnActualizar) {
            modificar();
        }else if (e.getSource()==VistaProductos.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaProductos.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaProductos.BtnSalir) {
            salir();
        }else if (e.getSource()==VistaProductos.LblSearch) {
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
        if (e.getSource()==VistaProductos.LblSearch) {
            VistaProductos.LblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void oyentesVista() {
        VistaProductos.BtnGuardar.addMouseListener(this);
        VistaProductos.BtnActualizar.addMouseListener(this);
        VistaProductos.BtnEliminar.addMouseListener(this);
        VistaProductos.BtnBuscar.addMouseListener(this);
        VistaProductos.BtnSalir.addMouseListener(this);
        VistaProductos.LblSearch.addMouseListener(this);
    }
    
    private void llenarModeloConVista(){
        ModeloProducto.setIdProducto(Integer.parseInt(VistaProductos.TxtIdProducto.getText()));
        ModeloProducto.setNombreProducto(VistaProductos.TxtNombre.getText());
        ModeloProducto.setDescripcion(VistaProductos.TxtDescripcion.getText());
        ModeloProducto.setCategoria(VistaProductos.TxtCategoria.getText());
        ModeloProducto.setExistencias(Integer.parseInt(VistaProductos.TxtExistencias.getText()));
        ModeloProducto.setPrecio(Double.parseDouble(VistaProductos.TxtPrecio.getText()));
    }
    
    private void llenarVistaConModelo(){
        VistaProductos.TxtIdProducto.setText(ModeloProducto.getIdProducto()+"");
        VistaProductos.TxtNombre.setText(ModeloProducto.getNombreProducto());
        VistaProductos.TxtDescripcion.setText(ModeloProducto.getDescripcion());
        VistaProductos.TxtCategoria.setText(ModeloProducto.getCategoria());
        VistaProductos.TxtExistencias.setText(ModeloProducto.getExistencias()+"");
        VistaProductos.TxtPrecio.setText(ModeloProducto.getPrecio()+"");
    }
    
    private void limpiarCampos(){
        VistaProductos.TxtIdProducto.setText("");
        VistaProductos.TxtNombre.setText("");
        VistaProductos.TxtDescripcion.setText("");
        VistaProductos.TxtCategoria.setText("");
        VistaProductos.TxtExistencias.setText("");
        VistaProductos.TxtPrecio.setText("");
    }
    
    private boolean validarCampoCodigo(){
        return !VistaProductos.TxtIdProducto.getText().isEmpty();
    }
    
    private boolean validarTodosLosCampos(){
        return !(VistaProductos.TxtIdProducto.getText().isEmpty()||
                VistaProductos.TxtNombre.getText().isEmpty()||
                VistaProductos.TxtDescripcion.getText().isEmpty()||
                VistaProductos.TxtCategoria.getText().isEmpty()||
                VistaProductos.TxtExistencias.getText().isEmpty()||
                VistaProductos.TxtPrecio.getText().isEmpty());
    }
    
    private void guardar(){
        if (validarTodosLosCampos()) {
            ModeloProducto.setIdProducto(Integer.parseInt(VistaProductos.TxtIdProducto.getText()));
            if (ConsultasProducto.buscar(ModeloProducto)==true) {
                JOptionPane.showMessageDialog(VistaProductos, "Ese producto ya existe");
            } else {
                llenarModeloConVista();
                if (ConsultasProducto.insertar(ModeloProducto)==true) {
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
            ModeloProducto ModeloTemporal = new ModeloProducto();
            ModeloTemporal.setIdProducto(Integer.parseInt(VistaProductos.TxtIdProducto.getText()));
            
            if (ConsultasProducto.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaProductos, "Ese producto no existe");
            } else {
                if (ConsultasProducto.modificar(ModeloProducto)){
                    JOptionPane.showMessageDialog(VistaProductos, "Registro modificado correctamente");
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
            ModeloProducto.setIdProducto(Integer.parseInt(VistaProductos.TxtIdProducto.getText()));
            if (ConsultasProducto.eliminar(ModeloProducto)==false) {
                JOptionPane.showMessageDialog(VistaProductos, "Ese producto no existe");
            } else {
                if (ConsultasProducto.eliminar(ModeloProducto)) {
                    JOptionPane.showMessageDialog(VistaProductos, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaProductos, "Error al eliminar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El compo codigo no debe estar vacio");
        }
    }
    
    private void buscar(){
        if (validarCampoCodigo()) {
            ModeloProducto.setIdProducto(Integer.parseInt(VistaProductos.TxtIdProducto.getText()));
            if (ConsultasProducto.buscar(ModeloProducto)==true) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(VistaProductos, "Registro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(VistaProductos, "Los compos no deben estar vacios");
        }
    }
    
    private void salir(){
        int opc = JOptionPane.showConfirmDialog(VistaProductos, "¿Desea salir de productos?", "Alerta!", 0, 1 );
        if (opc==0) {
            VistaProductos.dispose();
        }
    }
    
    private void busquedaMVC(){
        ModeloTablaProducto ModeloTablaProducto = new ModeloTablaProducto();
        VistaBusquedaPorDescripcionProducto vistaBusquedaPorDescripcionProducto = new VistaBusquedaPorDescripcionProducto(new JFrame(), true);
        
        ControladorVistaBusquedaPorDescripcionProducto ControladoSearch = new ControladorVistaBusquedaPorDescripcionProducto(ModeloTablaProducto, ModeloProducto, vistaBusquedaPorDescripcionProducto);
        llenarVistaConModelo();
    }
}
