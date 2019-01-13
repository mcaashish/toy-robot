package com.rea.toy.robot.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rea.toyrobot.model.Direction;

public class DirectionTest {

	@Test
	public void testLeftDirection() {
		Direction direction = Direction.NORTH;
		Direction dir = direction.rotateLeft();

		assertEquals(Direction.WEST, dir);

		dir = dir.rotateLeft();

		assertEquals(Direction.SOUTH, dir);

		dir = dir.rotateLeft();

		assertEquals(Direction.EAST, dir);

		dir = dir.rotateLeft();

		assertEquals(Direction.NORTH, dir);

	}

	@Test
	public void testRightDirection() {
		Direction direction = Direction.NORTH;
		Direction dir = direction.rotateRight();

		assertEquals(Direction.EAST, dir);

		dir = dir.rotateRight();

		assertEquals(Direction.SOUTH, dir);

		dir = dir.rotateRight();

		assertEquals(Direction.WEST, dir);

		dir = dir.rotateRight();

		assertEquals(Direction.NORTH, dir);

	}
}
