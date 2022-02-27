package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int getPayment() {
		System.out.println("구입금액을 입력해 주세요.");

		try {
			return Integer.parseInt(scanner.nextLine());

		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("금액은 숫자여야 합니다.");
		}
	}

	public static List<Integer> getWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");

		String[] input = scanner.nextLine()
			.split("," , -1);

		return Arrays.stream(input)
			.map(String::trim)
			.map(InputView::parseNumber)
			.collect(Collectors.toUnmodifiableList());
	}

	public static int getBonusBall() {
		System.out.println("보너스 볼을 입력해 주세요.");

		return parseNumber(scanner.nextLine());
	}

	private static int parseNumber(String number) {
		try {
			return Integer.parseInt(number);

		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("볼은 하나의 숫자여야 합니다.");
		}
	}
}
