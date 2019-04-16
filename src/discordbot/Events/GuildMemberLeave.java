/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.Events;

import java.awt.Color;
import java.util.Random;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author coolz
 */
public class GuildMemberLeave extends ListenerAdapter
{
    String [] messages =
    {"[member] left. You must deconstruct all pylons!",
    "[member] got tired of being Rick Rolled.",
    "Hey! Listen! [member] has left!",
    "Ha! [member] has left! Good Riddance!",
    "Its a shame to see you go, [member].",
    "Give it up [member], I have the high ground!",
    "Woooosh. [member] just departed.",
    "Brace yourselves. [member] just left the server.",
    "A wild [member] has fled.",
    "[member] just slid out of the server!",
    "Ermagherd. [member] left us.",
    "[member] abandoned your party.",
    "[member] just left the server. - gg EZ",
    "[member] just left. Everyone can relax now!",
    "[member]  just left. Talk about a RageQuit.",
    "Goodbye, [member]. Your stories no longer entertain us.",
    "Goodbye, [member]. You no longer waste our time.",
    "Goodbye, [member]. Why did you eat all the pizza.",
    "[member] just left. You no longer have to hide your bananas.",
    "[member] just departed. Too Weak - please buff.",
    "A [member] has despawned.",
    "Big [member] just left!",
    "Where’s [member]? Not in the server!"};
    
    @Override
    public void onGuildMemberLeave(GuildMemberLeaveEvent event)
    {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(Color.orange);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
        
        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
    }
}
