package br.com.cbgmdias.brauncycle.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class AbstractDeerEntity extends PathfinderMob implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected AbstractDeerEntity(EntityType<? extends AbstractDeerEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public abstract String getAnimationVariant();

    @Override
    public int getAmbientSoundInterval() {
        return 200;
    }

    @Override
    public int getMaxHeadYRot() {
        // Vanilla BodyRotationControl turns the body once the head reaches this limit.
        return 35;
    }

    @Override
    public int getMaxHeadXRot() {
        return 25;
    }

    @Override
    public int getHeadRotSpeed() {
        return 10;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        String prefix = "animation." + getAnimationVariant() + ".";
        RawAnimation idle = RawAnimation.begin().thenLoop(prefix + "idle");
        RawAnimation walk = RawAnimation.begin().thenLoop(prefix + "walk");
        RawAnimation run = RawAnimation.begin().thenLoop(prefix + "run");
        controllers.add(new AnimationController<>(this, "movement", 4,
                state -> state.setAndContinue(state.isMoving() ? (isAggressive() ? run : walk) : idle))
                .triggerableAnim("attack", RawAnimation.begin().thenPlay(prefix + "attack")));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
