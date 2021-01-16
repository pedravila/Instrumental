package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class Inspiration14Procedure extends InstrumentalModElements.ModElement {
	public Inspiration14Procedure(InstrumentalModElements instance) {
		super(instance, 73);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Inspiration14!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((14 == (entity.getPersistentData().getDouble("Inspiration"))) || (14 > (entity.getPersistentData().getDouble("Inspiration"))))) {
			return (true);
		}
		return (false);
	}
}
