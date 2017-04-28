package mod.baijson.skeleton.items.foods;

import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Baijson.
 */
public class GenericItemFood extends ItemFood implements IGenericItemFood {

    protected ResourceLocation resource;

    /**
     * @param resource
     */
    protected GenericItemFood(ResourceLocation resource) {
        this(resource, 0);
    }

    /**
     * @param resource
     * @param amount
     */
    protected GenericItemFood(ResourceLocation resource, int amount) {
        this(resource, amount, 0.0F);
    }

    /**
     * @param resource
     * @param amount
     * @param saturation
     */
    protected GenericItemFood(ResourceLocation resource, int amount, float saturation) {
        this(resource, amount, saturation, false);
    }

    /**
     * @param resource
     * @param amount
     * @param saturation
     * @param wolfsfood
     */
    protected GenericItemFood(ResourceLocation resource, int amount, float saturation, boolean wolfsfood) {
        super(amount, saturation, wolfsfood);

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
