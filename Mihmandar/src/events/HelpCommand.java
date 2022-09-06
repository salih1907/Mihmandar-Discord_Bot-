package events;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelpCommand extends ListenerAdapter {
	String prefix = "!";

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String[] args = event.getMessage().getContentRaw().split(" ");
		if (args[0].equalsIgnoreCase(prefix + "help")) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("🛠 HELP 🛠", "");
			embed.setDescription(
					"!dolar          - to see the current dolar currency"
					+ "\n!euro       - to see the current dolar currency" + "\n!kitten     - sends a kitten photo"
					+ "\n!info       - to take information about Mihmandar"
					+ "\n!test       - to check the bot is working" + "\n!giverole   - give a role to users"
					+ "\n!removerole - remove the role from user"
					+ "\n!anafen     - sadece yaz gerisine karışma");
			embed.setColor(Color.YELLOW);
			event.getChannel().sendMessage(embed.build()).queue();
			embed.clear();
		}

	}

}
