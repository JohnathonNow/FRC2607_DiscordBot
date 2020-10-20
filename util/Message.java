package util;

import transport.Transport;

public class Message {
    private final Transport replyChannel;
    private final String sender;
    private final String text;

    public Message(Transport replyChannel, String sender, String text) {
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

    public void reply(String body) {
        this.replyChannel.send(new Message(this.replyChannel, this.sender, body));
    }

    public void reply(Message m) {
        this.replyChannel.send(m);
    }
}
