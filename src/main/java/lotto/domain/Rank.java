package lotto.domain;

import java.util.Arrays;

public enum Rank implements Comparable<Rank> {
	FIFTH_GRADE(3, false, 5000L),
	FOURTH_GRADE(4, false, 50000L),
	THIRD_GRADE(5, false, 1500000L),
	SECOND_GRADE(5, true, 30000000L),
	FIRST_GRADE(6, false, 2000000000L);

	private final int matchCount;
	private final boolean bonusBallMatched;
	private final Long prize;

	private static final String PRIZE_COUNT_MESSAGE = "(%d원) - ";

	Rank(int matchCount, boolean bonusBallMatched, Long prize) {
		this.matchCount = matchCount;
		this.bonusBallMatched = bonusBallMatched;
		this.prize = prize;
	}

	public static Rank of(int matchCount, boolean bonusBallMatched) {
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.matches(matchCount, bonusBallMatched))
			.findFirst()
			.orElse(null);
	}

	private boolean matches(int matchCount, boolean bonusBallMatched) {
		return (this.matchCount == matchCount) && (this.bonusBallMatched == bonusBallMatched);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(matchCount + "개 일치");

		if(bonusBallMatched) {
			stringBuilder.append(", " +"보너스 볼 일치");
		}

		stringBuilder.append(String.format(PRIZE_COUNT_MESSAGE, prize));

		return stringBuilder.toString();
	}

	public long getPrize() {
		return prize;
	}
}
