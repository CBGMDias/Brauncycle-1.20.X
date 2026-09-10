package br.com.cbgmdias.brauncycle.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * A low, decorative pile that keeps its collision and selection shape close to
 * the Blockbench model instead of behaving like a full cube.
 */
public class TrashPileBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 0.0D, 14.0D, 4.5D, 16.0D);

    public TrashPileBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
