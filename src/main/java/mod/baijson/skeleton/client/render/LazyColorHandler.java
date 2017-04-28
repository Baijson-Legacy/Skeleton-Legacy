package mod.baijson.skeleton.client.render;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

/**
 * Created by Baijson.
 */
@SideOnly(Side.CLIENT)
public class LazyColorHandler {

    private static final Minecraft minecraft = Minecraft.getMinecraft();

    /**
     * @param clazz
     */
    public static void load(Class<? extends IMarkedLazy> clazz) {
        try {
            for (Field field : clazz.getFields()) {
                if (Block.class.isAssignableFrom(field.get(null).getClass())) {
                    Block block = (Block) field.get(null);
                    if (block instanceof IColorAware) {
                        register(block);
                    }
                }
                if (Item.class.isAssignableFrom(field.get(null).getClass())) {
                    Item item = (Item) field.get(null);
                    if (item instanceof IColorAware) {
                        register(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param block
     */
    private static void register(Block block) {
        minecraft.getBlockColors().registerBlockColorHandler(new BlockColorHandler(), block);
    }

    /**
     * @param item
     */
    private static void register(Item item) {
        minecraft.getItemColors().registerItemColorHandler(new ItemsColorHandler(), item);
    }

    /**
     *
     */
    @SideOnly(Side.CLIENT)
    public static class BlockColorHandler implements IBlockColor, IItemColor {

        /**
         * @param state
         * @param world
         * @param position
         * @param index
         * @return
         */
        @Override
        public int colorMultiplier(IBlockState state, @Nullable IBlockAccess world, @Nullable BlockPos position, int index) {
            return ((IColorAware) state.getBlock()).getColorByState(state, world, position, index);
        }

        /**
         * @param stack
         * @param index
         * @return
         */
        @Override
        public int getColorFromItemstack(ItemStack stack, int index) {
            return ((IColorAware) stack.getItem()).getColorByIndex(index);
        }
    }

    /**
     *
     */
    @SideOnly(Side.CLIENT)
    public static class ItemsColorHandler implements IItemColor {

        /**
         * @param stack
         * @param index
         * @return
         */
        @Override
        public int getColorFromItemstack(ItemStack stack, int index) {
            return ((IColorAware) stack.getItem()).getColorByIndex(index);
        }
    }
}

