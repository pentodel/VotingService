import java.util.ArrayList;

public class Quiz {
    private String name;
    private QuizOwner owner;
    private int numQuestions;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(String name, QuizOwner owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuizOwner getOwner() {
        return owner;
    }

    public void setOwner(QuizOwner owner) {
        this.owner = owner;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question newQuestion) {
        if(newQuestion.getAnswers().size() == 0) {
            System.out.println("Question needs to have answers before it can be added.");
        }
        numQuestions++;
        questions.add(newQuestion);
    }
}
