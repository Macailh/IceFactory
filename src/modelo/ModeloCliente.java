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
public class ModeloCliente {
    private int IdCliente;
    private String NombreCliente, ApellidoPaterno, ApellidoMaterno, Curp, Telefono, Direccion;
    private int CodigoPostal;

    public ModeloCliente() {
    }

    public ModeloCliente(int IdCliente, String NombreCliente, String ApellidoPaterno, String ApellidoMaterno, String Curp, String Telefono, String Direccion, int CodigoPostal) {
        this.IdCliente = IdCliente;
        this.NombreCliente = NombreCliente;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Curp = Curp;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.CodigoPostal = CodigoPostal;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(int CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }
}
