package net.yanay.morewardentools.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yanay.morewardentools.MoreWardenTools;

public class ModItemGroups {
    public static final ItemGroup WARDEN_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MoreWardenTools.MOD_ID, "warden_heart"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.warden_heart"))
                    .icon(() -> new ItemStack(ModItems.WARDEN_ORB)).entries((displayContext, entries) -> {
                        entries.add(ModItems.WARDEN_HEART);
                        entries.add(ModItems.WARDEN_ORB);

                        entries.add(ModItems.WARDEN_AXE);
                        entries.add(ModItems.WARDEN_PICKAXE);
                        entries.add(ModItems.WARDEN_SWORD);
                        entries.add(ModItems.WARDEN_SHOVEL);

                    }).build());


    public static void registerItemGroups() {
        MoreWardenTools.LOGGER.info("Registering Item Groups " + MoreWardenTools.MOD_ID);
    }
}
