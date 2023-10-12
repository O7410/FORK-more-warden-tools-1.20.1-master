package net.yanay.morewardentools.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.yanay.morewardentools.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WARDEN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARDEN_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.WARDEN_BONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.WARDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_SHOVEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_BOOTS));
    }
}
