package lalawr.item;

import lalawr.TestMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class TestModItems {
    public static final String TRANSLATION_KEY_PREFIX = RegistryKeys.ITEM.getValue().getPath();

    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Settings());
    public static final Item CONTROL_STICK = register("control_stick", Item::new, new Item.Settings());

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

        Identifier identifier = Identifier.of(TestMod.MOD_ID, name);

        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, identifier);

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey).translationKey(
                identifier.toTranslationKey(TestModItems.TRANSLATION_KEY_PREFIX)));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        /*获取用于修改 ingredients 组中的条目的事件。
        并注册一个事件处理程序，将我们的可疑项目添加到 ingredients 组。*/
        // addToGroup(ItemGroups.OPERATOR, SUSPICIOUS_SUBSTANCE);
    }

//    private static void addToGroup(RegistryKey<ItemGroup> itemGroupRegistryKey, Item item) {
//        ItemGroupEvents.modifyEntriesEvent(itemGroupRegistryKey)
//                .register((itemGroup) -> itemGroup.add(item));
//    }
}