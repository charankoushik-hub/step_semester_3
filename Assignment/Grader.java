import java.util.Scanner;

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {

    MCQ(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer))
            return points;
        return 0;
    }
}

class TF extends Question {

    TF(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer))
            return points;
        return 0;
    }
}

class Essay extends Question {

    Essay(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class Grader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            // Extract quoted strings and the final points
            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String remaining = parts[6].trim();
            double points = Double.parseDouble(remaining);

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(correctAnswer, studentAnswer, points);
            } 
            else if (type.equals("TF")) {
                question = new TF(correctAnswer, studentAnswer, points);
            } 
            else {
                question = new Essay(correctAnswer, studentAnswer, points);
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
