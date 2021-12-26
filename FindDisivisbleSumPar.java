package HackerRank;

import java.util.Scanner;

public class FindDisivisbleSumPar {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int n = userInput.nextInt();
        int k = userInput.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for(int i =0;i<n;i++){
            arr[i] = userInput.nextInt();
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((arr[i]+arr[j]) % k ==0){
                    count++;
                }
            }
        }

        System.out.print(count);

    }
}
