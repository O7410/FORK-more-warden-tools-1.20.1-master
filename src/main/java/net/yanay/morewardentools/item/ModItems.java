package net.yanay.morewardentools.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yanay.morewardentools.MoreWardenTools;
import net.yanay.morewardentools.item.custom.ModArmorItem;

public class ModItems {
    public static final Item WARDEN_HEART = registerItem("warden_heart", new Item(new FabricItemSettings()));
    public static final Item WARDEN_ORB = registerItem("warden_orb", new Item(new FabricItemSettings()));
    public static final Item WARDEN_BONE = registerItem("warden_bone", new Item(new FabricItemSettings()));

    public static final Item WARDEN_PICKAXE = registerItem("warden_pickaxe",
            new PickaxeItem(ModToolsMaterial.WARDEN_HEART, 6, -2.7f, new FabricItemSettings()));
    public static final Item WARDEN_AXE = registerItem("warden_axe",
            new AxeItem(ModToolsMaterial.WARDEN_HEART, 10, -2.5f, new FabricItemSettings()));
    public static final Item WARDEN_SWORD = registerItem("warden_sword",
            new SwordItem(ModToolsMaterial.WARDEN_HEART, 9, -2f, new FabricItemSettings()));
    public static final Item WARDEN_SHOVEL = registerItem("warden_shovel",
            new ShovelItem(ModToolsMaterial.WARDEN_HEART, 6, -3f, new FabricItemSettings()));

    public static final Item WARDEN_HELMET = registerItem("warden_helmet",
            new ModArmorItem(ModArmorMaterials.WARDEN_HEART, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item WARDEN_CHESTPLATE = registerItem("warden_chestplate",
            new ArmorItem(ModArmorMaterials.WARDEN_HEART, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item WARDEN_LEGGINGS = registerItem("warden_leggings",
            new ArmorItem(ModArmorMaterials.WARDEN_HEART, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item WARDEN_BOOTS = registerItem("warden_boots",
            new ArmorItem(ModArmorMaterials.WARDEN_HEART, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(WARDEN_HEART);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreWardenTools.MOD_ID, name), item);
    }
    public static void registerModItems() {
        MoreWardenTools.LOGGER.info("Registering Mod Items For " + MoreWardenTools.MOD_ID);
    }
}
