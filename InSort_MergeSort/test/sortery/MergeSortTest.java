package sortery;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSortTest {

    public MergeSortTest() {
    }

    @Test
    public void test_if_mergesort_sorts_right() {
        MergeSort mergeSorter = new MergeSort();
        double[] vector = new double[]{3.0, 2.0, 1.0};
        double[] vector2 = new double[]{1.0, 2.0, 3.0};
        mergeSorter.sort(vector);
        assertArrayEquals(vector, vector2, 0.0);
    }

    @Test
    public void test_how_much_time_takes_sort() {
        MergeSort mergeSorter = new MergeSort();
        double[] vectorRand = null;
        double[] vectorOpt = null;
        double[] vectorPes = null;
        long avg1 = 0;
        long avg2 = 0;
        long avg3 = 0;
        long start = 0;
        long time = 0;

        for (int n = 1000; n <= 7000; n += 2000) {
            vectorRand = new double[n];
            randomVector(vectorRand, n );
            vectorOpt = new double[n];
            vectorPes = new double[n];
            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < n; i++) {
                    vectorOpt[i] = i;
                    vectorPes[i] = (n - 1) - i;
                }
                start = System.nanoTime();
                mergeSorter.sort(vectorRand);
                time = (System.nanoTime() - start);
                avg1 = (avg1 + time);

                start = System.nanoTime();
                mergeSorter.sort(vectorRand);
                time = (System.nanoTime() - start);
                avg2 = (avg2 + time);

                start = System.nanoTime();
                mergeSorter.sort(vectorPes);
                time = (System.nanoTime() - start);
                avg3 = (avg3 + time);

            }
            System.out.println("------------------------------------------------");
            System.out.println("Średni czas sortowania losowych liczb Merge Sort dla elementów : " + n);
            System.out.println("Średnia : " + avg1 / n);

            System.out.println("Średni czas sortowania optymistycznego Merge Sort dla elementów : " + n);
            System.out.println("Średnia : " + avg2 / n);

            System.out.println("Średni czas sortowania pesymistycznego Merge Sort dla elementów : " + n);
            System.out.println("Średnia : " + avg3 / n);
            System.out.println("------------------------------------------------");

        }

    }

    public void randomVector(double vector[], int i) {
        Random random = new Random();
        for (int j = 0; j < i; j++) {
            vector[j] = random.nextDouble() * 100;
        }

    }
}
