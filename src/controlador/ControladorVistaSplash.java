/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaSplash;

/**
 *
 * @author enriq
 */
public class ControladorVistaSplash implements MouseListener, MouseMotionListener, MouseWheelListener{
    VistaSplash VistaSplash;
    int x,y;

    public ControladorVistaSplash(VistaSplash VistaSplash) {
        this.VistaSplash = VistaSplash;
        oyentes();
        this.VistaSplash.setVisible(true);
        dormirMatarSplash(5);
    }
    private void oyentes() {
        VistaSplash.LblSplash.addMouseListener(this);
        VistaSplash.LblSplash.addMouseMotionListener(this);
        VistaSplash.LblSplash.addMouseWheelListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            x = e.getX();
            y = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VistaSplash.LblSplash) {
            VistaSplash.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == VistaSplash.LblSplash) {
            VistaSplash.setLocation(VistaSplash.getLocation().x + e.getX()-x, VistaSplash.getLocation().y + e.getY()-y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getSource() == VistaSplash.LblSplash) {
            VistaSplash.dispose();
        }
    }

    private void dormirMatarSplash(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorVistaSplash.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            VistaSplash.dispose();
            
            ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaLogin VistaLogin = new VistaLogin();
            ControladorVistaLogin ControladorVistaLogin = new ControladorVistaLogin(VistaLogin, ModeloUsuario);
        }    
    }
    
    
}
