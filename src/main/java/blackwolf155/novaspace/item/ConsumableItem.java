package blackwolf155.novaspace.item;

import org.bukkit.Material;

// 消耗类道具类
public class ConsumableItem extends Weapon {
    public ConsumableItem(String name, String itemDisplayName, String itemModel, Material material) {
        super(material, name, itemDisplayName, itemModel);
    }
}
