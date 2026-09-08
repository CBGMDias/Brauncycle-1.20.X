package br.com.cbgmdias.brauncycle.entity.client;

import br.com.cbgmdias.brauncycle.BrauncycleMod;
import br.com.cbgmdias.brauncycle.entity.custom.AbstractDeerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import net.minecraft.util.Mth;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.constant.DataTickets;

public class DeerModel<T extends AbstractDeerEntity> extends GeoModel<T> {
    private static final ResourceLocation MODEL = new ResourceLocation(
            BrauncycleMod.MOD_ID, "geo/purified_deer.geo.json");
    private static final ResourceLocation ANIMATIONS = new ResourceLocation(
            BrauncycleMod.MOD_ID, "animations/deer.animation.json");
    private final ResourceLocation texture;

    public DeerModel(ResourceLocation texture) {
        this.texture = texture;
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return ANIMATIONS;
    }

    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        var head = getAnimationProcessor().getBone("head");
        EntityModelData data = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        if (head != null && data != null) {
            // Add the vanilla look direction to the authored pose, preserving the zombie idle.
            float yaw = Mth.clamp(data.netHeadYaw(), -animatable.getMaxHeadYRot(), animatable.getMaxHeadYRot());
            float pitch = Mth.clamp(data.headPitch(), -animatable.getMaxHeadXRot(), animatable.getMaxHeadXRot());
            head.setRotY(Mth.clamp(head.getRotY() + yaw * Mth.DEG_TO_RAD, -35 * Mth.DEG_TO_RAD, 35 * Mth.DEG_TO_RAD));
            head.setRotX(head.getRotX() + pitch * Mth.DEG_TO_RAD);
        }
    }
}
