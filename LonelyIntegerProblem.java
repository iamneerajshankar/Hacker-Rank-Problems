package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class LogicLonelyInteger {

    /*
     * Complete the 'lonelyInteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    // using naive method -time complexity O(n^2)
    public static int lonelyInteger(List<Integer> a) {
        for(int i =0; i<a.size(); i++)
        {
            boolean isDuplicate = false;
            for(int j=0; j<a.size(); j++){
                if(a.get(i)==a.get(j) && i!=j){
                    isDuplicate = true;
                }
            }
            if(!isDuplicate){
                return a.get(i);
            }
        }
        return -1;
    }

    //using the hashmap - Time Complexity 2n ~ n
    public static int usingHashmap(List<Integer> a){
        HashMap<Integer, Integer> num_count = new HashMap<Integer, Integer>();
        for(int i=0; i<a.size(); i++){
            int num = a.get(i);
            if(num_count.containsKey(num)){
                num_count.put(num, num_count.get(num)+1);
            }
            else {
                num_count.put(num, 1);
            }
        }

        for(int i=0; i<a.size(); i++){
            int num = a.get(i);
            if(num_count.get(num)==1){
                return a.get(i);
            }
        }
        return -1;
    }


}

public class LonelyIntegerProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nshankar/PROGRAMMING/JAVA_PROGRAMMING/src"
                +"/HackerRank/HACKER_RANK.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = LogicLonelyInteger.usingHashmap(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

