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

class SubArrayDivision2Logic {

    /*
     * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
     * Lily decides to share a contiguous segment of the bar selected such that:
     * 1. The length of the segment matches Ron's birth month, and,
     * 2.The sum of the integers on the squares is equal to his birthday.
     * Determine how many ways she can divide the chocolate.
     *
     * example:
     * s =[2,2,1,3,2]
     * d=4
     * m=2
     * In this case, there are two segments meeting her criteria: [2,2] and [3,1]
     *
     * INPUT FORMAT:
     * The first line contains an integer n, the number of squares in the chocolate bar.
     * The second line contains n space-separated integers s[i], the numbers on the chocolate squares
     * where 0<=i<n
     * The third line contains two space-separated integers, d and m, Ron's birthday and his birth month.
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int counter =0;
        int sum = 0;
        int valid = 0;

        for(int i=0; i<s.size(); i++){
            counter++;
            sum += s.get(i);
            if(counter == m){
                if(sum == d) valid++;
                counter--;
                sum -= s.get((i-m+1));
            }
        }


        return valid;
    }

}

public class SubArrayDivision2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = SubArrayDivision2Logic.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
