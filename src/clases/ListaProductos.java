/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author M. Durán
 */
public class ListaProductos {

    private ArrayList<Producto> lista;

    public ListaProductos() {
        lista = new ArrayList();
    }

    public boolean insertar(Producto prod) {
        for (int i = 0; i < lista.size(); i++) {
            if (prod.equals(lista.get(i))) {
                return false;
            }
        }

        lista.add(prod);
        return true;
    }

    public void ordenar() {
        Collections.sort(lista, new Comparator<Producto>() {

            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }

        });
    }

    public boolean eliminar(String nombre) {

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equals(nombre)) {
                lista.remove(i);
                return true;
            }
        }

        return false;
    }

    public int tamanno() {
        return lista.size();
    }

    public Producto[] toArray() {
        Producto[] aProd = new Producto[tamanno()];

        for (int i = 0; i < aProd.length; i++) {
            aProd[i] = lista.get(i);
        }

        return aProd;
    }

}
