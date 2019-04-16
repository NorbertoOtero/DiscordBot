/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.Events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author coolz
 */
public class GuildMessageRecieved extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        event.getMessage().addReaction("❌").queue();
    }
}
