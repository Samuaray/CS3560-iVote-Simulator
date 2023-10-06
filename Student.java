import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private String studentID;
    private String answer;
    private String[] mAnswer;

    public Student(String studentID) {
        this.studentID = studentID;
    }

     public void chooseRA(String[] choices) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(choices.length);
        this.setAnswer(choices[randomIndex]);
    }

    public void chooseRMA(String[] choices) {
        Random rand = new Random();
        int numOfAnswers = 1 + rand.nextInt(choices.length); // at least one answer
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < numOfAnswers; i++) {
            int randomIndex = rand.nextInt(choices.length);
            if (!answers.contains(choices[randomIndex])) {
                answers.add(choices[randomIndex]);
            } else {
                i--; // re-iterate to get a non-duplicate answer
            }
        }

        this.setmAnswer(answers.toArray(new String[0]));
    }

    public String getStudentID() {
        return studentID;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setmAnswer(String[] mAnswer) {
        this.mAnswer = mAnswer;
    }
    
    public String getAnswer() {
        return answer;
    }

    public String[] getmAnswer() {
        return mAnswer;
    }
    
}

