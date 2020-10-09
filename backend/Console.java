package backend;

import java.util.Scanner;

import util.Message;

public class Console implements Backend {
    private final Scanner scan;

    public Console() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public Message receive() {
        String line = this.scan.nextLine();
        return new Message(this, "user", line);
    }

    @Override
    public void send(Message m) {
        System.out.println(m.getText());
    }

}
