// This class will provide functionality needed to run a quiz.

public class VotingService {
    private boolean openToJoin = true;
    private boolean active = false;
    private QuizInstance instance;

    public VotingService(QuizInstance instance) {
        this.instance = instance;
    }

    public void addStudent(Student student) {
        if (openToJoin) {
            instance.addStudent(student);
        }
    }

    public void startQuiz() {
        active = true;
        System.out.println("Starting Quiz: " + instance.getQuizName());
        System.out.println("By: " + instance.getQuizOwner());
        instance.calculateQuizSize();
    }

    public void deliverQuestion() {
        instance.deliverQuestion();
    }

    public void finishQuestion(boolean singleChoice) {
        instance.finishQuestion(singleChoice);
    }

    public void moveToNextQuestion() {
        instance.moveToNextQuestion();
    }

    public void endQuiz() {
        active = false;
    }

    public void statistics() {
        instance.statistics();
    }

    public void noMoreJoins() {
        openToJoin = false;
    }
}
