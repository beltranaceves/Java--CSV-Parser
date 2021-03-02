/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Beltrán
 */
public class Estado_NumerosTest {
    
    public Estado_NumerosTest() {
    }
    
    @Test
    public void testEstado_numeros() {
        String entrada = "12312\n";
        CSV interprete = new CSV();
        List<Field> expected_result = new ArrayList<>();
        List<Field> result = interprete.Interpretar(entrada);
        expected_result.add(new NumberField(12312));
        interprete.Mostrar();
        assertEquals(result, expected_result);
    }
    
    @Test (expected = IllegalArgumentException.class) //Numero Incorrecto
    public void testEstado_Numero2() {
       String entrada = "123123jh,";
       CSV interprete = new CSV();
       interprete.Interpretar(entrada);
       System.out.println();
    }
}
