package com.ninni.dye_depot.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ninni.dye_depot.registry.DDParticles;
import com.ninni.dye_depot.registry.DDSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;

public class DyeBasketBlock extends HorizontalDirectionalBlock {

    public static final MapCodec<DyeBasketBlock> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                    DyeColor.CODEC.fieldOf("color").forGetter(DyeBasketBlock::getDyeColor), propertiesCodec()
            ).apply(builder, DyeBasketBlock::new)
    );

    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private final DyeColor dyeColor;

    public DyeBasketBlock(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
        this.registerDefaultState(((this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        super.entityInside(blockState, level, blockPos, entity);
        if (level instanceof ServerLevel serverLevel && serverLevel.random.nextInt(15) == 0) {
            serverLevel.sendParticles(new BlockParticleOption(DDParticles.DYE_POOF, blockState), entity.getX(), entity.getY() + 0.2, entity.getZ(), 1, 0.2, 0.2, 0.2, 1.0);
        }
    }

    @Override
    public void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        super.onProjectileHit(level, blockState, blockHitResult, projectile);
        if (blockHitResult.getDirection() == Direction.UP) {
            this.spawnParticles(level, blockHitResult.getBlockPos(), blockState);
        }
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        super.fallOn(level, blockState, blockPos, entity, f);
        this.spawnParticles(level, blockPos, blockState);
    }

    public void spawnParticles(Level level, BlockPos blockPos, BlockState state) {
        if (level instanceof ServerLevel serverLevel) {
            level.playSound(null, blockPos, DDSoundEvents.DYE_BASKET_POOF, SoundSource.BLOCKS, 1.5f, 1);
            serverLevel.sendParticles(new BlockParticleOption(DDParticles.DYE_POOF, state), blockPos.getX() + 0.5, blockPos.getY() + 1.2, blockPos.getZ() + 0.5, 60, 0.75, 0.2, 0.75, 3.0);
        }
    }

    public DyeColor getDyeColor() {
        return dyeColor;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return Shapes.block();
    }

    public VoxelShape getVisualShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.block();
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        return false;
    }

    public float getShadeBrightness(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return 0.2F;
    }
}
