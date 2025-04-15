package blackwolf155.novaspace.item;

import blackwolf155.novaspace.Novaspace;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    private final YamlConfiguration weaponConfig;
    private final YamlConfiguration toolConfig;
    private final ConfigurationSection weaponsSection;
    private final ConfigurationSection toolsSection;

    public ConfigManager() {

        //读取weapon.yml
        File file1 = new File(Novaspace.getInstance().getDataFolder(), "weapon.yml");
        weaponConfig = YamlConfiguration.loadConfiguration(file1);

        //读取tool.yml
        File file2 = new File(Novaspace.getInstance().getDataFolder(), "tool.yml");
        toolConfig = YamlConfiguration.loadConfiguration(file2);

        weaponsSection = weaponConfig.getConfigurationSection("weapons");
        toolsSection = toolConfig.getConfigurationSection("tools");
    }

    public ConfigurationSection getWeaponsSection() { return weaponsSection; }
    public ConfigurationSection getToolsSection() { return toolsSection; }

}
