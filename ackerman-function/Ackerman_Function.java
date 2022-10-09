public class Ackerman_Function {

    public static void main(String[] args) {
        System.out.println(ackerman_function(2, 2));
    }

    public static int ackerman_function(int m, int n) {
        /* 
         * Case 1: if m = 0 return n+1
         * Case 2: if m > 0 and n = 0 return ackerman_function(m-1,1)
         * Case 3: if m > 0 and n > 0 return ackerman_function(m-1, arckerman_function(m, n-1))
         */

        if (m == 0) 
            return n+1; 
        
        else if (m > 0 && n == 0) 
            return ackerman_function(m-1, 1); 
        
        return ackerman_function(m-1, ackerman_function(m, n-1)); 
    }
}