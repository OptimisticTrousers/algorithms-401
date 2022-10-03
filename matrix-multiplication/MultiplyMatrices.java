import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MultiplyMatrices {
    private boolean inUse;
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] matrixC;

    private Scanner in;
    private static File f;
    private static Random rand;

    MultiplyMatrices(Scanner scan, String path) { // Constructor
        f = new File(path);
        if (f.exists()) { // if file already exists, clear contents of .txt file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, false))) {
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        rand = new Random();
        in = scan;
        inUse = true;
    }

    public boolean isInUse() { // returns value of inUse
        return inUse;
    }

    public void defineDimensions() { // passes user input to give matrix dimensions
        // System.out.println("inUse: " + this.inUse);
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            do {
                try {
                    switch (i) {
                        case 0:
                            System.out.print("Enter the number of rows in the first matrix: ");
                            break;
                        case 1:
                            System.out.print("Enter the number of columns in the first matrix: ");
                            break;
                        case 2:
                            System.out.print("Enter the number of rows in the second matrix: ");
                            break;
                        case 3:
                            System.out.print("Enter the number of columns in the second matrix: ");
                            break;
                    }
                    num = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Invalid integer! ");
                }
                in.nextLine();// clears the buffer
            } while (num <= 0);
            arr[i] = num;
            System.out.println();
        }

        System.out.println("matrixA: " + arr[0] + "x" + arr[1]);
        write("matrixA: " + arr[0] + "x" + arr[1]);
        matrixA = generateMatrix(arr[0], arr[1]);
        System.out.println("matrixB: " + arr[2] + "x" + arr[3]);
        write("matrixB: " + arr[2] + "x" + arr[3]);
        matrixB = generateMatrix(arr[2], arr[3]);
    }

    public int[][] multiplyMatrices() { // see method name
        matrixC = new int[matrixA.length][matrixB[0].length];
        // the result of matrix multiplication is always the number of rows from matrixA
        // times the number of columns from matrixB (Ex. 2x1 * 1x2 = 2x2; 1x2 * 2x1 =
        // 1x1; 2x3 * 3x7 = 2x7)

        if (possible()) {
            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixC[0].length; j++) {
                    matrixC[i][j] = 0;
                    for (int k = 0; k < matrixA[0].length; k++) {
                        matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
            System.out.println("matrixC: " + matrixC.length + "x" + matrixC[0].length);
            write("matrixC: " + matrixC.length + "x" + matrixC[0].length);
            printMatrix(matrixC);
            write("");
            char choice = 0;
            do {
                try {
                    System.out.print("Would you like to try again? (y/n): ");
                    choice = in.next().charAt(0);
                } catch (InputMismatchException e) {
                    System.out.print("Invalid integer! ");
                }
            } while (choice != 'y' && choice != 'n');
            if (choice == 'n') {
                inUse = false;
                in.nextLine(); // clear buffer of Input Stream
            }
            return matrixC;
        }

        System.err.println(
                "Attention: The number of columns in the first matrix doesn't equal the number of rows in the second matrix.");
        System.err.println("Please provide adequate dimensions next time!");

        return matrixC;
    }

    private static int[][] generateMatrix(int numOfRows, int numOfColumns) { // randomly generates a given matrix

        int[][] matrix = new int[numOfRows][numOfColumns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        printMatrix(matrix);
        write("");

        return matrix;
    }

    private static void printMatrix(int[][] matrix) { // see previous comment
        String[] formattedMatrix = formatMatrix(matrix);
        String bound = "";

        for (int i = 0; i < formattedMatrix[0].length(); i++) {
            bound += "-";
        }

        for (int i = 0; i < matrix.length; i++) {
            if(i == 0){
                System.out.println(bound);
                write(bound);
            }

            System.out.println(formattedMatrix[i]); //deprecated
            write(formattedMatrix[i]);

            if(i == matrix.length-1){
                System.out.println(bound);
                write(bound);
            }
        }
    }

    private static String[] formatMatrix(int[][] matrix) {
        String[] stringMatrix = new String[matrix.length];

        // Step One: find largest integer
        int maxMatrix = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > maxMatrix) {
                    maxMatrix = matrix[i][j];
                }
            }
        }

        // Step Two: use largest integer's length to determine "cell" size
        int lengthMax = intLength(maxMatrix);
        String cell = "";
        for (int i = 0; i < lengthMax; i++) {
            cell += " ";
        }

        // Step Three: iterate through matrix and generate formatted version
        for (int i = 0; i < matrix.length; i++) {
            String row = "";
            for (int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j];
                String s = cell;

                int index = s.length() - intLength(num);
                if (index > 0) {
                    s = s.substring(0, index) + num;
                } else {
                    s = Integer.toString(num);
                }
                if (matrix[0].length == 1) {
                    row += ("|  " + s + "  |");
                    continue;
                }

                if (j == 0) {
                    row += ("|  " + s + "   ");

                } else if (j == matrix[0].length - 1) {
                    row += (s + "  |");

                } else {
                    row += (s + "   ");

                }
            }
            stringMatrix[i] = row;
        }

        return stringMatrix;
    }

    private boolean possible() { // checks if matrixA and matrixB are capable of multiplying
        if (matrixA[0].length == matrixB.length) {
            return true; // if matrixA has the same number of columns as the number of rows in matrixB
        }

        return false;
    }

    private static int intLength(int i) {
        return String.valueOf(i).length();
    }

    private static void write(String s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
            bw.write(s + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}