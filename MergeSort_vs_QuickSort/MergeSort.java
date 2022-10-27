package MergeSort_vs_QuickSort;

import print_log.PrintLog;

class MergeSort {

    static PrintLog pl = new PrintLog("MergeSort_vs_Quicksort/MergeSort");
    
    //Timer variables
    static long start;
    static long end;

    // Driver method
    public static void main(String args[]) {
        int arr[] = genRandomIntArray(6); // genRandomIntArray(6) = {12, 11, 13, 5, 6, 7};

        pl.write("Given Array\n");
        printArray(arr);

        start = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        end = System.currentTimeMillis();

        pl.write("\n\nSorted array\n");
        printArray(arr);
        pl.write("\nTotal time: " + (end - start) + "ms");
    }

    static int[] genRandomIntArray(int nth) {
        int[] arr = new int[nth];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 15 + 1);
        }
        return arr;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        String s = "";
        for (int i = 0; i < n; ++i)
            s += arr[i] + " ";
        pl.write(s);
    }

    // Main function that sorts arr[l..r] using merge()
    static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}