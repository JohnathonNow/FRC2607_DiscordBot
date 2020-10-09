package util;

import backend.Backend;

public class Message {
    private final Backend replyChannel;
    private final String sender;
    private final String text;

    public Message(Backend replyChannel, String sender, String text) {
        this.replyChannel = replyChannel;
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public void reply(Message m) {
        this.replyChannel.send(m);
    }
}
