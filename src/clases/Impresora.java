/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

/**
 *
 * @author M. Durán
 */
public class Impresora implements Printable {

    Font fuente = new Font("Lucida Console", Font.PLAIN, 13);
    String[] cadena;

    public Impresora(String[] cadena) {
        this.cadena = cadena;
    }

    public int print(Graphics g, PageFormat f, int pageIndex) {
        if (pageIndex == 0) {
            g.setFont(fuente);
            int espaciado = 100;
            for (int i = 0; i < cadena.length; i++) {
                g.drawString(cadena[i], 100, espaciado);
                espaciado += 20;
            }
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
}
