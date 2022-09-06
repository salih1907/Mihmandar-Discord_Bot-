package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.Color;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PrintEuro  extends ListenerAdapter{
	public String prefix = "!";

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		if (args[0].equalsIgnoreCase(prefix + "euro")) {
			final String url = "https://www.bloomberght.com/doviz/euro";
			EmbedBuilder embed = new EmbedBuilder();
			try {
				final Document document = Jsoup.connect(url).get();
				for (Element row : document.select("span.upGreen")) {
					final String Euro = row.select("span.upGreen").text();
					embed.setTitle("💶 Euro 💶", "");
					embed.setDescription("1 € şu anda "+Euro+" TL");
					embed.setColor(Color.BLUE);
					event.getChannel().sendMessage(embed.build()).queue();
					
					embed.clear();
				}for (Element row : document.select("span.downRed")) {
					final String Euro = row.select("span.downRed").text();
					embed.setTitle("💶 Euro 💶", "");
					embed.setDescription("1 € şu anda "+Euro+" TL");
					embed.setColor(Color.BLUE);
					event.getChannel().sendMessage(embed.build()).queue();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
