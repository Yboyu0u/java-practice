package racingcar.view;

import java.util.Scanner;

import racingcar.validator.InputValidator;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
	private static final String CAR_DELIMITER = ",";

	private static final String NOT_INT_ERROR = "시도 횟수는 숫자여야 합니다.";

	public static String[] getCarNames() {
		System.out.println(INPUT_CAR_NAMES);
		String input = scanner.nextLine();
		InputValidator.validateString(input);

		return input.split(CAR_DELIMITER);
	}

	public static int getTryNo() {
		System.out.println(INPUT_TRY_NUMBER);

		try {
			String input = scanner.nextLine();
			InputValidator.validateString(input);

			return Integer.parseInt(input);

		} catch(NumberFormatException ex) {
			throw new IllegalArgumentException(NOT_INT_ERROR);
		}
	}
}
