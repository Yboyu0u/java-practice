package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
	private static final int CONDITION_FOR_NUMBER_OF_CARS = 2;

	private List<Car> cars;

	public RacingGame(final String[] carNames) {
		validateCars(carNames);

		this.cars = makeCars(carNames);
	}

	private void validateCars(String[] cars) {
		if(cars.length < CONDITION_FOR_NUMBER_OF_CARS) {
			throw new IllegalArgumentException("차는 두 대이상이여야 게임이 가능합니다.");
		}

		Set<String> overlapChecker = new HashSet<>(Arrays.asList(cars));
		if(overlapChecker.size() != cars.length) {
			throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
		}
	}

	private List<Car> makeCars(final String[] carNames) {
		return Arrays.stream(carNames)
			.map(Car::new)
			.collect(toList());
	}

	public List<List<Car>> race(final int tryNo) throws CloneNotSupportedException {
		final Counter counter = new Counter(tryNo);
		List<List<Car>> carsStates = new ArrayList<>();

		while (!counter.isEnd()) {
			counter.subtract();
			moveCars();
			carsStates.add(getCarsState());
		}

		return carsStates;
	}

	private List<Car> getCarsState() throws CloneNotSupportedException {
		final List<Car> carState = new ArrayList<>();
		for (Car car : cars) {
			carState.add((Car)car.clone());
		}

		return carState;
	}

	private void moveCars() {
		cars.forEach(car -> car.move(new RandomMovingPolicy()));
	}

	public List<String> getWinners() {
		final int maxPosition = getMaxPosition();

		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(toList());
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}
}
