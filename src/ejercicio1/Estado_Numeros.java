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
public class Estado_Numeros extends CSV_Estado {
    private static final Estado_Numeros instancia = new Estado_Numeros();
    
    private Estado_Numeros() {}
    
    public static Estado_Numeros getInstancia() {
        return instancia;
    }
    
    @Override
    public void avanzar(String input, int index, List<Field> listado, CSV csv) {
        StringBuffer buffer = new StringBuffer();
        char aux = input.charAt(index);

        while (Character.isDigit(aux) && !esSeparador(aux) && index < input.length()) {
            aux = input.charAt(index);
            buffer.append(aux);
            index++;
            csv.aumentarIndice();
        }
        if (esSeparador(aux)) {
            buffer.deleteCharAt(buffer.length() - 1);
            csv.lista.add(new NumberField(Integer.parseInt(buffer.toString())));
            csv.setEstado(Estado_Inicial.getInstancia());
            csv.Interpretar(input);
        } else {
            if (index >= input.length()) {
                csv.lista.add(new NumberField(Integer.parseInt(buffer.toString())));
                csv.setEstado(Estado_Inicial.getInstancia());
                csv.Interpretar(input);
            } else {
                if (!Character.isDigit(aux)) {
                    throw new IllegalArgumentException("ERROR: número incorrecto");
                }
            }
        }
    }
    
}
