package MergeSort_vs_QuickSort;

import print_log.PrintLog;
import stop_watch.Stopwatch;

public class Main {

    static final PrintLog pl = new PrintLog("MergeSort_vs_QuickSort/Main");
    static final Stopwatch sw = new Stopwatch();

    public static void main(String[] args) {
        int[] arr1 = genRandomIntArray(100000);
        int[] arr2 = arr1.clone();
        pl.write("Given Array: ");
        printArray(arr2);
    
        sw.start(); 
        MergeSort.sort(arr1, 0, arr1.length - 1);
        sw.stop();
        pl.write("Sorted array: ");
        printArray(arr1);
        pl.writeln("MergeSort time: " + sw.getTime() + "ms");
        //print to file

        sw.start();
        QuickSort.sort(arr2, 0, arr2.length - 1);
        sw.stop();
        pl.writeln("QuickSort time: " + sw.getTime() + "ms");
        //print to file 
        
    }

    /* A utility function to generate array of size n */
    static int[] genRandomIntArray(int nth) {
        int[] arr = new int[nth];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10 + 1);
        }
        return arr;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        String s = "";
        if(n <= 10) {
            for (int i = 0; i < n; ++i)
                s += arr[i] + " ";
            pl.writeln(s);
        } else {
            for (int i = 0; i < 10; ++i)
                s += arr[i] + " ";
            pl.writeln(s);
        }
    }
}
