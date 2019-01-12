package com.rea.toyrobot.logic;

import com.rea.toyrobot.model.Direction;
import com.rea.toyrobot.model.Position;
import com.rea.toyrobot.model.ValidCommand;

public class CommandProcessor {
	ToyRobot robot = new ToyRobot();

	public void processCommand(String input) {
		String[] commands = input.split(" ");

		ValidCommand command = null;
		try {
			command = ValidCommand.valueOf(commands[0]);
		} catch (IllegalArgumentException exp) {
			System.out.println("Invalid command, please enter correct command");
			throw exp;
		}
		int x = 0;
		int y = 0;
		Direction direction = null;
		if (command == ValidCommand.PLACE) {
			String[] parameters = commands[1].split(",");
			x = Integer.parseInt(parameters[0]);
			y = Integer.parseInt(parameters[1]);
			direction = Direction.valueOf(parameters[2]);
		}

		switch (command) {
		case PLACE:
			robot.placeRobot(new Position(x, y), direction);
			break;
		case MOVE:
			robot.move();
			break;
		case LEFT:
			robot.rotateLeft();
			break;
		case RIGHT:
			robot.rotateRight();
			break;
		case REPORT:
			System.out.println(robot.report());
			break;
		}
	}
	
	public ToyRobot getRobot() {
		return robot;
	}

}
