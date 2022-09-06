package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PrintDolar extends ListenerAdapter {

	public String prefix = "!";

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		if (args[0].equalsIgnoreCase(prefix + "dolar")) {
			final String url = "https://www.bloomberght.com/doviz/dolar";
			EmbedBuilder embed = new EmbedBuilder();
			try {
				final Document document = Jsoup.connect(url).get();
				for (Element row : document.select("span.upGreen")) {
					final String dolar = row.select("span.upGreen").text();
					embed.setTitle("💵 Dolar 💵", "");
					embed.setDescription("1 $ şu anda " + dolar + " TL");
					embed.setColor(Color.GREEN);
					event.getChannel().sendMessage(embed.build()).queue();

					embed.clear();
				}
				for (Element row : document.select("span.downRed")) {
					final String dolar = row.select("span.downRed").text();
					embed.setTitle("💵 Dolar 💵", "");
					embed.setDescription("1 $ şu anda " + dolar + " TL");
					embed.setColor(Color.RED);
					event.getChannel().sendMessage(embed.build()).queue();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		else if (args[0].substring(0, 4).equalsIgnoreCase(prefix + "dol")) {
			event.getChannel().sendMessage("Hahaha çok komikti. Bidaha olmasın...").queue();
			
		}
	}
}
