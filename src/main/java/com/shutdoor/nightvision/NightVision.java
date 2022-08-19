package com.shutdoor.nightvision;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.slf4j.Logger;
import static com.shutdoor.nightvision.NightVision.MODID;


@Mod(MODID)
public class NightVision
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "nightvision";

    @ObjectHolder(MODID +":"+ MODID)
    public static final Enchantment nightvision = null;

    public NightVision()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class, this::registerEnchantments);
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(new EnchantNightVision().setRegistryName(MODID));
    }
}
