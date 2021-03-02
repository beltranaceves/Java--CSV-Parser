/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.ByteArrayOutputStream;
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
public class CSVTest {
    /**
     * Test of Mostrar method, of class CSV.
     */
    @Test
    public void testCSV() {
        String entrada = "\"fdsdfsdf\",\"patata\"\n39847594\n";
        CSV interprete = new CSV();
        List<Field> result = interprete.Interpretar(entrada);
        List<Field> expected_result = new ArrayList<>();
        expected_result.add(new StringField("fdsdfsdf"));
        expected_result.add(new StringField("patata"));
        expected_result.add(new NumberField(39847594));
        interprete.Mostrar();
        assertEquals(result, expected_result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCSV2() {
        String entrada = "\"fdsdfsdf,\"patata\",39847594,";
        CSV interprete = new CSV();
        interprete.Interpretar(entrada);
    }
}
