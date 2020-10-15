package handlers.FRC;

import java.util.HashMap;

public class ScoutingData {
    public HashMap<Integer, TeamData> data;
    public ScoutingData() {
        this.data = new HashMap<>();
        this.data.put(2607, new TeamData(5));
        // TODO: Read in data
    }

    public boolean isPlayingMatch(int team) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public boolean isPlayingDefense(int team) {
        int count = data.get(team).getMatchesPlayedDefence();
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public int getPossibleScore(int team) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }
}
