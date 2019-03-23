
package newheapsort;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HeapTest {
    
    public HeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetArray() {
        Double[] array = new Double[]{1.0,1.0,1.0}; 
        Heap heap = new Heap();
        heap.put(1.0);
        heap.put(1.0);
        heap.put(1.0);
        
        Double[] result = heap.getArray();
        assertArrayEquals(array, result);
        assertNotNull(result);
    }

   
    @Test
    public void testPut() {
         System.out.println("put");
        Heap heap= new Heap();
        heap.put(20.0);
        assertNotNull(heap.getArray());
        
    }

    
    @Test
    public void testPop() {
        System.out.println("pop");
        Heap heap= new Heap();
        heap.put(20.0);
        Double result = heap.pop();
        assertEquals(20.0, result,0);
        assertNotNull(result);
        
    }
    
}
