
package newheapsort;

import java.util.Arrays;


public class Heap implements HeapInterface<Double>  {

    private Double[] array;
    private int n=0;
    
    public Double[] getArray() {
        return array;
    }

 
    public Heap(){
     
        
    }
    
    
    @Override
    public void put(Double item){
       
        if(n==0){
            array= new Double[1];
            array[0]=item;
            n++;
        }else{
            Double[] tab = Arrays.copyOf(array, n+1);
       int i,j;
       
        i = n++;
        
      j = (i - 1) / 2;
        
        while(i > 0 && tab[j].compareTo(item)<0)
        {
         tab[i] = tab[j];
          i = j;
          j = (i - 1) / 2;
       }

    tab[i] = item;
    array=Arrays.copyOf(tab, n);
        }
        
    }
    
    @Override
    public Double pop(){
        if(n==0){
            return null;
        }
        
        Double ret = array[0];
        
        
        Double[] tab = Arrays.copyOf(array, n-1);
        
         int i,j;
   
      n--;
    Double tmp = array[n];
    
    i = 0;
    j = 1;

    while(j < n)
    {
      if(j + 1 < n && tab[j + 1] > tab[j]){
          j++;
      }
      if(tmp >= tab[j]){
          Double[] array = Arrays.copyOf(tab, n);
          break;
      }
      tab[i] = tab[j];
      i = j;
      j = 2 * j + 1;
    }
    if(n!=0){
    tab[i] = tmp;   
    }
    array = tab;
    return ret;
  }
        
   
}