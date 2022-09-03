package com.shutdoor.nightvision;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

import static com.shutdoor.nightvision.NightVision.MODID;
import static com.shutdoor.nightvision.NightVision.nightvision;

@Mod.EventBusSubscriber(modid = MODID)
public class EnchantNightVision extends Enchantment {
    public EnchantNightVision() {
        super(Rarity.UNCOMMON, EnchantmentCategory.ARMOR_HEAD, new EquipmentSlot[]{
                EquipmentSlot.HEAD
        });
    }

    @Override
    public int getMinCost(int level) {
        return 15;
    }

    @Override
    public int getMaxLevel() {return 1;}

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        ItemStack helmet = event.player.getItemBySlot(EquipmentSlot.HEAD);
        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(NightVision.nightvision, helmet);


        if(enchantLevel > 0 && !(event.player.hasEffect(MobEffects.NIGHT_VISION))){
            MobEffectInstance playerEffect = new MobEffectInstance(MobEffects.NIGHT_VISION, 1000000, 100, false, false);
            playerEffect.setNoCounter(true);
           event.player.addEffect(playerEffect);
       }else if(enchantLevel <= 0 && event.player.hasEffect(MobEffects.NIGHT_VISION)){
           event.player.removeEffect(MobEffects.NIGHT_VISION);
       }
    }
}
