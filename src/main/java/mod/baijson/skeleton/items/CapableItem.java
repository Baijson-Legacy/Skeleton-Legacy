package mod.baijson.skeleton.items;

import mod.baijson.skeleton.tiles.ICapableTileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
abstract public class CapableItem<T extends ICapableTileEntity> extends GenericItem implements ICapableItem<T> {

    /**
     * @param resource
     */
    protected CapableItem(ResourceLocation resource) {
        super(resource);
    }
}
