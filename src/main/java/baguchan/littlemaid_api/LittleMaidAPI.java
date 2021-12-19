package baguchan.littlemaid_api;

import baguchan.littlemaid_api.event.MaidAnimationEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sistr.littlemaidmodelloader.maidmodel.ModelCapsHelper;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaidBase;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaid_Beverly7;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaid_Chloe2;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LittleMaidAPI.MODID)
public class LittleMaidAPI {
	public static final String MODID = "littlemaid_api";

	public LittleMaidAPI() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	@SubscribeEvent
	public void renderMaidAnimation(MaidAnimationEvent event) {
		float particalTick = event.getPartialTick();
		float swimAmount = event.getEntity().getSwimAmount(1.0F);
		boolean flag1 = event.getEntity().isVisuallySwimming();
		ModelLittleMaidBase model = event.getModel();

		if (swimAmount > 0.0F) {
			model.bipedHead.rotateAngleX = 0.0F;
			float angle = ModelCapsHelper.getCapsValueFloat(event.getModel(), 336, new Object[]{particalTick});
		}
		if (swimAmount > 0.0F) {
			float f5 = event.getLimbAngle() % 26.0F;
			float f1 = swimAmount;
			float f2 = swimAmount;

			if(model instanceof ModelLittleMaid_Chloe2){
				((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleX = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = 0.0F;
				model.bipedRightArm.rotateAngleX = 0.0F;
				model.bipedRightArm.rotateAngleY = 0.0F;
				model.bipedRightArm.rotateAngleZ = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleX = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = 0.0F;
				model.bipedLeftArm.rotateAngleX = 0.0F;
				model.bipedLeftArm.rotateAngleY = 0.0F;
				model.bipedLeftArm.rotateAngleZ = 0.0F;

				((ModelLittleMaid_Chloe2) model).upperRightLeg.rotateAngleX = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperRightLeg.rotateAngleY = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperRightLeg.rotateAngleZ = 0.0F;
				model.bipedRightLeg.rotateAngleX = 0.0F;
				model.bipedRightLeg.rotateAngleY = 0.0F;
				model.bipedRightLeg.rotateAngleZ = 0.0F;

				((ModelLittleMaid_Chloe2) model).upperLeftLeg.rotateAngleX = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperLeftLeg.rotateAngleY = 0.0F;
				((ModelLittleMaid_Chloe2) model).upperLeftLeg.rotateAngleZ = 0.0F;
				model.bipedLeftLeg.rotateAngleX = 0.0F;
				model.bipedLeftLeg.rotateAngleY = 0.0F;
				model.bipedLeftLeg.rotateAngleZ = 0.0F;

				if (!event.getEntity().isUsingItem()) {
					if (f5 < 14.0F) {
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ, 0.0F);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ, 0.0F);
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ, (float) Math.PI + 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ, (float) Math.PI - 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
					} else if (f5 >= 14.0F && f5 < 22.0F) {
						float f6 = (f5 - 14.0F) / 8.0F;
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ, 5.012389F - 1.8707964F * f6);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ, 1.2707963F + 1.8707964F * f6);
					} else if (f5 >= 22.0F && f5 < 26.0F) {
						float f3 = (f5 - 22.0F) / 4.0F;
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Chloe2) model).upperLeftArm.rotateAngleZ, (float) Math.PI);
						((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Chloe2) model).upperRightArm.rotateAngleZ, (float) Math.PI);
					}
				}

				((ModelLittleMaid_Chloe2) model).upperRightLeg.rotateAngleZ = Mth.lerp(swimAmount, ((ModelLittleMaid_Chloe2) model).upperRightLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F + (float) Math.PI));
				((ModelLittleMaid_Chloe2) model).upperLeftLeg.rotateAngleZ = Mth.lerp(swimAmount,  ((ModelLittleMaid_Chloe2) model).upperLeftLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F));
			}else if(model instanceof ModelLittleMaid_Beverly7){
				((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleX = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = 0.0F;
				model.bipedRightArm.rotateAngleX = 0.0F;
				model.bipedRightArm.rotateAngleY = 0.0F;
				model.bipedRightArm.rotateAngleZ = 0.0F;

				((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleX = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = 0.0F;
				model.bipedLeftArm.rotateAngleX = 0.0F;
				model.bipedLeftArm.rotateAngleY = 0.0F;
				model.bipedLeftArm.rotateAngleZ = 0.0F;

				((ModelLittleMaid_Beverly7) model).upperRightLeg.rotateAngleX = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperRightLeg.rotateAngleY = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperRightLeg.rotateAngleZ = 0.0F;
				model.bipedRightLeg.rotateAngleX = 0.0F;
				model.bipedRightLeg.rotateAngleY = 0.0F;
				model.bipedRightLeg.rotateAngleZ = 0.0F;

				((ModelLittleMaid_Beverly7) model).upperLeftLeg.rotateAngleX = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperLeftLeg.rotateAngleY = 0.0F;
				((ModelLittleMaid_Beverly7) model).upperLeftLeg.rotateAngleZ = 0.0F;
				model.bipedLeftLeg.rotateAngleX = 0.0F;
				model.bipedLeftLeg.rotateAngleY = 0.0F;
				model.bipedLeftLeg.rotateAngleZ = 0.0F;

				if (!event.getEntity().isUsingItem()) {
					if (f5 < 14.0F) {
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ, 0.0F);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ, 0.0F);
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ, (float) Math.PI + 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ, (float) Math.PI - 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
					} else if (f5 >= 14.0F && f5 < 22.0F) {
						float f6 = (f5 - 14.0F) / 8.0F;
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ, 5.012389F - 1.8707964F * f6);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ, 1.2707963F + 1.8707964F * f6);
					} else if (f5 >= 22.0F && f5 < 26.0F) {
						float f3 = (f5 - 22.0F) / 4.0F;
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleY, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ = rotlerpRad(f2, ((ModelLittleMaid_Beverly7) model).upperLeftArm.rotateAngleZ, (float) Math.PI);
						((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ = Mth.lerp(f1, ((ModelLittleMaid_Beverly7) model).upperRightArm.rotateAngleZ, (float) Math.PI);
					}
				}

				((ModelLittleMaid_Beverly7) model).upperRightLeg.rotateAngleZ = Mth.lerp(swimAmount, ((ModelLittleMaid_Beverly7) model).upperRightLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F + (float) Math.PI));
				((ModelLittleMaid_Beverly7) model).upperLeftLeg.rotateAngleZ = Mth.lerp(swimAmount,  ((ModelLittleMaid_Beverly7) model).upperLeftLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F));
			}else {
				model.bipedRightArm.setRotateAngle(0.0F, 0.0F, 0.0F);
				model.bipedLeftArm.setRotateAngle(0.0F, 0.0F, 0.0F);
				model.bipedRightLeg.setRotateAngle(0.0F, 0.0F, 0.0F);
				model.bipedLeftLeg.setRotateAngle(0.0F, 0.0F, 0.0F);


				if (!event.getEntity().isUsingItem()) {

					if (f5 < 14.0F) {
						model.bipedLeftArm.rotateAngleZ = rotlerpRad(f2, model.bipedLeftArm.rotateAngleZ, 0.0F);
						model.bipedRightArm.rotateAngleZ = Mth.lerp(f1, model.bipedRightArm.rotateAngleZ, 0.0F);
						model.bipedLeftArm.rotateAngleY = rotlerpRad(f2, model.bipedLeftArm.rotateAngleY, (float) Math.PI);
						model.bipedRightArm.rotateAngleY = Mth.lerp(f1, model.bipedRightArm.rotateAngleY, (float) Math.PI);
						model.bipedLeftArm.rotateAngleZ = rotlerpRad(f2, model.bipedLeftArm.rotateAngleZ, (float) Math.PI + 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
						model.bipedRightArm.rotateAngleZ = Mth.lerp(f1, model.bipedRightArm.rotateAngleZ, (float) Math.PI - 1.8707964F * quadraticArmUpdate(f5) / quadraticArmUpdate(14.0F));
					} else if (f5 >= 14.0F && f5 < 22.0F) {
						float f6 = (f5 - 14.0F) / 8.0F;
						model.bipedLeftArm.rotateAngleZ = rotlerpRad(f2, model.bipedLeftArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
						model.bipedRightArm.rotateAngleZ = Mth.lerp(f1, model.bipedRightArm.rotateAngleZ, ((float) Math.PI / 2F) * f6);
						model.bipedLeftArm.rotateAngleY = rotlerpRad(f2, model.bipedLeftArm.rotateAngleY, (float) Math.PI);
						model.bipedRightArm.rotateAngleY = Mth.lerp(f1, model.bipedRightArm.rotateAngleY, (float) Math.PI);
						model.bipedLeftArm.rotateAngleZ = rotlerpRad(f2, model.bipedLeftArm.rotateAngleZ, 5.012389F - 1.8707964F * f6);
						model.bipedRightArm.rotateAngleZ = Mth.lerp(f1, model.bipedRightArm.rotateAngleZ, 1.2707963F + 1.8707964F * f6);
					} else if (f5 >= 22.0F && f5 < 26.0F) {
						float f3 = (f5 - 22.0F) / 4.0F;
						model.bipedLeftArm.rotateAngleZ = rotlerpRad(f2, model.bipedLeftArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
						model.bipedRightArm.rotateAngleZ = Mth.lerp(f1, model.bipedRightArm.rotateAngleZ, ((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f3);
						model.bipedLeftArm.rotateAngleY = rotlerpRad(f2, model.bipedLeftArm.rotateAngleY, (float) Math.PI);
						model.bipedRightArm.rotateAngleY = Mth.lerp(f1, model.bipedRightArm.rotateAngleY, (float) Math.PI);
						model.bipedLeftArm.rotateAngleZ = rotlerpRad(f2, model.bipedLeftArm.rotateAngleZ, (float) Math.PI);
						model.bipedRightArm.rotateAngleZ = Mth.lerp(f1, model.bipedRightArm.rotateAngleZ, (float) Math.PI);
					}
				}

				float f7 = 0.3F;
				float f4 = 0.33333334F;
				model.bipedLeftLeg.rotateAngleZ = Mth.lerp(swimAmount, model.bipedLeftLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F + (float) Math.PI));
				model.bipedRightLeg.rotateAngleZ = Mth.lerp(swimAmount, model.bipedRightLeg.rotateAngleZ, 0.1F * Mth.cos(event.getLimbAngle() * 0.33333334F));
			}
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

	private static float quadraticArmUpdate(float p_102834_) {
		return -65.0F * p_102834_ + p_102834_ * p_102834_;
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
	}

	private void processIMC(final InterModProcessEvent event) {
	}
}
