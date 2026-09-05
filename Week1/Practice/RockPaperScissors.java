import java.util.*;

class RockPaperScissors {

    // Method to decide the result of one round
    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int N = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Arrays to store the result of every round
        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];

        // Play 5 rounds
        for (int i = 0; i < N; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            playerMoves[i] = sc.next();
            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Computer Move: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } 
            else if (results[i].equals("Computer Wins")) {
                losses++;
            } 
            else {
                draws++;
            }
        }

        System.out.println("\n========== FINAL SCOREBOARD ==========");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + "\t" +
                    playerMoves[i] + "\t\t" +
                    computerMoves[i] + "\t\t" +
                    results[i]);
        }

        // Calculate win percentage
        double winPercentage = (wins * 100.0) / N;

        System.out.println("\n========== SCORE ==========");
        System.out.println("Total Wins   : " + wins);
        System.out.println("Total Losses : " + losses);
        System.out.println("Total Draws  : " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}