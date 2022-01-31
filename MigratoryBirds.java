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

class MigratoryBirdsLogic {

    /*
     * Determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount,
     * return the smallest of their ids.
     *
     * INPUT FORMAT:
     * The first line contains an integer, n, the size of arr.
     * The second line describes arr as n space-separated integers, each a type number of the bird sighted.
     */

    public static int migratoryBirds(List<Integer> arr) {

        // create TreeMap object with reference birds
        Map<Integer, Integer> birds = new TreeMap<Integer, Integer>();

        //iterate each element of the list store them in the TreeMap
        for(int i=0; i<arr.size(); i++){
            int element = arr.get(i);

            if(birds.containsKey(element)){
                // if the element is already present in the list only updated its count
                birds.put(element, birds.get(element) +1);
            }

            else{
                birds.put(element, 1);
            }

        }
        int key = 0; // stores the count of key.
        int count = 0; // store the count of value count
        for(Map.Entry<Integer, Integer> i: birds.entrySet()){

            if(i.getValue()>count){
                count = i.getValue();
                key = i.getKey();
            }

        }
        // System.out.println(key);

        return key;
    }



}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = MigratoryBirdsLogic.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
