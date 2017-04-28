package mod.baijson.skeleton.blocks;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Baijson.
 */
public interface IGrowingBlock extends IGenericBlock, IGrowable {

    /**
     * @param value
     */
    void setCurrentAge(World world, BlockPos position, int value);

    /**
     * @param state
     * @return
     */
    int getCurrentAge(IBlockState state);

    /**
     * @return
     */
    default int getMaximumAge() {
        return 3;
    }
}
