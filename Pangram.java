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

class PangramLogic {

    /*
     * A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet.
     * Ignore case. Return either pangram or not pangram as appropriate.

     * INPUT FORMAT:
     *A single line with string s.
     */

    public static String pangrams(String s) {

        // create an array for size 26 where each alphabet represent one charcter from ASCII table
        int[] arr = new int[26];

        //Initialize array elements with 0
        for(int i =0;i<26;i++){
            arr[i] = 0;
        }


        // we will traverse each char c of string s
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c>=97 && c<= 122){ // range small letter in ascii table
                arr[c-97] = 1;
            }

            else if(c>=65 && c<=90){ // range capital letter in ascii table
                arr[c-65] = 1;
            }
        }

        for(int i=0; i<26; i++){
            if(arr[i]==0){
                return "not pangram";
            }
        }

        return "pangram";

    }

}

public class Pangram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hacker_rank.txt"));

        String s = bufferedReader.readLine();

        String result = PangramLogic.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

