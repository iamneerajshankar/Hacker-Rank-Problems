<<<<<<< HEAD

=======
package HackerRank;
>>>>>>> origin/UsingJava

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

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    //List<Integer> record = new List<Integer>();
    
    int i =0;
    int least_score = scores.get(i);
    int max_score = scores.get(i);
    int low_count = 0;
    int high_count = 0;
    
   while(i<scores.size()){
        
        if(least_score>scores.get(i)){
            least_score = scores.get(i);
            low_count++;
        }
        
        if(max_score<scores.get(i)){
            max_score = scores.get(i);
            high_count++;
        }
        i++;
    }

    
        List<Integer> records = new ArrayList<Integer>();
        records.add(low_count);
        records.add(high_count);
    
    return records;
       
    }

}

public class BreakingTheRecord {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);


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
