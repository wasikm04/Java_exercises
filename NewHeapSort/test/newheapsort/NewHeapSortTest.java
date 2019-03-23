
package newheapsort;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NewHeapSortTest {
    
    public NewHeapSortTest() {
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
    public void testSort() {
        System.out.println("sort");
        NewHeapSort sorter = new NewHeapSort(); 
        double[] array = new double[]{1.0,2.0,3.0};
        double[] array2= new double[]{3.0,1.0,2.0};
        
        array2=sorter.sort(array2);
        assertEquals(array[0],array2[0],0);
        
    }

    
    @Test
    public void testMakeHeap() {
        System.out.println("makeHeap");
        NewHeapSort sorter = new NewHeapSort(); 
        double[] array = null;
        int heapSize = 0;
        int parent = 0;
        sorter.makeHeap(array, heapSize, parent);
    }

    
    @Test
    public void testSwap() {
        
        NewHeapSort sorter = new NewHeapSort(); 
        double[] array = new double[]{1,2,3};
        double[] arraytwo;
        arraytwo = new double[]{2,1,3};
        int indexone = 0;
        int indextwo = 1;
        sorter.swap(array, indexone, indextwo);
        assertEquals(arraytwo[1],array[1],0);
        
    }
    
}
