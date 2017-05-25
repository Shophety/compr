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
public class Texto {

    public static boolean validar(String cad) {
        if (cad.length() == 0) {
            return false;
        }

        for (int i = 0; i < cad.length(); i++) {
            if (!(Character.isLetter(cad.charAt(i)) || Character.isDigit(cad.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

}
