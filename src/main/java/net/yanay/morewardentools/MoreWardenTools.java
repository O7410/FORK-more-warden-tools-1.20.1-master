package net.yanay.morewardentools;

import net.fabricmc.api.ModInitializer;

import net.yanay.morewardentools.item.ModItemGroups;
import net.yanay.morewardentools.item.ModItems;
import net.yanay.morewardentools.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreWardenTools implements ModInitializer {
	public static final String MOD_ID = "morewardentools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModLootTableModifiers.modifyLootTables();
	}
}
