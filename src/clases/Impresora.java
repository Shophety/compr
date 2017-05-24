/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.*;

/**
 *
 * @author M. Durán
 */
public class Impresora {

    Font fuente = new Font("Lucida Console", Font.PLAIN, 13);
    PrintJob pj;
    Graphics pagina;
    
    public Impresora() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    }
    
    public void imprimir(String Cadena) {
        
        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);

            pagina.drawString(Cadena, 60, 60);
            
            pagina.dispose();
            pj.end();
        } catch (Exception e) {
            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
        }
    }
}
