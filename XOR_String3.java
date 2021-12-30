package HackerRank;
/*
* Given two strings consisting of digits 0 and 1 only, find the XOR of the two strings.
* Input Format:
* The input consists of two lines. The first line of the input contains the first string, s1,
* and the second line contains the second string, s2.
 * */

import java.util.*;

class XOR_StringLogic{
    public String logic(String s1, String s2){
        String result = "";
        for(int i=0; i<s1.length(); i++){

            if(s1.charAt(i) == s2.charAt(i)){
                result += '0';
            }
            else{
                result += '1';
            }
        }

        return result;
    }
}

public class XOR_String3{
    public static void main(String[] args){

        System.out.println("Please enter the string 1");
        Scanner userIn = new Scanner(System.in);

        String s1 = userIn.nextLine();
        System.out.println("Please enter the string 2");
        String s2 = userIn.nextLine();

        XOR_StringLogic obj = new XOR_StringLogic();
        System.out.print(obj.logic(s1, s2));

    }
}
