package racingcar.domain;

import racingcar.validator.InputValidator;

public class Car implements Cloneable {
	private static final int INIT_POSITION = 0;
	private static final int CONDITION_FOR_NAME_LENGTH = 5;

	private final String name;
	private int position;

	public Car(String name) {
		validateName(name);

		this.name = name;
		this.position = INIT_POSITION;
	}

	private void validateName(final String name) {
		InputValidator.validateString(name);

		if(name.length() >= CONDITION_FOR_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 5자 이상일 수 없다.");
		}

	}

	public void move(MovingPolicy movingPolicy) {
		if (movingPolicy.isMovable()) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
