package klouvEffectItem.listener;

import de.tr7zw.changeme.nbtapi.NBTItem;
import klouvEffectItem.KlouvEffectItem;
import klouvEffectItem.base.KlouvItem;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;

import java.util.List;
import java.util.Map;

public class EffectListener implements Listener {

    private Map<String, KlouvItem> map;

    public EffectListener(KlouvEffectItem main) {
        this.map = main.map;
    }

    public void onConsumeEvent(PlayerItemConsumeEvent event) {
        NBTItem item = new NBTItem(event.getItem());
        if (!(item.hasKey("id"))) return;

        Player player = event.getPlayer();
        String id = item.getString("id");

        List<PotionEffect> effects = map.get(id).effect();

        //player.addPotionEffect();//burayı yap
    }

}
