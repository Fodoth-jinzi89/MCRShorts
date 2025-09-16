package net.mcreator.mcrshorts.procedures;

import net.minecraft.core.Direction;

public class GildingChamberWuPinLanCaoWeiZiDongQuChuTiaoJianProcedure {
	public static boolean execute(Direction direction) {
		if (direction == null)
			return false;
		return direction == Direction.DOWN;
	}
}