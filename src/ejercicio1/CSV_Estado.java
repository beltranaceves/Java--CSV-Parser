/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.List;

/**
 *
 * @author Beltrán
 */
public abstract class CSV_Estado implements CSV_Estado_Interfaz {
  
    public abstract void avanzar(String input, int index, List<Field> listado, CSV csv);
    
    public boolean esSeparador(char caracter) {
        return (caracter == ',' || caracter == '\n');
    }
   
}
