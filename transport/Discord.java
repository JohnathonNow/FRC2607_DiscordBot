package transport;

import util.Message;

public class Discord implements Transport {

    @Override
    public Message receive() {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

    @Override
    public void send(Message m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }

}
