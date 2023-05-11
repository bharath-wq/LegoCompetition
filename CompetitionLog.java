/**
 * CompetitionLog
 *
 * gives information on each player number such as complete/incomplete sets and pieces used
 *
 * @author Bharath Sadagopan
 *
 * @version 10/12/2022
 *
 */
public class CompetitionLog {
    private int playerNumber;
    private String completeSets;
    private String incompleteSets;
    private int piecesBuilt;

    public CompetitionLog(int playerNumber, String completeSets, String incompleteSets, int piecesBuilt) {
        this.playerNumber = playerNumber;
        this.completeSets = completeSets;
        this.incompleteSets = incompleteSets;
        this.piecesBuilt = piecesBuilt;
    }

    public int getPlayerNumber() {

        return playerNumber;
    }
    public String getCompleteSets() {

        return completeSets;
    }
    public String getIncompleteSets() {

        return incompleteSets;
    }
    public int getPiecesBuilt() {

        return piecesBuilt;
    }
    public void setPlayerNumber(int playerNumber) {

        this.playerNumber = playerNumber;
    }
    public void setCompleteSets(String completeSets) {

        this.completeSets = completeSets;
    }
    public void setIncompleteSets(String incompleteSets) {

        this.incompleteSets = incompleteSets;
    }
    public void setPiecesBuilt(int piecesBuilt) {

        this.piecesBuilt = piecesBuilt;
    }
    public String toString() {
        return String.format("Player %d completed the following sets: %s\nPlayer %d did not complete" +
                        " the following sets: %s\nPlayer %d built a total of %d pieces\n", getPlayerNumber(), getCompleteSets(),
                getPlayerNumber(), getIncompleteSets(), getPlayerNumber(), getPiecesBuilt());
    }
}
