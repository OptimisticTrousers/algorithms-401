import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PolishPeasantNotMultiplication {

    public static void main(String[] args) {
        runFile();
    }

    static void runFile() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("ppinputfile.txt"))));
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("output.txt"), false));) {
                    for (String line = br.readLine(); line != null; line = br.readLine()) {
                        String temp = new String();

                        int[] arr = new int[2];
                        for (int i = 0; i < line.length(); i++) {
                            if (line.charAt(i) == (char) 32) {
                                arr[0] = Integer.parseInt(temp);
                                temp = new String();
                            } else if (i == line.length() - 1) {
                                temp += line.charAt(i);
                                arr[1] = Integer.parseInt(temp);
                            } else {
                                temp += line.charAt(i);
                            }
                        }

                        osw.write("" + arr[0]);
                        osw.write(" * " + arr[1]);
                        osw.write(" = " + ppnm(arr[0], arr[1]));
                        osw.write(10);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int ppnm(int x, int y) {

        int sum = 0;
        while (y > 0) {
            if (y % 2 == 1) {
                sum += x;
            }
            x <<= 1;
            y >>= 1;
        }
        return sum;
    }
}