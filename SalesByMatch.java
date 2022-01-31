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

class SalesByMatchLogic {

    /*
     *Given an array of integers representing the color of each sock, determine how many pairs
     * of socks with matching colors there are.
     * INPUT FORMAT:
     * The first line contains an integer n, the number of socks represented in ar.
     * The second line contains n space-separated integers, ar[i], the colors of the socks in the pile.
     * Example: n =7
     *          ar = [1,2,1,2,1,3,2]
     *          Output = 2
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int pairs = 0;

        for(int i=0; i<ar.size(); i++){

            int val = ar.get(i);

            if(counter.containsKey(val)){
                counter.put(val, counter.get(val)+ 1);
            }
            else{
                counter.put(val, 1);
            }

            if(counter.get(val) % 2 == 0){
                pairs++;
            }
        }
        // System.out.println(counter);
        //  System.out.println(pairs);
        return pairs;
    }

}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SalesByMatchLogic.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

