package racingcar.validator;

public class InputValidator {

	public static void validateString(final String input) {
		if(input == null || input.isEmpty() ||  input.isBlank()) {
			throw new IllegalArgumentException("입력 값은 null, blank, empty일 수 없습니다.");
		}
	}
}
