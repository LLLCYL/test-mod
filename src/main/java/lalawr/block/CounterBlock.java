package lalawr.block;

import com.mojang.serialization.MapCodec;
import lalawr.block.entity.CounterBlockEntity;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CounterBlock extends BlockWithEntity {

    public CounterBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends CounterBlock> getCodec() {
        return createCodec(CounterBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CounterBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
