package necode.angelitex.tiplur.angelitemsapi.tools;

import java.util.Iterator;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BookBuilder {
    private BookMeta bm;
    private ItemStack item;

    /**
     * @param writtenbook book
     */
    public BookBuilder(ItemStack writtenbook) {
        this.item = writtenbook;
        this.bm = (BookMeta)this.item.getItemMeta();
    }

    /**
     * @param name Author name
     */
    public BookBuilder setAuthor(String name) {
        this.bm.setAuthor(name);
        return this;
    }

    /**
     * @param content add page your book
     */
    public BookBuilder addPage(String... content) {
        this.bm.addPage(content);
        return this;
    }

    /**
     * @param contents add pages your book
     */
    public BookBuilder addPages(List<String> contents) {

        for (String content : contents) {
            this.bm.addPage(new String[]{content});
        }

        return this;
    }

    public int getPageCount() {
        return this.bm.getPageCount();
    }

    public BookBuilder buildItemMeta() {
        this.item.setItemMeta(this.bm);
        return this;
    }

    public ItemStack build() {
        return this.item;
    }
}