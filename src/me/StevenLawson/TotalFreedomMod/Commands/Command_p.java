package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList
import org.bukkit.command.Command;
import org.bukkit.command.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Sets everyone's Worldedit block modification limit to 500.", usage = "/<command>")
public class Command_setl extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length = 0)
        {
          return false;
        }
        // Chat
        for (final Player player : server.getOnlinePlayers())
        {
            if (TFM_AdminList.isSeniorAdmin(player))
            {
                player.sendMessage(ChatColor.YELLOW + "[SENIOR-ADMIN] " + ChatColor.DARK_RED + sender.getName() + ChatColor.AQUA + ":" + ChatColor.AQUA + StringUtils.join(args, " ")); 
            }
        }
        return true;
    }
}
