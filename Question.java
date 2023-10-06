/**
 * The question allows the creation of a question with its text, choices, and answer.
 */
public class Question {

    // Instance variables
    protected String text;       // The text of the question
    protected String[] choices;  // The array of answer choices
    protected String answer;     // The correct answer

    /**
     * Constructs a new Question object with the provided question text and answer choices.
     * @param text     The text of the question.
     * @param choices  An array of answer choices for the question.
     */
    public Question(String text, String[] choices) {
        this.text = text;
        this.choices = choices;
    }

    /**
     * Sets the correct answer for the question.
     * @param answer  The correct answer for the question.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Returns the correct answer for the question.
     * @return The correct answer for the question.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns the question text.
     * @return question text.
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the array of answer choices for this question.
     * @return An array of answer choices.
     */
    public String[] getChoices() {
        return choices;
    }

    /**
     * Sets a new array of answer choices for the question.
     * @param newChoices  An array of new answer choices.
     */
    public void setChoices(String[] newChoices) {
        this.choices = newChoices;
    }
}
