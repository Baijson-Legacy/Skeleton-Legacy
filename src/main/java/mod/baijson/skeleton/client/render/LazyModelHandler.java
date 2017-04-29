package mod.baijson.skeleton.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;

/**
 * Created by Baijson.
 */
@SideOnly(Side.CLIENT)
public class LazyModelHandler {

    /**
     * @param clazz
     */
    public static void load(Class<? extends IMarkedLazy> clazz) {
        try {
            for (Field field : clazz.getFields()) {
                if (field.get(null) != null) {
                    if (Block.class.isAssignableFrom(field.get(null).getClass())) {
                        Block block = (Block) field.get(null);
                        if (block instanceof IModelAware || block instanceof IStateAware) {
                            if (block instanceof IModelAware) {
                                Item item = Item.getItemFromBlock(block);
                                if (item instanceof ItemBlock) {
                                    register(item, ((IModelAware) block).getModelVariants());
                                }
                                ModelBakery.registerItemVariants(item, item.getRegistryName());
                            }
                            if (block instanceof IStateAware) {
                                ModelLoader.setCustomStateMapper(block, ((IStateAware) block).getStateMapper());
                            }
                        } else {
                            register(Item.getItemFromBlock(block));
                        }
                    }
                    if (Item.class.isAssignableFrom(field.get(null).getClass())) {
                        Item item = (Item) field.get(null);
                        if (item instanceof IModelAware) {
                            register(item, ((IModelAware) item).getModelVariants());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param item
     */
    private static void register(Item item) {
        register(item, new String[]{});
    }

    /**
     * @param item
     * @param variants
     */
    private static void register(Item item, String[] variants) {
        if (variants.length > 0) {
            for (int i = 0; i < variants.length; i++) {
                ModelLoader.registerItemVariants(item, new ModelResourceLocation(item.getRegistryName(), variants[i]));
                ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), variants[i]));
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
        }
    }
}
