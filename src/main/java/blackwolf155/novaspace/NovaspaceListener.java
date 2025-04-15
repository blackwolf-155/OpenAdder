package blackwolf155.novaspace;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NovaspaceListener implements Listener {
    //事件
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        String name = p.getName();
        event.setJoinMessage(name+"进入了游戏");
    }

    @EventHandler
    public void click(InventoryClickEvent event){
        //获取当前物品栏
        Inventory inv = event.getInventory();
        //点击者 必须是玩家
        Player player = (Player) event.getWhoClicked();
        //获取被点击的物品
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        // 判断是否为指定物品（通过材质和名称匹配）
        if (clickedItem.getType() == Material.DIAMOND
                && clickedItem.getItemMeta().getDisplayName().equals("傻逼")) {
            player.sendMessage("你点击了特殊钻石！");
            event.setCancelled(true); // 阻止玩家移动/拿走物品
        }


    }
}