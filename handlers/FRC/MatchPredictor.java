package handlers.FRC;

import handlers.Handler;
import util.Message;
import java.util.Scanner;
import java.util.ArrayList;

public class MatchPredictor implements Handler {
    private ScoutingData data;
    public MatchPredictor() {
        this.data = new ScoutingData();
    }

    @Override
    public void handleMessage(Message m) {
        if (m.getText().startsWith("!testdefense")) {
            m.reply("2607 played defense? " + this.data.isPlayingDefense(2607));
        }

        if (m.getText().startsWith("!match")) {
            Scanner scanner = new Scanner(m.getText());
            scanner.next();
            int[] blue = new int[]{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
            int[] red = new int[]{scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
            Match match = new Match(blue, red);     
            Prediction p = this.simulateMany(match);
            m.reply("Blue wins: " + p.getBlue_wins() +" " + "Red wins: " + p.getRed_wins() + " " + "Ties: " + p.getTies());
        }
    }

    public Result simulateOne(Match m) {
        int i = 0; 
        int blueScore = 0;
        int redScore = 0;
        while(i<3){
            if(data.isPlayingMatch(m.getBlueAlliance()[i]) && !data.isPlayingDefense(m.getBlueAlliance()[i])){
                blueScore = blueScore + data.getPossibleScore(m.getBlueAlliance()[i]);
            }
            if(data.isPlayingMatch(m.getRedAlliance()[i]) && !data.isPlayingDefense(m.getRedAlliance()[i])){
                redScore = redScore + data.getPossibleScore(m.getRedAlliance()[i]);
            }
            i++;
        }
        if(redScore<blueScore){
            return Result.BLUE_WIN;
        } else if (redScore>blueScore){
            return Result.RED_WIN;
        } else {
            return Result.TIE;
        }
    }

    public Prediction simulateMany(Match m) {
        int i = 0, blue = 0, red = 0, tie = 0;
        Result result;
        while(i<100){
            result = simulateOne(m);
            if(result == Result.BLUE_WIN){
                blue++;
            } else if (result == Result.RED_WIN){
                red++;
            } else {
                tie++;
            }
            i++;
        }
        return new Prediction(red, blue, tie);
    }
}
