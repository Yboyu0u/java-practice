package racingcar.domain;

public class Counter {
	private static final int CONDITION_FOR_END = 0;

	private int count;

	public Counter(final int count) {
		validateNumber(count);

		this.count = count;
	}

	private void validateNumber(final int number) {
		if(number <= 0) {
			throw new IllegalArgumentException("입력 횟수는 자연수여야 합니다.");
		}
	}

	public boolean isEnd() {
		return !(count > CONDITION_FOR_END);
	}

	public void subtract() {
		count--;
	}
}
