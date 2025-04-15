package blackwolf155.novaspace;

import blackwolf155.novaspace.commands.*;
import blackwolf155.novaspace.shop.ShopCommand;
import blackwolf155.novaspace.test.TestCommand;
import blackwolf155.novaspace.test.TestCommandTabCompleter;
import org.bukkit.Bukkit;

public class Register {
    public static void CommandRegister(){
        Bukkit.getPluginCommand("nshelp").setExecutor(new NshelpCommand());

        Bukkit.getPluginCommand("test").setExecutor(new TestCommand());
        Bukkit.getPluginCommand("test").setTabCompleter(new TestCommandTabCompleter());

        Bukkit.getPluginCommand("get").setExecutor(new GetCommand());
        Bukkit.getPluginCommand("get").setTabCompleter(new GetCommandTabCompleter());

        Bukkit.getPluginCommand("nsget").setExecutor(new NsGetCommand());

        Bukkit.getPluginCommand("menu").setExecutor(new MenuCommand());

        Bukkit.getPluginCommand("killme").setExecutor(new KillmeCommand());

        Bukkit.getPluginCommand("nsgamemode").setExecutor(new NsgamemodeCommand());
        Bukkit.getPluginCommand("nsgamemode").setTabCompleter(new NsgamemodeTabCompleter());

        Bukkit.getPluginCommand("shop").setExecutor(new ShopCommand());

    }
}
