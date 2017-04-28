package mod.baijson.skeleton.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by Baijson.
 */
abstract public class GrowingBlock extends GenericBlock implements IGrowingBlock {

    public static final PropertyInteger STAGES = PropertyInteger.create("stages", 0, 3);

    /**
     * @param resource
     */
    protected GrowingBlock(ResourceLocation resource) {
        this(resource, Material.PLANTS);
    }

    /**
     * @param resource
     * @param material
     */
    protected GrowingBlock(ResourceLocation resource, Material material) {
        this(resource, material, MapColor.GRASS);
    }

    /**
     * @param resource
     * @param material
     * @param mapcolor
     */
    protected GrowingBlock(ResourceLocation resource, Material material, MapColor mapcolor) {
        super(resource, material, mapcolor);

        setTickRandomly(true);
        setSoundType(SoundType.PLANT);
    }

    /**
     * @param state
     * @return
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(STAGES);
    }

    /**
     * @param meta
     * @return
     */
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(STAGES, meta);
    }

    /**
     * @return
     */
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{STAGES});
    }


    /**
     * @param world
     * @param position
     * @param value
     */
    @Override
    public void setCurrentAge(World world, BlockPos position, int value) {
        setCurrentAge(world, position, value, 2);
    }

    /**
     * @param world
     * @param position
     * @param value
     * @param flags
     */
    public void setCurrentAge(World world, BlockPos position, int value, int flags) {
        world.setBlockState(position, this.getDefaultState().withProperty(STAGES, value), flags);
    }


    /**
     * @param state
     * @param random
     * @return
     */
    public IBlockState getRandomState(IBlockState state, Random random) {
        return this.getDefaultState().withProperty(STAGES, random.nextInt(getMaximumAge()));
    }

    /**
     * @param state
     * @return
     */
    @Override
    public int getCurrentAge(IBlockState state) {
        return state.getValue(STAGES);
    }

    /**
     * @return
     */
    @Override
    public int getMaximumAge() {
        return STAGES.getAllowedValues().size() - 1;
    }


    /**
     * @param world
     * @param position
     * @param state
     * @param client
     * @return
     */
    @Override
    public boolean canGrow(World world, BlockPos position, IBlockState state, boolean client) {
        return getCurrentAge(state) < getMaximumAge();
    }

    /**
     * @param world
     * @param random
     * @param position
     * @param state
     */
    @Override
    public void grow(World world, Random random, BlockPos position, IBlockState state) {
        //
    }

    /**
     * @param world
     * @param random
     * @param position
     * @param state
     * @return
     */
    @Override
    public boolean canUseBonemeal(World world, Random random, BlockPos position, IBlockState state) {
        return true;
    }


    /**
     * @param state
     * @param rand
     * @param fortune
     * @return
     */
    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return super.getItemDropped(state, rand, fortune);
    }

    /**
     * @param state
     * @return
     */
    @Override
    public int damageDropped(IBlockState state) {
        return super.damageDropped(state);
    }
}
