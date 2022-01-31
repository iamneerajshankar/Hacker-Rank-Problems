

import java.io.*;
import java.util.stream.*;

class LogicFlippingBits {

    /*
     * You will be given a list of 32-bit unsigned integers. Flip all the bits (0->1 and 1->0 )
     * and return the result as an unsigned integer.

     *INPUT FORMAT
        *The first line of the input contains q, the number of queries.
        *Each of the next q lines contain an integer,n, to process.
     */

    public static long flippingBits(long n) {
        // Write your code here
        long max = Integer.MAX_VALUE;
        max = max* 2 + 1;
        long unsignedFlippedBits = ~n & max;

        return unsignedFlippedBits;
    }

}

public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nshankar/" +
                "PROGRAMMING/JAVA_PROGRAMMING/src/HackerRank/HACKER_RANK.txt"));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = LogicFlippingBits.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

