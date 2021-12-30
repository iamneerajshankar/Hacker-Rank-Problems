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

class Permute2ArraysLogic {

    /*
     *There are two n-element arrays of integers,A and B  and . Permute them into some A' and B' and
     *such that the relation A'[i]+B'[i]>=k  holds for all i where 0<=i<n.
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        int i = 0, j= 0;
        int matchCount = 0;
        int size = A.size();
        // sorting the arrays
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        while(i<A.size() && j<B.size()) {

            int sum = A.get(i) + B.get(j);
            if(sum>=k) {
                matchCount = matchCount + 1;
            }
            i++;
            j++;
        }

        if(matchCount == size){
            return "YES";
        }

        return "NO";
    }

}

public class Permute2Arrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Permute2ArraysLogic.twoArrays(k, A, B);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
