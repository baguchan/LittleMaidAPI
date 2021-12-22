package baguchan.littlemaid_api.mixin;

import baguchan.littlemaid_api.event.MaidAnimationEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.sistr.littlemaidmodelloader.maidmodel.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.sistr.littlemaidmodelloader.maidmodel.IModelCaps.caps_Entity;

@Mixin(ModelMultiBase.class)
public abstract class ModelMultiBaseMixin extends ModelBase {
	@Shadow(remap = false)
	public abstract Object getCapsValue(int pIndex, Object... pArg);

	@Inject(at = @At("TAIL"), method = "setAngles", remap = false)
	public void setAngles(IModelCaps caps, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo callbackInfo) {
		ModelBase modelBase = (ModelBase) ((Object) this);
		if (modelBase instanceof ModelLittleMaidBase) {
			LivingEntity ent = (LivingEntity) ModelCapsHelper.getCapsValue(caps, caps_Entity);
			MinecraftForge.EVENT_BUS.post(new MaidAnimationEvent(ent, (ModelLittleMaidBase) modelBase, limbAngle, limbDistance));
		}
	}
}
