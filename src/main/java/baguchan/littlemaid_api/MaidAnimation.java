package baguchan.littlemaid_api;

import baguchan.littlemaid_api.event.MaidAnimationEvent;
import baguchan.littlemaid_api.utils.MaidAnimationUtils;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.sistr.littlemaidmodelloader.maidmodel.ModelCapsHelper;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaidBase;
import net.sistr.littlemaidmodelloader.maidmodel.ModelRenderer;

public class MaidAnimation {
	public static void swiming(MaidAnimationEvent event) {
		float particalTick = event.getPartialTick();
		float swimAmount = event.getEntity().getSwimAmount(1.0F);
		boolean flag1 = event.getEntity().isVisuallySwimming();
		ModelLittleMaidBase model = event.getModel();

		ModelRenderer bipedRightArm = MaidAnimationUtils.getRightArm(model);
		ModelRenderer bipedLeftArm = MaidAnimationUtils.getLeftArm(model);

		ModelRenderer bipedRightLeg = MaidAnimationUtils.getRightLeg(model);
		ModelRenderer bipedLeftLeg = MaidAnimationUtils.getLeftLeg(model);

		if (swimAmount > 0.0F) {
			model.bipedHead.rotateAngleX = 0.0F;
			float angle = ModelCapsHelper.getCapsValueFloat(event.getModel(), 336, new Object[]{particalTick});
		}
		if (swimAmount > 0.0F) {
			float f5 = event.getLimbAngle() % 26.0F;
			float f1 = swimAmount;
			float f2 = swimAmount;


			bipedRightArm.setRotateAngle(0.0F, 0.0F, 0.0F);
			bipedLeftArm.setRotateAngle(0.0F, 0.0F, 0.0F);
			bipedRightLeg.setRotateAngle(0.0F, 0.0F, 0.0F);
			bipedLeftLeg.setRotateAngle(0.0F, 0.0F, 0.0F);


			if (!event.getEntity().isUsingItem()) {

				if (f5 < 14.0F) {
					bipedLeftArm.rotateAngleZ = rotlerpRad(f2, bipedLeftArm.rotateAngleZ, 0.0F);
					bipedRightArm.rotateAngleZ = Mth.lerp(f1, bipedRightArm.rotateAngleZ, 0.0F);
					bipedLeftArm.rotateAngleY = rotlerpRad(f2, bipedLeftArm.rotateAngleY, (float) Math.PI);
					bipedRightArm.rotateAngleY = Mth.lerp(f1, bipedRightArm.rotateAngleY, (float) Math.PI);
					bipedLeftArm.rotateAngleZ = rotlerpRad(f2, bipedLeftArm.rotateAngleZ, (float) Math.PI + 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
					bipedRightArm.rotateAngleZ = Mth.lerp(f1, bipedRightArm.rotateAngleZ, (float) Math.PI - 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
				} else if (f5 >= 14.0F && f5 < 22.0F) {
					float f6 = (f5 - 14.0F) / 8.0F;
					bipedLeftArm.rotateAngleZ = rotlerpRad(f2, bipedLeftArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
					bipedRightArm.rotateAngleZ = Mth.lerp(f1, bipedRightArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
					bipedLeftArm.rotateAngleY = rotlerpRad(f2, bipedLeftArm.rotateAngleY, (float) Math.PI);
					bipedRightArm.rotateAngleY = Mth.lerp(f1, bipedRightArm.rotateAngleY, (float) Math.PI);
					bipedLeftArm.rotateAngleZ = rotlerpRad(f2, bipedLeftArm.rotateAngleZ, 5.012389F - 1.8707964F * f6);
					bipedRightArm.rotateAngleZ = Mth.lerp(f1, bipedRightArm.rotateAngleZ, 1.2707963F + 1.8707964F * f6);
				} else if (f5 >= 22.0F && f5 < 26.0F) {
					float f3 = (f5 - 22.0F) / 4.0F;
					bipedLeftArm.rotateAngleZ = rotlerpRad(f2, bipedLeftArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
					bipedRightArm.rotateAngleZ = Mth.lerp(f1, bipedRightArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
					bipedLeftArm.rotateAngleY = rotlerpRad(f2, bipedLeftArm.rotateAngleY, (float) Math.PI);
					bipedRightArm.rotateAngleY = Mth.lerp(f1, bipedRightArm.rotateAngleY, (float) Math.PI);
					bipedLeftArm.rotateAngleZ = rotlerpRad(f2, bipedLeftArm.rotateAngleZ, (float) Math.PI);
					bipedRightArm.rotateAngleZ = Mth.lerp(f1, bipedRightArm.rotateAngleZ, (float) Math.PI);
				}
			}

			float f7 = 0.3F;
			float f4 = 0.33333334F;
			bipedLeftLeg.rotateAngleZ = Mth.lerp(swimAmount, bipedLeftLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F + (float) Math.PI));
			bipedRightLeg.rotateAngleZ = Mth.lerp(swimAmount, bipedRightLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F));

		}
	}

	public static void usingItem(MaidAnimationEvent event) {
		LivingEntity living = event.getEntity();
		if (event.getEntity().isUsingItem()) {
			if (living.getUsedItemHand() == InteractionHand.MAIN_HAND) {
				poseRightArm(event);
			} else {
				poseLeftArm(event);
			}
		}
	}

	private static void poseRightArm(MaidAnimationEvent event) {
		float particalTick = event.getPartialTick();
		LivingEntity living = event.getEntity();
		ModelLittleMaidBase model = event.getModel();

		ModelRenderer bipedRightArm = MaidAnimationUtils.getRightArm(model);
		ModelRenderer bipedLeftArm = MaidAnimationUtils.getLeftArm(model);

		ModelRenderer subRightArm = MaidAnimationUtils.getSubRightArm(model);
		ModelRenderer subLeftArm = MaidAnimationUtils.getSubLeftArm(model);

		ItemStack itemstack = living.getItemInHand(living.getUsedItemHand());
		switch (itemstack.getUseAnimation()) {
			case BLOCK:
				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.9424779F;
				bipedRightArm.rotateAngleY = (-(float) Math.PI / 6.5F);
				break;
			case DRINK:
				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
				bipedRightArm.rotateAngleY = 0.0F;
				break;
			case SPEAR:
				bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - (float) Math.PI;
				bipedRightArm.rotateAngleY = 0.0F;
				if (subRightArm != null) {
					subRightArm.rotateAngleX = -0.5F;
				}
				break;
			case CROSSBOW:
				MaidAnimationUtils.animateCrossbowCharge(bipedRightArm, bipedLeftArm, living, true);
				break;
			case SPYGLASS:
				bipedRightArm.rotateAngleX = Mth.clamp(model.bipedHead.rotateAngleX - 1.9198622F - (living.isCrouching() ? 0.2617994F : 0.0F), -2.4F, 3.3F);
				bipedRightArm.rotateAngleY = model.bipedHead.rotateAngleY - 0.2617994F;
				break;
		}


	}

	private static void poseLeftArm(MaidAnimationEvent event) {
		float particalTick = event.getPartialTick();
		LivingEntity living = event.getEntity();
		ModelLittleMaidBase model = event.getModel();


		ModelRenderer bipedRightArm = MaidAnimationUtils.getRightArm(model);
		ModelRenderer bipedLeftArm = MaidAnimationUtils.getLeftArm(model);

		ModelRenderer subRightArm = MaidAnimationUtils.getSubRightArm(model);
		ModelRenderer subLeftArm = MaidAnimationUtils.getSubLeftArm(model);

		ItemStack itemstack = living.getItemInHand(living.getUsedItemHand());
		switch (itemstack.getUseAnimation()) {
			case BLOCK:
				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F;
				bipedLeftArm.rotateAngleY = ((float) Math.PI / 6.5F);
				break;
			case EAT:
				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
				bipedLeftArm.rotateAngleY = 0.0F;
				break;
			case SPEAR:
				bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - (float) Math.PI;
				bipedLeftArm.rotateAngleY = 0.0F;

				if (subLeftArm != null) {
					subLeftArm.rotateAngleX = -0.5F;
				}

				break;
			case CROSSBOW:
				MaidAnimationUtils.animateCrossbowCharge(bipedLeftArm, bipedRightArm, living, true);
				break;
			case SPYGLASS:
				bipedLeftArm.rotateAngleX = Mth.clamp(model.bipedHead.rotateAngleX - 1.9198622F - (living.isCrouching() ? 0.2617994F : 0.0F), -2.4F, 3.3F);
				bipedLeftArm.rotateAngleY = model.bipedHead.rotateAngleY + 0.2617994F;
		}


	}


	protected static float rotlerpRad(float p_102836_, float p_102837_, float p_102838_) {
		float f = (p_102838_ - p_102837_) % ((float) Math.PI * 2F);
		if (f < -(float) Math.PI) {
			f += ((float) Math.PI * 2F);
		}

		if (f >= (float) Math.PI) {
			f -= ((float) Math.PI * 2F);
		}

		return p_102837_ + p_102836_ * f;
	}

	public static float quadraticArmUpdate(float p_102834_) {
		return -65.0F * p_102834_ + p_102834_ * p_102834_;
	}
}
