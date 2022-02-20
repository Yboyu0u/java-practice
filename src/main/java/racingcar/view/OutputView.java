package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	private static final String NAME_POSITION_DELIMITER = " : ";
	private static final String POSITION_SIGN = "-";
	private static final String WINNER_DELIMITER = ", ";

	private static final int POSITION_ZERO = 0;

	public static void printErrorMessage(String message) {
		System.out.println(message);
		System.out.println();
	}

	public static void printStates(List<List<Car>> carsStates) {
		System.out.println();
		System.out.println(RESULT_MESSAGE);

		carsStates.forEach(OutputView::printState);
	}

	private static void printState(List<Car> carsState) {
		carsState.forEach(car -> System.out.println(makeStateFormat(car)));
		System.out.println();
	}

	private static String makeStateFormat(Car car) {
		StringBuilder stringBuilder = new StringBuilder(car.getName() + NAME_POSITION_DELIMITER);
		int position = car.getPosition();

		while (position-- > POSITION_ZERO) {
			stringBuilder.append(POSITION_SIGN);
		}

		return stringBuilder.toString();
	}

	public static void printWinners(List<String> winners) {
		System.out.println(String.join(WINNER_DELIMITER, winners) + WINNER_MESSAGE);
	}
}
