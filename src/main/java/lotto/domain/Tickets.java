package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.domain.strategy.LottoGenerator;

public class Tickets {
	private final List<Ticket> tickets;

	public Tickets() {
		this.tickets = new ArrayList<>();
	}

	public void makeTickets(int count, LottoGenerator lottoGenerator) {
		for(int i = 0; i < count; i++) {
			tickets.add(new Ticket(lottoGenerator.generate()));
		}
	}

	public List<Rank> getRanks(WinningNumber winningNumber) {
		return tickets.stream()
			.map(ticket -> ticket.getRank(winningNumber))
			.filter(Objects::nonNull)
			.collect(Collectors.toUnmodifiableList());
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public int size() {
		return tickets.size();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		tickets.forEach(ticket -> stringBuilder.append(ticket.toString()));

		return stringBuilder.toString();
	}
}
