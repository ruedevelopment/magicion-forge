package io.github.ruedev.magicion.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class ManaCapability {

    @CapabilityInject(IMana.class)
    public static Capability<IMana> MANA_CAPABILITY = null;

    public static void registerCapability() {
        CapabilityManager.INSTANCE.register(IMana.class, new Storage(), DefaultManaImpl::new);
    }

    public static class Storage implements Capability.IStorage<IMana> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<IMana> capability, IMana instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            nbt.putInt("mana", instance.getMana());
            return nbt;
        }

        @Override
        public void readNBT(Capability<IMana> capability, IMana instance, Direction side, INBT nbt) {
            int mana = ((CompoundNBT)nbt).getInt("mana");
            instance.setMana(mana);
        }
    }
}

