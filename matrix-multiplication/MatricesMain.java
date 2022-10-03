import java.util.Scanner;

public class MatricesMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
 
        //Single Instantiation 
        MultiplyMatrices mm = new MultiplyMatrices(in,"output.txt");
        if(mm.isInUse()){
            System.out.println("mm" + mm.isInUse());
            while(mm.isInUse()){
                mm.defineDimensions();
                mm.multiplyMatrices();
            }
        }

        in.close();

        //Iterative Instatiation (maybe multiple output files?)
        /*MultiplyMatrices[] arrMultiMatrices = new MultiplyMatrices[n];
        int i = 0;
        for(MultiplyMatrices e : arrMultiMatrices){
            System.out.println(i);
            e = new MultiplyMatrices(in);
            while(e.isInUse()){
                e.defineDimensions();
                e.multiplyMatrices();
            }
            i++;
        }*/
    }
}