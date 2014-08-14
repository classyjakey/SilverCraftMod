package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and stops the server.", usage = "/<command>")
public class Command_stop extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length > 0)
        {
                 new BukkitRunnable()
                 {
                 @Override
                 public void run()
                 {
                   // Announce
                   TFM_Util.bcastMsg(sender.getName() + " is closing the server..", ChatColor.LIGHT_PURPLE);
                 }
                     }.runTaskLater(plugin, 3L * 20L);
                     
            for (Player player : server.getOnlinePlayers())
            {
                player.kickPlayer("Server is going offline" StringUtils.join(args, " "));
            }

            server.shutdown();
        }
        return true;
    }
}
