package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class Inspiration16Procedure extends InstrumentalModElements.ModElement {
	public Inspiration16Procedure(InstrumentalModElements instance) {
		super(instance, 75);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Inspiration16!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((16 == (entity.getPersistentData().getDouble("Inspiration"))) || (16 > (entity.getPersistentData().getDouble("Inspiration"))))) {
			return (true);
		}
		return (false);
	}
}