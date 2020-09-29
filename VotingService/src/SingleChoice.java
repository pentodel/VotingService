import java.util.ArrayList;

public class SingleChoice extends Question {
    private int correctAnswer;

    public SingleChoice(String name, ArrayList<Answer> answers, int correctAnswer) {
        super(name, answers);
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println("Single Choice: " + getName());
        ArrayList<Answer> answers = getAnswers();
        for (Answer answer : answers) {
            System.out.println(answer.getNumber() + ") " + answer.getName());
        }
    }
}
