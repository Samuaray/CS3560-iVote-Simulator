import java.util.Arrays;
/**
 * MCVotingService extends the VotingService to handle multiple-choice questions specifically.
 */
public class MCVotingService extends VotingService {

    /**
     * Submits the student's answers for multiple-choice questions.
     * Overrides the method in the parent class to handle multiple-choice answers.
     * @param student The student object containing student's answers.
     */
    @Override
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

    /**
     * Checks if the student's answers for a multiple-choice question are correct.
     * @param mAnswer The student's answers.
     * @return true if the student's answers match the correct answers; false otherwise.
     */
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
