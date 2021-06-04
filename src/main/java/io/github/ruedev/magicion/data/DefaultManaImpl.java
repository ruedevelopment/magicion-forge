package io.github.ruedev.magicion.data;

public class DefaultManaImpl implements IMana {
    private int manaAmount;

    @Override
    public void setMana(int newAmount) {
        this.manaAmount = newAmount;
    }

    @Override
    public int getMana() {
        return manaAmount;
    }
}
