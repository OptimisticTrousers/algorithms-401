public class binary_search {
    /*
     * Pre-Condition: arr has to be sorted
     * Desc
     *      Uses binary search (a divide and conqure technique) to find a given target 
     * 
     * Args 
     *      arr: an ordered array 
     *      target: an integer to find within the ordered array
     * 
     * Returns
     *      returns the index of the target in the given array
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0; 
        int high = arr.length-1;
        
        while (low <= high) {
            int mid = low + (high - low)/ 2; 

            if (arr[mid] == target)
                return mid; 
            
            else if (arr[mid] > target) 
                high = mid - 1; 
            

            else if (arr[mid] < target)
                low = mid + 1; 
        }

        // returns -1 if target not found in array
        return -1; 
    }


}