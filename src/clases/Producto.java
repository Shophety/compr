/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author M. Durán
 */
public class Producto{
    private String nombre;
    private float precio;
    
    
    public Producto(String nombre, float precio){
        this.nombre=nombre;
        this.precio=precio;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public float getPrecio(){
        return this.precio;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Producto){
            Producto p = (Producto)obj;
            if(p.nombre.equals(this.nombre)){
                return true;
            }
        }
        
        return false;
    }
}
