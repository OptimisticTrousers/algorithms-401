package binomial_coefficients;

public class BinomialCoefficients {
    /*
     * Desc
     *      computes the factorial value of the given integer
     * 
     * Params
     *      n : given integer 
     * 
     * Returns 
     *      factorial_value : the factorial value of n 
     */
    private static int factorial(int n) {
        if (n <= 0) 
            return -1; 

        int factorial_value = 1; 

        for (int i = n; i > 0; i--) {
            factorial_value *= i; 
        }

        return factorial_value;
    }

    /*
     * Desc
     *      Computes the combinatorial value of n and k 
     * 
     * Params 
     *      n : total number 
     *      k : how many you want to choose
     * 
     * Returns 
     *      returns the combinatorial value of n and k
     */
    private static int combinatorial_calc(int n, int k) {
        // Since binomial coefficents starts and ends with ones, we actively look for those cases to return one
        if (n == 0 || k == 0) 
            return 1; 
        
        else if (n == k) 
            return 1; 
        
        else 
            return factorial(n) / (factorial(k) * factorial(n-k)); 
    }

    /*
     * Desc
     *      computes the binomial coefficients for the given number
     * 
     * Params
     *      num : the given number of coefficents
     * 
     * Returns 
     *      returns the last row of the 2D-array since that will have the binomial coefficents for the given number 
     */
    public static int[] binomial_coefficients(int num) {

        int[][] arr = new int[num][num]; 

        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                arr[row][col] = combinatorial_calc(row, col); 
            }
        }

        
        return arr[num-1]; 
    }   
}
