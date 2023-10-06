import java.util.Arrays;
import java.util.HashMap;
public class VotingService {
    protected Question question; //Use protected instead of private so that child class can access values
    protected int right;
    protected int wrong;
    protected HashMap<String, String> studentAnswers = new HashMap<>(); // Student ID, Answers
   
    public void displayResults() {
        System.out.println("Right: " + right);
        System.out.println("Wrong: " + wrong);
        System.out.println("--------------------------");
    }
    
    public void displayQuestion(){
        System.out.println("Question: " + question.getText());
        System.out.println("Choices: " + String.join(", ", question.getChoices()));
    }

    public void createQuestion(String text, String type, String [] choices) {
        // Reset counts for the new question
        right = 0;
        wrong = 0;
        studentAnswers.clear();  // Clear the student answers for the new question

        if ("Single".equals(type)) {
            question = new Question(text,choices);
        } else {
            question = new MCQuestion(text,choices);
        }
    }

    public void submitAnswers(Student student) {
        String newAnswer = student.getAnswer();
    
        // Print the student's choice
        System.out.println(student.getStudentID() + " chose: " + newAnswer);
        // Check if student has answered before
        if (studentAnswers.containsKey(student.getStudentID())) {
            String oldAnswer = studentAnswers.get(student.getStudentID());
            
            // If previous answer was right, decrement the right counter
            if (isAnswerRight(oldAnswer)) {
                right--;
            } else {
                wrong--;
            }
        }
        
        // Update student's answer in the map
        studentAnswers.put(student.getStudentID(), newAnswer);
        
        // Check new answer
        if (isAnswerRight(newAnswer)) {
            right++;
        } else {
            wrong++;
        }
    }

    protected boolean isAnswerRight(String answer) {
        return answer.equals(question.getAnswer());
    }

    public void setChoices(String [] choices) {
        question.setChoices(choices);
    }

    public void setQA(String answer) {
        question.setAnswer(answer);
    }

    public void setmcQA(String [] answers) {
        if (question instanceof MCQuestion) {
            ((MCQuestion)question).setAnswers(answers);
        }
    }
}
