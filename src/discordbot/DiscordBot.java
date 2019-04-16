/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot;

import discordbot.Commands.ClearCommand;
import discordbot.Commands.InfoCommand;
import discordbot.Events.GuildMemberJoin;
import discordbot.Events.GuildMemberLeave;
import discordbot.Events.GuildMessageReactionAdd;
import discordbot.Events.GuildMessageRecieved;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

/**
 *
 * @author coolz
 */
public class DiscordBot 
{
    public static String prefix = "~";
    /**
     * @param args the command line arguments
     * @throws javax.security.auth.login.LoginException
     */
    public static void main(String[] args) throws LoginException 
    {
        JDABuilder builder = new JDABuilder();
        builder.setToken("NTU4NDMyNzQ1MDAxNTgyNjAx.D3W3qg.wZqGRAoWrClyWJG3he9-Y6UKeoU");
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("Nothing"));
        
        //Add Listeners
        builder.addEventListener(new InfoCommand());
        builder.addEventListener(new ClearCommand());
        builder.addEventListener(new GuildMemberJoin());
        builder.addEventListener(new GuildMemberLeave());
        builder.addEventListener(new GuildMessageRecieved());
        builder.addEventListener(new GuildMessageReactionAdd());
        builder.build();
    }
    
}
