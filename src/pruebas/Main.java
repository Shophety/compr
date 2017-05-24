/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import clases.Impresora;
import clases.Texto;
import clases.Usuario;
import java.io.IOException;

/**
 *
 * @author dam121
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Impresora imp = new Impresora();
        imp.imprimir("abc abc asdfg sad \n asdf");
        System.exit(0);
    }
    
}
