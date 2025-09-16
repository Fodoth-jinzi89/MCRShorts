// Save this class in your mod and generate all required imports

/**
 * Made with Blockbench 4.12.5 Exported for Minecraft version 1.19 or later with
 * Mojang mappings
 * 
 * @author Author
 */
public class gold_slab1Animation {
	public static final AnimationDefinition push1 = AnimationDefinition.Builder.withLength(3.0F)
			.addAnimation("all",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.7833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("all",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.7833F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 1.5F, 4.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 6.0F),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 8.0F),
									AnimationChannel.Interpolations.LINEAR)))
			.build();
}