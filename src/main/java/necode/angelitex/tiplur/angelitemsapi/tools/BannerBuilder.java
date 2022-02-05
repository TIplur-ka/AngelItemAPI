package necode.angelitex.tiplur.angelitemsapi.tools;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class BannerBuilder {
    /**
     * Created by TIplur 05.02.2022
     */
    private BannerMeta bm;
    private ItemStack item;

    /**
     * @param banner item banner
     */
    public BannerBuilder(ItemStack banner) {
        this.item = banner;
        this.bm = (BannerMeta)this.item.getItemMeta();
    }

    /**
     * @param color set color based banner
     */
    public BannerBuilder setBasecolor(DyeColor color) {
        this.bm.setBaseColor(color);
        return this;
    }

    /**
     * @param color set color pattern your banner
     * @param pattern set pattern your banner
     */
    public BannerBuilder addPattern(DyeColor color, PatternType pattern) {
        this.bm.addPattern(new Pattern(color, pattern));
        return this;
    }

    public BannerBuilder buildItemMeta() {
        this.item.setItemMeta(this.bm);
        return this;
    }

    public ItemStack build() {
        return this.item;
    }
}
