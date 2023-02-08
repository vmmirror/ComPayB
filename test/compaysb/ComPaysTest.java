/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compaysb;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nemo
 */
public class ComPaysTest {
    
    public ComPaysTest() {
    }

    /**
     * Test of calcLine method, of class ComPays.
     */
    @Test
    public void testCalcLine() {
        System.out.println("Test: calcLine");
        
        String[] a = { "1.2", "0.7", "1,2", "7" };
        String[] b = { "3.1", "321", "3", "ab" };
        Double expResult[] = { 3.72, 224.7, Double.NaN, Double.NaN };
        Double result;

        ComPays instance = new ComPays();

        for(int i=0;i<a.length;i++) {
            result = instance.calcLine(a[i], b[i]);
            assertEquals(expResult[i], result, 0.00000000001);
        }
    }

    /**
     * Test of calcDrainage method, of class ComPays.
     */
    @Test
    public void testCalcDrainage() {
        System.out.println("Test: calcDrainage");
        String[] a = { "1.2","2.9", "3,7", "2.3" };
        String[] b = { "3.1", "3.1", "0.3", "ab" };
        Double expResult[] = { 4.3, 6.0, Double.NaN, Double.NaN };
        Double result;

        ComPays instance = new ComPays();

        for(int i=0;i<a.length;i++) {
            result = instance.calcDrainage(a[i], b[i]);
            assertEquals(expResult[i], result, 0.00000000001);
        }
    }

    /**
     * Test of calcTotal method, of class ComPays.
     */
    @Test
    public void testCalcTotal() {
        System.out.println("Test: calcTotal");
        ArrayList<Double> arr = new ArrayList<>();
        Double expResult = 0.0;
        for(int i=0;i<6;i++) {
            Double r=Math.random()*1000.0;
            expResult+=r;
            arr.add(r);
        }
        ComPays instance = new ComPays();
        Double result = instance.calcTotal(arr);
        assertEquals(expResult, result, 0.00000000001);
        
        arr.add(Double.NaN);
        result = instance.calcTotal(arr);
        assertEquals(Double.NaN, result, 0.00000000001);
    }
}
