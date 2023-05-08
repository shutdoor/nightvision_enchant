package com.shutdoor.nightvision;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.shutdoor.nightvision.NightVision.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class EnchantNightVision extends Enchantment {

    protected EnchantNightVision() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentType.ARMOR_HEAD, new EquipmentSlotType[]{ EquipmentSlotType.HEAD });
    }

    @Override
    public int getMinCost(int level) {
        return 15;
    }

    @Override
    public int getMaxLevel() {return 1;}

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        ItemStack helmet = event.player.getItemBySlot(EquipmentSlotType.HEAD);
        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentReg.NIGHT_VISION.get(), helmet);

        if(enchantLevel > 0){
            EffectInstance playerEffect = new EffectInstance(Effects.NIGHT_VISION, 210, 100, false, false);
            playerEffect.setNoCounter(true);
            event.player.addEffect(playerEffect);
        }
    }
}
