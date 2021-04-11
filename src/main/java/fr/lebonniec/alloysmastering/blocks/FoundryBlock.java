package fr.lebonniec.alloysmastering.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;


public class FoundryBlock
        extends Block
{

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


    public FoundryBlock(Properties properties)
    {

        super(properties);

        this.setDefaultState(this.stateContainer.getBaseState()
                                                .with(FACING,
                                                      Direction.NORTH
                                                ));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {

        switch (state.get(FACING))
        {
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            case EAST:
                return SHAPE_EAST;
            default:
                return SHAPE_NORTH;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {

        return this.getDefaultState()
                   .with(FACING,
                         context.getPlacementHorizontalFacing()
                                .getOpposite()
                   );
    }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {

        super.fillStateContainer(builder);
        builder.add(FACING);
    }


    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {

        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction)
    {

        return state.with(FACING,
                          direction.rotate(state.get(FACING))
        );
    }


    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.makeCuboidShape(0,
                                  0,
                                  0,
                                  16,
                                  1,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  5,
                                  1,
                                  15,
                                  6,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  1,
                                  15,
                                  15,
                                  2,
                                  16
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  0,
                                  16,
                                  14,
                                  1
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  1,
                                  1,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(15,
                                  1,
                                  1,
                                  16,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(10,
                                  3,
                                  15,
                                  12,
                                  4,
                                  16
            ),
            Block.makeCuboidShape(7,
                                  3,
                                  15,
                                  9,
                                  4,
                                  16
            ),
            Block.makeCuboidShape(4,
                                  3,
                                  15,
                                  6,
                                  4,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  3,
                                  15,
                                  3,
                                  4,
                                  16
            ),
            Block.makeCuboidShape(13,
                                  3,
                                  15,
                                  15,
                                  4,
                                  16
            ),
            Block.makeCuboidShape(12,
                                  2,
                                  15,
                                  13,
                                  5,
                                  16
            ),
            Block.makeCuboidShape(9,
                                  2,
                                  15,
                                  10,
                                  5,
                                  16
            ),
            Block.makeCuboidShape(6,
                                  2,
                                  15,
                                  7,
                                  5,
                                  16
            ),
            Block.makeCuboidShape(3,
                                  2,
                                  15,
                                  4,
                                  5,
                                  16
            ),
            Block.makeCuboidShape(10,
                                  14,
                                  5,
                                  13,
                                  16,
                                  8
            ),
            Block.makeCuboidShape(1,
                                  13,
                                  1,
                                  15,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(12,
                                  8,
                                  15,
                                  13,
                                  9,
                                  16
            ),
            Block.makeCuboidShape(13,
                                  8,
                                  14,
                                  14,
                                  9,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  6,
                                  13,
                                  15,
                                  13,
                                  14
            )
    )
                                                        .reduce((v1, v2) ->
                                                                    {
                                                                    return VoxelShapes.combineAndSimplify(v1,
                                                                                                          v2,
                                                                                                          IBooleanFunction.OR
                                                                    );
                                                                    })
                                                        .get();

    private static final VoxelShape SHAPE_WEST = Stream.of(
            Block.makeCuboidShape(0,
                                  0,
                                  0,
                                  16,
                                  1,
                                  16
            ),
            Block.makeCuboidShape(0,
                                  5,
                                  1,
                                  15,
                                  6,
                                  15
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  1,
                                  1,
                                  2,
                                  15
            ),
            Block.makeCuboidShape(15,
                                  1,
                                  0,
                                  16,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  0,
                                  15,
                                  14,
                                  1
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  15,
                                  15,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(0,
                                  3,
                                  10,
                                  1,
                                  4,
                                  12
            ),
            Block.makeCuboidShape(0,
                                  3,
                                  7,
                                  1,
                                  4,
                                  9
            ),
            Block.makeCuboidShape(0,
                                  3,
                                  4,
                                  1,
                                  4,
                                  6
            ),
            Block.makeCuboidShape(0,
                                  3,
                                  1,
                                  1,
                                  4,
                                  3
            ),
            Block.makeCuboidShape(0,
                                  3,
                                  13,
                                  1,
                                  4,
                                  15
            ),
            Block.makeCuboidShape(0,
                                  2,
                                  12,
                                  1,
                                  5,
                                  13
            ),
            Block.makeCuboidShape(0,
                                  2,
                                  9,
                                  1,
                                  5,
                                  10
            ),
            Block.makeCuboidShape(0,
                                  2,
                                  6,
                                  1,
                                  5,
                                  7
            ),
            Block.makeCuboidShape(0,
                                  2,
                                  3,
                                  1,
                                  5,
                                  4
            ),
            Block.makeCuboidShape(8,
                                  14,
                                  10,
                                  11,
                                  16,
                                  13
            ),
            Block.makeCuboidShape(0,
                                  13,
                                  1,
                                  15,
                                  14,
                                  15
            ),
            Block.makeCuboidShape(0,
                                  8,
                                  12,
                                  1,
                                  9,
                                  13
            ),
            Block.makeCuboidShape(0,
                                  8,
                                  13,
                                  2,
                                  9,
                                  14
            ),
            Block.makeCuboidShape(2,
                                  6,
                                  1,
                                  3,
                                  13,
                                  15
            )
    )
                                                       .reduce((v1, v2) ->
                                                                   {
                                                                   return VoxelShapes.combineAndSimplify(v1,
                                                                                                         v2,
                                                                                                         IBooleanFunction.OR
                                                                   );
                                                                   })
                                                       .get();

    private static final VoxelShape SHAPE_EAST = Stream.of(
            Block.makeCuboidShape(0,
                                  0,
                                  0,
                                  16,
                                  1,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  5,
                                  1,
                                  16,
                                  6,
                                  15
            ),
            Block.makeCuboidShape(15,
                                  1,
                                  1,
                                  16,
                                  2,
                                  15
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  0,
                                  1,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  1,
                                  15,
                                  16,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  1,
                                  0,
                                  16,
                                  14,
                                  1
            ),
            Block.makeCuboidShape(15,
                                  3,
                                  4,
                                  16,
                                  4,
                                  6
            ),
            Block.makeCuboidShape(15,
                                  3,
                                  7,
                                  16,
                                  4,
                                  9
            ),
            Block.makeCuboidShape(15,
                                  3,
                                  10,
                                  16,
                                  4,
                                  12
            ),
            Block.makeCuboidShape(15,
                                  3,
                                  13,
                                  16,
                                  4,
                                  15
            ),
            Block.makeCuboidShape(15,
                                  3,
                                  1,
                                  16,
                                  4,
                                  3
            ),
            Block.makeCuboidShape(15,
                                  2,
                                  3,
                                  16,
                                  5,
                                  4
            ),
            Block.makeCuboidShape(15,
                                  2,
                                  6,
                                  16,
                                  5,
                                  7
            ),
            Block.makeCuboidShape(15,
                                  2,
                                  9,
                                  16,
                                  5,
                                  10
            ),
            Block.makeCuboidShape(15,
                                  2,
                                  12,
                                  16,
                                  5,
                                  13
            ),
            Block.makeCuboidShape(5,
                                  14,
                                  3,
                                  8,
                                  16,
                                  6
            ),
            Block.makeCuboidShape(1,
                                  13,
                                  1,
                                  16,
                                  14,
                                  15
            ),
            Block.makeCuboidShape(15,
                                  8,
                                  3,
                                  16,
                                  9,
                                  4
            ),
            Block.makeCuboidShape(14,
                                  8,
                                  2,
                                  16,
                                  9,
                                  3
            ),
            Block.makeCuboidShape(13,
                                  6,
                                  1,
                                  14,
                                  13,
                                  15
            )
    )
                                                       .reduce((v1, v2) ->
                                                                   {
                                                                   return VoxelShapes.combineAndSimplify(v1,
                                                                                                         v2,
                                                                                                         IBooleanFunction.OR
                                                                   );
                                                                   })
                                                       .get();

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.makeCuboidShape(0,
                                  0,
                                  0,
                                  16,
                                  1,
                                  16
            ),
            Block.makeCuboidShape(1,
                                  5,
                                  0,
                                  15,
                                  6,
                                  15
            ),
            Block.makeCuboidShape(1,
                                  1,
                                  0,
                                  15,
                                  2,
                                  1
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  15,
                                  16,
                                  14,
                                  16
            ),
            Block.makeCuboidShape(15,
                                  1,
                                  0,
                                  16,
                                  14,
                                  15
            ),
            Block.makeCuboidShape(0,
                                  1,
                                  0,
                                  1,
                                  14,
                                  15
            ),
            Block.makeCuboidShape(4,
                                  3,
                                  0,
                                  6,
                                  4,
                                  1
            ),
            Block.makeCuboidShape(7,
                                  3,
                                  0,
                                  9,
                                  4,
                                  1
            ),
            Block.makeCuboidShape(10,
                                  3,
                                  0,
                                  12,
                                  4,
                                  1
            ),
            Block.makeCuboidShape(13,
                                  3,
                                  0,
                                  15,
                                  4,
                                  1
            ),
            Block.makeCuboidShape(1,
                                  3,
                                  0,
                                  3,
                                  4,
                                  1
            ),
            Block.makeCuboidShape(3,
                                  2,
                                  0,
                                  4,
                                  5,
                                  1
            ),
            Block.makeCuboidShape(6,
                                  2,
                                  0,
                                  7,
                                  5,
                                  1
            ),
            Block.makeCuboidShape(9,
                                  2,
                                  0,
                                  10,
                                  5,
                                  1
            ),
            Block.makeCuboidShape(12,
                                  2,
                                  0,
                                  13,
                                  5,
                                  1
            ),
            Block.makeCuboidShape(3,
                                  14,
                                  8,
                                  6,
                                  16,
                                  11
            ),
            Block.makeCuboidShape(1,
                                  13,
                                  0,
                                  15,
                                  14,
                                  15
            ),
            Block.makeCuboidShape(3,
                                  8,
                                  0,
                                  4,
                                  9,
                                  1
            ),
            Block.makeCuboidShape(2,
                                  8,
                                  0,
                                  3,
                                  9,
                                  2
            ),
            Block.makeCuboidShape(1,
                                  6,
                                  2,
                                  15,
                                  13,
                                  3
            )
    )
                                                        .reduce((v1, v2) ->
                                                                    {
                                                                    return VoxelShapes.combineAndSimplify(v1,
                                                                                                          v2,
                                                                                                          IBooleanFunction.OR
                                                                    );
                                                                    })
                                                        .get();

}
