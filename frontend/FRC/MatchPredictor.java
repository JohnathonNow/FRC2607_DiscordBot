package frontend.FRC;

import frontend.Frontend;
import util.Message;

public class MatchPredictor implements Frontend {
    private ScoutingData data;
    public MatchPredictor() {
        this.data = new ScoutingData();
    }

    @Override
    public void handleMessage(Message m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public Result simulateOne(Match m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    public Prediction simulateMany(Match m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }
}
