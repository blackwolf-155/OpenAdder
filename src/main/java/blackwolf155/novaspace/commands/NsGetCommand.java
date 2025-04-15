package blackwolf155.novaspace.commands;

import blackwolf155.novaspace.Novaspace;
import blackwolf155.novaspace.item.Weapon;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class NsGetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        //判断是不是玩家
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§c只有玩家可以执行此命令");
            return true;
        }

        if (args.length < 1 || args.length > 2) return false;

        if (args[0].equalsIgnoreCase("list")) {
            player.sendMessage("可以获取的物品如下:");
            return true;
        }

        try {
            int amount = args.length == 2 ? Integer.parseInt(args[1]) : 1;
            switch (args[0].toLowerCase()) {
                case "dirt": {
                    ItemStack dirt = new ItemStack(Material.DIRT, amount);
                    player.getInventory().addItem(dirt);
                    return true;
                }
                case "my_sword": {
                    Weapon weapon = new Weapon("my_sword");
                    player.getInventory().addItem(weapon.getItemStack());

                    return true;
                }
                default: {
                    player.sendMessage("§c未知物品类型: " + args[0]);
                    return true;
                }
            }

        } catch (NumberFormatException e) {
            player.sendMessage("§c数量参数无效");
        }


        return false;
    }

    // 创建菜单钥匙
    private ItemStack createMenuKey(int amount) {
        ItemStack menuKey = new ItemStack(Material.CLOCK, amount);
        ItemMeta meta = menuKey.getItemMeta();

        // 添加特殊显示属性
        meta.setDisplayName("§6服务器菜单钥匙");
        meta.setLore(Arrays.asList("§e点击打开服务器菜单", "§7通过/get menu获取"));

        menuKey.setItemMeta(meta);
        return menuKey;
    }
}

