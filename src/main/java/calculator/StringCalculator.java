package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	private static final String NORMAL_DELIMITER = "[,|:]";
	private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

	public static int splitAndSum(String input) {
		if(input == null || input.isEmpty() || input.isBlank()) {
			return 0;
		}

		return sum(toInts(split(input)));
	}

	private static String[] split(String input) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return input.split(NORMAL_DELIMITER);
	}

	private static List<Integer> toInts(String[] values) {
		return Arrays.stream(values)
			.map(StringCalculator::toInt)
			.collect(Collectors.toList());
	}

	private static int toInt(String value) {
		validateNumber(value);
		return Integer.parseInt(value);
	}

	private static void validateNumber(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException ex){
			throw new RuntimeException();
		}

		if(Integer.parseInt(value) < 0) {
			throw new RuntimeException();
		}
	}

	private static int sum(List<Integer> numbers) {
		return numbers.stream().mapToInt(number -> number).sum();
	}

}
