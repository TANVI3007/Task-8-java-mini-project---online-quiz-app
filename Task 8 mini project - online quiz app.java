import java.util.ArrayList;
import java.util.Scanner;
class Question {
    String questionText;
    String[] options;
    int correctOption; 
    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption + 1;
    }
}
public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Chennai", "Kolkata"},
                0));
        questions.add(new Question(
                "Which data type is used to store true/false in Java?",
                new String[]{"int", "boolean", "String", "double"},
                1));
        questions.add(new Question(
                "What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Very Much", "Just Very Modern", "None of these"},
                0));
        questions.add(new Question(
                "Which keyword is used to create a class in Java?",
                new String[]{"method", "object", "class", "interface"},
                2));
        questions.add(new Question(
                "Which symbol is used for comments in Java?",
                new String[]{"//", "**", "#", "%%"},
                0));
        int score = 0;
        System.out.println("===== Welcome to the Java Quiz! =====");
        for (Question q : questions) {
            q.display();
            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();
            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong. Correct answer: " + (q.correctOption + 1) + ". " + q.options[q.correctOption]);
            }
        }
        System.out.println("\n🎉 Quiz Over! Your score: " + score + "/" + questions.size());
        sc.close();
    }
}