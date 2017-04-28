package mod.baijson.skeleton.client.render;

import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Baijson.
 */
public interface IStateAware {

    /**
     * @return
     */
    @SideOnly(Side.CLIENT)
    IStateMapper getStateMapper();
}
