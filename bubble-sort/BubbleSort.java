import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    final static int ARRAY_LENGTH = 200; // max number of elements per array
    final static int DEBUG_INTERVAL = 50; // -1 to disable debug messages

    static File f = new File("OPTIMISTICTROUSERSout.txt");

	public static int[] genRandomArray() {
        Random rand = new Random();
        int[] arr = new int[ARRAY_LENGTH];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(200 + 1);
        }

        return arr;
    }
	
	public static void write(String s) {
        try (FileWriter fw = new FileWriter(f, true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] arr1 = genRandomArray();
        int[] arr2 = genRandomArray();
        int[] arr3 = genRandomArray();

        write("Bubble Sort v1");
        arr1 = v1(arr1);
        write("Bubble Sort v2");
        arr2 = v2(arr2);
        write("Bubble Sort v3");
        arr3 = v3(arr3);
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void swap(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[index + 1];
        arr[index + 1] = temp;
    }

    /*
     * v3 of the bubble sort algorithm
     * parameters: int type array
     * output: int type array
     * 
     * utilizes a boolean "flag", flag is initialized as true, set false in each
     * pass and made true if a swap occurs during iteration.
     * if a pass goes through a complete iteration and the flag remains false,
     * one of the "j" while conditions will be false,
     * making the entire condition false, exiting from the while loop.
     */
    public static int[] v3(int[] arr) {
        write(Arrays.toString(arr) + "\n" + "Sorted: " + isSorted(arr) + "\n");

        int j = 0;
        boolean flag = true;
        while (j < arr.length - 1 && (flag)) {
            flag = false;
            for (int i = 0; i < (arr.length - 1) - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    // write(debug(arr, j, i));
                    flag = true;
                }
                // j++; will cause errors here
            }

            eachInterval(arr, j);
            j++;
        }
        write(Arrays.toString(arr) + "\n" + "Sorted: " + isSorted(arr) + "\n");

        return arr;
    }

    /*
     * v2 of the bubble sort algorithm
     * parameters: int type array
     * output: int type array
     * 
     * we increment j for each complete pass so we don't re-sort sorted numbers at
     * the end of the array.
     */
    public static int[] v2(int[] arr) {
        write(Arrays.toString(arr) + "\n" + "Sorted: " + isSorted(arr) + "\n");

        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < (arr.length - 1) - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    // write(debug(arr, j, i));
                }
            }
            eachInterval(arr, j);
        }
        write(Arrays.toString(arr) + "\n" + "Sorted: " + isSorted(arr) + "\n");

        return arr;
    }

    /*
     * v1 of the bubble sort algorithm
     * parameters: int type array
     * output: int type array
     * 
     * sort each element regardless if it's already in a sorted position, slow.
     * brute force method of bubble sort, takes the longest, gets the job done.
     */
    public static int[] v1(int[] arr) {
        write(Arrays.toString(arr) + "\n" + "Sorted: " + isSorted(arr) + "\n");

        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i);
                    // write(debug(arr, j, i));
                }
            }
            eachInterval(arr, j);

        }
        write(Arrays.toString(arr) + "\n" + "Sorted: " + isSorted(arr) + "\n");

        return arr;
    }

    public static String debug(int[] arr, int j) {
        String debugMessage = "pass " + j + ": " + Arrays.toString(arr);

        return debugMessage;
    }

    public static String debug(int[] arr, int j, int i) {
        String debugMessage = "pass " + j + ": i " + i + ": " + Arrays.toString(arr);

        return debugMessage;
    }

    public static void eachInterval(int[] arr, int j) {
        if (DEBUG_INTERVAL >= 0) {
            try {
                if (j % DEBUG_INTERVAL == 0) {
                    write(debug(arr, j));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }  
        }
    }
}