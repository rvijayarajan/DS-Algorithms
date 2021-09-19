import java.io.*;

public class MergeSort {
    public static void main(String args[]) throws IOException {
        int[] data = new int[]{38, 27, 43, 3, 9, 82, 10};
        for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        sort(data, 0, data.length-1);
        System.out.println();
        for(int i=0; i<data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private static void sort(int[] data, int l, int r) {
        if (l < r) {
            int median = l + (r-l)/2;

            sort(data, l, median);
            sort(data, median+1, r);

            merge(data, l, median, r);
        }
    }

    private static void merge(int[] data, int l, int median, int r) {
        int leftSize = median-l+1;
        int rightSize = r-median;
        int left[] = new int[leftSize];
        int right[] = new int[rightSize];
        
        for(int i=0; i<leftSize ; i++) {
            left[i] = data[l+i];
        }
        
        for(int i=0; i<rightSize; i++) {
            right[i] = data[median+1+i];
        }

        int i=0, j=0, k=l;
        while(i<leftSize && j<rightSize) {
            if(left[i] <= right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < leftSize) {
            data[k] = left[i];
            i++;
            k++;
        }

        while(j < rightSize) {
            data[k] = right[j];
            j++;
            k++;
        }
    }
}