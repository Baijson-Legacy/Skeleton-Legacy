package mod.baijson.skeleton.blocks;

import mod.baijson.skeleton.tiles.ICapableTileEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
abstract public class CapableBlock<T extends ICapableTileEntity> extends GenericBlock implements ICapableBlock<T> {

    /**
     * @param resource
     */
    protected CapableBlock(ResourceLocation resource) {
        this(resource, Material.IRON);
    }

    /**
     * @param resource
     * @param material
     */
    protected CapableBlock(ResourceLocation resource, Material material) {
        this(resource, material, MapColor.IRON);
    }

    /**
     * @param resource
     * @param material
     * @param mapcolor
     */
    protected CapableBlock(ResourceLocation resource, Material material, MapColor mapcolor) {
        super(resource, material, mapcolor);
    }
}
