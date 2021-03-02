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
public class Estado_CaracteresTest {
    
    public Estado_CaracteresTest() {
    }
    
    @Test (expected = IllegalArgumentException.class)  //Faltan comillas 
    public void testCSV4() {
        String entrada = "\"";
        CSV interprete = new CSV();
        interprete.Interpretar(entrada);
    }
    
}
