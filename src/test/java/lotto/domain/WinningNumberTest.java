package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

	@DisplayName("생성자 테스트")
	@Test
	void constructor() {
		List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
		int bonusBall = 7;

		assertDoesNotThrow(() -> new WinningNumber(winningNumbers, bonusBall));
	}

	@DisplayName("당첨 번호, 보너스볼 중복이면 예외 데스트")
	@Test
	void duplicate() {
		List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
		int bonusBall = 6;

		assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusBall))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
