// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmoo_hat<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "moo_hat"), "main");
	private final ModelPart hat;
	private final ModelPart hat1;
	private final ModelPart hat2;
	private final ModelPart hat3;
	private final ModelPart hat4;
	private final ModelPart hat5;
	private final ModelPart ear1;
	private final ModelPart ear2;
	private final ModelPart horn1;
	private final ModelPart horn2;
	private final ModelPart nose;
	private final ModelPart eyes;

	public Modelmoo_hat(ModelPart root) {
		this.hat = root.getChild("hat");
		this.hat1 = this.hat.getChild("hat1");
		this.hat2 = this.hat.getChild("hat2");
		this.hat3 = this.hat.getChild("hat3");
		this.hat4 = this.hat.getChild("hat4");
		this.hat5 = this.hat.getChild("hat5");
		this.ear1 = this.hat.getChild("ear1");
		this.ear2 = this.hat.getChild("ear2");
		this.horn1 = this.hat.getChild("horn1");
		this.horn2 = this.hat.getChild("horn2");
		this.nose = this.hat.getChild("nose");
		this.eyes = this.hat.getChild("eyes");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition hat1 = hat.addOrReplaceChild("hat1",
				CubeListBuilder.create().texOffs(0, 27)
						.addBox(4.0F, -8.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 25)
						.addBox(5.0F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(52, 60)
						.addBox(5.0F, -7.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 48)
						.addBox(6.0F, -7.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(48, 60)
						.addBox(5.0F, -7.0F, 3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 55)
						.addBox(6.0F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat2 = hat.addOrReplaceChild("hat2",
				CubeListBuilder.create().texOffs(18, 27)
						.addBox(4.0F, -8.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 38)
						.addBox(5.0F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(60, 59)
						.addBox(5.0F, -7.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 5)
						.addBox(6.0F, -7.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(14, 61)
						.addBox(5.0F, -7.0F, 3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(46, 55)
						.addBox(6.0F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition hat3 = hat.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(32, 9).mirror()
				.addBox(-5.0F, -8.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 43)
				.mirror().addBox(-6.0F, -8.0F, -3.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 61).mirror().addBox(-6.0F, -7.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(50, 26).mirror()
				.addBox(-7.0F, -7.0F, -3.0F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(64, 2)
				.mirror().addBox(-6.0F, -7.0F, 3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(14, 56).mirror().addBox(-7.0F, -2.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat4 = hat.addOrReplaceChild("hat4",
				CubeListBuilder.create().texOffs(28, 18)
						.addBox(-5.0F, -8.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 59)
						.addBox(-5.0F, -8.0F, -5.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 59)
						.addBox(4.0F, -8.0F, 4.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 59)
						.addBox(4.0F, -8.0F, -5.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat5 = hat.addOrReplaceChild("hat5",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-5.0F, -9.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
						.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(36, 5)
						.addBox(-3.0F, -10.0F, 4.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 7)
						.addBox(-3.0F, -10.0F, -5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 18)
						.addBox(-3.0F, -11.0F, -4.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(50, 47)
						.addBox(-4.0F, -9.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 49)
						.addBox(-4.0F, -9.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ear1 = hat.addOrReplaceChild("ear1",
				CubeListBuilder.create().texOffs(36, 0)
						.addBox(-0.5F, -10.0F, -2.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(50, 37)
						.addBox(-0.5F, -11.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 51)
						.addBox(4.5F, -11.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(58, 2)
						.addBox(6.5F, -10.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 16)
						.addBox(-0.5F, -9.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 32)
						.addBox(5.5F, -9.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 51)
						.addBox(-0.5F, -10.0F, -3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).texOffs(24, 56)
						.addBox(-0.5F, -9.0F, -3.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(56, 55)
						.addBox(-0.5F, -9.0F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(50, 51)
						.addBox(-0.5F, -10.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition ear2 = hat.addOrReplaceChild("ear2", CubeListBuilder.create().texOffs(0, 43).mirror()
				.addBox(-6.5F, -10.0F, -2.0F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(50, 42)
				.mirror().addBox(-4.5F, -11.0F, -2.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 65).mirror().addBox(-5.5F, -11.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(0, 66).mirror()
				.addBox(-7.5F, -10.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(50, 21)
				.mirror().addBox(-5.5F, -9.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(22, 66).mirror().addBox(-6.5F, -9.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(36, 53).mirror()
				.addBox(-5.5F, -10.0F, -3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false)
				.texOffs(56, 57).mirror().addBox(-4.5F, -9.0F, -3.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
				.mirror(false).texOffs(58, 0).mirror()
				.addBox(-4.5F, -9.0F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false).texOffs(50, 53)
				.mirror().addBox(-5.5F, -10.0F, 2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition horn1 = hat.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(36, 60).mirror()
				.addBox(-2.25F, -13.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(14, 48).mirror().addBox(-3.25F, -15.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(64, 9).mirror()
				.addBox(-3.25F, -14.0F, -2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false)
				.texOffs(64, 26).mirror().addBox(-3.25F, -14.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.1F))
				.mirror(false).texOffs(30, 58).mirror()
				.addBox(-4.25F, -14.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition horn2 = hat.addOrReplaceChild("horn2",
				CubeListBuilder.create().texOffs(42, 60)
						.addBox(1.25F, -13.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 58)
						.addBox(2.25F, -15.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(64, 59)
						.addBox(2.25F, -14.0F, -2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(30, 65)
						.addBox(2.25F, -14.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.1F)).texOffs(0, 59)
						.addBox(3.25F, -14.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition nose = hat.addOrReplaceChild("nose",
				CubeListBuilder.create().texOffs(70, 1)
						.addBox(-3.0F, -9.0F, -6.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(70, 4)
						.addBox(-2.0F, -7.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition eyes = hat.addOrReplaceChild("eyes", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = eyes.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(73, 6).mirror()
						.addBox(2.0F, -9.0F, -7.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false)
						.texOffs(70, 6).addBox(-3.0F, -9.0F, -7.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}