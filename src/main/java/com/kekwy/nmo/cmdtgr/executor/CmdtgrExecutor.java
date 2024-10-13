package com.kekwy.nmo.cmdtgr.executor;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class CmdtgrExecutor implements CommandExecutor {

    private final Logger logger;
    private final Plugin plugin;

    public CmdtgrExecutor(Logger logger, Plugin plugin) {
        this.logger = logger;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        /* 过滤其他指令 */
        if (!command.getName().equalsIgnoreCase("cmdtgr")) {
            return false;
        }

        String playerName = args[0];
        Player player = Bukkit.getPlayerExact(playerName);

        if (player != null && player.isOnline()) {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                builder.append(args[i]);
                builder.append(" ");
            }
            player.sendPluginMessage(plugin,  // 使用自定义消息通道发送消息到指定玩家
                    "cmdtgr:channel", builder.toString().getBytes());
        } else {
            sender.sendMessage("Player not found or not online.");
        }

        return true;
    }

}
