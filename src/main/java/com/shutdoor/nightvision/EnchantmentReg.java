package com.shutdoor.nightvision;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.shutdoor.nightvision.NightVision.MODID;


public class EnchantmentReg {

    public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

    public static final RegistryObject<Enchantment> NIGHT_VISION = ENCHANTMENT.register("nightvision", () -> new EnchantNightVision());

}
