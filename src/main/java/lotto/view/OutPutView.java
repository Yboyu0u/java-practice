package lotto.view;

import lotto.domain.Tickets;
import lotto.domain.WinningAnalyze;

public class OutPutView {

	public static void printTickets(Tickets tickets) {
		System.out.println(tickets.size() + "개를 구매했습니다.");
		System.out.println(tickets.toString());
	}

	public static void printStatistics(WinningAnalyze winningAnalyze) {
		System.out.println();
		System.out.println("당첨 통계\n"
			+ "---------");

		System.out.println(winningAnalyze.toString());
	}
}
