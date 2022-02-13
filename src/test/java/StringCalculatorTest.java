import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.StringCalculator;

public class StringCalculatorTest {

	@DisplayName("빈 문자열이 들어올 때  0 return")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "  "})
	void splitAndSum_잘못된입력1(String input) {
		int result = StringCalculator.splitAndSum(input);

		assertThat(result).isEqualTo(0);
	}

	@DisplayName("null이 들어올 때 0 return")
	@Test
	void splitAndSum_잘못된입력2() {
		int result = StringCalculator.splitAndSum(null);

		assertThat(result).isEqualTo(0);
	}

	@DisplayName("")
	@Test
	void splitAndSum_숫자하나() {
		int result  = StringCalculator.splitAndSum("5");

		assertThat(result).isEqualTo(5);
	}

	@DisplayName("쉼표, 컴마로 숫자를 구분해서 sum을 return")
	@ParameterizedTest
	@ValueSource(strings = {"1:2","1,2"})
	void splitAnsSum_쉼표컴마구분자(String input) {
		int result = StringCalculator.splitAndSum(input);

		assertThat(result).isEqualTo(3);
	}

	@DisplayName("음수를 전달할 경우 RuntimeException 발생")
	@ParameterizedTest
	@ValueSource(strings = {"-1","-1:2","-1,2"})
	void splitAnsSum_음수확인(String input) {
		assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("숫자 이외의 값이 전달될 경우 RuntimeException 발생")
	@ParameterizedTest
	@ValueSource(strings = {"보보:2","비비,소소"})
	void splitAndSum_숫자아님(String input) {
		assertThatThrownBy(() -> StringCalculator.splitAndSum(input))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3","//;\n1;2;3"})
	void splitAndSum_커스텀구분자(String input) {
		assertThat(StringCalculator.splitAndSum(input))
			.isEqualTo(6);
	}
}
