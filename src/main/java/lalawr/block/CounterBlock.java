package lalawr.block;

import com.mojang.serialization.MapCodec;
import lalawr.block.entity.CounterBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof CounterBlockEntity counterBlockEntity) {
            if (!world.isClient) {
                counterBlockEntity.incrementCounter();
                player.sendMessage(Text.literal("clicked %dth time".formatted(counterBlockEntity.getCounter())), true);
            }
            return ActionResult.SUCCESS;
        } else return ActionResult.PASS;
    }
}
