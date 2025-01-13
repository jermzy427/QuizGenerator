import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class quizGen {
    private ArrayList<String> qsAndAs;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<String> quizQs;
    private ArrayList<String> quizAs;

    public static void main(String[] args) throws FileNotFoundException {
        new quizGen();
    }

    public quizGen() throws FileNotFoundException {
        this.questions = new ArrayList<String>();
        this.answers = new ArrayList<String>();
        this.quizQs = new ArrayList<String>();
        this.quizAs = new ArrayList<String>();
        this.qsAndAs = new ArrayList<String>();

        readQuestion();

    }


    public void readQuestion() throws FileNotFoundException {
        String file = "/Users/jeremy/IdeaProjects/QuizGenerator/src/question bank and answers.csv";
        File f = new File(file);
        Scanner sc = new Scanner(f);
        sc.useDelimiter(",");
        while (sc.hasNext())  //returns a boolean value
        {
            qsAndAs.add(sc.nextLine()); //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
        ArrayList<String> tempqsandas = new ArrayList<String>();
        int commaindex = 0;
        int comma2index = 0;
        int questionindex = 0;
        for (int i = 0; i < qsAndAs.size(); i++) {
            for (int j = 0; j < qsAndAs.get(i).length(); j++) {
                if (qsAndAs.get(i).charAt(j) == ',') {
                    commaindex = j;
                }


                if (qsAndAs.get(i).charAt(j) == '?') {
                    questionindex = j;
                    tempqsandas.add(qsAndAs.get(i).substring(commaindex + 1, questionindex + 1));
                }
                if (qsAndAs.get(i).charAt(j) == ',' && (questionindex == j - 1 || questionindex == j - 2)) {
                    comma2index = j;
                    tempqsandas.add(qsAndAs.get(i).substring(comma2index + 1, qsAndAs.get(i).length()));

                }

            }
        }
        for (int k = 0; k < tempqsandas.size(); k += 2) {
            questions.add((String) tempqsandas.toArray()[k]);
        }
        for (int l = 1; l < tempqsandas.size(); l += 2) {
            answers.add((String) tempqsandas.toArray()[l]);
        }


    }
}