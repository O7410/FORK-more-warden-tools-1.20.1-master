package net.yanay.morewardentools.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.yanay.morewardentools.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier WARDEN_ID =
            new Identifier("minecraft", "entities/warden");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (WARDEN_ID.equals(id)) {
                LootPool.Builder heartPoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.WARDEN_HEART))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 10.0f)).build());

                LootPool.Builder bonePoolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.90f))
                        .with(ItemEntry.builder(ModItems.WARDEN_BONE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());

                tableBuilder
                        .pool(heartPoolBuilder.build())
                        .pool(bonePoolBuilder.build());
            }
        });
    }
}
