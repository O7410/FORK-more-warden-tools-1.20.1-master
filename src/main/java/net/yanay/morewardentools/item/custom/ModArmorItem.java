package net.yanay.morewardentools.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.yanay.morewardentools.item.ModArmorMaterials;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance[]> MATERIAL_TO_EFFECTS_MAP = new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance[]>()
            .put(ModArmorMaterials.WARDEN_HEART, new StatusEffectInstance[]{
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0, false, false),
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 1, false, false),
                    new StatusEffectInstance(StatusEffects.SATURATION, 400, 1, false, false)})
            .build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            boolean isWearingFullCorrectArmor = true;
            for (ItemStack armorStack : player.getArmorItems()) {
                if (!(armorStack.getItem() instanceof ArmorItem armorItem) || armorItem.getMaterial() != this.material) {
                    isWearingFullCorrectArmor = false;
                    break;
                }
            }

            if (isWearingFullCorrectArmor && MATERIAL_TO_EFFECTS_MAP.containsKey(this.material)) {
                for (StatusEffectInstance statusEffectInstance : MATERIAL_TO_EFFECTS_MAP.get(this.material)) {
                    if (!player.hasStatusEffect(statusEffectInstance.getEffectType())) {
                        player.addStatusEffect(new StatusEffectInstance(statusEffectInstance));
                    }
                }
            }
        }
    }
}
