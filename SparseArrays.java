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

class LogicSparseArrays {

    /*
     * There is a collection of input strings and a collection of query strings. For each query string,
     * determine how many times it occurs in the list of input strings. Return an array of the results.
     * Example:
     * strings = ['ab', 'ab', 'abc']
     * queries = ['abc', 'abc', 'bc']
     * output: [2,1,0]
     *
     * INPUT FORMAT
     *  The first line contains and integer n, the size of strings[] .
        Each of the next n lines contains a string strings[i].
        The next line contains q, the size of queries[].
        Each of the next q lines contains a string queries[i].
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    // Write your code here
     List<Integer> myCount = new ArrayList<Integer>();
       
         for(int i=0; i<queries.size(); i++){
              int count = 0;
             for(int j=0;j<strings.size(); j++){
                 if(queries.get(i).equals(strings.get(j))){
                     count++;
                 }
             }
             myCount.add(count);
         }
         
       
        
        return myCount;
    }

}

public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = LogicSparseArrays.matchingStrings(strings, queries);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
