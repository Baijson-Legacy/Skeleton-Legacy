package mod.baijson.skeleton.world;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;

/**
 * Created by Baijson.
 */
public class WorldgenBlockValidation {

    /**
     * @param world
     * @param position
     * @return
     */
    public static boolean validate(World world, BlockPos position) {
        return !world.getBlockState(position).isOpaqueCube();
    }

    /**
     * @param world
     * @param position
     * @param blocksBelow
     * @return
     */
    public static boolean validate(World world, BlockPos position, ArrayList<Block> blocksBelow) {
        return validate(world, position, blocksBelow, null);
    }

    /**
     * @param world
     * @param position
     * @param blocksBelow
     * @param blocksAbove
     * @return
     */
    public static boolean validate(World world, BlockPos position, ArrayList<Block> blocksBelow, @Nullable ArrayList<Block> blocksAbove) {
        if (validate(world, position)) {
            if (blocksAbove != null && !blocksAbove.isEmpty()) {
                return blocksBelow.contains(get(world, position.down())) && blocksAbove.contains(get(world, position.up()));
            }
            return blocksBelow.contains(get(world, position.down()));
        }
        return false;
    }

    /**
     * @param world
     * @param position
     * @return
     */
    private static Block get(World world, BlockPos position) {
        return world.getBlockState(position).getBlock();
    }
}
