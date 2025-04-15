package blackwolf155.novaspace.item;

import blackwolf155.novaspace.Novaspace;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;

import static net.kyori.adventure.text.Component.text;

//这是一个用来描述星域服务器基础物品的类
public class Weapon {
    private static final Logger log = LoggerFactory.getLogger(Weapon.class);
    //结构
    Material material;
    private final String name;  // 唯一标识
    private final String itemDisplayName;  // 物品名称
    private final String itemModel; // 物品模型

    ItemStack itemStack;


    //初始化物品
    public Weapon(Material material, String name, String itemDisplayName, String itemModel) {
        this.material = material;
        this.name = name;
        this.itemDisplayName = itemDisplayName;
        this.itemModel = itemModel;
        init();
    }

    public Weapon(String name){
        this.name = name;
        ConfigurationSection weapons = Novaspace.getInstance().getConfigManager().getWeaponsSection();
        material = Material.getMaterial(Objects.requireNonNull(weapons.getString(name+".material")));
        itemDisplayName = weapons.getString(name+".display_name");
        itemModel = weapons.getString(name+".item_model");
        init();
    }

    private void init(){
        //创建物品实例
        itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        //物品名（唯一标识）
        final Component component = text()
                .content(name)
                .build();
        itemMeta.itemName(component);
        //物品显示名称
        final Component component2 = text()
                .content(itemDisplayName)
                .build();
        itemMeta.customName(component2);
        //物品模型
        itemMeta.setItemModel(new NamespacedKey(Novaspace.getInstance(),itemModel));

        itemStack.setItemMeta(itemMeta);
    }

    public ItemStack getItemStack(){
        return itemStack;
    }

    public String getName() { return name; }
    public String getItemDisplayName() { return itemDisplayName; }
    public String getItemModel() { return itemModel; }

}
