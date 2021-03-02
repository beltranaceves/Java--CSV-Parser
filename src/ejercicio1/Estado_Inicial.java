/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.List;

/**
 *
 * @author Beltran
 */
public class Estado_Inicial extends CSV_Estado {
    private static final Estado_Inicial instancia = new Estado_Inicial();
    
    private Estado_Inicial() {}
    
    public static Estado_Inicial getInstancia () {
        return instancia;
    }
    @Override
    public void avanzar(String input, int indice, List<Field> listado, CSV csv) {
        /* Algoritmo:
        -Rellenar el String buffer si la entrada mientras la entrada valida. En caso contrario: excepcion
        -Crear el Field del tipo correspondiente
        -Meterlo en la lista
        -Determinar el estado siguiente y seguir con la ejecucion. En caso de llegar al final del input se acabó
        */
        char aux;
        if (indice < input.length()) { 
            aux = input.charAt(indice);
            if (aux == '\"') {
                if (indice + 1 == input.length()) {
                    throw new IllegalArgumentException("ERROR: fin inesperado del input");
                } else {
                    csv.aumentarIndice();
                    csv.setEstado(Estado_Caracteres.getInstancia());
                    csv.Interpretar(input);
                }
            } else {
                if (Character.isDigit(aux)) {
                    csv.setEstado(Estado_Numeros.getInstancia());
                    csv.Interpretar(input);
                } else {
                    if (esSeparador(aux)) {
                        csv.aumentarIndice();
                        csv.Interpretar(input);
                    } else {
                        if (Character.isLetter(aux)) {
                            throw new IllegalArgumentException("ERROR: Carácter no entre comillas");
                        } else {
                            throw new IllegalArgumentException("Error: Sintaxis incorrecta");
                        }
                    }
                }
            }
        }
    }
    
}
