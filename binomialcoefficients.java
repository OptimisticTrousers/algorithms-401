import java.util.Arrays;

public class binomialcoefficients {

    public static void getBinomialCoefficients(int nth) {

        int[] arr = new int[nth + 1];
        int[] _arr = new int[nth + 1];

        for (int i = 0; i < _arr.length; i++) {
            int[] arrFormated = new int[i + 1];
            int index = 0;
            _arr[0] = 1;
            arrFormated[0] = _arr[0];
            if (i == 0 || i == 1) {
                arr[i] = 1;
                arrFormated[i] = 1;

            } else if (i >= 2 && i % 2 == 0) { // if i is even, number of elements is odd, unique element at center of array
                for (int j = 1; j < i / 2 + 1; j++) {
                    index++;
                    _arr[index] = arr[j] + arr[j - 1];
                }
                for (int j = i / 2 - 1; j > -1; j--) {
                    index++;
                    _arr[index] = _arr[j];
                }

                arrEquals(arr, _arr);
                arrEquals(arrFormated, arr);

            } else { // if i is odd, number of elements is even and is a perfect reflection
                for (int j = 1; j < i / 2 + 1; j++) {
                    index++;
                    _arr[index] = arr[j] + arr[j - 1];
                }
                for (int j = i / 2; j > -1; j--) {
                    index++;
                    _arr[index] = _arr[j];
                }

                arrEquals(arr, _arr);
                arrEquals(arrFormated, arr);
            }

            System.out.println(Arrays.toString(arrFormated));
        }
    }

    public static void arrEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr2[i];
        }
    }

    public static void main(String[] args) {
        getBinomialCoefficients(8);
    }

}

/*
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 */