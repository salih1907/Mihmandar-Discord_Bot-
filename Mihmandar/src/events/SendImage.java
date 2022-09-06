package events;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SendImage extends ListenerAdapter{
	
String prefix = "!";

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		ArrayList<File> files = new ArrayList<File>();
		files.add(new File("C:\\Users\\gencs\\Desktop\\images\\kitten.jpg"));
		files.add(new File("C:\\Users\\gencs\\Desktop\\images\\kitten2.jpg"));
		files.add(new File("C:\\Users\\gencs\\Desktop\\images\\kitten3.jpg"));
		files.add(new File("C:\\Users\\gencs\\Desktop\\images\\kitten4.jpg"));

		if (args[0].equalsIgnoreCase(prefix + "kitten")) {
			Random rand = new Random();
			int file = rand.nextInt(files.size()-1);
			
			
			event.getChannel().sendMessage("😺 Here is yout kitten 😺").addFile(files.get(file)).queue();
		}
		else if (args[0].equalsIgnoreCase(prefix + "anafen")) {
			File anafen = new File("C:\\Users\\gencs\\Desktop\\images\\anafen.jpg");
	
			event.getChannel().sendMessage("REİS GELİYOR").addFile(anafen).queue();
		}

	}
	
}
	
	
	

