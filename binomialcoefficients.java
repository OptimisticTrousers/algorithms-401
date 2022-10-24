import java.util.Arrays;

public class binomialcoefficients {
    public static void main(String[] args){
        getBinomialCoefficients(8);
    }
    
    public static void getBinomialCoefficients(int nth){
        int[] arr = new int[nth + 1];
        int[] _arr = arr.clone();
        for(int i = 0; i < arr.length; i++){
            int index = 0;
            if(i == 0 || i == 1){
                arr[i] = 1;
            }else if(i >= 2 && i % 2 == 0){ //if i is even, number of elements is odd, unique element at center of array
                _arr[0] = 1;
                _arr[i] = arr[0];
                for(int j = 1; j < i/2+1; j++){
                    index++;
                    _arr[index] = arr[j] + arr[j-1];
                }
                for(int j = i/2-1; j > -1; j--){
                    index++;
                    _arr[index] = _arr[j];
                }

                for(int j = 0; j < arr.length; j++){
                    arr[j] = _arr[j];
                }

            }else{ // if i is odd, number of elements is even and is a perfect reflection
                for(int j = 1; j < i/2+1; j++){
                    index++;
                    _arr[index] = arr[j] + arr[j-1];
                }
                for(int j = i/2; j > -1; j--){
                    index++;
                    _arr[index] = _arr[j];
                }
                
                for(int j = 0; j < arr.length; j++){
                    arr[j] = _arr[j];
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }   

    /*
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    */
}