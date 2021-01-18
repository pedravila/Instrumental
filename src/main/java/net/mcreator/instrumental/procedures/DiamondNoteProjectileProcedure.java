package net.mcreator.instrumental.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.instrumental.particle.DiamondNoteParticle;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class DiamondNoteProjectileProcedure extends InstrumentalModElements.ModElement {
	public DiamondNoteProjectileProcedure(InstrumentalModElements instance) {
		super(instance, 179);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure DiamondNoteProjectile!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure DiamondNoteProjectile!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure DiamondNoteProjectile!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure DiamondNoteProjectile!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.addParticle(DiamondNoteParticle.particle, x, y, z, 0, 0, 0);
	}
}
