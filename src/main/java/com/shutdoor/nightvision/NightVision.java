package com.shutdoor.nightvision;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import static com.shutdoor.nightvision.NightVision.MODID;


@Mod(MODID)
public class NightVision
{
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "nightvision";

    public NightVision()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EnchantmentReg.ENCHANTMENT.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
