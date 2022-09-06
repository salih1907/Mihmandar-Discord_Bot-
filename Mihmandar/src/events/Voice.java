package events;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class Voice extends ListenerAdapter {

	public String prefix = "!";

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		TextChannel channel = event.getChannel();
		if (args[0].equalsIgnoreCase(prefix + "join")) {
			if (!event.getGuild().getSelfMember().hasPermission(channel, Permission.VOICE_CONNECT)) {
				channel.sendMessage("I don't have a permission to join a voice channel").queue();
				return;
			}

			VoiceChannel connectedChannel = event.getMember().getVoiceState().getChannel();
			
			
			if (connectedChannel == null) {
				channel.sendMessage("You are not connected to a voice channel!").queue();
			}

			AudioManager audioManager = event.getGuild().getAudioManager();
			if (audioManager.isAttemptingToConnect()) {
				channel.sendMessage("The bot is already trying to connect! Enter the chill zone!").queue();
				return;
			}

			audioManager.openAudioConnection(connectedChannel);
			

			channel.sendMessage("Connected to the voice channel!").queue();

		} else if (args[0].equalsIgnoreCase(prefix + "leave")) {
			VoiceChannel connectedChannel = event.getGuild().getSelfMember().getVoiceState().getChannel();
			if (connectedChannel == null) {
				channel.sendMessage("I am not connected to a voice channel!").queue();
				return;
			}
			event.getGuild().getAudioManager().closeAudioConnection();

			channel.sendMessage("Disconnected from the voice channel!").queue();

		}
	}

}
