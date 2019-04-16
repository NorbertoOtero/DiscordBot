/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.Commands;

import discordbot.DiscordBot;
import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author coolz
 */
public class InfoCommand extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String [] args = event.getMessage().getContentRaw().split("\\s+");
        if(args[0].equalsIgnoreCase(DiscordBot.prefix + "info"))
        {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("General Information about this bot:");
            info.setDescription("Available commands: ~clear = use to clear messages\n");
            info.setColor(Color.green);
            info.setFooter("Created by Nor83rto", event.getMember().getUser().getAvatarUrl());
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }
    }
}