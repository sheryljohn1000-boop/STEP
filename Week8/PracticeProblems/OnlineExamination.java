class Question {
    String question;
    String answer;
    int marks;

    Question(String question, String answer, int marks) {
        this.question = question;
        this.answer = answer;
        this.marks = marks;
    }

    boolean checkAnswer(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Question q1 = new Question("Java is OOP?", "Yes", 5);
        Question q2 = new Question("2 + 2?", "4", 5);

        String[] answers = {"Yes", "3"};
        Question[] questions = {q1, q2};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            if (questions[i].checkAnswer(answers[i])) {
                score += questions[i].marks;
                System.out.println("Correct answer");
            } else {
                System.out.println("Wrong answer");
            }
        }

        System.out.println("Total score: " + score);
    }
}