package lotto.domain;

import java.util.Iterator;
import java.util.List;

import lotto.domain.strategy.LottoGenerator;

public class CustomLottoGenerator implements LottoGenerator {

	private Iterator<List<Integer>> numbers;

	public void initNumbers(List<List<Integer>> numbers) {
		this.numbers = numbers.iterator();
	}

	@Override
	public List<Integer> generate() {
		return this.numbers.next();
	}
}
