public class linear_search {
    /*
     * Pre-Condition
     *      Inputted array needs to be sorted
     * 
     * Desc
     *      Searches through an array one element at a time to find the target
     * 
     * Args
     *      arr:    array to search throguh
     *      target: integer to find within the array
     * 
     * Return
     *      returns index of the target if found in the array 
     *      returns -1 if the target is not found in the array
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) 
            if (arr[i] == target)
                return i; 
        
        return -1; 
    }
}
