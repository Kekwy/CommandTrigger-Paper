package com.kekwy.nmo.cmdtgr.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CmdtgrExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        /* 过滤其他指令 */
        if (!command.getName().equalsIgnoreCase("cmdtgr")) {
            return false;
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("You executed the custom command!");
            return true;
        }
        sender.sendMessage("This command can only be executed by a player!");
        return false;
    }

}
