package br.com.cbgmdias.brauncycle.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import br.com.cbgmdias.brauncycle.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;

public class PurifiedDeerEntity extends AbstractDeerEntity {
    public PurifiedDeerEntity(EntityType<? extends PurifiedDeerEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public String getAnimationVariant() {
        return "purified_deer";
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.PURIFIED_DEER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.PURIFIED_DEER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.PURIFIED_DEER_DEATH.get();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
    }
}
