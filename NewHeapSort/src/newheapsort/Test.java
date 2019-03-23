
package newheapsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Test {
    
    public static void main(String[] args) {
        System.out.println("Ile elementów ma być w tablicy: ");
        Scanner in = new Scanner(System.in);
        int liczba = in.nextInt();
        double array[] = new double[liczba];
        Random rand = new Random();
        int i;
        for(i=0;i<array.length;i++)
       {
             array[i]=rand.nextDouble()*20;
         }
        
         System.out.println("Tablica przed "+Arrays.toString(array));
         NewHeapSort Sorter = new NewHeapSort();
         long startTime = System.currentTimeMillis();
         
         
         array = Sorter.sort(array);
         
         
         System.out.println("Time of sorting "+ ((System.currentTimeMillis() - startTime)));
         
         System.out.println("Tablica po "+Arrays.toString(array));
         
        
         System.out.println("\n-----------------------\n");
         
          System.out.println("Ile elementów ma być w stogu: ");
       
        liczba = in.nextInt();
         Heap heap = new Heap();
         heap.put(rand.nextDouble()*20);
         heap.put(rand.nextDouble()*20);
         heap.put(rand.nextDouble()*20);
         heap.put(rand.nextDouble()*20);
         heap.put(rand.nextDouble()*20); 
        
                           
         System.out.println("\nKopiec po dodaniu kilku liczb: \n"+Arrays.toString(heap.getArray()));
        
         for(i=0;i<liczba;i++){
         Double returnedValue = heap.pop();
         System.out.println("Zdjęta liczba: "+returnedValue);
         
         }
         
         
         System.out.println("Kopiec po zdjęciu  liczb: "+Arrays.toString(heap.getArray()));
         
         
         
         
    }
    
}
