package lalawr;

import lalawr.datagen.TestModEnglishLangProvider;
import lalawr.datagen.TestModChineseLangProvider;
import lalawr.datagen.TestModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TestModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TestModModelProvider::new);
		pack.addProvider(TestModEnglishLangProvider::new);
		pack.addProvider(TestModChineseLangProvider::new);
	}
}
