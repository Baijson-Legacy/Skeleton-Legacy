package mod.baijson.skeleton.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Baijson.
 */
public class WorldgenPlaceValidation {

    /**
     * @return
     */
    public static BlockPos getValidGroundPosition(World world, BlockPos position) {

        int resultY = -1;
        int heightY = world.getHeight(position).getY();

        if (WorldgenBlockValidation.validate(world, position))
            return position;

        do {
            if (WorldgenBlockValidation.validate(world, new BlockPos(position.getX(), heightY, position.getZ()))) {
                resultY = heightY;
            }
            heightY--;
        } while (heightY > 0);

        return new BlockPos(position.getX(), resultY, position.getZ());
    }
}
