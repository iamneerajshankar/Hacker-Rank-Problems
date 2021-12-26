package HackerRank;

import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int n = userInput.nextInt();
        int[] grade = new int[n];

        for(int i = 0;i<n;i++){
            grade[i] = userInput.nextInt();
        }

        for(int i = 0;i<n;i++){
            int round_grade = (grade[i]+(5-(grade[i]%5))) - grade[i];
            if(grade[i] < 38){
                System.out.println(grade[i]);

            }

            else if((grade[i] % 5) == 0){
                System.out.println(grade[i]);
            }

            else if(round_grade<3){
                System.out.println(round_grade);
            }

            else {
                System.out.println(grade[i]);
            }
        }

    }
}
