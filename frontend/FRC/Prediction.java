package frontend.FRC;

public class Prediction {
    private final int red_wins;
    private final int blue_wins;
    private final int ties;

    public Prediction(int red_wins, int blue_wins, int ties) {
        this.red_wins = red_wins;
        this.blue_wins = blue_wins;
        this.ties = ties;
    }

    public int getRed_wins() {
        return red_wins;
    }

    public int getBlue_wins() {
        return blue_wins;
    }

    public int getTies() {
        return ties;
    }
}
