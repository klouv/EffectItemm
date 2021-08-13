package klouvEffectItem.Command;

import com.sun.tools.javac.Main;
import klouvEffectItem.KlouvEffectItem;
import klouvEffectItem.base.KlouvItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.List;
import java.util.Map;

public class GiveItem implements CommandExecutor {

    private Map<String, KlouvItem> map;

    public GiveItem(KlouvEffectItem main) {
        this.map = main.map;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        if (args.length != 1){
            if (args.length != 0) return true;
            Player player = (Player) sender;

            map.forEach((k,l) -> {
                player.sendMessage("id: " + k);
            } );

            return true;
        }

        Player player = (Player) sender;
        KlouvItem Kitem = map.get(args[0]);
        ItemStack item = Kitem.item();

        player.getInventory().addItem(item);
        player.sendMessage("item başarıyla envanterinize eklendi");
        return true;
    }

}
