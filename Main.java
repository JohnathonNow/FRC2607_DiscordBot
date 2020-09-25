import javax.security.auth.login.LoginException;

import blackjack.Deck;
import blackjack.Hand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
    public static JDA jda;
    public Deck deck;
    public boolean started = false;
    public Hand dealer;
    public Hand player;

    public static void main(String[] args) throws LoginException, InterruptedException {
        jda = JDABuilder.createDefault("NzU4ODMxMTQzMDU0NjA2MzU3.X20qkg.UIib3PezFGiUZtxWI6krrc5WNOE").addEventListeners(new Main()).build();
        // optionally block until JDA is ready
        jda.awaitReady();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        MessageChannel channel = event.getChannel();
        if (message.startsWith("!start")) {
            this.deck = new Deck(6);
            this.deck.shuffle();
            this.started = true;

            this.dealer = new Hand();
            this.player = new Hand();

            this.dealer.deal(this.deck.draw());
            channel.sendMessage("Dealer: " + this.dealer.getText()).queue();
            this.dealer.deal(this.deck.draw());

            this.player.deal(this.deck.draw());
            this.player.deal(this.deck.draw());
            channel.sendMessage("You hand: " + this.player.getText()).queue();
        }
        if (this.started) {
            if (message.startsWith("!hit")) {
                this.player.deal(this.deck.draw());
                channel.sendMessage("Your hand: " + this.player.getText()).queue();
            }
            if (message.startsWith("!stand") || message.startsWith("!stay") || this.player.getValue() > 21) {
                //now it's the dealer's turn
                channel.sendMessage("Dealer: " + this.dealer.getText()).queue();
                while (this.dealer.getValue() <= 16) {
                    this.dealer.deal(this.deck.draw());
                    channel.sendMessage("Dealer: " + this.dealer.getText()).queue();
                }
                if (this.dealer.getValue() > 21 && this.player.getValue() > 21 || this.dealer.getValue() == this.player.getValue()) {
                    channel.sendMessage("Tie!").queue();
                } else if (this.dealer.getValue() > this.player.getValue()) {
                    channel.sendMessage("Dealer wins!").queue();
                } else {
                    channel.sendMessage("You win!").queue();
                }
                this.started = false;
            }
        } else if (message.startsWith("!")) {
            channel.sendMessage("To start a game, type !start").queue();
        }
    }
}