package net.mcreator.instrumental.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.instrumental.particle.IronNoteParticle;
import net.mcreator.instrumental.InstrumentalModElements;
import net.mcreator.instrumental.InstrumentalMod;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class IronNoteProjectileProcedure extends InstrumentalModElements.ModElement {
	public IronNoteProjectileProcedure(InstrumentalModElements instance) {
		super(instance, 227);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency x for procedure IronNoteProjectile!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency y for procedure IronNoteProjectile!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency z for procedure IronNoteProjectile!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				InstrumentalMod.LOGGER.warn("Failed to load dependency world for procedure IronNoteProjectile!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.addParticle(IronNoteParticle.particle, x, y, z, 0, 0, 0);
	}
}
