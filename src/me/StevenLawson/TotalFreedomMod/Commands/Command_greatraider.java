/* package me.StevenLawson.TotalFreedomMod.Commands;
//What a copy of doom
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidResolver;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "For the stupid bitches", usage = "/<command> <playername>")
public class Command_greatraider extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("GreatRaider"))
        {
            playerMsg("You do not have the correct permisions");
            return true;
        }
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }

        TFM_Util.adminAction(sender.getName(), "Casting oblivion over " + player.getName(), true);
        TFM_Util.bcastMsg(player.getName() + " Will be destroyed using magical satan powers", ChatColor.RED);
        
        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if (TFM_AdminList.isSuperAdmin(player))
                 {
                      TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
                      TFM_AdminList.removeSuperadmin(player);
                 }
            }
        }.runTaskLater(plugin, 3L * 20L);
        // remove from superadmin
        

        // remove from whitelist
        player.setWhitelisted(false);

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban uuid
        TFM_BanManager.addUuidBan(player);

        // set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // ignite player
        player.setFireTicks(10000);

        // generate explosion
        player.getWorld().createExplosion(player.getLocation(), 4F);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());
                
                // kill
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 3L * 20L);
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Needs to fuckoff");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Needs to fuckoff");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Needs to fuckoff");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Needs to fuckoff");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Needs to fuckoff");
                player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
                player.getWorld().createExplosion(player.getLocation(), 4F);
            }
        }.runTaskLater(plugin, 3L * 20L);
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Is a bitch");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Is a bitch");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Is a bitch");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Is a bitch");
                TFM_Util.bcastMsg(TFM_Util.randomChatColor() + player.getName() + " Is a bitch");
                player.getWorld().createExplosion(player.getLocation(), 8F);
                
            }
        }.runTaskLater(plugin, 3L * 20L);
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.sendMessage(TFM_Util.randomChatColor() + player.getName() + " Fuck off you bitch");
                player.getWorld().createExplosion(player.getLocation(), 8F);
               
            }
        }.runTaskLater(plugin, 3L * 20L);
        
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                TFM_Util.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.RED + "GTFO bitch -" + sender.getName());
            }
        }.runTaskLater(plugin, 3L * 30L);

        return true;
    }
}
*/
