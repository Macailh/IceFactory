/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author enriq
 */
public class ModeloUsuario {
    private String Usuario, Password, Nombre, Tipo;

    public ModeloUsuario(String Usuario, String Password, String Nombre, String Tipo) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
    }
    
    //Getters y setters
    public ModeloUsuario() {
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
       
}
