package handlers.FRC;

import handlers.Handler;
import util.Message;

public class MatchPredictor implements Handler {
    private ScoutingData data;
    public MatchPredictor() {
        this.data = new ScoutingData();
    }

    @Override
    public void handleMessage(Message m) {
        if (m.getText().startsWith("!testdefense")) {
            System.out.println("2607 played defense? " + this.data.isPlayingDefense(2607));
        }
    }

    public Result simulateOne(Match m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public Prediction simulateMany(Match m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }
}
