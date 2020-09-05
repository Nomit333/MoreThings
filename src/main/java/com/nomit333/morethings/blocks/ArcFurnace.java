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

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 11, 7, 8, 15, 10), Block.makeCuboidShape(3, 0, 3, 13, 6, 13),
            Block.makeCuboidShape(4, 6, 4, 12, 6.5, 12), Block.makeCuboidShape(4, 9.5, 4, 12, 10.5, 12),
            Block.makeCuboidShape(4, 6.5, 7, 12, 9.5, 12), Block.makeCuboidShape(10, 6.5, 4, 12, 9.5, 7),
            Block.makeCuboidShape(6, 6.5, 4, 10, 9.5, 5), Block.makeCuboidShape(4, 6.5, 4, 6, 9.5, 7),
            Block.makeCuboidShape(6, 6, 1, 10, 6.5, 4), Block.makeCuboidShape(4.5, 10.5, 4.5, 11.5, 11, 11.5),
            Block.makeCuboidShape(4.5, 11, 4.5, 11.5, 11.5, 11.5), Block.makeCuboidShape(9, 11, 7, 10, 15, 10),
            Block.makeCuboidShape(8, 11, 7, 9, 15, 8), Block.makeCuboidShape(8, 11, 9, 9, 15, 10),
            Block.makeCuboidShape(6, 6.5, 5, 10, 9.5, 7), Block.makeCuboidShape(8, 12, 8, 9, 12, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5.40625, 11, 6.09375, 8.40625, 15, 7.09375), Block.makeCuboidShape(2.40625, 0, 2.09375, 12.40625, 6, 12.09375),
            Block.makeCuboidShape(3.40625, 6, 3.09375, 11.40625, 6.5, 11.09375), Block.makeCuboidShape(3.40625, 9.5, 3.09375, 11.40625, 10.5, 11.09375),
            Block.makeCuboidShape(3.40625, 6.5, 3.09375, 8.40625, 9.5, 11.09375), Block.makeCuboidShape(8.40625, 6.5, 9.09375, 11.40625, 9.5, 11.09375),
            Block.makeCuboidShape(10.40625, 6.5, 5.09375, 11.40625, 9.5, 9.09375), Block.makeCuboidShape(8.40625, 6.5, 3.09375, 11.40625, 9.5, 5.09375),
            Block.makeCuboidShape(11.40625, 6, 5.09375, 14.40625, 6.5, 9.09375), Block.makeCuboidShape(3.90625, 10.5, 3.59375, 10.90625, 11, 10.59375),
            Block.makeCuboidShape(3.90625, 11, 3.59375, 10.90625, 11.5, 10.59375), Block.makeCuboidShape(5.40625, 11, 8.09375, 8.40625, 15, 9.09375),
            Block.makeCuboidShape(7.40625, 11, 7.09375, 8.40625, 15, 8.09375), Block.makeCuboidShape(5.40625, 11, 7.09375, 6.40625, 15, 8.09375),
            Block.makeCuboidShape(8.40625, 6.5, 5.09375, 10.40625, 9.5, 9.09375), Block.makeCuboidShape(6.40625, 12, 7.09375, 7.40625, 12, 8.09375)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(8.3125, 11, 4.5, 9.3125, 15, 7.5), Block.makeCuboidShape(3.3125, 0, 1.5, 13.3125, 6, 11.5),
            Block.makeCuboidShape(4.3125, 6, 2.5, 12.3125, 6.5, 10.5), Block.makeCuboidShape(4.3125, 9.5, 2.5, 12.3125, 10.5, 10.5),
            Block.makeCuboidShape(4.3125, 6.5, 2.5, 12.3125, 9.5, 7.5), Block.makeCuboidShape(4.3125, 6.5, 7.5, 6.3125, 9.5, 10.5),
            Block.makeCuboidShape(6.3125, 6.5, 9.5, 10.3125, 9.5, 10.5), Block.makeCuboidShape(10.3125, 6.5, 7.5, 12.3125, 9.5, 10.5),
            Block.makeCuboidShape(6.3125, 6, 10.5, 10.3125, 6.5, 13.5), Block.makeCuboidShape(4.8125, 10.5, 3, 11.8125, 11, 10),
            Block.makeCuboidShape(4.8125, 11, 3, 11.8125, 11.5, 10), Block.makeCuboidShape(6.3125, 11, 4.5, 7.3125, 15, 7.5),
            Block.makeCuboidShape(7.3125, 11, 6.5, 8.3125, 15, 7.5), Block.makeCuboidShape(7.3125, 11, 4.5, 8.3125, 15, 5.5),
            Block.makeCuboidShape(6.3125, 6.5, 7.5, 10.3125, 9.5, 9.5), Block.makeCuboidShape(7.3125, 12, 5.5, 8.3125, 12, 6.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7.90625, 11, 7.40625, 10.90625, 15, 8.40625), Block.makeCuboidShape(3.90625, 0, 2.40625, 13.90625, 6, 12.40625),
            Block.makeCuboidShape(4.90625, 6, 3.40625, 12.90625, 6.5, 11.40625), Block.makeCuboidShape(4.90625, 9.5, 3.40625, 12.90625, 10.5, 11.40625),
            Block.makeCuboidShape(7.90625, 6.5, 3.40625, 12.90625, 9.5, 11.40625), Block.makeCuboidShape(4.90625, 6.5, 3.40625, 7.90625, 9.5, 5.40625),
            Block.makeCuboidShape(4.90625, 6.5, 5.40625, 5.90625, 9.5, 9.40625), Block.makeCuboidShape(4.90625, 6.5, 9.40625, 7.90625, 9.5, 11.40625),
            Block.makeCuboidShape(1.90625, 6, 5.40625, 4.90625, 6.5, 9.40625), Block.makeCuboidShape(5.40625, 10.5, 3.90625, 12.40625, 11, 10.90625),
            Block.makeCuboidShape(5.40625, 11, 3.90625, 12.40625, 11.5, 10.90625), Block.makeCuboidShape(7.90625, 11, 5.40625, 10.90625, 15, 6.40625),
            Block.makeCuboidShape(7.90625, 11, 6.40625, 8.90625, 15, 7.40625), Block.makeCuboidShape(9.90625, 11, 6.40625, 10.90625, 15, 7.40625),
            Block.makeCuboidShape(5.90625, 6.5, 5.40625, 7.90625, 9.5, 9.40625), Block.makeCuboidShape(8.90625, 12, 6.40625, 9.90625, 12, 7.40625)
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
                return SHAPE_N;
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

