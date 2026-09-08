package br.com.cbgmdias.brauncycle.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import br.com.cbgmdias.brauncycle.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;

public class CorruptedDeerEntity extends AbstractDeerEntity {
    public CorruptedDeerEntity(EntityType<? extends CorruptedDeerEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return AbstractDeerEntity.createAttributes().add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    @Override
    public String getAnimationVariant() {
        return "corrupted_deer";
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CORRUPTED_DEER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CORRUPTED_DEER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CORRUPTED_DEER_DEATH.get();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.25D, false) {
            private int nextAttackTick;

            @Override
            protected void checkAndPerformAttack(LivingEntity target, double distanceSqr) {
                // Allow the 1.3-second attack animation to finish before the next hit.
                if (tickCount >= nextAttackTick && isTimeToAttack()
                        && distanceSqr <= getAttackReachSqr(target)
                        && getSensing().hasLineOfSight(target)) {
                    super.checkAndPerformAttack(target, distanceSqr);
                    nextAttackTick = tickCount + 30;
                }
            }
        });
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit && !level().isClientSide()) {
            triggerAnim("movement", "attack");
            playSound(ModSounds.CORRUPTED_DEER_ATTACK.get(), getSoundVolume(), getVoicePitch());
        }
        return hit;
    }
}
