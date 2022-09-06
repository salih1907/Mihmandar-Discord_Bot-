package mihmandar;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

	public String prefix = "!";

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		if (args[0].equalsIgnoreCase(prefix + "test")) {
			event.getMessage().reply("Welcome " + event.getAuthor().getName()).queue();
		} else if (args[0].equalsIgnoreCase(prefix + "info")) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("✨  Mihmandar  ✨", "");
			embed.setDescription("🛠 Use the !help command for help! 🛠");
			embed.addField("👷‍♂️ Abilities 👷‍♂️", "I can do everything, just tell me!", false);
			embed.addField("⭕ To reach me  ⭕", "Don't try, you can't reach me  ", false);
			embed.setColor(Color.GREEN);
			embed.setFooter("Created by Salih Dündar", event.getGuild().getOwner().getUser().getAvatarUrl());
			event.getChannel().sendMessage(embed.build()).queue();
			embed.clear();

		} else if (args[0].equalsIgnoreCase(prefix + "giverole")) {
			if (event.getMessage().getMentionedRoles().toArray().length == 1) {
				if (event.getMessage().getMentionedUsers().toArray().length == 1) {
					if (event.getMessage().getMentionedUsers().toArray().equals(event.getMessage().getAuthor())) {
						event.getMessage().reply("You can't give role to yourself").queue();
					} else {
						Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
						Role roleToGive = event.getMessage().getMentionedRoles().get(0);
						event.getGuild().addRoleToMember(member, roleToGive).queue();
						event.getMessage()
								.reply("Gave the role" + roleToGive.getAsMention() + " to " + member.getAsMention())
								.queue();
					}

				} else {
					event.getMessage().reply("Please mention only one user").queue();
				}
			} else {
				event.getMessage().reply("Please mention only one role to give").queue();
			}
		}

		else if (args[0].equalsIgnoreCase(prefix + "removerole")) {
			if (event.getMessage().getMentionedRoles().toArray().length == 1) {
				if (event.getMessage().getMentionedUsers().toArray().length == 1) {

					Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleToGive = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().removeRoleFromMember(member, roleToGive).queue();
					event.getMessage()
							.reply("Removed the role" + roleToGive.getAsMention() + " to " + member.getAsMention())
							.queue();

				} else {
					event.getMessage().reply("Please mention only one user").queue();
				}
			} else {
				event.getMessage().reply("Please mention only one role to give").queue();
			}
		} else if (args[0].equalsIgnoreCase(prefix + "dolar")) {

		}
	}
}
