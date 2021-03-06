package com.rea.toy.robot.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rea.toyrobot.logic.CommandProcessor;
import com.rea.toyrobot.logic.ToyRobot;
import com.rea.toyrobot.model.Direction;
import com.rea.toyrobot.model.Position;

public class CommandProcessorTest {

	CommandProcessor processor = new CommandProcessor();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testPlaceWithValidCommand() {
		String cmd = "PLACE 2,3,NORTH";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "2, 3, NORTH");
	}

	@Test
	public void tesPlaceWithInValidCommand() {
		String cmd = "PLCE 2,3,NORTH";
		exception.expect(IllegalArgumentException.class);

		// exception.expectMessage("error1");
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "2, 3, NORTH");
	}

	@Test
	public void testPlaceWithNoArguments() 
	{
		String cmd = "PLACE";
		initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		exception.expect(IllegalArgumentException.class);
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "0, 0, NORTH");
	}
	
	@Test
	public void testPlaceWithWrongArguments() 
	{
		String cmd = "PLACE 2";
		initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		exception.expect(IllegalArgumentException.class);
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "1, 0, NORTH");
	}
	
	@Test
	public void testMoveWithoutPlace() {

		String cmd = "MOVE";
		initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "0, 0, NORTH");
	}

	@Test
	public void testMoveAfterPlace() 
	{
		String cmd = "PLACE 2,3,NORTH";
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "2, 4, NORTH");
		
		cmd = "PLACE 2,3,SOUTH";
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "2, 2, SOUTH");
		
		cmd = "PLACE 2,3,WEST";
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "1, 3, WEST");
		
		cmd = "PLACE 2,3,EAST";
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "3, 3, EAST");
	}
	
	@Test
	public void testMoveWithInvalidRangeNorth() 
	{
		String cmd = "PLACE 2,4,NORTH";
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "2, 4, NORTH");
	}
	
	@Test
	public void testMoveWithInvalidRangeEast() 
	{
		String cmd = "PLACE 4,3,EAST";
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "4, 3, EAST");
	}
	
	@Test
	public void testPlaceWithInvalidRange() 
	{
		String cmd = "PLACE 4,5,NORTH";
		//initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "0, 0, null");
	}
	
	@Test
	public void testLeftRotation() 
	{
		String cmd = "PLACE 4,4,NORTH";
		//initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		processor.processCommand(cmd);
		cmd = "LEFT";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "4, 4, WEST");
	}
	
	@Test
	public void testRightRotation() 
	{
		String cmd = "PLACE 4,4,NORTH";
		//initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		processor.processCommand(cmd);
		cmd = "RIGHT";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "4, 4, EAST");
	}
	
	@Test
	public void testLeftRotationAfterMove() 
	{
		String cmd = "PLACE 3,2,NORTH";
		//initializeRobotPosition(new Position(0, 0), Direction.NORTH);
		processor.processCommand(cmd);
		cmd = "MOVE";
		processor.processCommand(cmd);
		cmd = "LEFT";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "3, 3, WEST");
	}
	
	@Test
	public void testReportWithValidCommand() {
		String cmd = "PLACE 2,3,NORTH";
		processor.processCommand(cmd);
		cmd = "REPORT";
		processor.processCommand(cmd);
		assertEquals(processor.getRobot().report(), "2, 3, NORTH");
	}

	private void initializeRobotPosition(Position position, Direction direction) {
		processor.getRobot().setPosition(position);
		processor.getRobot().setDirection(direction);
	}

}
