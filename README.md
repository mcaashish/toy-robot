# Toy Robot Simulator

This is a command line Java application that simulates a robot
on a specifiable grid

## Description

- The application is a simulation of a toy robot moving on a square tabletop,
  of dimensions 5 units x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be
  prevented from falling to destruction. Any movement that would result in the
  robot falling from the table must be prevented, however further valid movement
  commands must still be allowed.
 
The application that can read in commands of the following form

    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

- PLACE will put the toy robot on the table in position X,Y
  and facing NORTH, SOUTH, EAST or WEST.
- The origin (0,0) can be considered to be the SOUTH WEST most corner.
- The first valid command to the robot is a PLACE command, after that,
  any sequence of commands may be issued, in any order, including another
  PLACE command. The application should discard all commands in the
  sequence until a valid PLACE command has been executed.
- MOVE will move the toy robot one unit forward in the direction it is currently
  facing.
- LEFT and RIGHT will rotate the robot 90 degrees in the specified direction
  without changing the position of the robot.
- REPORT will announce the X,Y and F of the robot.
- Any move that would cause the robot to fall must be ignored.

## Example Input and Output
------------------------

### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Expected output:

    0,1,NORTH

### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Expected output:

    0,0,WEST

### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Expected output

    3,3,NORTH
    
## Total Code coverage

![Code Coverage](https://github.com/mcaashish/toy-robot/blob/master/Toy_Robot_Code_Coverage.JPG)

## Build package and Execute steps

```
# Build package
mvn package

# Run tests
mvn test

# Execute jar
java -jar target\robot-0.0.1-SNAPSHOT.jar
```

## Sample Output

```
Toy Robot Simulator
Enter your command
Usage:
PLACE X,Y,NORTH|SOUTH|EAST|WEST, MOVE, LEFT, RIGHT, REPORT
type EXIT/exit to exit
PLACE 2,3,EAST

MOVE

LEFT

REPORT
3, 3, NORTH

MOVE

REPORT
3, 4, NORTH
```
