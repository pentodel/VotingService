// This class will run everything as users theoretically might.

import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {

    public static void main(String[] args) {
        // Quiz must first be made.
        QuizOwner owner = new QuizOwner("Professor");
        Quiz newQuiz = owner.createQuiz("Unit Test");
        owner.createQuestion(newQuiz, "Do elephants have legs?",
                             new String[]{"True", "False"} , 0);
        owner.createQuestion(newQuiz, "What numbers are smaller than 3?",
                             new String[]{"1", "2", "3", "4", "5"} , new int[]{0,1});
        owner.createQuestion(newQuiz, "What is the capital of Montenegro?",
                new String[]{"Skopje", "Ljubljana", "Bern", "Podgorica", "Monaco"} , 3);

        // Run the quiz
        QuizInstance instance = new QuizInstance(newQuiz);
        VotingService event = new VotingService(instance);

        System.out.println("------------------------------------------------------");
        System.out.println();

        // You MUST start the quiz before adding students
        owner.startQuiz(event);

        Student s1 = new Student("Salamander");
        Student s2 = new Student("Jackal");
        Student s3 = new Student("Pothos");
        Student s4 = new Student("Goldfish");
        Student s5 = new Student("Skate");
        event.addStudent(s1);
        event.addStudent(s2);
        event.addStudent(s3);
        event.addStudent(s4);
        event.addStudent(s5);

        event.noMoreJoins();

        System.out.println();
        System.out.println("------------------------------------------------------");
        event.deliverQuestion();
        System.out.println();
        Random rand = new Random();
        s1.guessSingle(instance, rand.nextInt(2));
        s2.guessSingle(instance, rand.nextInt(2));
        s3.guessSingle(instance, rand.nextInt(2));
        s4.guessSingle(instance, rand.nextInt(2));
        s5.guessSingle(instance, rand.nextInt(2));
        System.out.println();
        event.finishQuestion(true);

        event.moveToNextQuestion();

        System.out.println();
        System.out.println("------------------------------------------------------");
        event.deliverQuestion();
        System.out.println();
        s2.guessMultiple(instance, new int[]{3, 4});
        s1.guessMultiple(instance, new int[]{1, 0});
        s2.guessMultiple(instance, new int[]{4, 1});
        s3.guessMultiple(instance, new int[]{3});
        s4.guessMultiple(instance, new int[]{1, 2, 3});
        s2.guessMultiple(instance, new int[]{2, 1});
        s2.guessMultiple(instance, new int[]{1, 3});
        s2.guessMultiple(instance, new int[]{0, 1});
        System.out.println();
        event.finishQuestion(false);

        event.moveToNextQuestion();
        System.out.println();
        System.out.println("------------------------------------------------------");
        event.deliverQuestion();
        System.out.println();
        s1.guessSingle(instance, rand.nextInt(5));
        s2.guessSingle(instance, rand.nextInt(5));
        s3.guessSingle(instance, rand.nextInt(5));
        s4.guessSingle(instance, rand.nextInt(5));
        s5.guessSingle(instance, rand.nextInt(5));
        System.out.println();
        event.finishQuestion(true);


        System.out.println();
        System.out.println("------------------------------------------------------");

        event.endQuiz();
        event.statistics();
    }
}
