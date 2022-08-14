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
public class ModeloProducto {
    private int IdProducto;
    private String NombreProducto,Descripcion,Categoria;
    private double Precio;
    private int Existencias;

    public ModeloProducto() {
    }

    public ModeloProducto(int IdProducto, String NombreProducto, String Descripcion, String Categoria, float Precio, int Existencias) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.Precio = Precio;
        this.Existencias = Existencias;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getExistencias() {
        return Existencias;
    }

    public void setExistencias(int Existencias) {
        this.Existencias = Existencias;
    }
}
