import java.util.Scanner;

import handlers.Handler;
import handlers.FRC.MatchPredictor;
import handlers.Image.ImageManipulator;
import transport.Console;
import transport.Transport;
import util.Message;

public class Main {
    public static void main(String[] args) {
        Handler[] handlers = new Handler[] {
            new MatchPredictor(),
            new ImageManipulator()
        };
        Transport b = new Console();
        while (true) {
            Message m = b.receive();
            Scanner scan = new Scanner(m.getText());
            for (Handler f : handlers) {
                f.handleMessage(m);
            }
        }
    }
}