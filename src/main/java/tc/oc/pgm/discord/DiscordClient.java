package tc.oc.pgm.discord;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import tc.oc.pgm.Config;

public class DiscordClient {

  public static void initialize() throws InterruptedException, LoginException {
    JDA jda =
        new JDABuilder(Config.Discord.token()).addEventListeners(new DiscordListener()).build();
  }
}
