/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Colores;
import interfaces.Fuentes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author enriq
 */
public class VistaLogin extends JFrame implements Fuentes, Colores{
    ImageIcon ImCubo = new ImageIcon(getClass().getResource("/imagenes/cubo.png"));
    
    JPanel JplLoginI = new JPanel();
    public JPanel JplLoginD = new JPanel();
    
    JTextArea TxtTitulo = new JTextArea("Zapatería");
    
    ImageIcon ImPerson = new ImageIcon(getClass().getResource("/imagenes/person_icon.png"));
    JLabel LblPerson = new JLabel(ImPerson);
    
    ImageIcon ImUserName = new ImageIcon(getClass().getResource("/imagenes/username.png"));
    JLabel LblUsuario = new JLabel(ImUserName);
    
    ImageIcon ImPassword = new ImageIcon(getClass().getResource("/imagenes/lock.png"));
    JLabel LblPassword = new JLabel(ImPassword);
    
    ImageIcon ImShow = new ImageIcon(getClass().getResource("/imagenes/show.png"));
    public JLabel LblShow = new JLabel(ImShow);
    
    ImageIcon ImHide = new ImageIcon(getClass().getResource("/imagenes/hide.png"));
    public JLabel LblHide = new JLabel(ImHide);
    
    public JTextField TxtUsuario = new JTextField();
    public JPasswordField TxtPassword = new JPasswordField();
    
    JLabel LblLogin = new JLabel("Login");
    JLabel LblRecuerdame = new JLabel("Recuerdame");
    JCheckBox ChkRecordar = new JCheckBox();
    
    ImageIcon ImAceptar = new ImageIcon(getClass().getResource("/imagenes/aceptar.png"));
    public JButton BtnLogin = new JButton("Aceptar", ImAceptar);
    
    public VistaLogin() {
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Iniciar Sesion");
        this.setIconImage(ImCubo.getImage());
        getContentPane().setLayout(null);
        JplLoginI.setLayout(null);
        JplLoginD.setLayout(null);
    }

    private void agregarComponentes() {
        getContentPane().add(JplLoginI);
        JplLoginI.setBounds(0, 0, 0, 0);
        JplLoginI.setBackground(PANEL_PRIMARIO);
        
        getContentPane().add(JplLoginD);
        JplLoginD.setBounds(0, 0, 450, 500);
        JplLoginD.setBackground(PANEL_SECUNDARIO);
        
//        JplLoginI.add(LblLogo);
//        LblLogo.setBounds(111, 210, ImCubo.getIconWidth(), ImCubo.getIconHeight());
        
        JplLoginI.add(TxtTitulo);
        TxtTitulo.setBounds(90, 120, 260, 100);
        TxtTitulo.setOpaque(false);
        TxtTitulo.setEditable(false);
        TxtTitulo.setFont(FUENTE_TITULOS);
        TxtTitulo.setHighlighter(null);
        
        JplLoginD.add(LblPerson);
        LblPerson.setBounds(161, 50, ImPerson.getIconWidth(), ImPerson.getIconHeight());
        
        JplLoginD.add(LblUsuario);
        LblUsuario.setBounds(70, 250, ImUserName.getIconWidth(), ImUserName.getIconHeight());
        
        JplLoginD.add(LblPassword);
        LblPassword.setBounds(70, 300, ImPassword.getIconWidth(), ImPassword.getIconHeight());
        
        JplLoginD.add(LblShow);
        LblShow.setBounds(330, 340, ImHide.getIconWidth(), ImHide.getIconHeight());
        LblShow.setVisible(false);
        
        JplLoginD.add(LblHide);
        LblHide.setBounds(330, 340, ImHide.getIconWidth(), ImHide.getIconHeight());
        
        JplLoginD.add(TxtUsuario);
        TxtUsuario.setBounds(110, 250, 250, 30);
        TxtUsuario.setFont(FUENTE_TEXTFIELDS);
        
        JplLoginD.add(TxtPassword);
        TxtPassword.setBounds(110, 300, 250, 30);
        TxtPassword.setFont(FUENTE_TEXTFIELDS);
        TxtPassword.setEchoChar('*');
        
        JplLoginD.add(LblRecuerdame);
        LblRecuerdame.setBounds(130, 340, 100, 20);
        LblRecuerdame.setFont(FUENTE_LOGIN);
        
        JplLoginD.add(ChkRecordar);
        ChkRecordar.setBounds(110, 340, 20, 20);
        ChkRecordar.setBackground(PANEL_SECUNDARIO);
        
        JplLoginD.add(LblLogin);
        LblLogin.setBounds(180, 185, 100, 50);
        LblLogin.setFont(FUENTE_TITULOS);
        
        JplLoginD.add(BtnLogin);
        BtnLogin.setBounds(160, 380, 150, 40);
        BtnLogin.setBackground(Color.decode("#76c3d7"));
        BtnLogin.setBorder(null);
        BtnLogin.setBorder(new BasicBorders.RolloverButtonBorder(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
        BtnLogin.setFont(FUENTE_LOGIN);
       
    }   
    
}
