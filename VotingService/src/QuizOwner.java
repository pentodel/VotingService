// This class is for someone who makes a quiz. For ease of understanding, the voting service runs the quiz instead

import java.util.ArrayList;

public class QuizOwner {
    private String name;
    private ArrayList<Quiz> quizzes = new ArrayList<>();

    public QuizOwner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public Quiz createQuiz(String quizName) {
        Quiz newQuiz = new Quiz(quizName, this);
        quizzes.add(newQuiz);

        return newQuiz;
    }

    public void createQuestion(Quiz quiz, String questionName, String[] answers, int correct) {
        ArrayList<Answer> answersConverted = new ArrayList<>();
        for (int i = 1; i <= answers.length; i++) {
            answersConverted.add(new Answer(answers[i - 1], i));
        }

        SingleChoice question = new SingleChoice(questionName, answersConverted, correct);
        quiz.addQuestion(question);
        question.setNumber(quiz.getQuestions().size());
    }

    public void createQuestion(Quiz quiz, String questionName, String[] answers, int[] correct) {
        ArrayList<Integer> correctConverted = new ArrayList<>();
        for (int i = 0; i < correct.length; i++) {
            correctConverted.add(correct[i]);
        }

        // Convert array of answers into an ArrayList of Answers
        ArrayList<Answer> answersConverted = new ArrayList<>();
        for (int i = 0; i < answers.length; i++) {
            answersConverted.add(new Answer(answers[i], i + 1));
        }

        MultipleChoice question = new MultipleChoice(questionName, answersConverted, correctConverted);
        quiz.addQuestion(question);
        question.setNumber(quiz.getQuestions().size());
    }

    public void deleteQuestion(int questionNumber) {
        quizzes.remove(questionNumber);

    }

    public void startQuiz(VotingService service) {
        service.startQuiz();
    }
}
