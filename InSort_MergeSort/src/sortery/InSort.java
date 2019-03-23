package sortery;

import java.util.Arrays;
import java.util.Random;

public class InSort implements SortingAlgorithm {

    public InSort() {
    }

    @Override
    public double[] sort(double[] vector) {
        int n = vector.length;
        double value;
        int j;
        for (int i = 1; i < n; i++) {
            value = vector[i];
            for (j = i - 1; j >= 0 && vector[j] > value; --j) {
                vector[j + 1] = vector[j];
            }
            vector[j + 1] = value;
        }
        return vector;
    }

    public static void main(String[] args) {
        InSort InSorter = new InSort();
        MergeSort MergeSorter = new MergeSort();

        Random rand = new Random();
        double[] vector = new double[5];
        for (int i = 0; i < vector.length; i++) {
            //   vector[i] = rand.nextDouble()*10;
            vector[i] = 5.0 - i;
        }
        double[] vectorTwo = Arrays.copyOf(vector, vector.length);

        System.out.println("Tablica przed posortowaniem:" + Arrays.toString(vector));
        System.out.println("----------------------------------------------------------");
        System.out.println("InSort");
        long start = System.nanoTime();
        InSorter.sort(vector);
        long stop = System.nanoTime() - start;
        System.out.println("Tablica po posortowaniu:" + Arrays.toString(vector));
        System.out.println("Czas sortowania InSort: " + stop);
        System.out.println("----------------------------------------------------------\n");

        System.out.println("Tablica przed posortowaniem:" + Arrays.toString(vectorTwo));
        System.out.println("----------------------------------------------------------");
        System.out.println("MergeSort");
        start = System.nanoTime();
        MergeSorter.sort(vectorTwo);
        stop = System.nanoTime() - start;
        System.out.println("Tablica po posortowaniu:" + Arrays.toString(vectorTwo));
        System.out.println("Czas sortowania MergeSort: " + stop);
        System.out.println("----------------------------------------------------------\n");

    }

}
