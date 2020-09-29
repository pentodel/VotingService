import java.util.ArrayList;

public class MultipleChoice extends Question {
    private ArrayList<Integer> correctAnswers = new ArrayList<>();

    public MultipleChoice(String name, ArrayList<Answer> answers, ArrayList<Integer> correctAnswers) {
        super(name, answers);
        this.correctAnswers = correctAnswers;
    }

    public ArrayList<Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(ArrayList<Integer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void displayQuestion() {
        System.out.println("Multiple Choice: " + getName());
        ArrayList<Answer> answers = getAnswers();
        for (Answer answer : answers) {
            System.out.println(answer.getNumber() + ") " + answer.getName());
        }
    }

}
