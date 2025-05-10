package lalawr.datagen;

import lalawr.item.TestModItemGroups;
import lalawr.item.TestModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TestModEnglishLangProvider extends FabricLanguageProvider{
    public TestModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // 指定 en_us 是可选的，因为它是默认语言代码
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(TestModItems.SUSPICIOUS_SUBSTANCE,"Suspicious Substance");
        translationBuilder.add(TestModItemGroups.CUSTOM_ITEM_GROUP_KEY,"Test Mod Items");
    }
}
