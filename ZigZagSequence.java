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

class ZigZagSequenceLogic {

    /*
     * Determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount,
     * return the smallest of their ids.
     *
     * INPUT FORMAT:
     * The first line contains an integer, n, the size of arr.
     * The second line describes arr as n space-separated integers, each a type number of the bird sighted.
     */

    public static List<Integer> zigZagSequence(List<Integer> arr) {

//first we will sort the arr using insertion sort without using sort method.
        int key, j;
        int mid = (arr.size() + 1)/2;

        //loop for passes
        for(int i =1 ; i<=mid-1;i++){
            key = arr.get(i);
            j= i-1;

            //loop for each of the pass - pass start from 1 to n
            while(j>=0 && arr.get(j)>key){
                arr.set(j+1, arr.get(j));
                j--;
            }
            arr.set(j+1, key);
        }

        //loop for passes
        int key2;
        for(int i = mid+1; i<=arr.size()-1; i++){
            key2 = arr.get(i);
            j= i-1;

            //loop for each of the pass - pass start from 1 to n
            while(j>=0 && key2>arr.get(j)){
                arr.set(j+1, arr.get(j));
                j--;
            }
            arr.set(j+1, key2);
        }

        return arr;
    }



}

public class ZigZagSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ZigZagSequenceLogic.zigZagSequence(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

