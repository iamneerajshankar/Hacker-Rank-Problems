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

/*
HackerLand University has the following grading policy:

Every student receives a  in the inclusive range from 0 to 100.
Any  less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's grades according to these rules:
    If the difference between the grade and the next multiple of 5 is less than 3, round  up to the next multiple of 5.
    If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.

Example:
grade = 84, round to 85 (85-84 is less than 85)
grade = 20, do not round less than 40
grade = 57, do not round (60-57 is equal to 3)
* INPUT FORMAT
* The first line contains a single integer, n, the number of students.
  Each line i of the n subsequent lines contains a single integer, grades[i].
* */

class LogicGradingStudents {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> finalGrades = new ArrayList<Integer>();
        for(int i=0; i<grades.size(); i++){
            int grade = grades.get(i);
            int rem = grade%5;
            int roundedToMultipleFive = (grade+(5-rem));
            if(grade<38){
                finalGrades.add(grade);
            }

            else if((roundedToMultipleFive-grade)>=3){
                finalGrades.add(grade);
            }
            else if(rem==0){
               finalGrades.add(grade);
            }
            else {
                finalGrades.add(roundedToMultipleFive);
            }
        }
        return finalGrades;
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nshankar/PROGRAMMING/JAVA_PROGRAMMING/src"
                +"/HackerRank/HACKER_RANK.txt"));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = LogicGradingStudents.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
