package net.boster.bamboss.coins.api;

import net.boster.bamboss.coins.BambossCoins;
import net.boster.bamboss.coins.utils.Utils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BambossCoinsAPI {

    public static void earnCoins(@NotNull Player p, int amount) {
        addCoins(p, amount);
        BambossCoins.getInstance().getConfig().getStringList("Messages.coinsEarned").forEach(s -> {
            p.sendMessage(Utils.toColor(s.replace("%coins%", amount + "")));
        });
    }

    public static void addCoins(@NotNull Player p, int amount) {
        BambossCoins.getInstance().getPlayerData(p).add(amount);
    }

    public static void withdrawCoins(@NotNull Player p, int amount) {
        BambossCoins.getInstance().getPlayerData(p).subtract(amount);
    }

    public static void setCoins(@NotNull Player p, int amount) {
        BambossCoins.getInstance().getPlayerData(p).set(amount);
    }

    public static int getCoins(@NotNull Player p) {
        return BambossCoins.getInstance().getPlayerData(p).get();
    }
}
