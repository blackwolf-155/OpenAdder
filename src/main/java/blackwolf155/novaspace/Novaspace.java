package blackwolf155.novaspace;

import blackwolf155.novaspace.database.DatabaseManager;
import blackwolf155.novaspace.item.ConfigManager;
import blackwolf155.novaspace.menu.MenuListener;
import blackwolf155.novaspace.shop.ShopManager;
import me.yic.xconomy.api.XConomyAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import static blackwolf155.novaspace.Register.CommandRegister;


public final class Novaspace extends JavaPlugin {
    private static Novaspace instance;

    private XConomyAPI xcapi;
    private ShopManager shopManager;
    private ConfigManager configManager;
    private DatabaseManager databaseManager;

    private static Logger logger;

    @Override
    public void onEnable() {
        logger = this.getSLF4JLogger();

        // 首先设置实例
        instance = this;
        // 初始化 XConomy API
        try {
            this.xcapi = new XConomyAPI();
            checkAPIVersion();
        } catch (NoClassDefFoundError e) {
            getLogger().severe("XConomy依赖未加载，请确认已安装XConomy插件");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        logger.info("已加载 XConomy"  + xcapi.getversion());


        // 配置文件初始化
        saveResource("config.yml", false);
        saveResource("shop.yml", true);
        saveResource("weapon.yml", true);
        //创建配置管理器
        configManager = new ConfigManager();

        // 初始化商店管理器
        shopManager = new ShopManager();

        // 初始化数据库
        databaseManager = new DatabaseManager(getDataFolder().getAbsolutePath());

        // 注册指令
        CommandRegister();

        // 最后注册事件
        Bukkit.getPluginManager().registerEvents(new NovaspaceListener(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);


        logger.info("星域服务器插件启动了");
    }

    // 版本兼容性校验
    private void checkAPIVersion() {
        if (xcapi.getversion().compareTo("2.26.3") < 0) {
            getLogger().warning("推荐使用XConomy v2.26.3版本，当前版本：" + xcapi.getversion());
        }
    }

    public static Novaspace getInstance() {
        return instance;
    }

    public XConomyAPI getXconomyAPI() {
        return xcapi;
    }
    public ShopManager getShopManager() {
        return shopManager;
    }
    public ConfigManager getConfigManager() {
        return configManager;
    }
    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger = this.getSLF4JLogger();
        logger.info("星域服务器插件关闭了");
    }



}
