package io.github.ruedev.magicion;

import io.github.ruedev.magicion.data.ManaCapability;
import io.github.ruedev.magicion.data.ManaEventHandler;
import io.github.ruedev.magicion.data.network.ManaPacketHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("magicion")
public class Magicion {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "magicion";

    public Magicion() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {
        ManaCapability.registerCapability();
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, ManaEventHandler::attachCapabilitiesEvent);
    }
}
