package lalawr.datagen;

import lalawr.block.PrismarineLamp;
import lalawr.block.TestModBlocks;
import lalawr.item.TestModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;

public class TestModModelProvider extends FabricModelProvider {
    public TestModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(TestModBlocks.CONDENSED_DIRT);
        generator.registerSimpleCubeAll(TestModBlocks.COUNTER_BLOCK);
        registerPrismarineLamp(generator, TestModBlocks.PRISMARINE_LAMP);
    }

    private static void registerPrismarineLamp(BlockStateModelGenerator generator, Block block) {
        BooleanProperty property = PrismarineLamp.LIT;
        WeightedVariant unlitVariant = BlockStateModelGenerator.createWeightedVariant(Models.CUBE_ALL.upload(block, TextureMap.all(block), generator.modelCollector));
        WeightedVariant litVariant = BlockStateModelGenerator.createWeightedVariant(generator.createSubModel(block, "_" + property.getName(), Models.CUBE_ALL, TextureMap::all));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(BlockStateVariantMap.models(property).generate(powered -> powered ? litVariant : unlitVariant)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(TestModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
        generator.register(TestModItems.CONTROL_STICK, Models.GENERATED);
    }
}
