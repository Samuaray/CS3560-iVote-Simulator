
import java.util.HashMap;
/**
 * Represents a voting service that handles the creation of questions,
 * submission of answers, and display of results.
 */
public class VotingService {
    protected Question question;
    protected int right;
    protected int wrong;
    protected HashMap<String, String> studentAnswers = new HashMap<>(); // Maps Student ID to Answers
   
    /**
     * Displays the number of right and wrong answers.
     */
    public void displayResults() {
        System.out.println("Right: " + right);
        System.out.println("Wrong: " + wrong);
        System.out.println("--------------------------");
    }

    /**
     * Displays the current question and its choices.
     */
    public void displayQuestion(){
        System.out.println("Question: " + question.getText());
        System.out.println("Choices: " + String.join(", ", question.getChoices()));
    }

    /**
     * Creates a new question.
     * @param text The question text.
     * @param type The type of the question.
     * @param choices The available choices for the question.
     */
    public void createQuestion(String text, String type, String [] choices) {
        // Reset counts for the new question
        right = 0;
        wrong = 0;
        studentAnswers.clear();

        if ("Single".equals(type)) {
            question = new Question(text, choices);
        } else {
            question = new MCQuestion(text, choices);
        }
    }

    /**
     * Submits a student's answer and updates the counts of right and wrong answers.
     * Checks if the student has already submitted an answer.
     * If they did their latest answer overwrites the old one
     * And the wrong/right count is updated depending on that new answer
     * @param student The student submitting the answer.
     */
    public void submitAnswers(Student student) {
        String newAnswer = student.getAnswer();
    
        // Print the student's choice
        System.out.println(student.getStudentID() + " chose: " + newAnswer);

        if (studentAnswers.containsKey(student.getStudentID())) {
            String oldAnswer = studentAnswers.get(student.getStudentID());

            if (isAnswerRight(oldAnswer)) {
                right--;
            } else {
                wrong--;
            }
        }
        
        studentAnswers.put(student.getStudentID(), newAnswer);

        if (isAnswerRight(newAnswer)) {
            right++;
        } else {
            wrong++;
        }
    }

    /**
     * Determines if the provided answer is correct.
     * @param answer The answer to check.
     * @return True if the answer is correct, false otherwise.
     */
    protected boolean isAnswerRight(String answer) {
        return answer.equals(question.getAnswer());
    }

    /**
     * Sets the available choices for the current question.
     * @param choices The array of choices.
     */
    public void setChoices(String [] choices) {
        question.setChoices(choices);
    }

    /**
     * Sets the correct answer for the current question.
     * @param answer The correct answer.
     */
    public void setQA(String answer) {
        question.setAnswer(answer);
    }

    /**
     * Sets the correct answers for a multiple-choice question.
     * @param answers The array of correct answers.
     */
    public void setmcQA(String [] answers) {
        if (question instanceof MCQuestion) {
            ((MCQuestion)question).setAnswers(answers);
        }
    }
}
