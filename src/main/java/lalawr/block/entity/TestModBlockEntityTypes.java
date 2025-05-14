package lalawr.block.entity;

import lalawr.TestMod;
import lalawr.block.TestModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestModBlockEntityTypes {
    public static final BlockEntityType<CounterBlockEntity> COUNTER_BLOCK = register("counter_block",
            FabricBlockEntityTypeBuilder.create(CounterBlockEntity::new, TestModBlocks.COUNTER_BLOCK).build()
    );

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TestMod.MOD_ID, path), blockEntityType);
    }

    public static void initialize() {
    }
}
