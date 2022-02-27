package lotto.controller;

import java.util.List;

import lotto.domain.Tickets;
import lotto.domain.WinningAnalyze;
import lotto.domain.WinningNumber;
import lotto.domain.strategy.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoController {

	public void run() {
		int payment = InputView.getPayment();
		Tickets tickets = generateTickets(payment);
		OutPutView.printTickets(tickets);

		List<Integer> numbers = InputView.getWinningNumber();
		int bonusBall = InputView.getBonusBall();
		WinningNumber winningNumber = new WinningNumber(numbers, bonusBall);

		WinningAnalyze winningAnalyze = generateStatistics(tickets, winningNumber);
		OutPutView.printStatistics(winningAnalyze);
	}

	private Tickets generateTickets(int payment) {
		Tickets tickets = new Tickets();
		tickets.makeTickets(payment / 1000, new RandomLottoGenerator());

		return tickets;
	}

	private WinningAnalyze generateStatistics(Tickets tickets, WinningNumber winningNumber) {
		WinningAnalyze winningAnalyze = new WinningAnalyze();
		winningAnalyze.analyze(tickets, winningNumber);

		return winningAnalyze;
	}
}
