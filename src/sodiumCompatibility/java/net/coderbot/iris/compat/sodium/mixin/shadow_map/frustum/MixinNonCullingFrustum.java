package net.coderbot.iris.compat.sodium.mixin.shadow_map.frustum;

import me.jellysquid.mods.sodium.client.render.viewport.Viewport;
import me.jellysquid.mods.sodium.client.render.viewport.ViewportProvider;
import net.coderbot.iris.compat.sodium.impl.shadow_map.ExtendedViewport;
import net.coderbot.iris.compat.sodium.impl.shadow_map.IrisFrustum;
import net.coderbot.iris.shadows.frustum.fallback.NonCullingFrustum;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NonCullingFrustum.class)
public class MixinNonCullingFrustum implements IrisFrustum, ViewportProvider {
	@Override
	public Viewport sodium$createViewport() {
		return new ExtendedViewport(this, 0 ,0 ,0);
	}

	@Override
	public boolean apply(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		return true;
	}
}
