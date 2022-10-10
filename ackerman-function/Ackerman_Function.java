import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ackerman_Function {

    public static File inFile = new File("in.txt");
    public static File outFile = new File("out.txt");

    public static void main(String[] args) {
        read();
    }

    private static void read() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outFile, false))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                int[] arr = new int[2];
                if (line.indexOf('m') != -1 && line.indexOf('n') != -1) {
                    int indexM = line.indexOf('m');
                    int indexN = line.indexOf('n');
                    String mEquals = line.substring(indexM, indexN - 1);
                    String nEquals = line.substring(indexN, line.length());
                    mEquals = mEquals.substring(mEquals.indexOf('=') + 2, mEquals.length());
                    nEquals = nEquals.substring(nEquals.indexOf('=') + 2, nEquals.length());
                    arr[0] = Integer.parseInt(mEquals);
                    arr[1] = Integer.parseInt(nEquals);
                    long start = System.currentTimeMillis();
                    int result = ackerman_function(arr[0], arr[1]);
                    long end = System.currentTimeMillis();
                    long time = end - start;
                    osw.write("m = " + arr[0] + " n = " + arr[1] + " answer = " + result + "\t|     time = " + time + "(ms)");
                    osw.write(10);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int ackerman_function(int m, int n) {
        /*
         * Case 1: if m = 0 return n+1
         * Case 2: if m > 0 and n = 0 return ackerman_function(m-1,1)
         * Case 3: if m > 0 and n > 0 return ackerman_function(m-1,ackerman_function(m, n-1))
         */

        if (m <= 3) {
            if ((m == 3 && n < 12) || (m < 3)) {
                if (m == 0)
                    return n + 1;
                else if (m > 0 && n == 0)
                    return ackerman_function(m - 1, 1);
                else if (m > 0 && n > 0)
                    return ackerman_function(m - 1, ackerman_function(m, n - 1));
            }
        }
        return -1; // error code
    }
}