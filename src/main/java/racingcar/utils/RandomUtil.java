package racingcar.utils;

import java.util.Random;

public class RandomUtil {
	private static Random random = new Random();

	public static int getRandomNumber() {
		return random.nextInt(9);
	}
}
