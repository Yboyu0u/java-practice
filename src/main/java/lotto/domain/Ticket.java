package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
	private final List<Ball> balls;

	public Ticket(final List<Integer> numbers) {
		final List<Ball> beBalls = makeNumbersToBalls(numbers);
		this.balls = makeNumbersToBalls(numbers);
	}

	private List<Ball> makeNumbersToBalls(List<Integer> numbers) {
		return numbers.stream()
			.map(Ball::new)
			.collect(Collectors.toUnmodifiableList());
	}

	public Rank getRank(WinningNumber winningNumber) {
		int matchCount = countMatch(winningNumber.getWinningBalls());
		boolean bonusBallMatched = false;

		if(matchCount == 5) {
			bonusBallMatched = balls.contains(winningNumber.getBonusBall());
		}

		return Rank.of(matchCount, bonusBallMatched);
	}

	private int countMatch(List<Ball> balls) {
		return (int)balls.stream()
			.filter(this.balls::contains)
			.count();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[");
		stringBuilder.append(String.join(",", balls.stream()
			.map(Ball::toString)
			.collect(Collectors.toUnmodifiableList())));
		stringBuilder.append("]");
		stringBuilder.append("\n");

		return stringBuilder.toString();
	}
}
