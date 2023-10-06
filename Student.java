import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a student with an ID and their answer(s) to questions.
 */
public class Student {
    private String studentID;
    private String answer;
    private String[] mAnswer;

    /**
     * Constructor to initialize a student with a specific ID.
     * @param studentID The unique identifier for the student.
     */
    public Student(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Chooses a random single answer from the available choices.
     * @param choices Array of possible answer choices.
     */
    public void chooseRA(String[] choices) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(choices.length);
        this.setAnswer(choices[randomIndex]);
    }

    /**
     * Chooses random multiple answers from the available choices.
     * @param choices Array of possible answer choices.
     */
    public void chooseRMA(String[] choices) {
        Random rand = new Random();
        int numOfAnswers = 1 + rand.nextInt(choices.length); // gets at least one answer
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < numOfAnswers; i++) {
            int randomIndex = rand.nextInt(choices.length);
            if (!answers.contains(choices[randomIndex])) { // checks for duplicate choices
                answers.add(choices[randomIndex]);
            } else {
                i--; // reiterate to get a non-duplicate answer
            }
        }

        this.setmAnswer(answers.toArray(new String[0]));
    }

    /**
     * Gets the student's  ID.
     * @return The student's ID.
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Sets the student's single answer.
     * @param answer The student's chosen answer.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Sets the student's multiple answers.
     * @param mAnswer The student's chosen multiple answers.
     */
    public void setmAnswer(String[] mAnswer) {
        this.mAnswer = mAnswer;
    }

    /**
     * Gets the student's single answer.
     * @return The student's answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Gets the student's multiple answers. 
     * @return Array containing the student's multiple answers.
     */
    public String[] getmAnswer() {
        return mAnswer;
    }

}
