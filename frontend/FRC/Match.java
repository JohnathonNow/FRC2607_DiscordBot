package frontend.FRC;

public class Match {
    private final int[] blueAlliance;
    private final int[] redAlliance;

    public Match(int[] blueAlliance, int[] redAlliance) {
        this.blueAlliance = blueAlliance;
        this.redAlliance = redAlliance;
    }

    public int[] getBlueAlliance() {
        return blueAlliance;
    }

    public int[] getRedAlliance() {
        return redAlliance;
    }
    
}
