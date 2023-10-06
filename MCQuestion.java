/**
 * The MCQuestion class represents a multiple-choice question that extends the base Question class.
 * It includes support for one or multiple correct answers.
 */
public class MCQuestion extends Question {

    // Instance variable
    protected String[] answers; // Field for one or multiple correct answers

    /**
     * Constructs a new MCQuestion object with the provided question text and answer choices.
     * @param text     The text of the multiple-choice question.
     * @param choices  An array of answer choices for the question.
     */
    public MCQuestion(String text, String[] choices) {
        super(text, choices); // Call the constructor of the base class (Question)
    }

    /**
     * Sets one or multiple correct answers for this multiple-choice question.
     * @param answers  An array of correct answer(s) for the question.
     */
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    /**
     * Gets the correct answer(s) for this multiple-choice question.
     * @return An array of correct answer(s) for the question.
     */
    public String[] getAnswers() {
        return answers;
    }
}
