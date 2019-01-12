package com.rea.toyrobot.logic;

import com.rea.toyrobot.model.Direction;
import com.rea.toyrobot.model.Position;

public class ToyRobot {

	private Direction direction;
	private Position position = new Position(0, 0);
	private boolean placed;

	public void placeRobot(Position newPosition, Direction newDirection) {
		if (newPosition.getX() < 0 || newPosition.getX() > 4) {
			System.err.println("Invalid X position, please enter in range of 0 to 4");
			return;
		}
		if (newPosition.getY() < 0 || newPosition.getY() > 4) {
			System.err.println("Invalid Y position, please enter in range of 0 to 4");
			return;
		}
		this.position = newPosition;
		this.direction = newDirection;
		placed = true;
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
			if (nextPosition.getX() < 0 || nextPosition.getX() > 4) {
				System.err.println("Invalid X position, please enter in range of 0 to 4");
				return;
			}
			if (nextPosition.getY() < 0 || nextPosition.getY() > 4) {
				System.err.println("Invalid Y position, please enter in range of 0 to 4");
				return;
			}

			setPosition(nextPosition);
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
