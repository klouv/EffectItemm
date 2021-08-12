package klouvEffectItem;

import com.cryptomorin.xseries.XItemStack;
import klouvEffectItem.Command.GiveItem;
import klouvEffectItem.base.KlouvItem;
import klouvEffectItem.file.ConfigFile;
import klouvEffectItem.listener.EffectListener;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KlouvEffectItem extends JavaPlugin implements Listener {

    private ConfigFile config;
    public Map<String, KlouvItem> map = new HashMap<>();

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EffectListener(this),this);

        config = new ConfigFile(this, "config");
        getCommand("itemver").setExecutor(new GiveItem(this));

        List<PotionEffect> list = null;
        for (String key: config.getKeys(false)) {
            ConfigurationSection section = config.getConfigurationSection(key);

            ItemStack item = XItemStack.deserialize(section.getConfigurationSection("item"));
            ConfigurationSection effects = section.getConfigurationSection("effects");

            for (String Key: effects.getKeys(false)) {
                //list.add();//burayı doldur

            }
            KlouvItem Kitem = new KlouvItem(key, item, list);
            map.put(key, Kitem);
        }

    }


    @Override
    public void onDisable() {




    }
}
