package handlers.FRC;

public class MatchData {
    public enum SpinnerState {
        NOT_STARTED,
        DONE_1,
        DONE_2,
        DONE_3
    }
    public enum ClimbState {
        NOT_STARTED,
        PARKED,
        HANGING,
        BALANCED
    }
    private final int innerPortAuto;
    private final int outerPortAuto;
    private final int lowerPortAuto;
    private final int innerPortTeleop;
    private final int outerPortTeleop;
    private final int lowerPortTeleop;
    private final SpinnerState spinner;
    private final ClimbState climbed;
    private final boolean initiationLine;

    public int getInnerPortAuto() {
        return innerPortAuto;
    }

    public int getOuterPortAuto() {
        return outerPortAuto;
    }

    public int getLowerPortAuto() {
        return lowerPortAuto;
    }

    public int getInnerPortTeleop() {
        return innerPortTeleop;
    }

    public int getOuterPortTeleop() {
        return outerPortTeleop;
    }

    public int getLowerPortTeleop() {
        return lowerPortTeleop;
    }

    public SpinnerState getSpinner() {
        return spinner;
    }

    public ClimbState getClimbed() {
        return climbed;
    }

    public boolean isInitiationLine() {
        return initiationLine;
    }

    public MatchData(int innerPortAuto, int outerPortAuto, int lowerPortAuto, int innerPortTeleop, int outerPortTeleop,
            int lowerPortTeleop, SpinnerState spinner, ClimbState climbed, boolean initiationLine) {
        this.innerPortAuto = innerPortAuto;
        this.outerPortAuto = outerPortAuto;
        this.lowerPortAuto = lowerPortAuto;
        this.innerPortTeleop = innerPortTeleop;
        this.outerPortTeleop = outerPortTeleop;
        this.lowerPortTeleop = lowerPortTeleop;
        this.spinner = spinner;
        this.climbed = climbed;
        this.initiationLine = initiationLine;
    }

    
}
