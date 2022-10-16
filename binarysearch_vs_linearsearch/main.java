import java.util.Arrays;
public class main {
    public static void main(String[] args) {
       // int[] arr = {1,2,3,4,5}; 
        int[] arr = {5,3,2,3,1};
        Arrays.sort(arr); 

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " "); 
        System.out.println("\n" + linear_search.linearSearch(arr,5));
        System.out.println(binary_search.binarySearch(arr,5));
    }
}
