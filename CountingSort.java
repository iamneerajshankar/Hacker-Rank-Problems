package HackerRank;

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

class CountingSortLogic {

    /*
     *Another sorting method, the counting sort, does not require comparison. 
     Instead, you create an integer array whose index range covers the entire range 
     of values in your array to sort. Each time a value occurs in the original array, 
     you increment the counter at that index. At the end, run through your counting array, 
     printing the value of each non-zero valued index that number of times.

     example:
      Input: arr = [1,1,2,3,1]
      Output: [0,3,1,1]

      All of the values are in the range (0....3), so create an array of zeros, result =[0,0,0,0]
      The frequency array is [0,3,1,1]. These values can be used to create the sorted array as well: 
      sorted=[1,1,2,3].

     INPUT FORMAT:
     The first line contains an integer n, the number of items in arr.
     Each of the next n lines contains an integer arr[i] where 0<=i<n .
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        //find the max element in the given ArrayList
        int max = Integer.MIN_VALUE; // please take max = 99 if using this code on hacker rank problem
        //System.out.println(max);
        int i;
        
        //find max element from given ArrayList
        for(i=0; i<arr.size(); i++){
            if(max<arr.get(i)){
                max = arr.get(i);
            }
        }
        //System.out.println(max);
        
        //Create a new Arraylist -countArray with size max+1 and initialize its elements with 0
        List<Integer> countArray = new ArrayList<Integer>();
        for(i=0;i<max+1; i++){ // change max+ with 100 if you are solving this on hacker rank
              countArray.add(0);  
            }
        
        //System.out.println(countArray);
        
        //Increment the corresponding index in countArray
        for(i=0;i<arr.size();i++){
            //countArray.get(arr.get(i)) = countArray.get(arr.get(i)) +1;
            countArray.set(arr.get(i), countArray.get(arr.get(i)) +1);
            
        }
        return countArray;
    }

}

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nshankar/PROGRAMMING/JAVA_PROGRAMMING/src"
                +"/HackerRank/HACKER_RANK.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = CountingSortLogic.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
