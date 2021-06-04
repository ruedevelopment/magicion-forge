package io.github.ruedev.magicion.data;

import io.github.ruedev.magicion.Magicion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class ManaEventHandler {
    public static void attachCapabilitiesEvent(final AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            ManaProvider provider = new ManaProvider();
            event.addCapability(new ResourceLocation(Magicion.MODID, "mana"), provider);
        }
    }
}
