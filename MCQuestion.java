public class MCQuestion extends Question {
    protected String[] answers; // field for one or multiple correct answers

    // Constructor
    public MCQuestion(String text, String[] choices) {
        super(text, choices); 
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;
    }
}