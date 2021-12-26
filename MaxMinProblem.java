import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ProgramLogic {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> myArr) {
           
            
            //first we will sort the arr using insertion sort without using sort method. 
            int key, j;
            long maxValue = 0;
            long minValue = 0;
            //loop for passes
            for(int i =1 ; i<=myArr.size()-1;i++){
                key = myArr.get(i);
                j= i-1;
                
                //loop for each of the pass - pass start from 1 to n 
                while(j>=0 && myArr.get(j)>key){
                    myArr.set(j+1, myArr.get(j));
                    j--;
                }
                myArr.set(j+1, key);
            }
            
            // find max and min value 
            
            for(int i = 0;i<myArr.size()-1;i++){
                minValue = minValue + myArr.get(i);
            }
            
            for(int i =1;i<myArr.size(); i++)
            {
                maxValue = maxValue + myArr.get(i);
            }
            
            System.out.println(myArr);
            System.out.println(minValue + " " +maxValue);
            
    }

}

public class MaxMinProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        ProgramLogic.miniMaxSum(arr);

        bufferedReader.close();
    }
}