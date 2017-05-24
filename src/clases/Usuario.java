/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author dam121
 */
public class Usuario {

    public static boolean crearUsuario(String nombre, String pass) throws IOException {
        File dirOrigen = new File("users/default");
        File dirDestino = new File("users/" + nombre);

        if (CopiarDirectorio(dirOrigen, dirDestino)) {
            FileWriter fichero = new FileWriter("users/"+nombre+"/pass.lml");;
            PrintWriter pw = new PrintWriter(fichero);
            
            pw.print(pass);
            fichero.close();
            
            return true;
        }

        return false;
    }

    private static boolean CopiarDirectorio(File dirOrigen, File dirDestino) throws IOException {
        if (dirOrigen.isDirectory()) {
            if (dirDestino.exists()) {
                return false;
            } else {
                dirDestino.mkdir();

                String[] hijos = dirOrigen.list();
                for (int i = 0; i < hijos.length; i++) {
                    CopiarDirectorio(new File(dirOrigen, hijos[i]), new File(dirDestino, hijos[i]));
                }
            }
        } else {
            copiarArchivo(dirOrigen, dirDestino);
        }

        return true;
    }

    private static void copiarArchivo(File dirOrigen, File dirDestino) throws FileNotFoundException, IOException {
        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();
    }
    
    public static boolean eliminarUsuario(String nombre, String pass) throws FileNotFoundException, IOException {
        String passReal = pass(nombre);
        
        if(!passReal.equals(pass)){
            return false;
        }else{
            File dir =new File("users/"+nombre);
            borrarRecursivo(dir);
            dir.delete();
        }
        
        return true;
    }
    
    private static void borrarRecursivo(File dir) {
        File[] lista = dir.listFiles();

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].isDirectory()) {
                borrarRecursivo(lista[i]);
            }
            lista[i].delete();
        }
    }
    
    public static String pass(String nombre) throws FileNotFoundException, IOException {
        String pass;
        FileReader archivo = new FileReader(new File("users/" + nombre + "/pass.lml"));
        BufferedReader br = new BufferedReader(archivo);
        pass = br.readLine();
        br.close();

        return pass;
    }

    public static String[] listarUsuarios() {
        File dir = new File("users/");
        File[] listaDir = dir.listFiles();
        int numUsers = 0;

        if (listaDir != null) {
            for (int i = 0; i < listaDir.length; i++) {
                if (listaDir[i].isDirectory()) {
                    numUsers++;
                }
            }
        }

        String[] listaUsers = new String[numUsers];
        if (listaDir != null) {
            for (int i = 0; i < listaDir.length; i++) {
                if (listaDir[i].isDirectory()) {
                    listaUsers[i] = (listaDir[i].getPath()).substring(6);
                }
            }
        }

        return listaUsers;
    }
    
    public static ListaProductos listaProductos(String nombre) throws FileNotFoundException{
        FileReader archivo = new FileReader(new File("users/" + nombre + "/productos.lml"));
        BufferedReader br = new BufferedReader(archivo);
        ListaProductos lista = new ListaProductos();
        
        
        return lista;
    }
}
