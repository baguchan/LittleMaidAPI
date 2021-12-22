package baguchan.littlemaid_api.utils;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CrossbowItem;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaidBase;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaid_Beverly7;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaid_Chloe2;
import net.sistr.littlemaidmodelloader.maidmodel.ModelRenderer;

import javax.annotation.Nullable;

public class MaidAnimationUtils {
	public static ModelRenderer getRightArm(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return ((ModelLittleMaid_Beverly7) model).upperRightArm;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return ((ModelLittleMaid_Chloe2) model).upperRightArm;
		}
		return model.bipedRightArm;
	}

	public static ModelRenderer getLeftArm(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return ((ModelLittleMaid_Beverly7) model).upperLeftArm;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return ((ModelLittleMaid_Chloe2) model).upperLeftArm;
		}

		return model.bipedLeftArm;
	}

	@Nullable
	public static ModelRenderer getSubRightArm(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return model.bipedRightArm;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return model.bipedRightArm;
		}
		return null;
	}

	@Nullable
	public static ModelRenderer getSubLeftArm(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return model.bipedLeftArm;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return model.bipedLeftArm;
		}
		return null;
	}

	public static ModelRenderer getRightLeg(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return ((ModelLittleMaid_Beverly7) model).upperRightLeg;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return ((ModelLittleMaid_Chloe2) model).upperRightLeg;
		}
		return model.bipedRightArm;
	}

	public static ModelRenderer getLeftLeg(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return ((ModelLittleMaid_Beverly7) model).upperLeftLeg;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return ((ModelLittleMaid_Chloe2) model).upperLeftLeg;
		}

		return model.bipedLeftArm;
	}

	@Nullable
	public static ModelRenderer getSubRightLeg(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return model.bipedRightLeg;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return model.bipedRightLeg;
		}
		return null;
	}

	@Nullable
	public static ModelRenderer getSubLeftLeg(ModelLittleMaidBase model) {
		if (model instanceof ModelLittleMaid_Beverly7) {
			return model.bipedLeftLeg;
		}
		if (model instanceof ModelLittleMaid_Chloe2) {
			return model.bipedLeftLeg;
		}
		return null;
	}


	public static void animateCrossbowCharge(ModelRenderer mainHand, ModelRenderer subHand, LivingEntity living, boolean right, boolean isSlim) {
		ModelRenderer modelpart = right ? mainHand : subHand;
		ModelRenderer modelpart1 = right ? subHand : mainHand;
		modelpart.rotateAngleY = right ? -0.8F : 0.8F;
		modelpart.rotateAngleX = -0.97079635F;
		modelpart1.rotateAngleX = modelpart.rotateAngleX;
		modelpart.rotateAngleZ = 0.0F;
		modelpart1.rotateAngleZ = 0.0F;
		float f = (float) CrossbowItem.getChargeDuration(living.getUseItem());
		float f1 = Mth.clamp((float) living.getTicksUsingItem(), 0.0F, f);
		float f2 = f1 / f;
		modelpart1.rotateAngleY = Mth.lerp(f2, 0.4F, 0.85F) * (float) (right ? 1 : -1) * (isSlim ? 0.5F : 1F);
		modelpart1.rotateAngleX = Mth.lerp(f2, modelpart1.rotateAngleX, (-(float) Math.PI / 2F)) * (isSlim ? 0.5F : 1F);
	}
}
