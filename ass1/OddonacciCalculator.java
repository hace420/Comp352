/* PSEUDO CODE
OddonacciExponential(int)
if int <= 3
    RETURN 1
else
    RETURN  OddonacciExponential(int-1)+
            OddonacciExponential(int-2)+
            OddonacciExponential(int-3)


*/


/* PSEUDO CODE
OddonacciLinear(int)
IF n = 1
    RETURN (1, 0, 0)
ELSE IF n = 2
    RETURN (1, 1, 0)
ELSE IF n = 3
    RETURN (1, 1, 1)

ELSE
    (i, j, k) = linearOddonacci(n - 1)
     RETURN (i + j + k, i, j)  
*/


import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;




public class OddonacciCalculator {
    public static void main(String[] args) {
        
        long output1;
        OddonacciResult output2;
        String file = "OddoOut.txt";
        Scanner in = new Scanner(System.in);
        

        System.out.print("enter index of oddonacci to calculate up to: ");
        int index = in.nextInt();

        long start1 = System.nanoTime(); // start of timer to calculate runtime exponential
        output1 = OddonacciExponential(index);
        long end1 = System.nanoTime(); // end of timer
        long elapsedTime1 = end1 - start1 ;

        long start2 = System.nanoTime();// start of timer to calculate runtime linear 
        output2 = OddonacciLinear(index);
        long end2 = System.nanoTime(); // end of timer
        long elapsedTime2 = end2 - start2 ;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
            bw.write("Exponential Calculator ouput of the "); // writting to txt file for exponential
            bw.write(String.valueOf(index));
            bw.write("th index is:  ");
            bw.write(String.valueOf(output1));
            bw.write(" with a runtime of: ");
            bw.write(String.valueOf(elapsedTime1));
            bw.write(" nanoseconds \n");

            bw.write("Linear Calculator output of the "); // writting to txt file for linear
            bw.write(String.valueOf(index));
            bw.write("th index is:  ");
            bw.write(String.valueOf(output2));
            bw.write(" with a runtime of: ");
            bw.write(String.valueOf(elapsedTime2));
            bw.write(" nanoseconds \n------------------------------------------------------------------------------------------------------------\n");
        } catch (Exception e) {
            System.out.println("Error writting to file!");
        }
        //System.out.println(OddonacciExponential(index));
        //System.out.println(OddonacciLinear(index));
        in.close();
        
        
    }

    public static  long OddonacciExponential(int a){ 
        if (a <= 3){ // base case
            return 1;
        }
        return OddonacciExponential(a-1)+OddonacciExponential(a-2)+OddonacciExponential(a-3);
        
    }
    

    public static OddonacciResult OddonacciLinear(int b){
        if (b ==1) {
            return new OddonacciResult(1, 0, 0); // base case
        }
        else if (b ==2 ){
            return new OddonacciResult(1, 1, 0); // base case
        }
        else if (b == 3){
            return new OddonacciResult(1, 1, 1); // base case
        }

        OddonacciResult result = OddonacciLinear(b-1);
        int f = result.first;
        int s = result.second;
        int t = result.third;

        return new OddonacciResult(f+s+t, f, s);
    }
}

