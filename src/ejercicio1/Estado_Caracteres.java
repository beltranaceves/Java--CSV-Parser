/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.List;
import java.lang.StringBuffer;

/**
 *
 * @author Beltran
 */
public class Estado_Caracteres extends CSV_Estado {

    private static final Estado_Caracteres instancia = new Estado_Caracteres();

    private Estado_Caracteres() {
    }

    public static Estado_Caracteres getInstancia() {
        return instancia;
    }

    @Override
    public void avanzar(String input, int index, List<Field> listado, CSV csv) {
        StringBuffer buffer = new StringBuffer();
        char aux = input.charAt(index);

        while (aux != '"' && !esSeparador(aux) && index < input.length()) { 
            aux = input.charAt(index);
            buffer.append(aux);
            index++;
            csv.aumentarIndice();
        }
        
        if (aux == '\"') {
            buffer.deleteCharAt(buffer.length() - 1);
            csv.lista.add(new StringField(buffer.toString()));
            index++;
            csv.setEstado(Estado_Inicial.getInstancia());
            csv.Interpretar(input);
        } else {
            throw new IllegalArgumentException("ERROR: Faltan comillas finales");
        }
    }
}


