package baguchan.littlemaid_api.mixin;

import baguchan.littlemaid_api.event.MaidAnimationEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.sistr.littlemaidmodelloader.client.renderer.MultiModel;
import net.sistr.littlemaidmodelloader.entity.compound.IHasMultiModel;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaidBase;
import net.sistr.littlemaidmodelloader.multimodel.IMultiModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiModel.class)
public class MultiModelMixin<T extends net.minecraft.entity.LivingEntity & IHasMultiModel> {

	private static MultiModel model;

	@Inject(at = @At("TAIL"), method = "<init>")
	private void setAngles(CallbackInfo callbackInfo) {
		MultiModel multiModel = (MultiModel) ((Object) this);
		model = multiModel;
	}

	/**
	 * @author bagu_chan
	 * @reason because multi model animation cannot add maid animation event on mixin
	 */
	@Inject(at = @At("TAIL"), method = "setAngles*", remap = false)
	@SuppressWarnings("all")
	public void setAngles(LivingEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo callbackInfo) {
		((IHasMultiModel) entity).getModel(IHasMultiModel.Layer.SKIN, IHasMultiModel.Part.HEAD).ifPresent((model) -> {
			if (model instanceof ModelLittleMaidBase) {
				MinecraftForge.EVENT_BUS.post(new MaidAnimationEvent(entity, (ModelLittleMaidBase) model, limbAngle, limbDistance));
			}
		});
	}
}
