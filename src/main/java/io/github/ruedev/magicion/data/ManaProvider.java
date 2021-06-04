package io.github.ruedev.magicion.data;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManaProvider implements ICapabilitySerializable<CompoundNBT> {
    private final DefaultManaImpl mana = new DefaultManaImpl();
    private final LazyOptional<IMana> optional = LazyOptional.of(() -> mana);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return optional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if(ManaCapability.MANA_CAPABILITY == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) ManaCapability.MANA_CAPABILITY.writeNBT(mana, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (ManaCapability.MANA_CAPABILITY != null) {
            ManaCapability.MANA_CAPABILITY.readNBT(mana, null, nbt);
        }
    }
}
