
package newheapsort;


 
public class NewHeapSort implements ListSorterAlgorithm  {
    
        public NewHeapSort(){
            
        }

       @Override
       public double[] sort(double[] unsortedVector){
                double[] array=unsortedVector;
		int n = unsortedVector.length;
		
		for(int i = n / 2 - 1; i >= 0; i--){
			makeHeap(array, n, i);
		}
		
		for(int i = n - 1; i > 0; i--){
			swap(array, 0, i);
			--n;
			makeHeap(array, n, 0);
		}
                return array;
       }
       
       public void makeHeap(double[]array, int size, int parent){
		int index = parent;
		int leftChild = parent * 2 + 1;
		int rightChild = parent * 2 + 2;
		
		if(leftChild < size && array[leftChild] > array[index]){
			index = leftChild;
		}
		if(rightChild < size && array[rightChild] > array[index]){
			index = rightChild;
		}
		if(index != parent){
			swap(array, index, parent);
			makeHeap(array, size, index);
		}
	} 
        public void swap(double[] array, int index1, int index2) {
        
            if (index1 != index2){ 
                double tmp = array[index1];
                array[index1] = array[index2];
                array[index2] = tmp;
            }
    
    }
    
}
