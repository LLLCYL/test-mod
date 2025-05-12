package lalawr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PrismarineLamp extends Block {
    public static final BooleanProperty LIT = Properties.LIT;

    public PrismarineLamp(Settings settings) {
        super(settings);
        // Set the default state of the block to be deactivated.
        setDefaultState(getDefaultState().with(LIT, false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            // Skip if the player isn't allowed to modify the world.
            return ActionResult.PASS;
        } else {
            // Get the current value of the "activated" property
            boolean activated = state.get(LIT);

            // Flip the value of activated and save the new block state.
            world.setBlockState(pos, state.with(LIT, !activated));

            // Play a click sound to emphasise the interaction.
            world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.SUCCESS;
        }
    }
    public static int getLuminance(BlockState currentBlockState) {
        // Get the value of the "activated" property.
        boolean activated = currentBlockState.get(PrismarineLamp.LIT);

        // Return a light level if activated = true
        return activated ? 15 : 0;
    }
}