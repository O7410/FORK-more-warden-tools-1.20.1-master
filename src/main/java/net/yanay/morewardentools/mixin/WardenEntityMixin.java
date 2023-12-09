package net.yanay.morewardentools.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.yanay.morewardentools.item.ModItems;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(WardenEntity.class)
public class WardenEntityMixin {
    @Inject(at = @At("HEAD"), method = "addDarknessToClosePlayers", cancellable = true)
    private static void addDarknessToClosePlayers(ServerWorld world, Vec3d pos, @Nullable Entity entity, int range, CallbackInfo ci) {
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.DARKNESS, 260, 0, false, false);
        StatusEffect statusEffect = statusEffectInstance.getEffectType();
        List<ServerPlayerEntity> players = world.getPlayers(player -> !(!player.interactionManager.isSurvivalLike() || entity != null && entity.isTeammate(player) ||
                !pos.isInRange(player.getPos(), range) || player.hasStatusEffect(statusEffect) &&
                player.getStatusEffect(statusEffect).getAmplifier() >= statusEffectInstance.getAmplifier() && !player.getStatusEffect(statusEffect).isDurationBelow(199) ||
                (player.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.WARDEN_BOOTS) &&
                        player.getEquippedStack(EquipmentSlot.LEGS).isOf(ModItems.WARDEN_LEGGINGS) &&
                        player.getEquippedStack(EquipmentSlot.CHEST).isOf(ModItems.WARDEN_CHESTPLATE) &&
                        player.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.WARDEN_HELMET))
        ));
        players.forEach(player -> player.addStatusEffect(new StatusEffectInstance(statusEffectInstance), entity));
        ci.cancel();
    }
}
