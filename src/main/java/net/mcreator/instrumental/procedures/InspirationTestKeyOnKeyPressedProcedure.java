package net.mcreator.instrumental.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.instrumental.InstrumentalModVariables;
import net.mcreator.instrumental.InstrumentalModElements;

import java.util.Map;

@InstrumentalModElements.ModElement.Tag
public class InspirationTestKeyOnKeyPressedProcedure extends InstrumentalModElements.ModElement {
	public InspirationTestKeyOnKeyPressedProcedure(InstrumentalModElements instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InspirationTestKeyOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) (((entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new InstrumentalModVariables.PlayerVariables())).Inspiration) + 1);
			entity.getCapability(InstrumentalModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Inspiration = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
