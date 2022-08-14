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
public class ModeloProveedor {
    private int IDProveedor;
    private String NombreProveedor,NombreContacto,Rfc,Direccion,Ciudad,Pais,Telefono,Email;
    private int CodigoPostal;

    public ModeloProveedor() {
    }

    public ModeloProveedor(int IDProveedor, String NombreProveedor, String NombreContacto, String Rfc, String Direccion, String Ciudad, String Pais, String Telefono, String Email, int CodigoPostal) {
        this.IDProveedor = IDProveedor;
        this.NombreProveedor = NombreProveedor;
        this.NombreContacto = NombreContacto;
        this.Rfc = Rfc;
        this.Direccion = Direccion;
        this.Ciudad = Ciudad;
        this.Pais = Pais;
        this.Telefono = Telefono;
        this.Email = Email;
        this.CodigoPostal = CodigoPostal;
    }

    public int getIDProveedor() {
        return IDProveedor;
    }

    public void setIDProveedor(int IDProveedor) {
        this.IDProveedor = IDProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public void setNombreContacto(String NombreContacto) {
        this.NombreContacto = NombreContacto;
    }

    public String getRfc() {
        return Rfc;
    }

    public void setRfc(String Rfc) {
        this.Rfc = Rfc;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }
}
