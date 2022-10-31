package MergeSort_vs_QuickSort;

public class QuickSort {

    /*
     * Desc
     *      Selects the largest element as the pivot and puts all the elements greater than it to the right and smaller than it to the left
     * 
     * Params
     *      arr : array to be sorted
     *      low : lowest index for the algorithm to start 
     *      high : highest index for the algorithm to stop 
     * 
     * Returns 
     *      returns i which is the index of the pivot in its sorted location
     */

    public static int partition(int arr[], int low, int high) {
        int pivot_index = high;
        int i = low-1; 
        for (int j = low; j < high; j++)
        {  
            if (arr[j] <= arr[pivot_index])
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }

    /*
     * Desc
     *      sorts the array recrusively by calling sort on sub-portions on the array
     * 
     * Params
     *      arr : array to be sorted
     *      low : lowest index for the algorithm to start 
     *      high : highest index for the algorithm to stop 
     * 
     * Returns 
     *      None
     */
    public static void sort(int arr[], int low, int high) {
        if (low < high)
        {
            int index = partition(arr, low, high);
 
            sort(arr, low, index-1);
            sort(arr, index+1, high);
        }
    }
}
