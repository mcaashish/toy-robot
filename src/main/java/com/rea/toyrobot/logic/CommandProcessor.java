package com.rea.toyrobot.logic;

import com.rea.toyrobot.model.Direction;
import com.rea.toyrobot.model.Position;
import com.rea.toyrobot.model.ValidCommand;

/**
 * CommandProcessor class is responsible for processing the user commands and it
 * controls and reports the Toy Robot positions accordingly.
 * 
 */

public class CommandProcessor {
	ToyRobot robot = new ToyRobot();

	/**
	 * Executes the user command and moves the toy robot position accordingly
	 * @param Input command
	 */
	public void processCommand(String input) {
		String[] commands = input.split(" ");

		ValidCommand command = null;
		try {
			command = ValidCommand.valueOf(commands[0]);
		} catch (IllegalArgumentException exp) {
			System.err.println("Invalid command, please enter correct command");
			throw exp;
		}
		int x = 0;
		int y = 0;
		Direction direction = null;
		if (command == ValidCommand.PLACE) {
			if (commands.length > 1) {
				String[] parameters = commands[1].split(",");
				if (parameters.length < 3) {
					throw new IllegalArgumentException("Wrong parameters provided for PLACE command");
				}
				x = Integer.parseInt(parameters[0]);
				y = Integer.parseInt(parameters[1]);
				direction = Direction.valueOf(parameters[2]);
			} else {
				System.err.println("No  parameters provided with PLACE command");
				throw new IllegalArgumentException("No  parameters provided with PLACE command");
			}
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
