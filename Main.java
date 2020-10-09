import handlers.Handler;
import handlers.FRC.MatchPredictor;
import transport.Console;
import transport.Transport;
import util.Message;

public class Main {
    public static void main(String[] args) {
        Handler[] handlers = new Handler[] {
            new MatchPredictor()
        };
        Transport b = new Console();
        while (true) {
            Message m = b.receive();
            for (Handler f : handlers) {
                f.handleMessage(m);
            }
        }
    }
}