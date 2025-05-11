package lalawr.datagen;

import lalawr.block.TestModBlocks;
import lalawr.item.TestModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class TestModModelProvider extends FabricModelProvider {
    public TestModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(TestModBlocks.CONDENSED_DIRT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(TestModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
        generator.register(TestModItems.CONTROL_STICK, Models.GENERATED);
    }
}
