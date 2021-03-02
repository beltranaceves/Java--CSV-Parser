/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

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
public class Estado_InicialTest {
    
    public Estado_InicialTest() {
    }
    
    @Test (expected = IllegalArgumentException.class) //Sintaxis Incorrecta
    public void testEstado_inicial() {
        String entrada = "\"f\", 2342";
        CSV interprete = new CSV();
        interprete.Interpretar(entrada);
    }    
    
    @Test (expected = IllegalArgumentException.class) //Carácter no entre comillas
    public void testEstado_Inicial2() {
        String entrada = "a";
        CSV interprete = new CSV();
        interprete.Interpretar(entrada);
    } 
    
}
