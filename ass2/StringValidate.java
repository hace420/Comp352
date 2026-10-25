import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;




public class StringValidate {
    public static void main(String[] args) {

        StringBuilder validate = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("codes.txt"))){
            String code;
            while ((code = br.readLine()) != null){
                validate.append(code);
            }
        } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
        }

        String[] parts = validate.toString().split("(?<=\\$)");
        for (int i = 0 ; i < parts.length;i++){
            System.out.println(parts[i]+"/");
        }

        

        for (int i = 0 ; i < parts.length;i++){
           String temp = parts[i];
           System.out.println("String "+temp + " ---- " + validateString(temp));
                
        }      
    }



    public static String validateString(String temp){

        customStack mainStack = new customStack();
        customStack wildcardStack = new customStack();


        int[] indexOfParanthesis = new int[temp.length()];
        int[] indexOfStar = new int[temp.length()];
        int pcount= 0;
        int scount= 0;

        for (int j = 0 ; j < temp.length(); j++){
                    
                    if (temp.charAt(j) == '(' ){
                        mainStack.push(temp.charAt(j));
                        indexOfParanthesis[pcount] = j;
                        pcount++;
                        
                        
                    } else if  (temp.charAt(j) == '*' ){
                        wildcardStack.push(temp.charAt(j)); 
                        indexOfStar[scount] = j; 
                        scount ++;



                    } else if (temp.charAt(j) == ')' ){
                         if (mainStack.isEmpty() && wildcardStack.isEmpty()) {
                            return "Invalid";
                        }
                        if (!(mainStack.isEmpty())){
                            char compare = mainStack.pop();
                            pcount--;
                            if (compare == '('){
                                
                            }
                        } else if (!(wildcardStack.isEmpty())){
                            wildcardStack.pop();
                            scount--;
                            
                        } else {
                            return "Invalid";
                        }

                    }


           
            
           }

           while (pcount > 0 && scount > 0) {
                if (indexOfStar[scount - 1] > indexOfParanthesis[pcount - 1]) {
                    wildcardStack.pop();
                    mainStack.pop();
                    scount--;
                    pcount--;
                } else {
                    return "Invalid";
                }
            }

           if (!(mainStack.isEmpty())){
            return "Invalid";
           }
           return "Valid";
    }
}
