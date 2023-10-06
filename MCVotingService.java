import java.util.Arrays;
public class MCVotingService extends VotingService {

    // Override the method to submit answers for multiple-choice questions
    public void submitAnswers(Student student) {
        String[] mNewAnswer = student.getmAnswer();
    
        // Print the student's choice
        System.out.println(student.getStudentID() + " chose: " + Arrays.toString(mNewAnswer));
    
        // Check if student has answered before using StudentID and MCAnswers as the key-value pair
        String key = student.getStudentID() + Arrays.toString(mNewAnswer);
        if (studentAnswers.containsKey(key)) {
            String[] oldAnswer = student.getmAnswer();
    
            // If previous answer was right, decrement the right counter
            if (isMCAnswerRight(oldAnswer)) {
                right--;
            } else {
                wrong--;
            }
        }
    
        // Update student's answer in the map
        studentAnswers.put(key, Arrays.toString(mNewAnswer));
    
        // Check new answer
        if (isMCAnswerRight(mNewAnswer)) {
            right++;
        } else {
            wrong++;
        }
    }
    

    private boolean isMCAnswerRight(String[] mAnswer) {
        if (question instanceof MCQuestion) { 
            String[] correctAnswers = ((MCQuestion) question).getAnswers();
    
            for (String correctAnswer : correctAnswers) {
                boolean found = false;
                for (String studentAnswer : mAnswer) {
                    if (correctAnswer.equals(studentAnswer)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
            return true;
        }
        return false; 
    }
    
    }
    


