package transport;
import util.Message;

public interface Transport {
    public Message receive();
    public void send(Message m);
}
