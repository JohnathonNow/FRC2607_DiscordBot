package handlers.FRC;

import java.util.HashMap;

public class ScoutingData {
    public HashMap<Integer, TeamData> data;
    public ScoutingData() {
        this.data = new HashMap<>();
        // TODO: Read in data
    }

    public boolean isPlayingMatch(int team) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public boolean isPlayingDefense(int team) {
        int count = this.data.get(team).matchesPlayedDefence;
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public int getPossibleScore(int team) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }
}
