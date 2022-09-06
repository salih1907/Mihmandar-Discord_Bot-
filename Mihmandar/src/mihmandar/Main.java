package mihmandar;

import javax.security.auth.login.LoginException;

import events.GuildMemberJoin;
import events.GuildMessageReactionAdd;
import events.GuildMessageReceived;
import events.HelpCommand;
import events.PrintDolar;
import events.PrintEuro;
import events.SendImage;
import events.Voice;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;



public class Main {
	
	
	// Main method
	
	public static void main(String[] args) throws LoginException{
		 JDABuilder jda = JDABuilder.createDefault("OTE0MjE0MTc5MTk4NjE1NjEy.YaJyTQ.cmWv3vVvCAB3piMtbLv3g5_op8A");
		 jda.setActivity(Activity.listening("Sizi"));
		 jda.setStatus(OnlineStatus.ONLINE);
		 jda.addEventListeners(new Commands());
		 jda.addEventListeners(new GuildMemberJoin());
		 jda.addEventListeners(new GuildMessageReceived());
		 jda.addEventListeners(new GuildMessageReactionAdd());
		 jda.setChunkingFilter(ChunkingFilter.ALL);
		 jda.setMemberCachePolicy(MemberCachePolicy.ALL);
		 jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
		 jda.addEventListeners(new PrintDolar());
		 jda.addEventListeners(new PrintEuro());
		 jda.addEventListeners(new SendImage());
		 jda.addEventListeners(new HelpCommand());
		 jda.addEventListeners(new Voice());
		 jda.build();
	}
}