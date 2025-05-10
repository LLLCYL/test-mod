package lalawr;

import lalawr.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TestModModelProvider::new);
		pack.addProvider(TestModEnglishLangProvider::new);
		pack.addProvider(TestModChineseLangProvider::new);
		pack.addProvider(TestModBlockTagProvider::new);
		pack.addProvider(TestModItemTagProvider::new);
		pack.addProvider(TestModLootTableProvider::new);
//		pack.addProvider(TestModRecipeProvider::new);
	}
}
