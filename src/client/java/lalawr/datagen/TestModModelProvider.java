package lalawr.datagen;

import lalawr.block.PrismarineLamp;
import lalawr.block.TestModBlocks;
import lalawr.item.TestModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class TestModModelProvider extends FabricModelProvider {
    public TestModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(TestModBlocks.CONDENSED_DIRT);
        generator.registerSimpleCubeAll(TestModBlocks.COUNTER_BLOCK);
        registerPrismarineLamp(generator);
        generator.createLogTexturePool(TestModBlocks.CONDENSED_OAK_LOG).log(TestModBlocks.CONDENSED_OAK_LOG);
    }

    private static void registerPrismarineLamp(BlockStateModelGenerator generator) {
        BooleanProperty property = PrismarineLamp.LIT;
        WeightedVariant unlitVariant = BlockStateModelGenerator.createWeightedVariant(Models.CUBE_ALL.upload(TestModBlocks.PRISMARINE_LAMP, TextureMap.all(TestModBlocks.PRISMARINE_LAMP), generator.modelCollector));
        WeightedVariant litVariant = BlockStateModelGenerator.createWeightedVariant(generator.createSubModel(TestModBlocks.PRISMARINE_LAMP, "_%s".formatted(property.getName()), Models.CUBE_ALL, TextureMap::all));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(TestModBlocks.PRISMARINE_LAMP).with(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, litVariant, unlitVariant)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(TestModItems.SUSPICIOUS_SUBSTANCE, Models.GENERATED);
        generator.register(TestModItems.CONTROL_STICK, Models.GENERATED);
    }
}
