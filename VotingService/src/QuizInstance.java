// This class is for creating single-use instances of quizzes meant for when a quiz is run.

import java.util.ArrayList;

public class QuizInstance {
    private Quiz quiz;
    private ArrayList<Student> students = new ArrayList<>();
    private int currentQuestion = 0;
    // If I had more time, I would find a way to not have to do this. This doesn't make sense in the context of the service.
    static int lastQuestion;

    public QuizInstance(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getQuizName() {
        return quiz.getName();
    }

    public String getQuizOwner() {
        return quiz.getOwner().getName();
    }

    public ArrayList<Question> getQuizQuestions() {
        return quiz.getQuestions();
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int numberOfStudents() {
        return students.size();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void calculateQuizSize() {
        lastQuestion = quiz.getNumQuestions();
    }

    public void deliverQuestion() {
        if (currentQuestion < lastQuestion) {
            getQuizQuestions().get(currentQuestion).displayQuestion();
        } else {
            System.out.println("You have reached the last question. Please end the quiz.");
            return;
        }

        for (Student student : students) {
            student.setScore(currentQuestion, 0);
            ArrayList<Answer> temp = new ArrayList<>();
            temp.add(new Answer("", -1));
            student.setCurrentGuess(temp);
        }
    }


    public void finishQuestion(boolean singleChoice) {
        Question question = quiz.getQuestions().get(currentQuestion);
        int[] stats = new int[question.getAnswers().size()];

        for (Student student : students) {
            for (Answer each : student.getCurrentGuess()) {
                int nEach = each.getNumber();
                if (nEach != -1) stats[nEach]++;
            }
        }

        String bar = "|";
        if (singleChoice) {
            SingleChoice temp = (SingleChoice) question;
            for (int i = 0; i < temp.getAnswers().size(); i++) {
                if (i == temp.getCorrectAnswer()) {
                    System.out.println("Right: " + temp.getAnswers().get(i).getName());
                    System.out.println(bar.repeat(stats[i]));
                } else {
                    System.out.println("Wrong: " + temp.getAnswers().get(i).getName());
                    System.out.println(bar.repeat(stats[i]));
                }
            }
        } else {
            MultipleChoice temp = (MultipleChoice) question;
            for (int i = 0; i < temp.getAnswers().size(); i++) {
                if (temp.getCorrectAnswers().contains(i)) {
                    System.out.println("Right: " + temp.getAnswers().get(i).getName());
                    System.out.println(bar.repeat(stats[i]));
                } else {
                    System.out.println("Wrong: " + temp.getAnswers().get(i).getName());
                    System.out.println(bar.repeat(stats[i]));
                }
            }
        }
    }

    public void moveToNextQuestion() {
        currentQuestion++;
    }

    public void statistics() {
        System.out.println("Statistics:");
        for (Student student : students) {
            double count = 0, sum = 0;
            for (double score : student.getScore()) {
                if (score != -1.0) count += score;
                sum++;
            }
            double average = (count * 1.0) / sum;
            System.out.println(student.getName() + ": " + String.format("%.2f", average));
        }
    }
}
