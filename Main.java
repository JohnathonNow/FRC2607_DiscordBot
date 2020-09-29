import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
    public static JDA jda;
    public static void main(String[] args) throws LoginException, InterruptedException {
        jda = JDABuilder.createDefault("TOKEN").addEventListeners(new Main()).build();
        // optionally block until JDA is ready
        jda.awaitReady();
    }
//hello
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        event.getMessage().addReaction("U+1F620").queue();
        System.out.println(event.getAuthor().getAsMention());
        if (event.isFromType(ChannelType.PRIVATE)) {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
            
            if (!event.getAuthor().getAsMention().equals(jda.getSelfUser().getAsMention())) {
                MessageChannel channel = event.getChannel();
                channel.sendMessage("Don't ever contact me again").queue();
            }
        } else {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(), event.getTextChannel().getName(),
                    event.getMember().getEffectiveName(), event.getMessage().getContentDisplay());
        }
    }
}