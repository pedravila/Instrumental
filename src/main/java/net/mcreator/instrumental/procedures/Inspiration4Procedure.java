package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class Inspiration4Procedure extends InstrumentalModElements.ModElement {
	public Inspiration4Procedure(InstrumentalModElements instance) {
		super(instance, 63);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Inspiration4!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((4 == (entity.getPersistentData().getDouble("Inspiration"))) || (4 > (entity.getPersistentData().getDouble("Inspiration"))))) {
			return (true);
		}
		return (false);
	}
}
