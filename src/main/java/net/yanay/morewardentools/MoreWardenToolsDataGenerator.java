package net.yanay.morewardentools;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.yanay.morewardentools.datagen.ModItemTagProvider;
import net.yanay.morewardentools.datagen.ModLootTableProvider;
import net.yanay.morewardentools.datagen.ModModelProvider;
import net.yanay.morewardentools.datagen.ModRecipeProvider;

public class MoreWardenToolsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}
}
