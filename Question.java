public class Question {
    protected String text;
    protected String[] choices;
    protected String answer;

    // Constructor
    public Question(String text, String[] choices) {
        this.text = text;
        this.choices = choices;
    }

    // Setters and Getters
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getText() {
        return text;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] newChoices) {
        this.choices = newChoices;
    }
}