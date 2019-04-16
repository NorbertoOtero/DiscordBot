/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.Commands;

import discordbot.DiscordBot;
import java.awt.Color;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author coolz
 */
public class ClearCommand extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String [] args = event.getMessage().getContentRaw().split("\\s+");
        if(args[0].equalsIgnoreCase(DiscordBot.prefix + "clear"))
        {
            if(args.length < 2)
            {
                //TODO error handling
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(Color.RED);
                usage.setTitle("Specify amount to delete");
                usage.setDescription("Usage: " + DiscordBot.prefix + "clear # of messages");
                event.getChannel().sendMessage(usage.build()).queue();
            }
            else
            {
                try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getChannel().deleteMessages(messages).queue();
                    //Too many messages
                     EmbedBuilder sucess = new EmbedBuilder();
                     sucess.setColor(Color.GREEN);
                     sucess.setTitle("Succesfully deleted " + args[1] + " messages.");
                     event.getChannel().sendMessage(sucess.build()).queue();
                }
                catch(IllegalArgumentException e)
                {
                   if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval"))
                   {
                       //Too many messages
                       EmbedBuilder error = new EmbedBuilder();
                       error.setColor(Color.RED);
                       error.setTitle("Too many messages selected");
                       error.setDescription("Messages selected must be between 1 and 100");
                       event.getChannel().sendMessage(error.build()).queue();
                   }
                   else
                   {
                       //Messages too old
                       EmbedBuilder error = new EmbedBuilder();
                       error.setColor(Color.RED);
                       error.setTitle("Messages are too old");
                       error.setDescription("Cannot delete messages older than 2 weeks");
                       event.getChannel().sendMessage(error.build()).queue();
                   }
                }
            }
        }
    }
}
