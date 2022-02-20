package racingcar.domain;

import racingcar.utils.RandomUtil;

public class RandomMovingPolicy implements MovingPolicy {
	private static final int CONDITION_FOR_MOVE = 4;

	@Override
	public boolean isMovable() {
		return RandomUtil.getRandomNumber() >= CONDITION_FOR_MOVE;
	}
}
