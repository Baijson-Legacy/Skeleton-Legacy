package mod.baijson.skeleton.blocks;

import mod.baijson.skeleton.client.Tooltip;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

/**
 * Created by Baijson.
 */
abstract public class GenericBlock extends Block implements IGenericBlock {

    protected ResourceLocation resource;

    /**
     * @param resource
     */
    protected GenericBlock(ResourceLocation resource) {
        this(resource, Material.ROCK);
    }

    /**
     * @param resource
     * @param material
     */
    protected GenericBlock(ResourceLocation resource, Material material) {
        this(resource, material, MapColor.STONE);
    }

    /**
     * @param resource
     * @param material
     * @param mapcolor
     */
    protected GenericBlock(ResourceLocation resource, Material material, MapColor mapcolor) {
        super(material, mapcolor);

        this.resource = resource;
        this.setRegistryName(resource);
        this.setUnlocalizedName(resource.getResourcePath());
    }

    /**
     *
     */
    public void register() {
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this).setRegistryName(this.resource));
    }
}
