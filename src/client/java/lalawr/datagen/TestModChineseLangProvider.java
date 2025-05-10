package lalawr.datagen;

import lalawr.item.TestModItemGroups;
import lalawr.item.TestModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TestModChineseLangProvider extends FabricLanguageProvider{
    public TestModChineseLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // 指定 en_us 是可选的，因为它是默认语言代码
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(TestModItems.SUSPICIOUS_SUBSTANCE,"可疑的物品");
        translationBuilder.add(TestModItemGroups.CUSTOM_ITEM_GROUP_KEY,"测试模组物品");
    }
}
