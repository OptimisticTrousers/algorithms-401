package binomial_coefficients;

import java.util.Arrays;

public class GetBinomialCoefficients {

    public static void arrEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            arr1[i] = arr2[i];
        }
    }

    public static void binom_coef(int nth) {
        int[] arr = new int[nth]; // register array, will cycle through previous arrays used for the computation of a temporary arr,
        //_arr, in this case, will be instantiated to represent the current array being solved for each iteration of i.

        for (int i = 0; i < arr.length-1; i++) {
            int[] _arr = new int[i + 1]; // current _arr is sized to fit all possible elements
            int index = 0; // index is set to 0 each iteration of i

            _arr[0] = 1; // every iteration of i sets the first index of _arr to 1
            if (i == 1) { // if iteration of i = 1,
                _arr[1] = 1; // sets the second index of _arr to 1
            } else if (i % 2 == 0) { // if iteration of i is even, then there will be a unique element at the mid index of _arr
                for (int j = 1; j < i / 2 + 1; j++) { // at each of iteration of j,
                    index++; // increment index so index = j,
                    _arr[index] = arr[j] + arr[j - 1]; // set value of _arr[index] by finding the sum of arr[j] + arr[j - 1]
                }
                for (int j = i / 2 - 1; j > -1; j--) { // first half of the array is reflected onto the second
                    index++; // increment index as j approaches -1
                    _arr[index] = _arr[j]; // set _arr[index] to it's mirrored index
                }
            } else if (i % 2 == 1) { // if iteration of i is odd, then it's a perfect reflection, no middle element
                for (int j = 1; j < i / 2 + 1; j++) { // at each of iteration of j,
                    index++; // increment index so index = j,
                    _arr[index] = arr[j] + arr[j - 1]; // set value of _arr[index] by finding the sum of arr[j] + arr[j - 1]
                }
                for (int j = i / 2; j > -1; j--) { // first half of the array is reflected onto the second
                    index++; // increment index as j approaches -1
                    _arr[index] = _arr[j]; // set _arr[index] to it's mirrored index
                }
            }

            arrEquals(arr, _arr); //sets arr equal to _arr given for the length of _arr
            System.out.println(Arrays.toString(_arr)); //prints current array to console
        }
    }

    public static void main(String[] args) {
        binom_coef(10);
    }
}