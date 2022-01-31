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

class MarsExplorationLogic {

    /*
     * A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
     * Letters in some SOS messages are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string, s, determine how many letters of the SOS message
     * have been changed by radiation.

     * INPUT FORMAT:
     * There is one line of input: a single string, s.

     * Example - Input: SOSTOT, Output = 2 // two letters altered
     */

    public static int marsExploration(String s) {
        // Write your code here
        int errorCount = 0;
        // we take three variable of each letter of correct sequence SOS
        int first = 0;
        int second = 1;
        int third = 2;

        //To make sure index does not out of bounce. keep third variable index <s.length().
        while(third<s.length()){

            if( (s.charAt(first)) != 'S'){
                errorCount++;
            }
            if(s.charAt(second) != 'O'){
                errorCount++;
            }

            if(s.charAt(third) != 'S'){
                errorCount++;
            }

            // increment count of three variable first, second and third by 3 so that sequence of SOS is maintained
            first= first + 3;
            second = second + 3;
            third = third + 3;
        }
        return errorCount;
    }

}

public class MarsExploration {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        String s = bufferedReader.readLine();

        int result = MarsExplorationLogic.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

