package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testAverage() {
        System.out.println("Average");
        double expResult = 1;
        double result = intStream.average();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void tesMax() {
        System.out.println("Maximum");
        double expResult = 3;
        double result = intStream.max();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void tesMin() {
        System.out.println("Minimum");
        double expResult = -1;
        double result = intStream.min();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void tesSum() {
        System.out.println("Sum");
        double expResult = 5;
        double result = intStream.sum();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testCount() {
        System.out.println("Count");
        double expResult = 5;
        double result = intStream.count();
        assertEquals(expResult, (Object) result);
    }


    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);        
    }
    
}
