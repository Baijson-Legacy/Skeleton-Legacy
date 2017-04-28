package mod.baijson.skeleton.items.tools;

import mod.baijson.skeleton.items.GenericItem;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Baijson.
 */
public class GenericItemTool extends GenericItem implements IGenericItemTool {

    /**
     * @param resource
     */
    protected GenericItemTool(ResourceLocation resource) {
        super(resource);

        this.setMaxStackSize(1);
    }
}
