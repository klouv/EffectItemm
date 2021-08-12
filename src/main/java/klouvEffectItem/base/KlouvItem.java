package klouvEffectItem.base;

import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public class KlouvItem {

    private String name;
    private List<PotionEffect> list;
    private ItemStack itemStack;

    public KlouvItem(String name, ItemStack itemStack, List<PotionEffect> list) {
        this.name = name;
        this.itemStack = itemStack;
        this.list = list;
    }

    public List<PotionEffect> effect() {
        return list;
    }

    public ItemStack item() {
        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setString("id",name);
        ItemStack items = nbtItem.getItem();

        return items;
    }
    public String name() {return name;}


}



