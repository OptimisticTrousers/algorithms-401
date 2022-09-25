import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class PolishPeasantMultiplication {

    static Map<Integer, Integer> map;
    static long start;
    static long end;

    static File f = new File("output.txt");

    public static void write(String s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        map = new LinkedHashMap<Integer, Integer>();
        if (f.exists()) { //if file already exists, clear contents of .txt file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, false))) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int x = 9999;
        int y = 9999;

        i_ppm(x, y);
        r_ppm(x, y);
        write("Whether written in iterative or recursive form, the difference in time efficiency\nbetween either implementations is negligable since both share the same steps,\nbut structured to fit the dimensions of either implementation.\n\nIn very rare cases, one method will trail behind the other by 1ms.");
    }

    public static void debugMap(int product) {
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();

        write("\nsum = ");
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            if (entry.getValue() == 1) {
                write("" + entry.getKey());
            } else if (entry.getValue() % 2 == 1) {
                write(entry.getKey() + " + ");
            }
        }

        write("\n = " + product);
    }

    private static int i_ppm(int x, int y) {
        start = System.currentTimeMillis();
        write("Iterative Method: " + x + " * " + y + "\n\n");

        int product = 0;
        while (y >= 1) {
            map.put(x, y);
            write("[" + x + " " + y + "]\n");
            if (y % 2 == 1) {
                product = x + product;
            }
            y = y / 2;
            x = x * 2;
        }

        debugMap(product);
        map.clear();
        end = System.currentTimeMillis();
        write("\nTotal time (ms): " + (end - start) + "\n\n");
        return product;
    }

    private static int r_ppm(int x, int y) {
        start = System.currentTimeMillis();
        write("Recursive Method: " + x + " * " + y + "\n\n");
        int product = h_ppm(x, y, 0);
        debugMap(product);

        end = System.currentTimeMillis();
        write("\nTotal time (ms): " + (end - start) + "\n\n");
        return product;
    }

    private static int h_ppm(int x, int y, int product) {
        map.put(x, y);
        write("[" + x + " " + y + "]\n");

        if (y == 1)
            return product + x;

        if (y % 2 == 1)
            product += x;

        return h_ppm(x * 2, y / 2, product);
    }
}

/*
 * ex: 3 x 2
 * Iterative Method:
 * two numbers being mutiplied + expected result
 * //
 * Write steps
 * 
 * x: [3 6]
 * y: [2 1]
 * 
 * sum = ....
 * time stamp
 * 
 * 
 * 
 * Recursive Method:
 * repeat above
 * addtion: compare timestamps, explain recurvise method base case helper
 */