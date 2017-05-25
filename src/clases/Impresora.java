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
public class Impresora implements Printable  {

    Font fuente = new Font("Lucida Console", Font.PLAIN, 13);
    String cadena;
    
    public Impresora(String cadena) {
        this.cadena=cadena;
    }
    
    public int print (Graphics g, PageFormat f, int pageIndex) 
   {
      if (pageIndex == 0) 
      {
         // Imprime "Hola mundo" en la primera pagina, en la posicion 100,100
         g.setFont(fuente);
         g.drawString(cadena, 100,100);
         g.drawString("asdfg", 100,120);
         g.drawString("qwerty", 100,140);
         return PAGE_EXISTS;
      }
      else
         return NO_SUCH_PAGE;
   }
}
