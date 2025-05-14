package lalawr.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CounterBlockEntity extends BlockEntity {
    private int counter = 0;

    public CounterBlockEntity(BlockPos pos, BlockState state) {
        super(TestModBlockEntityTypes.COUNTER_BLOCK, pos, state);
    }

    public void incrementCounter() {
        counter++;
    }

    public void resetCounter() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }
}
