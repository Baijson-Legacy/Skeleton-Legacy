package mod.baijson.skeleton.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Baijson.
 */
@SideOnly(Side.CLIENT)
public class CreativeTab extends CreativeTabs {

    private ItemStack image;

    /**
     * @param label
     */
    public CreativeTab(String label) {
        this(label, new ItemStack(Blocks.COMMAND_BLOCK));
    }

    /**
     * @param label
     * @param image
     */
    public CreativeTab(String label, ItemStack image) {
        super(label);

        if (image.getItem() != null) {
            setTabIconItem(image);
        }
    }

    /**
     * @param index
     * @param label
     */
    public CreativeTab(int index, String label) {
        this(index, label, new ItemStack(Blocks.COMMAND_BLOCK));
    }

    /**
     * @param index
     * @param label
     * @param image
     */
    public CreativeTab(int index, String label, ItemStack image) {
        super(index, label);

        if (image.getItem() != null) {
            setTabIconItem(image);
        }
    }

    @Override
    public ItemStack getTabIconItem() {
        if (this.image != null && this.image != null) {
            return this.image;
        }
        return new ItemStack(Blocks.COMMAND_BLOCK);
    }

    /**
     * @param stack
     * @return
     */
    public ItemStack setTabIconItem(ItemStack stack) {
        if (stack != null && stack.getItem() != null) {
            this.image = stack;
        }
        return this.image;
    }
}