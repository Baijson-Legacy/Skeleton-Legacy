package mod.baijson.skeleton.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Baijson.
 */
abstract public class GenericItem extends Item implements IGenericItem {

    protected ResourceLocation resource;

    /**
     * @param resource
     */
    protected GenericItem(ResourceLocation resource) {
        super();

        this.resource = resource;

        setRegistryName(resource);
        setUnlocalizedName(resource.getResourcePath());
    }

    /**
     *
     */
    protected void register() {
        GameRegistry.register(this);
    }
}
