import java.util.ArrayList;

abstract class Question {
    private String name;
    private int number;
    private ArrayList<Answer> answers;

    public Question(String name, ArrayList<Answer> answers) {
        this.name = name;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    abstract void displayQuestion();
}
