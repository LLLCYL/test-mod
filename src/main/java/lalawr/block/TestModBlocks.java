package lalawr.block;

import lalawr.TestMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class TestModBlocks {
    public static final String TRANSLATION_KEY_PREFIX = RegistryKeys.BLOCK.getValue().getPath();
    public static final Block CONDENSED_DIRT = register("condensed_dirt",
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS)
    );

    private static Block register(String name, AbstractBlock.Settings settings) {
        return register(name, Block::new, settings);
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        return register(name, blockFactory, settings, new Item.Settings());
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, Item.Settings itemSettings) {
        Identifier identifier = Identifier.of(TestMod.MOD_ID, name);
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(identifier);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (itemSettings != null) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(identifier);
            BlockItem blockItem = new BlockItem(block, itemSettings.registryKey(itemKey)
                    .translationKey(identifier.toTranslationKey(TestModBlocks.TRANSLATION_KEY_PREFIX)));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void initialize() {
    }

    private static RegistryKey<Block> keyOfBlock(Identifier identifier) {
        return RegistryKey.of(RegistryKeys.BLOCK, identifier);
    }

    private static RegistryKey<Item> keyOfItem(Identifier identifier) {
        return RegistryKey.of(RegistryKeys.ITEM, identifier);
    }

}
