package com.rea.toyrobot.logic;

import com.rea.toyrobot.model.Direction;
import com.rea.toyrobot.model.Position;

public class ToyRobot {
	private static final int MIN_Y_LIMIT = 0;
	private static final int MIN_X_LIMIT = 0;
	private static final int MAX_Y_LIMIT = 4;
	private static final int MAX_X_LIMIT = 4;
	private Direction direction;
	private Position position = new Position(0, 0);
	private boolean placed;

	public void placeRobot(Position newPosition, Direction newDirection) {
		if (isValidPosition(newPosition)) {

			this.position = newPosition;
			this.direction = newDirection;
			placed = true;
		} else {
			System.err.println("Invalid position");
			return;
		}
	}

	private boolean isValidPosition(Position position) {
		if (position.getX() < MIN_X_LIMIT || position.getX() > MAX_X_LIMIT) {
			return false;
		}

		if (position.getY() < MIN_Y_LIMIT || position.getY() > MAX_Y_LIMIT) {
			return false;
		}
		return true;
	}

	public String report() {
		return position.getX() + ", " + position.getY() + ", " + (direction != null ? direction.name() : "null");
	}

	public void move() {
		if (placed) {
			Position nextPosition = new Position(this.position.getX(), this.position.getY());
			switch (direction) {
			case NORTH:
				nextPosition.incrementY();
				break;
			case SOUTH:
				nextPosition.decrementY();
				break;
			case WEST:
				nextPosition.decrementX();
				break;
			case EAST:
				nextPosition.incrementX();
				break;

			}
			if (isValidPosition(nextPosition)) {
				setPosition(nextPosition);
			} else {
				System.err.println("Invalid position");
				return;
			}
		} else {
			System.err.println("Robot not yet placed");
		}

	}

	public void rotateLeft() {
		direction = direction.rotateLeft();
	}

	public void rotateRight() {
		direction = direction.rotateRight();
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
