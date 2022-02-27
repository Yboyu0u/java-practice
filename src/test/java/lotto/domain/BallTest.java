package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

	@DisplayName("생성자 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void NegativeNumberTest(int number) {
		assertDoesNotThrow(() -> new Ball(number));
	}

	@DisplayName("번호가 1~45 범위의 숫자가 아니면 예외 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46, 50})
	void rangeExceptionTest(int number) {
		assertThatThrownBy(() -> new Ball(number))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
