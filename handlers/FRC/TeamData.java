package handlers.FRC;

import java.util.ArrayList;

public class TeamData {
    public final ArrayList<MatchData> matches;
    public final int teamNumber;

    public ArrayList<MatchData> getMatches() {
        return matches;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public TeamData(int teamNumber) {
        this.matches = new ArrayList<>();
        this.teamNumber = teamNumber;
    }
    
    public void playMatch(MatchData m) {
        this.matches.add(m);
    }
    
}
