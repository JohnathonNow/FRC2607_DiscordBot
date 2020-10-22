package handlers.FRC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ScoutingData {
    public HashMap<Integer, TeamData> data;
    private static Random r = new Random();

    public ScoutingData() {
        this.data = new HashMap<>();
        this.data.put(2607, new TeamData(2607));
        // TODO: Read in data
    }

    public boolean isPlayingMatch(int team) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public boolean isPlayingDefense(int team) {
        int count = data.get(team).getMatchesPlayedDefence();
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    private int getPossibleInnerGoals(int team) {
        TeamData d = this.data.get(team);
        ArrayList<Integer> innerGoals = new ArrayList<>();
        for (MatchData m : d.matches) {
            int score = m.getInnerPortTeleop();
            innerGoals.add(score);
        }
        return innerGoals.get(r.nextInt(innerGoals.size()));
    }


    public int getPossibleScore(int team) {
        int score = 0;
        score += getPossibleInnerGoals(team) * 3;
        return score;
    }
}
