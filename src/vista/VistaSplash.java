/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.awt.AWTUtilities;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author enriq
 */
public class VistaSplash extends JFrame{
    ImageIcon ImSplash = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
    public JLabel LblSplash = new JLabel(ImSplash);

    public VistaSplash() {
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(ImSplash.getIconWidth(),ImSplash.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        AWTUtilities.setWindowOpaque(this, false);
        this.setAlwaysOnTop(true);
    }

    private void agregarComponentes() {
        this.add(LblSplash);
    }
    
    
            
      
}
