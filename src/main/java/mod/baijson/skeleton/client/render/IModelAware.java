package mod.baijson.skeleton.client.render;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Baijson.
 */
public interface IModelAware {

    /**
     * @return
     */
    @SideOnly(Side.CLIENT)
    default String[] getModelVariants() {
        return new String[0];
    }
}
