package backend;
import util.Message;

public interface Backend {
    public Message receive();
    public void send(Message m);
}
