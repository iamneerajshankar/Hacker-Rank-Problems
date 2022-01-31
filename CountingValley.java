package HackerRank;

import java.io.*;

import static java.util.stream.Collectors.joining;

class CountingValleyLogic {

    /*
     *We define the following terms:
     *  1. A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level
          and ending with a step down to sea level.
     *  2. A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level
          and ending with a step up to sea level.

        3. Given the sequence of up and down steps during a hike, find and print the number of
           valleys walked through.

         * INPUT FORMAT:
            The first line contains an integer steps, the number of steps in the hike.
            The second line contains a single string path, of steps characters that describe the path.

          Example:
           Input: 8
                  UDDDUDUU

           Output: 1

      */

    public static int countingValleys(int steps, String path) {
        // initialize the tracker and valley count with zeros
        int tracker = 0;
        int valley = 0;

        //Traverse the path with steps given and adjust the count of tracker
        for (int i = 0; i < path.length(); i++) {

            // Print current character
            if(path.charAt(i) == ('D')){
                tracker--;
            }
            else if(path.charAt(i) == ('U'))
            {
                tracker++;
            }
            if(tracker ==-1 && path.charAt(i) == ('D') ){
                valley++;
            }
        }


        return valley;
    }

}

public class CountingValley {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nshankar/" +
                "PROGRAMMING/JAVA_PROGRAMMING/src/HackerRank/HACKER_RANK.txt"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleyLogic.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

