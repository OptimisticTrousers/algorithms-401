package binomial_coefficients;

public class GetBinomialCoefficients {

    private static void reflectArr(long[] arr, int index) {
        int i = arr.length - 1;
        if (i % 2 == 0) { // if iteration of i is even, then there will be a unique element at the mid index of arr
            for (int j = i / 2 - 1; j > -1; j--) { // first half of the array is reflected onto the second
                index++; // increment index as j approaches -1
                arr[index] = arr[j]; // set arr[index] to it's mirrored index
            }
        } else if (i % 2 == 1) { // if iteration of i is odd, then it's a perfect reflection, no middle element
            for (int j = i / 2; j > -1; j--) {
                index++;
                arr[index] = arr[j];
            }
        }
    }

    public static long[] genPascalTriangle(int nth) {
        long[] arr = new long[nth + 1];
        int index = 0;

        if (nth == 0) {
            arr = new long[] { 1 };
        } else if (nth == 1) {
            arr = new long[] { 1, 1 };
        } else {
            arr[0] = 1;
            arr[1] = arr[0];
            for (int i = 0; i < nth + 1; i++) {
                arr = new long[i + 1]; // current arr is sized to fit all possible elements
                index = 0; // index is set to 0 each iteration of i

                arr[0] = 1; // every iteration of i sets the first index of arr to 1
                if (i == 1) { // if iteration of i = 1,
                    arr[1] = 1; // sets the second index of arr to 1
                }
                for (int j = 1; j < i / 2 + 1; j++) { // at each of iteration of j,
                    index++; // increment index so index = j,
                    arr[index] = getCoefficient(i, j);
                }

                reflectArr(arr, index);
            }
        }

        return arr;
    }

    private static long getCoefficient(int n, int k) {
        long coeff[] = new long[k + 1];
        coeff[0] = 1;

        for (int i = 1; i <= n; i++) {
            int min = Math.min(i, k);
            for (int j = min; j > 0; j--)
                coeff[j] = coeff[j] + coeff[j - 1];
        }
        return coeff[k];
    }
}