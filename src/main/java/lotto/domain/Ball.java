package lotto.domain;

import java.util.Objects;

public class Ball {
	private final int number;

	public Ball(final int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(int number) {
		if(number < 1 || number > 45) {
			throw new IllegalArgumentException("번호는 1~45 범위 내의 숫자여야 합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
