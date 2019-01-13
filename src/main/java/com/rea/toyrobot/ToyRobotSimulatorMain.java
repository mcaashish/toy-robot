package com.rea.toyrobot;

import java.util.Scanner;

import com.rea.toyrobot.logic.CommandProcessor;

public class ToyRobotSimulatorMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Toy Robot Simulator" );
        System.out.println("Enter your command");
        System.out.println("Usage: ");
        System.out.println("PLACE X,Y,NORTH|SOUTH|EAST|WEST, MOVE, LEFT, RIGHT, REPORT");
        System.out.println("type EXIT/exit to exit");
        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor();
        while(true)
        {
        	try
        	{
        	String input = scanner.nextLine();
        	
        	if(input.equalsIgnoreCase("Exit"))
        	{
        		System.out.println("Exiting now...");
        		System.exit(0);
        	}
        	else 
        	{
        		processor.processCommand(input);
        	}
        	}catch(IllegalArgumentException e)
        	{
        		System.out.println(e.getMessage());
        	}
        	System.out.println("");
        }
    }
}
