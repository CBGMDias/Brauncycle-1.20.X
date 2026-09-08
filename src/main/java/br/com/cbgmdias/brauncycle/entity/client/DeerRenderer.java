package br.com.cbgmdias.brauncycle.entity.client;

import br.com.cbgmdias.brauncycle.entity.custom.AbstractDeerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DeerRenderer<T extends AbstractDeerEntity> extends GeoEntityRenderer<T> {
    public DeerRenderer(EntityRendererProvider.Context context, ResourceLocation texture) {
        super(context, new DeerModel<>(texture));
        this.shadowRadius = 0.55F;
    }
}
