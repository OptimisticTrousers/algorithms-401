package print_log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrintLog {
    
    private File f;

    public PrintLog(String fileNamePath){ 
        f = new File(fileNamePath + "_output.txt");
        clear(); //ensures a fresh output file each time PrintLog is instantiated
    }
    
    // If file already exists, clear contents of .txt file
    public void clear() {
        if (f.exists()) { 
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //writes to the output file whilst printing that same string to the console
    public void write(String s) {
        if(s != null){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
                System.out.print(s);
                bw.write(s);
                
            } catch (IOException e) {
                e.printStackTrace();
            }       
        }
    }

    //writes whole line to output file and console
    public void writeln(String s) {
        if(s != null){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
                System.out.println(s);
                bw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
    }
}
