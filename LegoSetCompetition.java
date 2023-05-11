import java.util.Scanner;
/**
 * LegoSetCompetition
 *
 * conducts the Lego Competition and provides winner and statistics at the end
 *
 * @author Bharath Sadagopan
 *
 * @version 10/12/2022
 *
 */
public class LegoSetCompetition {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int playerOnePieces = 0;
        int playerOneDayPieces = 0;
        int playerOneFullPieces = 0;
        String playerOneCompleted = "None";
        String playerTwoCompleted = "None";
        String playerOneFullCompleted = "";
        String playerTwoFullCompleted = "";
        String playerOneFullIncompleted = "";
        String playerTwoFullIncompleted = "";
        int playerTwoPieces = 0;
        int playerTwoDayPieces = 0;
        int playerTwoFullPieces = 0;
        int day = 0;
        int totalPieces = 0;
        System.out.println("Welcome to the Lego Set Competition!");
        boolean tie = false;
        do {
            System.out.println("Enter the name of Lego Set 1");
            String legoSet1 = scanner.nextLine();
            System.out.println("Enter the number of pieces in Lego Set 1");
            int piecesSet1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the name of Lego Set 2");
            String legoSet2 = scanner.nextLine();
            System.out.println("Enter the number of pieces in Lego Set 2");
            int piecesSet2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the name of Lego Set 3");
            String legoSet3 = scanner.nextLine();
            System.out.println("Enter the number of pieces in Lego Set 3");
            int piecesSet3 = scanner.nextInt();
            scanner.nextLine();
            totalPieces = piecesSet1 + piecesSet2 + piecesSet3;
            String playerOneIncompleted = (legoSet1 + ", " + legoSet2 + ", " + legoSet3);
            String playerTwoIncompleted = (legoSet1 + ", " + legoSet2 + ", " + legoSet3);
            CompetitionLog playerOne = new CompetitionLog(1, playerOneCompleted, playerOneIncompleted,
                    playerOneFullPieces);
            CompetitionLog playerTwo = new CompetitionLog(2, playerTwoCompleted, playerTwoIncompleted,
                    playerTwoFullPieces);
            while (playerOnePieces < totalPieces && playerTwoPieces < totalPieces) {
                day++;
                System.out.printf("Enter the number of pieces player 1 used for building on day %d\n", day);
                playerOneDayPieces = scanner.nextInt();
                scanner.nextLine();
                playerOnePieces += playerOneDayPieces;
                playerOne.setPiecesBuilt(playerOnePieces);
                if (playerOnePieces >= piecesSet1) {
                    playerOne.setCompleteSets(legoSet1);
                    playerOne.setIncompleteSets(legoSet2 + ", " + legoSet3);
                }
                if (playerOnePieces >= (piecesSet1 + piecesSet2)) {
                    playerOne.setCompleteSets(legoSet1 + ", " + legoSet2);
                    playerOne.setIncompleteSets(legoSet3);
                }
                if (playerOnePieces >= (piecesSet1 + piecesSet2 + piecesSet3)) {
                    playerOne.setCompleteSets(legoSet1 + ", " + legoSet2 + ", " + legoSet3);
                    playerOne.setIncompleteSets("None");
                }
                System.out.printf("Enter the number of pieces player 2 used for building on day %d\n", day);
                playerTwoDayPieces = scanner.nextInt();
                scanner.nextLine();
                playerTwoPieces += playerTwoDayPieces;
                playerTwo.setPiecesBuilt(playerTwoPieces);
                if (playerTwoPieces >= piecesSet1) {
                    playerTwo.setCompleteSets(legoSet1);
                    playerTwo.setIncompleteSets(legoSet2 + ", " + legoSet3);
                }
                if (playerTwoPieces >= (piecesSet1 + piecesSet2)) {
                    playerTwo.setCompleteSets(legoSet1 + ", " + legoSet2);
                    playerTwo.setIncompleteSets(legoSet3);
                }
                if (playerTwoPieces >= (piecesSet1 + piecesSet2 + piecesSet3)) {
                    playerTwo.setCompleteSets(legoSet1 + ", " + legoSet2 + ", " + legoSet3);
                    playerTwo.setIncompleteSets("None");
                }
            }
            if (playerOneFullCompleted.equalsIgnoreCase("None") || playerOneFullCompleted.equalsIgnoreCase("")) {
                playerOneFullCompleted = playerOne.getCompleteSets();

            } else {
                playerOneFullCompleted += (", " + playerOne.getCompleteSets());
            }
            if (playerOneFullIncompleted.equalsIgnoreCase("None") || playerOneFullIncompleted.equalsIgnoreCase("")) {
                playerOneFullIncompleted = playerOne.getIncompleteSets();
            } else {
                playerOneFullIncompleted += (", " + playerOne.getIncompleteSets());
            }
            if (playerTwoFullCompleted.equalsIgnoreCase("None") || playerTwoFullCompleted.equalsIgnoreCase("")) {
                playerTwoFullCompleted = playerTwo.getCompleteSets();
            } else {
                playerTwoFullCompleted += (", " + playerTwo.getCompleteSets());
            }
            if (playerTwoFullIncompleted.equalsIgnoreCase("None") || playerTwoFullIncompleted.equalsIgnoreCase("")) {
                playerTwoFullIncompleted = playerTwo.getIncompleteSets();
            } else {
                playerTwoFullIncompleted += playerTwo.getIncompleteSets();
            }
            playerOne.setCompleteSets(playerOneFullCompleted);
            playerOne.setIncompleteSets(playerOneFullIncompleted);
            playerTwo.setCompleteSets(playerTwoFullCompleted);
            playerTwo.setIncompleteSets(playerTwoFullIncompleted);
            playerOneFullPieces += playerOnePieces;
            playerTwoFullPieces += playerTwoPieces;
            playerOne.setPiecesBuilt(playerOneFullPieces);
            playerTwo.setPiecesBuilt(playerTwoFullPieces);
            // add here
            if (playerOnePieces >= totalPieces && playerTwoPieces >= totalPieces) {
                tie = true;
                System.out.println("The competition ended in a tie! There will be a tiebreaker round");
            } else if (playerOnePieces >= totalPieces) {
                System.out.println("Congratulations to player 1 for winning the Lego Set Competition!");
                System.out.println("Additional information about the competition results is below");
                System.out.print(playerOne.toString());
                System.out.print(playerTwo.toString());
                System.out.printf("The competition lasted %d days", day);
                tie = false;
            } else if (playerTwoPieces >= totalPieces) {
                System.out.println("Congratulations to player 2 for winning the Lego Set Competition!");
                System.out.println("Additional information about the competition results is below");
                System.out.print(playerOne.toString());
                System.out.print(playerTwo.toString());
                System.out.printf("The competition lasted %d days", day);
                tie = false;
            }

            playerOnePieces = 0;
            playerTwoPieces = 0;

        } while(tie == true);
    }

}



/*
Pirate Ship
2000
Ice Skating Rink
500
Swimming Pool
1000
900
650
1000
1000
800
1050
500
550
300
250
 */


