import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of questions
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("1. What are Java loops?",
                new String[]{"a) Repeating structures", "b) Variables", "c) Classes", "d) None"},
                1));
        questions.add(new Question("2. What is enhanced for-loop?",
                new String[]{"a) While loop", "b) For-each loop", "c) Infinite loop", "d) Do-while"},
                2));
        questions.add(new Question("3. What is ArrayList?",
                new String[]{"a) Fixed array", "b) Dynamic array", "c) Map", "d) Class"},
                2));
        questions.add(new Question("4. Which keyword is used to inherit a class in Java?",
                new String[]{"a) super", "b) extends", "c) implements", "d) import"},
                2));
        questions.add(new Question("5. Which of these is not OOPs concept in Java?",
                new String[]{"a) Inheritance", "b) Encapsulation", "c) Polymorphism", "d) Compilation"},
                4));

        int score = 0;

        System.out.println("\n--- Welcome to Online Quiz App ---");
        System.out.println("Answer the following questions by selecting 1-4:\n");

        for (Question q : questions) {
            System.out.println(q.getQuestionText());
            String[] options = q.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Your answer (1-4): ");
            int answer;
            try {
                answer = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Skipping question.");
                sc.next(); 
                continue;
            }

            if (answer == q.getCorrectAnswer()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is: " + q.getCorrectAnswer() + "\n");
            }
        }

        // Show result
        System.out.println("\n Quiz Over!");
        System.out.println("You scored " + score + " out of " + questions.size());
        double percentage = (score * 100.0) / questions.size();
        System.out.printf("Your Percentage: %.2f%%\n", percentage);

        if (percentage >= 60) {
            System.out.println(" Congratulations! You passed the quiz.");
        } else {
            System.out.println(" Better luck next time!");
        }

        sc.close();
    }
}
