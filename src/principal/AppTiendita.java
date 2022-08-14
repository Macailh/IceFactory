/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlador.ControladorVistaLogin;
import controlador.ControladorVistaSplash;
import vista.VistaLogin;
import vista.VistaSplash;

/**
 *
 * @author enriq
 */
public class AppTiendita {
    public static void main(String[] args) {
        VistaSplash VistaSplah = new VistaSplash();
        ControladorVistaSplash ControladorSplash = new ControladorVistaSplash(VistaSplah);
    }
}
