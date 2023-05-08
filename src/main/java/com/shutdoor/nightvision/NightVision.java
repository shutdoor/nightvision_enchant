package com.shutdoor.nightvision;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.slf4j.Logger;
import static com.shutdoor.nightvision.NightVision.MODID;


@Mod(MODID)
public class NightVision
{
    public static final String MODID = "nightvision";


    public NightVision()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EnchantmentReg.ENCHANTMENTS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }


}
