package baguchan.littlemaid_api.event;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.Event;
import net.sistr.littlemaidmodelloader.maidmodel.ModelLittleMaidBase;

/*
 * This event can able to make little maid animation
 * If you support another multi model, you should use instanceof
 */
public class MaidAnimationEvent extends Event
{

	private final LivingEntity entity;
	private final ModelLittleMaidBase model;
	private final float limbAngle;
	private final float limbDistance;
	private final float partialTick;


	public MaidAnimationEvent(LivingEntity entity, ModelLittleMaidBase model, float limbAngle, float limbDistance) {
		this.entity = entity;
		this.model = model;
		this.limbAngle = limbAngle;
		this.limbDistance = limbDistance;
		this.partialTick = Minecraft.getInstance().getFrameTime();
	}

	public LivingEntity getEntity() { return entity; }

	public float getLimbAngle() {
		return limbAngle;
	}

	public float getLimbDistance() {
		return limbDistance;
	}

	public float getPartialTick() {
		return partialTick;
	}

	public ModelLittleMaidBase getModel() {
		return model;
	}
}
