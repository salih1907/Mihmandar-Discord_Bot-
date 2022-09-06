package events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Timer;
import java.util.TimerTask;

public class GuildMessageReactionAdd extends ListenerAdapter {

	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
		if (event.getReactionEmote().getName().equals("❌")
				&& !event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
			if (!event.getMember().getUser().isBot()) {
				event.getChannel().deleteMessageById(event.getChannel().getLatestMessageIdLong()).queue();
				
			}else {
				event.getReaction().removeReaction().queue();
			}
			
			

		} else {

			Timer myTimer = new Timer();

			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					event.getReaction().removeReaction().queue();
					myTimer.cancel();

				}
			};
			myTimer.schedule(task, 3000);
		}

	}

}
