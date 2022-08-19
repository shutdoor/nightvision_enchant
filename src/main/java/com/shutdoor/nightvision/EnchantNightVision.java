package com.shutdoor.nightvision;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import static com.shutdoor.nightvision.NightVision.MODID;

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
        ItemStack helment = event.player.getItemBySlot(EquipmentSlot.HEAD);
        Player player = event.player;
        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(NightVision.nightvision, helment);
        MobEffectInstance effect = new MobEffectInstance(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, 100, false, false);

        if(enchantLevel > 0){
           effect.setNoCounter(true);
           player.addEffect(effect);
       }else{
           player.removeEffect(MobEffects.NIGHT_VISION);
       }
    }
}
