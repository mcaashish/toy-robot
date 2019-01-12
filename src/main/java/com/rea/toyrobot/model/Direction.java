package com.rea.toyrobot.model;

/**
 * Enum class for the directions NORTH, WEST, EAST and SOUTH.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    /**
     * Returns the right direction in the sequence. If the last enum, cycles to the first element.
     *
     * @return  Right Direction enum
     */
    public Direction rotateRight() {
        if (this.ordinal() < Direction.values().length - 1) {
            return Direction.values()[this.ordinal() + 1];
        }
        else {
            return Direction.values()[0];
        }
    }

    /**
     * Returns the previous direction in the sequence. If the first enum, cycles to the last element.
     *
     * @return  Left direction enum
     */
    public Direction rotateLeft() {
        if (this.ordinal() == 0) {
            return Direction.values()[Direction.values().length - 1];
        }
        else {
            return Direction.values()[this.ordinal() - 1];
        }
    }
}
