import backend.Backend;
import backend.Console;
import frontend.Frontend;
import frontend.FRC.MatchPredictor;
import util.Message;

public class Main {
    public static void main(String[] args) {
        Frontend[] handlers = new Frontend[] {
            new MatchPredictor()
        };
        Backend b = new Console();
        while (true) {
            Message m = b.receive();
            for (Frontend f : handlers) {
                f.handleMessage(m);
            }
        }
    }
}