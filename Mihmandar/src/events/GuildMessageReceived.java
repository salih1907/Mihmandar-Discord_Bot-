package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter{
	
	public String prefix = "!";
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if (!event.getMessage().getAuthor().isBot()) {
				event.getMessage().addReaction("❌").queue();
			
		}
		
	}

}
