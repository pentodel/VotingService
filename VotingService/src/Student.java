import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Answer> currentGuess = new ArrayList<>();
    private double[] score = new double[QuizInstance.lastQuestion];

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public void setScore(int question, double score) {
        this.score[question] = score;
    }

    public ArrayList<Answer> getCurrentGuess() {
        return currentGuess;
    }

    public void setCurrentGuess(ArrayList<Answer> currentGuess) {
        this.currentGuess = currentGuess;
    }

    public void guessSingle(QuizInstance q, int answer) {
        currentGuess.clear();
        System.out.println(name + " guessed " + (answer + 1));
        SingleChoice currentQuestion = (SingleChoice) q.getQuizQuestions().get(q.getCurrentQuestion());
        int questionCount = q.getCurrentQuestion();
        score[questionCount] = 0.0;

        if (answer > currentQuestion.getAnswers().size()) {
            System.out.println(name + ": Answer not available.");
        } else {
            currentGuess.add(new Answer("", answer));
            if (answer == currentQuestion.getCorrectAnswer()) score[questionCount] = 1.0;
        }
    }

    public void guessMultiple(QuizInstance q, int[] answers) {
        currentGuess.clear();
        System.out.print(name + " guessed ");
        for (int each : answers) {
            System.out.print((each + 1) + " ");
        }
        System.out.println();
        MultipleChoice currentQuestion = (MultipleChoice) q.getQuizQuestions().get(q.getCurrentQuestion());
        int questionCount = q.getCurrentQuestion();

        // Check validity of guesses
        for (int answer : answers) {
            if (answer > currentQuestion.getAnswers().size()) {
                System.out.println(name + ": Answer " + answer + "not available.");
                score[questionCount] = 0.0;
                currentGuess.clear();
                return;
            }
            if (currentQuestion.getCorrectAnswers().contains(answer)) {
                score[questionCount] = 1.0 / (currentQuestion.getCorrectAnswers().size() - 1);
            }
            currentGuess.add(new Answer("", answer));
        }
    }
}
