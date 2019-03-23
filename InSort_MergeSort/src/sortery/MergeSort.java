package sortery;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

    public MergeSort() {
    }

    @Override
    public double[] sort(double[] unsortedVector) {
        return mergeSort(unsortedVector, 0, unsortedVector.length - 1);

    }

    public double[] mergeSort(double[] unsortedVector, int left, int right) {
        int middle = left / 2 + right / 2;
        if (left < right) {
            mergeSort(unsortedVector, left, middle);
            mergeSort(unsortedVector, middle + 1, right);
            merge(unsortedVector, left, middle, right);
        }
        return unsortedVector;
    }

    public void merge(double[] vector, int left, int middle, int right) {
        double[] supportArray = new double[right+1];
        for (int j = left; j <= right; j++) {
            supportArray[j] = vector[j];
        }
        int i = left;
        int first = left;
        int second = middle + 1;

        while (first <= middle && second <= right) {
            if (supportArray[first] <= supportArray[second]) {
                vector[i] = supportArray[first];
                first++;
            } else {
                vector[i] = supportArray[second];
                second++;
            }
            i++;
        }
        while (first <= middle) {
            vector[i] = supportArray[first];
            i++;
            first++;
        }
    }
}
