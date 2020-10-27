package handlers.FRC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoutingData {
    public HashMap<Integer, TeamData> data;
    private static Random r = new Random();
    private Scanner scan;
    public ScoutingData() {
        System.out.println("hi");
        try{
            scan = new Scanner(new File("scoutingData.txt"));
            ArrayList<String> names = new ArrayList<>();
            while(scan.hasNextLine()){
                names.add(scan.nextLine());
            }
            System.out.println("I read in " + names.size() + " names:");
            for (String s : names) {
                System.out.println("\t" + s);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        this.data = new HashMap<>();
        this.data.put(2607, new TeamData(2607));
        // TODO: Read in data
    }

    public boolean isPlayingMatch(int team) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public boolean isPlayingDefense(int team) {
        //int count = data.get(team).getMatchesPlayedDefence();
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
