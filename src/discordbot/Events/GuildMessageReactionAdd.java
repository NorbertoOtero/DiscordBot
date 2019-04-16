/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.Events;

import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author coolz
 */
public class GuildMessageReactionAdd extends ListenerAdapter
{
    @Override
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event)
    {
        if(event.getReactionEmote().getName().equals("❌") && !event.getMember().getUser().equals(event.getJDA().getSelfUser()))
        {
            if(event.getMember().getUser().equals(event.getChannel().getMessageById(event.getMessageId()).complete().getAuthor()))
            {
                //If bot confirms it is the author of emote then...
                event.getChannel().getMessageById(event.getMessageId()).complete().delete().queue();
            }
            else
            {
                //If not the author
                event.getReaction().removeReaction().queue();
            }
        }
    }
}
