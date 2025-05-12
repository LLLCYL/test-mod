package lalawr.item;

import lalawr.TestMod;
import lalawr.block.TestModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TestModItemGroups {
    public static final Identifier itemGroupIdentifier = Identifier.of("item_group", TestMod.MOD_ID);
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(), itemGroupIdentifier);
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(TestModItems.SUSPICIOUS_SUBSTANCE))
            .displayName(Text.translatable("itemGroup." + TestMod.MOD_ID)).build();

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, TestModItemGroups.CUSTOM_ITEM_GROUP_KEY, TestModItemGroups.CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(TestModItemGroups.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(TestModItems.SUSPICIOUS_SUBSTANCE);
            itemGroup.add(TestModItems.CONTROL_STICK);
            itemGroup.add(TestModBlocks.CONDENSED_DIRT.asItem());
            itemGroup.add(TestModBlocks.COUNTER_BLOCK.asItem());
            itemGroup.add(TestModBlocks.PRISMARINE_LAMP.asItem());
            // ...
        });
    }
}
