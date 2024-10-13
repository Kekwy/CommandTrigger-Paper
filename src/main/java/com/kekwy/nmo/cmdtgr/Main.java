package com.kekwy.nmo.cmdtgr;

import com.kekwy.nmo.cmdtgr.executor.CmdtgrExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        /* 注册指令，并指定指令处理器 */
        Objects.requireNonNull(this.getCommand("cmdtgr")).setExecutor(new CmdtgrExecutor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
