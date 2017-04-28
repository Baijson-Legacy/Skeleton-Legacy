package mod.baijson.skeleton.client.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;
import java.awt.*;

/**
 * Created by Baijson.
 */
public interface IColorAware {

    /**
     * @param value
     */
    void setColor(Color value);

    /**
     * @return
     */
    int getColor();

    /**
     * @param index
     * @return
     */
    default int getColorByIndex(int index) {
        return 0;
    }

    /**
     * @param state
     * @param world
     * @param position
     * @param index
     * @return
     */
    default int getColorByState(IBlockState state, @Nullable IBlockAccess world, @Nullable BlockPos position, int index) {
        return 0;
    }
}
