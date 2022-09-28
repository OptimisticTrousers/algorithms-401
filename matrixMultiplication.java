import java.util.*;

import javax.print.attribute.standard.NumberUpSupported;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class matrixMultiplication {
    public static void main(String args[]){
        /* 
         * ask user to enter dimensions of matrics
         * check validity of mult
         * use random object to generate data (math class)
         * multiply matrices
         * output: print on screen AND write to txt file
         * 
         * 
         * extra for experts: making the display of the output pretty as such
         * 
         *      ---------------
         *      |  a   b   c  |
         *      |  d   e   f  |
         *      |  g   h   i  |
         *      ---------------
         */

         Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows of first matrix: ");
        int aRow = sc.nextInt();

        System.out.println("Enter number of columns of first matrix: ");
        int aCol = sc.nextInt();
        System.out.println("Enter number of rows of second matrix: ");
        int bRow = sc.nextInt();
        System.out.println("Enter number of columns of second matrix: ");
        int bCol = sc.nextInt();

        read in the matrices
         
        boolean plausible = validityCheck(aCol, bRow);

         // could move this into the validity check
        while (!plausible){
            System.out.println("Please ensure that the number of columns in Matrix 1 is the same as the number of rows in Matrix 2");
            System.out.println("Would you like to (1) Change the # of columns in Matrix 1 or (2) Change the # of rows in Matrix 2");
            int toChange = sc.nextInt(); // write a try and catch here if they dont enter numbers

            if (toChange == 1){
                System.out.println("What is your new number of rows for Matrix 1?");
                aCol = sc.nextInt();
            } else {
                System.out.println("What is your new number of columns for Matrix 2?");
                bRow = sc.nextInt();
            }
            plausible = validityCheck(aCol, bRow);
        }

        int[][] matrixA = arrayGenerator(aRow, aCol);
        int[][] matrixB = arrayGenerator(bRow, aCol);

        // printArray(array);

    }

    public static void printArray(int[][] array) {
        for(int i = 0;i < array[0].length; i++) {
            for(int j = 0; j < array.length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }

    public static boolean validityCheck(int firstCol, int secondRow){ // pass in the ints entered
        if (firstCol == secondRow){
            return true;
        } else {
            return false;
        }
    }

    public static int[][] arrayGenerator(int rows, int cols){
        Random rand = new Random();
        int[][] array = new int[rows][cols];

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                array[i][j] = rand.nextInt(10);
            }
        }
        return array;
    }

    public static int[][] multiplication(int[][] matA, int[][] matB){

        int[][] finalArray = new int[matB[0].length][matB.length];

        int numOfCols = matA[0].length;

        for(int i = 1; i <= numOfCols; i++) {
            for(int j = 1; j <= numOfCols;i ++) {
               finalArray[i][j] = 0;
               for(int k = 1; k<= numOfCols; k++) {
                finalArray[i][j] = finalArray[i][j] + (matA[i][k] * matB[k][j])
               }
            }
        }
    }






}
