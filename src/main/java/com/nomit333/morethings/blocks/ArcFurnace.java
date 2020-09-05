package com.nomit333.morethings.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ArcFurnace extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_D = Stream.of(
            Block.makeCuboidShape(4, 9, -4, 12, 10, 2), Block.makeCuboidShape(0, 0, 0, 16, 9, 16),
            Block.makeCuboidShape(0, 9, 0, 16, 10, 16), Block.makeCuboidShape(0, 16, 0, 16, 18, 16),
            Block.makeCuboidShape(1, 18, 1, 15, 19, 15), Block.makeCuboidShape(1, 19, 1, 15, 20, 15),
            Block.makeCuboidShape(0, 10, 6, 16, 16, 16), Block.makeCuboidShape(12, 10, 0, 16, 16, 6),
            Block.makeCuboidShape(0, 10, 0, 4, 16, 6), Block.makeCuboidShape(4, 10, 1, 12, 16, 3),
            Block.makeCuboidShape(4, 10, 0, 12, 16, 2), Block.makeCuboidShape(10, 20, 8, 12, 28, 14),
            Block.makeCuboidShape(6, 20, 8, 10, 28, 10), Block.makeCuboidShape(6, 20, 10, 10, 20, 12),
            Block.makeCuboidShape(4, 20, 8, 6, 28, 14), Block.makeCuboidShape(6, 20, 12, 10, 28, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(4, 9, -4, 12, 10, 2), Block.makeCuboidShape(0, 0, 0, 16, 9, 16),
            Block.makeCuboidShape(0, 9, 0, 16, 10, 16), Block.makeCuboidShape(0, 16, 0, 16, 18, 16),
            Block.makeCuboidShape(1, 18, 1, 15, 19, 15), Block.makeCuboidShape(1, 19, 1, 15, 20, 15),
            Block.makeCuboidShape(0, 10, 6, 16, 16, 16), Block.makeCuboidShape(12, 10, 0, 16, 16, 6),
            Block.makeCuboidShape(0, 10, 0, 4, 16, 6), Block.makeCuboidShape(4, 10, 1, 12, 16, 3),
            Block.makeCuboidShape(4, 10, 0, 12, 16, 2), Block.makeCuboidShape(10, 20, 8, 12, 28, 14),
            Block.makeCuboidShape(6, 20, 8, 10, 28, 10), Block.makeCuboidShape(6, 20, 10, 10, 20, 12),
            Block.makeCuboidShape(4, 20, 8, 6, 28, 14), Block.makeCuboidShape(6, 20, 12, 10, 28, 14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(14.125, 9, 4.125, 20.125, 10, 12.125), Block.makeCuboidShape(0.125, 0, 0.125, 16.125, 9, 16.125),
            Block.makeCuboidShape(0.125, 9, 0.125, 16.125, 10, 16.125), Block.makeCuboidShape(0.125, 16, 0.125, 16.125, 18, 16.125),
            Block.makeCuboidShape(1.125, 18, 1.125, 15.125, 19, 15.125), Block.makeCuboidShape(1.125, 19, 1.125, 15.125, 20, 15.125),
            Block.makeCuboidShape(0.125, 10, 0.125, 10.125, 16, 16.125), Block.makeCuboidShape(10.125, 10, 12.125, 16.125, 16, 16.125),
            Block.makeCuboidShape(10.125, 10, 0.125, 16.125, 16, 4.125), Block.makeCuboidShape(13.125, 10, 4.125, 15.125, 16, 12.125),
            Block.makeCuboidShape(14.125, 10, 4.125, 16.125, 16, 12.125), Block.makeCuboidShape(2.125, 20, 10.125, 8.125, 28, 12.125),
            Block.makeCuboidShape(6.125, 20, 6.125, 8.125, 28, 10.125), Block.makeCuboidShape(4.125, 20, 6.125, 6.125, 20, 10.125),
            Block.makeCuboidShape(2.125, 20, 4.125, 8.125, 28, 6.125), Block.makeCuboidShape(2.125, 20, 6.125, 4.125, 28, 10.125)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(4, 9, 14.25, 12, 10, 20.25), Block.makeCuboidShape(0, 0, 0.25, 16, 9, 16.25),
            Block.makeCuboidShape(0, 9, 0.25, 16, 10, 16.25), Block.makeCuboidShape(0, 16, 0.25, 16, 18, 16.25),
            Block.makeCuboidShape(1, 18, 1.25, 15, 19, 15.25), Block.makeCuboidShape(1, 19, 1.25, 15, 20, 15.25),
            Block.makeCuboidShape(0, 10, 0.25, 16, 16, 10.25), Block.makeCuboidShape(0, 10, 10.25, 4, 16, 16.25),
            Block.makeCuboidShape(12, 10, 10.25, 16, 16, 16.25), Block.makeCuboidShape(4, 10, 13.25, 12, 16, 15.25),
            Block.makeCuboidShape(4, 10, 14.25, 12, 16, 16.25), Block.makeCuboidShape(4, 20, 2.25, 6, 28, 8.25),
            Block.makeCuboidShape(6, 20, 6.25, 10, 28, 8.25), Block.makeCuboidShape(6, 20, 4.25, 10, 20, 6.25),
            Block.makeCuboidShape(10, 20, 2.25, 12, 28, 8.25), Block.makeCuboidShape(6, 20, 2.25, 10, 28, 4.25)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(-4.125, 9, 4.125, 1.875, 10, 12.125), Block.makeCuboidShape(-0.125, 0, 0.125, 15.875, 9, 16.125),
            Block.makeCuboidShape(-0.125, 9, 0.125, 15.875, 10, 16.125), Block.makeCuboidShape(-0.125, 16, 0.125, 15.875, 18, 16.125),
            Block.makeCuboidShape(0.875, 18, 1.125, 14.875, 19, 15.125), Block.makeCuboidShape(0.875, 19, 1.125, 14.875, 20, 15.125),
            Block.makeCuboidShape(5.875, 10, 0.125, 15.875, 16, 16.125), Block.makeCuboidShape(-0.125, 10, 0.125, 5.875, 16, 4.125),
            Block.makeCuboidShape(-0.125, 10, 12.125, 5.875, 16, 16.125), Block.makeCuboidShape(0.875, 10, 4.125, 2.875, 16, 12.125),
            Block.makeCuboidShape(-0.125, 10, 4.125, 1.875, 16, 12.125), Block.makeCuboidShape(7.875, 20, 4.125, 13.875, 28, 6.125),
            Block.makeCuboidShape(7.875, 20, 6.125, 9.875, 28, 10.125), Block.makeCuboidShape(9.875, 20, 6.125, 11.875, 20, 10.125),
            Block.makeCuboidShape(7.875, 20, 10.125, 13.875, 28, 12.125), Block.makeCuboidShape(11.875, 20, 6.125, 13.875, 28, 10.125)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ArcFurnace() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(2.5f, 3.5f)
                .sound(SoundType.METAL)
                .harvestLevel(1)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_D;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }



    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.5F;
    }
}

