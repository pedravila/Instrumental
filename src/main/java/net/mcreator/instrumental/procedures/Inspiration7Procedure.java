package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class Inspiration7Procedure extends InstrumentalModElements.ModElement {
	public Inspiration7Procedure(InstrumentalModElements instance) {
		super(instance, 66);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Inspiration7!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((7 == (entity.getPersistentData().getDouble("Inspiration")))) {
			return (true);
		}
		return (false);
	}
}
