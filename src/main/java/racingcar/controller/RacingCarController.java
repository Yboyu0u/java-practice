package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
	private RacingGame racingGame;

	public void run() throws CloneNotSupportedException {
		getCarNames();
		getTryNo();
	}

	private void getCarNames() {
		try {
			racingGame = new RacingGame(InputView.getCarNames());

		} catch (IllegalArgumentException ex) {
			OutputView.printErrorMessage(ex.getMessage());
			getCarNames();
		}
	}

	private void getTryNo() throws CloneNotSupportedException {
		try {
			OutputView.printStates(racingGame.race(InputView.getTryNo()));
			OutputView.printWinners(racingGame.getWinners());

		} catch (IllegalArgumentException ex) {
			OutputView.printErrorMessage(ex.getMessage());
			getTryNo();
		}
	}
}
