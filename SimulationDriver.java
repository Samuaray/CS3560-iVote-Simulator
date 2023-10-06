import java.util.Arrays;

public class SimulationDriver {
    public static void main(String[] args) {
        
        VotingService votingService = new VotingService();
        MCVotingService mcVotingService = new MCVotingService();
        
        // Create the Students
        Student alice = new Student("Alice123");
        Student bob = new Student("Bob456");
        Student charlie = new Student("Charlie789");

        //Question 1 Single Choice 
        String[] choice1 = {"Effiel Tower", "Burj Khalifa", "Statue of Liberty"};
        votingService.createQuestion("What Building is Tallest?", "Single", choice1);
        votingService.setQA("Burj Khalifa");

        // Students answering the single choice questions
        votingService.displayQuestion();
            alice.chooseRA(choice1);
            votingService.submitAnswers(alice);
            
            bob.chooseRA(choice1);
            votingService.submitAnswers(bob);

            charlie.chooseRA(choice1);
            votingService.submitAnswers(charlie);
           
        votingService.displayResults();

        //Question 2 Single Choice 
        String[] choice2 = {"Apple", "Orange", "Banana", "Pear"};
        votingService.createQuestion("Which fruit is yellow?", "Single", choice2);
        votingService.setQA("Banana");
        
        votingService.displayQuestion();
            alice.chooseRA(choice2);
            votingService.submitAnswers(alice);
            
            bob.chooseRA(choice2);
            votingService.submitAnswers(bob);

            charlie.chooseRA(choice2);
            votingService.submitAnswers(charlie);
        votingService.displayResults();

        //Question 3 Multiple Choice 
        String[] choice3 = {"Mercury", "Venus", "Mars", "Jupiter"};
        mcVotingService.createQuestion("Which planets are closer to the sun than Earth?", "Multiple", choice3);
        mcVotingService.setmcQA(new String[] {"Mercury", "Venus"});

         // Students answering the multiple choice questions
         mcVotingService.displayQuestion();
            alice.chooseRMA(choice3);
            mcVotingService.submitAnswers(alice);
            
            bob.chooseRMA(choice3);
            mcVotingService.submitAnswers(bob);

            charlie.chooseRMA(choice3);
            mcVotingService.submitAnswers(charlie);
        mcVotingService.displayResults();


        //Question 4 Multiple Choice 
        String[] choice4 = {"Physics","Biology","Chemistry","Mathematics"};
        mcVotingService.createQuestion("Which subjects are a natural science?", "Multiple", choice4);
        mcVotingService.setmcQA(new String[] {"Physics","Biology","Chemistry"});
        
        mcVotingService.displayQuestion();
            alice.chooseRMA(choice4);
            mcVotingService.submitAnswers(alice);
            
            bob.chooseRMA(choice4);
            mcVotingService.submitAnswers(bob);

            charlie.chooseRMA(choice4);
            mcVotingService.submitAnswers(charlie);
        mcVotingService.displayResults();
        

        
        
         
        

       

        
    }
}
